package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.people.cityworkers.ManualWorker;
import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.Tool;
import engine.tools.ToolUnderConstruction;
import engine.tools.vehicles.Liver;
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
import ui.view.Controller;

import java.util.ArrayList;
import java.util.Optional;

public class Factory extends Workplace implements ToolBuilder<Tool>
{
	public static double healthInitial = 10000;
	public static double resistanceInitial = 2000;
	//only builds weapons/ vehicles roadgoing or otherwise
	public static int maxWorkersInitial = 2001;//just in cas I have off by one
	public ToolUnderConstruction<Tool> inProduction;
	public Factory factorySelfReference = this;
	public Factory(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(parentBlock.getLocation(),healthInitial,resistanceInitial), parentBlock, maxWorkersInitial, owner);
		if(parentBlock.getParentGrid().getParentPlanet() == null)
			throw new IllegalArgumentException();
	}
	@Override
	protected String getName() {
		return "factory";
	}
	@Override
	public ResourceDemand getResourceCost() {
		return new ResourceDemand(new Resource.Type[] {},healthInitial,resistanceInitial,maxWorkersInitial);
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
		if(tool instanceof Liver)
			Liver.deregister((Liver) tool);
		EventHandler<MouseEvent> handler= new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				TextInputDialog dialog = new TextInputDialog("10");
				dialog.setTitle("Select Quantity");
				dialog.setHeaderText("Enter the number of "+tool.getClass().getSimpleName() + "s to build");
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
					Alert alert = new Alert(Alert.AlertType.WARNING,"not a valid integer. Please enter a valid integer value., greater than 0");
					alert.showAndWait();
					return;
				}
				tool.setNumTools(numTools);
				setToolUnderConstruction(new ToolUnderConstruction<>(tool));
				Controller.controller.cityAccordionManager.redraw(factorySelfReference);
			}
		};
		Image image = tool.getImage();
		if(image != null)
			buttons.add(new Button(tool.getClass().getSimpleName(), new ImageView(image){{
				setPreserveRatio(true);
				setFitHeight(100);
				setFitWidth(100);
			}}){{
				setOnMouseClicked(handler);
			}});
		else
			buttons.add(new Button(tool.getClass().getSimpleName()){{
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