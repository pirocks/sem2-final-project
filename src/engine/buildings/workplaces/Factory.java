package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.people.cityworkers.ManualWorker;
import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.Tool;
import engine.tools.ToolUnderConstruction;
import engine.tools.vehicles.air.*;
import engine.tools.vehicles.land.ArmouredVehicle;
import engine.tools.vehicles.land.AutomatedArmouredVehicle;
import engine.tools.vehicles.land.AutomatedTank;
import engine.tools.vehicles.land.Tank;
import engine.tools.vehicles.roadgoing.*;
import engine.tools.vehicles.space.shuttle.ShuttleMedium;
import engine.tools.vehicles.space.shuttle.ShuttleSmall;
import engine.tools.weapons.guns.artillery.*;
import engine.tools.weapons.guns.carried.HandGun;
import engine.tools.weapons.guns.carried.SniperRifle;
import engine.tools.weapons.guns.mounted.AntiAirCraftGun;
import engine.tools.weapons.guns.mounted.MachineGunLarge;
import engine.tools.weapons.guns.mounted.MachineGunMedium;
import engine.tools.weapons.guns.mounted.MachineGunSmall;
import engine.universe.MoneySource;
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

public class Factory extends Workplace implements ToolBuilder<Tool>
{
	public static double healthInitial = 10000;
	public static double resistanceInitial = 2000;
	//only builds weapons/ vehicles roadgoing or otherwise
	public static int maxWorkersInitial = 2001;//just in cas I have off by one
	public ToolUnderConstruction<Tool> inProduction;
	public Factory(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(parentBlock.getLocation(),healthInitial,resistanceInitial), parentBlock, maxWorkersInitial, owner);
	}
	@Override
	protected String getName() {
		return "factory";
	}
	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}
	@Override
	public Tool setToolUnderConstruction(ToolUnderConstruction<Tool> in) {
		inProduction = in;
		return inProduction.getFinishedTool();
	}
	@Override
	public ToolUnderConstruction<Tool> getToolUnderConstruction() {
		return inProduction;
	}
	@Override
	public void addBuildOptions(VBox in) {
		ArrayList<Node> buttons = new ArrayList<>();
		addGunsButtons(buttons);
		addAirButtons(buttons);
		addLandButtons(buttons);
		addRoadGoingButtons(buttons);
		addSpaceButtons(buttons);
		in.getChildren().addAll(buttons);
	}
	private void addButton(ArrayList<Node> buttons,Tool tool){
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
				setToolUnderConstruction(new ToolUnderConstruction<>(tool));
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
	private void addSpaceButtons(ArrayList<Node> buttons) {
		addButton(buttons,new ShuttleSmall(new LocationPlanet(this),-1));
		addButton(buttons,new ShuttleMedium(new LocationPlanet(this),-1));
	}
	private void addRoadGoingButtons(ArrayList<Node> buttons) {
		addButton(buttons,new AllPurpose(new LocationPlanet(this),-1));
		addButton(buttons,new Bus(new LocationPlanet(this),-1));
		addButton(buttons,new Train(new LocationPlanet(this),-1));
		addButton(buttons,new TruckLarge(new LocationPlanet(this),-1));
		addButton(buttons,new TruckMedium(new LocationPlanet(this),-1));
		addButton(buttons,new TruckSmall(new LocationPlanet(this),-1));
	}
	private void addLandButtons(ArrayList<Node> buttons) {
		addButton(buttons,new ArmouredVehicle(new LocationPlanet(this),-1));
		addButton(buttons,new AutomatedArmouredVehicle(new LocationPlanet(this),-1));
		addButton(buttons,new AutomatedTank(new LocationPlanet(this),-1));
		addButton(buttons,new Tank(new LocationPlanet(this),-1));
	}
	private void addAirButtons(ArrayList<Node> buttons) {
		addButton(buttons,new CargoPlaneLarge(new LocationPlanet(this),-1));
		addButton(buttons,new CargoPlaneMedium(new LocationPlanet(this),-1));
		addButton(buttons,new CargoPlaneSmall(new LocationPlanet(this),-1));
		addButton(buttons,new FighterPlaneMedium(new LocationPlanet(this),-1));
		addButton(buttons,new FighterPlaneSmall(new LocationPlanet(this),-1));
		addButton(buttons,new Helicopter(new LocationPlanet(this),-1));
	}
	private void addGunsButtons(ArrayList<Node> buttons) {
		addArtilleryButtons(buttons);
		addCarriedButtons(buttons);
		addMountedButtons(buttons);
	}
	private void addMountedButtons(ArrayList<Node> buttons) {
		addButton(buttons,new AntiAirCraftGun(-1));
		addButton(buttons,new MachineGunSmall(-1));
		addButton(buttons,new MachineGunMedium(-1));
		addButton(buttons,new MachineGunLarge(-1));
	}
	private void addCarriedButtons(ArrayList<Node> buttons) {
		addButton(buttons,new HandGun(-1));
		addButton(buttons,new SniperRifle(-1));
	}
	private void addArtilleryButtons(ArrayList<Node> buttons) {
		addButton(buttons,new ArtilleryLarge(-1));
		addButton(buttons,new ArtilleryMedium(-1));
		addButton(buttons,new ArtillerySmall(-1));
		addButton(buttons,new Howitzer(-1));
		addButton(buttons,new TankArtillery(-1));
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