package engine.buildings.workplaces;

import engine.buildings.Building;
import engine.cities.City;
import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.people.cityworkers.ManualWorker;
import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.ToolUnderConstruction;
import engine.tools.vehicles.sea.*;
import engine.universe.MoneySource;
import engine.universe.Resource;
import engine.universe.ResourceDemand;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by bob on 4/9/2016.
 *
 */
public class DockYard extends Workplace implements ToolBuilder<SeaCraft> {
	public static double healthInitial = 15000;
	public static double resistanceInitial= 2000;
	public static int maxWorkersInitial = 1000;
	private ToolUnderConstruction<SeaCraft> seaCraftUnderConstruction;
	Building buildingSelfReference = this;//for the listeners who need a this
	public DockYard(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(parentBlock.getLocation(),healthInitial,resistanceInitial), parentBlock, maxWorkersInitial, owner);
	}
	@Override
	protected String getName() {
		return "DockYard";
	}
	@Override
	public ResourceDemand getResourceCost() {
		return new ResourceDemand(new Resource.Type[] {},healthInitial,resistanceInitial,maxWorkersInitial);
	}
	//the two methods bellow  should only be used by Toolbuilder
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
	private void addButton(ArrayList<Node> buttons,SeaCraft vehicle){
		EventHandler<MouseEvent> handler= new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				TextInputDialog dialog = new TextInputDialog("10");
				dialog.setTitle("Select Quantity");
				dialog.setHeaderText("Enter the number of "+vehicle.getClass().getSimpleName() + "s to build");
				Optional<String> result = dialog.showAndWait();
				String entered = "100";
				if (result.isPresent()) {
					entered = result.get();
				}
				int numTools = 1;
				try{
					numTools = Integer.parseInt(entered);
					if(numTools <= 0)
						throw new NumberFormatException();
				}catch (NumberFormatException e){
					Alert alert = new Alert(Alert.AlertType.WARNING,"not a valid integer. Please enter a valid integer value, greater than 0.");
					alert.showAndWait();
					return;
				}
				vehicle.setNumTools(numTools);
				setToolUnderConstruction(new ToolUnderConstruction<>(vehicle));
			}
		};
		Image image = vehicle.getImage();
		if(image != null)
			buttons.add(new Button(vehicle.getClass().getName(), new ImageView(image)){{
				setOnMouseClicked(handler);
			}});
		else
			buttons.add(new Button(vehicle.getClass().getName()){{
				setOnMouseClicked(handler);
			}});
	}
	private void addTransporterMediumButton(ArrayList<Node> buttons) {
		addButton(buttons,new TransporterMedium(new LocationPlanet(this),-1));
	}
	private void addTransporterSmallButton(ArrayList<Node> buttons) {
		addButton(buttons,new TransporterSmall(new LocationPlanet(this),-1));
	}
	private void addSubmarineButton(ArrayList<Node> buttons) {
		addButton(buttons,new Submarine(new LocationPlanet(this),-1));
	}
	private void addDestroyerButton(ArrayList<Node> buttons) {
		addButton(buttons,new Destroyer(new LocationPlanet(this),-1));
	}
	@Override
	public SeaCraft setToolUnderConstruction(ToolUnderConstruction<SeaCraft> seaCraftUnderConstruction) {
		assert (seaCraftUnderConstruction.areWeDoneYet());
		this.seaCraftUnderConstruction = seaCraftUnderConstruction;
		return seaCraftUnderConstruction.getFinishedTool();
	}
	@Override
	public boolean isSuitableType(CityWorker cityWorker) {
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

	@Override
	public City getCity() {
		return getParentCity();
	}
}
