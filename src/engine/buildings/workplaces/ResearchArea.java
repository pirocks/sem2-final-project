package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.people.cityworkers.Researcher;
import engine.planets.LocationPlanet;
import engine.science.Discovery;
import engine.tools.AttackableConstants;
import engine.universe.MoneySource;
import engine.universe.Resource;
import engine.universe.ResourceDemand;
import engine.universe.Universe;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ui.view.Controller;

import java.util.Optional;

public class ResearchArea extends Workplace
{
	private boolean haveIAsked = false;
	public static boolean askedThisCycle = false;
	private ResearchArea self = this;
	public static double healthInitial = 5000;
	public static double resistanceInitial = 1000;
	public static int maxWorkersInitial;
	private Discovery discovery;
	public static int count = 0;

	public ResearchArea(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(healthInitial,resistanceInitial,parentBlock.getLocation()), parentBlock, maxWorkersInitial, owner);
		count++;
	}

	@Override
	protected String getName() {
		return "ResearchArea";
	}

	@Override
	public ResourceDemand getResourceCost() {
		return new ResourceDemand(new Resource.Type[] {},healthInitial,resistanceInitial,maxWorkersInitial);
	}

	public Discovery getDiscovery() {
		return discovery;
	}

	public void setDiscovery(Discovery discovery) {
		ResearchArea.askedThisCycle = false;
		haveIAsked = false;
		this.discovery = discovery;
	}

	@Override
	protected boolean isSuitableType(CityWorker cityWorker) {
		return cityWorker instanceof Researcher;
	}

	@Override
	public void addSpecific(VBox in) {
		nullityHandler();
		try {
			in.getChildren().add(new Text("working on:" + discovery.getClass().getSimpleName()));
		} catch (NullPointerException ignored) {
			System.out.print("you probably shouldn't see this but its really not that bad");
		}
		try {
			in.getChildren().add(new Text("Percent complete:" + 100*discovery.getPercentComplete() + "%"));
		} catch (NullPointerException e) {
			System.out.print("you probably shouldn't see this but its really not that bad");
		}
		for (Discovery discovery1 : getParentCity().getParentCountry().getCountriesDiscoveries().getUnDiscovered()) {
			in.getChildren().add(new Button("Research " + discovery1.getClass().getSimpleName()){{
				setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						discovery = discovery1;
						Controller.controller.updateResearchAreas();
					}
				});
			}});
		}

	}
	@Override
	public CityWorker createCorrectType() {
		return new Researcher(getParentCity(),new LocationPlanet(this));
	}

	public void nullityHandler(){
		if(Universe.playersCountry  == getParentCity().getParentCountry()) {
			if (discovery == null && !haveIAsked && !askedThisCycle) {
				askedThisCycle = true;
				haveIAsked = true;
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.setTitle("A research are does not have anything to research.");
						alert.getButtonTypes().add(new ButtonType("Ignore"));
						alert.getButtonTypes().add(new ButtonType("Take me to the research center"));
						Optional<ButtonType> buttonType = alert.showAndWait();
						if (buttonType.isPresent()) {
							if (buttonType.get().getText().equals("Ignore")) {
							} else {
								Controller.controller.switchTo(self.getParentBlock());
							}
						}
					}
				});
			}
		}
	}
}