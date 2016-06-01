package ui.view;

import engine.planets.Grid;
import engine.planets.LocationPlanet;
import engine.planets.Planet;
import engine.tools.vehicles.Vehicle;
import engine.universe.Country;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import ui.view.planet.PlanetGroup;

/**
 * Created by bob on 5/31/2016.
 */
public class PlanetBorderPane
{
	double planetViewScrollX = 0;
	double planetViewScrollY = 0;
	public final static int pixelsPerGridPlanetViewX = 100;
	public final static int pixelsPerGridPlanetViewY = 75;
	private Planet planet;
	private Country playersCountry;
	private Controller controller;
	private BorderPane borderPane;
	private Vehicle currentlySelectedVehicle = null;
	private int mousePositionX = 0;
	private int mousePositionY = 0;

	private Line vehicleLine = new Line(0,0,0,0){{
		setFill(Color.BLUE);
		setStrokeWidth(10);
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				currentlySelectedVehicle = null;
				vehicleLine.setStartX(0);
				vehicleLine.setStartY(0);
				vehicleLine.setEndY(0);
				vehicleLine.setEndX(0);
			}
		});
	}};

	public void initVars(Planet planet, Country playersCountry,Controller controller,BorderPane borderPane){

		this.planet = planet;
		this.playersCountry = playersCountry;
		this.controller = controller;
		this.borderPane = borderPane;
	}
	public void init(){
		try {
			planetViewScrollY = ((ScrollPane)borderPane.getCenter()).getVvalue();
			planetViewScrollX = ((ScrollPane)borderPane.getCenter()).getHvalue();
		}catch(Exception ignored) {}
		StackPane stackPane = new StackPane();
		GridPane gridPane = new GridPane();
		gridPane.setHgap(0);
		gridPane.setVgap(0);
		for(int y = 0; y < planet.getGrids().length;y++)
			for (int x = 0; x < planet.getGrids()[y].length; x++) {
				Grid grid = planet.getGrids()[y][x];
				Pane completeGridImage =  PlanetGroup.getPlanetGroup(grid,playersCountry,controller);
				gridPane.add(completeGridImage, x, y);
			}
		stackPane.getChildren().add(gridPane);
		stackPane.getChildren().add(new Pane(vehicleLine){{
			setHeight(gridPane.getHeight());
			setWidth(gridPane.getWidth());
			setPickOnBounds(false);
		}});
		stackPane.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				mousePositionX = (int) event.getX();
				mousePositionY = (int) event.getY();
				if(currentlySelectedVehicle != null) {
					double x = 100*mousePositionX/pixelsPerGridPlanetViewX;
					double y = 100*mousePositionY/pixelsPerGridPlanetViewY;
					LocationPlanet locationPlanet = new LocationPlanet(planet,x,y);
					currentlySelectedVehicle.setDestination(locationPlanet);
					updateVehicleLine(currentlySelectedVehicle);
					System.out.println("x:" + mousePositionX + "y:" + mousePositionY + "gridx:" + locationPlanet
							.getGridx() + "gridy:" + locationPlanet.getGridy());
				}
			}
		});
		borderPane.setCenter(new ScrollPane(stackPane){{
			setVvalue(planetViewScrollY);
			setHvalue(planetViewScrollX);
		}});
	}
	private void updateVehicleLine(Vehicle selectedVehicle) {
		System.out.println("updating");
		double startX = selectedVehicle.getLocation().get(0).getLocNumX();
		double startY = selectedVehicle.getLocation().get(0).getLocNumY();
		double endX = selectedVehicle.getDestination().getLocNumX();
		double endY = selectedVehicle.getDestination().getLocNumY();
		startX /= 100;
		startY /= 100;
		endX /= 100;
		endY /= 100;
		startX *= pixelsPerGridPlanetViewX;
		startY *= pixelsPerGridPlanetViewY;
		endX *= pixelsPerGridPlanetViewX;
		endY *=  pixelsPerGridPlanetViewY;
		vehicleLine.setEndY(endY);
		vehicleLine.setEndX(endX);
		vehicleLine.setStartY(startY);
		vehicleLine.setStartX(startX);
//		System.out.print("endX:" + endX +  "endY:" + endY);
//		vehicleLine.setTranslateX(startX);
//		vehicleLine.setTranslateY(startY);
//		vehicleLine.setLayoutX(endX);
//		vehicleLine.setLayoutY(endY);
//		vehicleLine.setStartX(startX);
//		vehicleLine.setStartY(startY);
	}
	public void selectVehicle(Vehicle vehicle) {
		System.out.println("click recieved");
		currentlySelectedVehicle = vehicle;
		controller.initPlanetAccordion();
		controller.initPlanetView();
	}

}
