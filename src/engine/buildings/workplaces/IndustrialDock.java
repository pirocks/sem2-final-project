package engine.buildings.workplaces;

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

public class IndustrialDock extends Workplace implements ToolBuilder<SeaCraft>
{
	public static double resistanceInitial = 3000;
	public static double healthInitial = 25000;
	public static int maxWorkersInitial = 5000;
	private ToolUnderConstruction<SeaCraft> underConstruction;
	public IndustrialDock(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(healthInitial,resistanceInitial,parentBlock.getLocation()), parentBlock, maxWorkersInitial, owner);
	}
	@Override
	protected String getName() {
		return "IndustrialDock";
	}
	@Override
	public ResourceDemand getResourceCost() {
		return new ResourceDemand(new Resource.Type[] {},healthInitial,resistanceInitial,maxWorkersInitial);
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
	@Override
	public SeaCraft setToolUnderConstruction(ToolUnderConstruction<SeaCraft> in) {
		assert (underConstruction.areWeDoneYet());
		SeaCraft temp = underConstruction.getFinishedTool();
		underConstruction = in;
		return temp;
	}
	@Override
	public ToolUnderConstruction<SeaCraft> getToolUnderConstruction() {
		return underConstruction;
	}
	@Override
	public void addBuildOptions(VBox in) {
		ArrayList<Node> buttons = new ArrayList<>();
		addButton(buttons, new AircraftCarrier(new LocationPlanet(this),-1));
		addButton(buttons, new BattleShip(new LocationPlanet(this),-1));
		addButton(buttons, new Destroyer(new LocationPlanet(this),-1));
		addButton(buttons, new NuclearAircraftCarrier(new LocationPlanet(this),-1));
		addButton(buttons, new NuclearSubmarine(new LocationPlanet(this),-1));
		addButton(buttons, new Submarine(new LocationPlanet(this),-1));
		addButton(buttons, new TransporterSmall(new LocationPlanet(this),-1));
		addButton(buttons, new TransporterMedium(new LocationPlanet(this),-1));
		addButton(buttons, new TransporterLarge(new LocationPlanet(this),-1));
		in.getChildren().addAll(buttons);
	}
	private void addButton(ArrayList<Node> buttons,SeaCraft tool){
		EventHandler<MouseEvent> handler= new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				TextInputDialog dialog = new TextInputDialog("10");
				dialog.setTitle("Select Quantity");
				dialog.setHeaderText("Enter some text, or use default value.");
				Optional<String> result = dialog.showAndWait();
				String entered = "10";
				if (result.isPresent()) {
					entered = result.get();
				}
				int numTools = 1;
				try{
					numTools = Integer.parseInt(entered);
				}catch (NumberFormatException e){
					Alert alert = new Alert(Alert.AlertType.WARNING,"not a valid integer. Please enter a valid integer value.");
					alert.showAndWait();
					return;
				}
				tool.setNumTools(numTools);
				setToolUnderConstruction(new ToolUnderConstruction<SeaCraft>(tool));
			}
		};
		Image image = tool.getImage();
		if(image != null)
			buttons.add(new Button(tool.getClass().getName(), new ImageView(image)){{
				setOnMouseClicked(handler);
			}});
		else
			buttons.add(new Button(tool.getClass().getName()){{
				setOnMouseClicked(handler);
			}});
	}
}