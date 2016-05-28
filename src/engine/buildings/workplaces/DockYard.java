package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.people.cityworkers.ManualWorker;
import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.ToolUnderConstruction;
import engine.tools.vehicles.VehicleInitialConstants;
import engine.tools.vehicles.sea.SeaCraft;
import engine.tools.vehicles.sea.TransporterMedium;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * Created by bob on 4/9/2016.
 *
 */
public class DockYard extends Workplace implements ToolBuilder<SeaCraft> {
	public static double healthInitial;// TODO: 5/27/2016
	public static double resistanceInitial;// TODO: 5/27/2016
	public static int maxWorkersInitial = 1000;
	private ToolUnderConstruction<SeaCraft> seaCraftUnderConstruction;
	public DockYard(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(parentBlock.getLocation(),healthInitial,resistanceInitial), parentBlock, maxWorkersInitial, owner);
	}
	@Override
	protected String getName() {
		return "DockYard";
	}
	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/10/2016
	}
	//the two classes bellow  should only be used by Toolbuilder
	@Override
	public ToolUnderConstruction<SeaCraft> getToolUnderConstruction() {
		return seaCraftUnderConstruction;
	}

	/*
	* a dockyard can build the following:
	* destroyer,submarine,transporter small through transporter medium
	* */
	@Override
	public void addBuildOptions(VBox in) {
		ArrayList<Node> buttons = new ArrayList<>();
		addDestroyerButton(buttons);
		addSubmarineButton(buttons);
		addTransporterSmallButton(buttons);
		addTransporterMediumButton(buttons);
		in.getChildren().addAll(buttons);
	}

	private void addTransporterMediumButton(ArrayList<Node> buttons) {
		TransporterMedium medium = new TransporterMedium(new VehicleInitialConstants());
		buttons.add(new Button(){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {

				}
			});
		}});
	}

	private void addTransporterSmallButton(ArrayList<Node> buttons) {
		buttons.add(new Button(){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {

				}
			});
		}});
	}

	private void addSubmarineButton(ArrayList<Node> buttons) {
		buttons.add(new Button(){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {

				}
			});
		}});
	}

	private void addDestroyerButton(ArrayList<Node> buttons) {
		buttons.add(new Button(){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {

				}
			});
		}});
	}

	@Override
	public SeaCraft setToolUnderConstruction(ToolUnderConstruction<SeaCraft> seaCraftUnderConstruction) {
		assert (seaCraftUnderConstruction.areWeDoneYet());
		this.seaCraftUnderConstruction = seaCraftUnderConstruction;
		return seaCraftUnderConstruction.getFinishedTool();
	}
	@Override
	protected boolean isSuitableType(CityWorker cityWorker) {
		return cityWorker instanceof ManualWorker;
	}

	@Override
	public void addSpecific(VBox in) {
		addSpecificToolBuilder(in);
	}

	@Override
	public CityWorker createCorrectType() {
		return new ManualWorker(getParentCity(),new LocationPlanet(this));
	}
}
