package ui.view;

import engine.buildings.Building;
import engine.buildings.housing.ApartmentBlock;
import engine.buildings.housing.Housing;
import engine.buildings.housing.RulersHouse;
import engine.buildings.housing.WorkersHouseBlock;
import engine.buildings.workplaces.*;
import engine.cities.City;
import engine.planets.Grid;
import engine.planets.LocationPlanet;
import engine.planets.Planet;
import engine.planets.TerrainType;
import engine.tools.vehicles.CityBuilder;
import engine.tools.vehicles.Vehicle;
import engine.universe.Country;
import engine.universe.SolarSystem;
import engine.universe.Universe;
import javafx.embed.swing.SwingNode;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import ui.view.city.CityButton;
import ui.view.city.NewBuildingPane;
import ui.view.planet.PlanetButton;
import ui.view.planet.PlanetGroup;
import ui.view.solarsystem.SolarSystemButton;
import ui.view.solarsystem.SolarSystemJPanel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/*
 * Created by bob on 5/14/2016.
 */
public class Controller implements Initializable{
	//despite the vast number of vars having this all in one class seems like the best way. having multiple
	// controller classes gets very messy with controller class references all over the place
	@FXML
	TabPane tabPane;
	@FXML
	BorderPane universeBorderPane;
	@FXML
	BorderPane solarSystemBorderPane;
	@FXML
	BorderPane planetBorderPane;
	double planetViewScrollX = 0;
	double planetViewScrollY = 0;
	@FXML
	BorderPane cityBorderPane;
	@FXML
	Accordion universeAccordion;
	@FXML
	Accordion solarSystemAccordion;
	@FXML
	Accordion planetAccordion;
	@FXML
	Accordion cityAccordion;
	@FXML
	AnchorPane citySpecificPane;

	private ScrollPane cityScrollPane;
	private Universe universe;
	private Country playersCountry;
	private SolarSystem solarSystem;
	private Planet planet;
	private City city;
	private Vehicle currentlySelectedVehicle = null;

	public final static int pixelsPerGridPlanetViewX = 100;
	public final static int pixelsPerGridPlanetViewY = 75;
	private int mousePositionX = 0;
	private int mousePositionY = 0;

	/**
	 * Called to initialize a controller after its root element has been
	 * completely processed.
	 *
	 * @param location  The location used to resolve relative paths for the root object, or
	 *                  <tt>null</tt> if the location is not known.
	 * @param resources The resources used to localize the root object, or <tt>null</tt> if
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		boolean capitalCityAvailable = initVars();
		initUniverseTab();
		initSolarSystemTab();
		initPlanetTab();
		if(capitalCityAvailable) {
			initCityTab();
			switchTo(city);
		}
		else {
			switchTo(planet);
		}
	}
	private boolean initVars(){
		playersCountry = Universe.playersCountry;
		city = Universe.playersCountry.getCapitalCity();
		universe = Main.getUniverse();
		if(city == null) {
			LocationPlanet locationPlanet = playersCountry.initialBuilder.getLocation().get(0);
			planet = locationPlanet.planet;
			solarSystem = planet.getParentSolarSystem();
			return false;
		}
		else {
			planet = city.getParentGrid().getParentPlanet();
			solarSystem = planet.getParentSolarSystem();
			return true;
		}
	}
	private void initUniverseTab(){
		universeAccordion.getPanes().clear();
		for(SolarSystem solarSystem:universe.getSolarSystems())
		{
			VBox pane = new VBox();
			pane.getChildren().add(new Text(solarSystem.name));
			pane.getChildren().add(new SolarSystemButton(solarSystem,solarSystem.name,playersCountry, this));
			universeAccordion.getPanes().add(new TitledPane(solarSystem.name,pane));
		}
	}
	private void initSolarSystemTab(){
		getSolarSystemTab().setText("Solar System:" + solarSystem.name);
		initSolarSystemAccordion();
		initSolarSystemView();
	}
	private void initSolarSystemAccordion() {
		solarSystemAccordion.getPanes().clear();
		for(Planet planet:solarSystem.getPlanets())
		{
			VBox pane = new VBox();
			pane.getChildren().add(new Text(planet.name));
			pane.getChildren().add(new PlanetButton(planet,"Go To Planet",this));
			solarSystemAccordion.getPanes().add(new TitledPane(planet.name,pane));
		}
	}
	private void initSolarSystemView(){
		SwingNode node = new SwingNode();
		node.setContent(new SolarSystemJPanel(solarSystem,this));
		solarSystemBorderPane.setCenter(new ScrollPane(node));
	}
	public void focusPlanetInAccordion(Planet planet) {
		for(TitledPane p:solarSystemAccordion.getPanes())
		{
			if(p.getText().equals(planet.name)) {
				p.setExpanded(true);
			}
		}
	}
	private void initPlanetTab(){
		getPlanetTab().setText("Planet:" + planet.name);
		initPlanetAccordion();
		initPlanetView();
	}
	private void initPlanetAccordion() {
		planetAccordion.getPanes().clear();
		planetAccordionAddCitys();
		planetAccordionAddVehicles();
	}
	private void planetAccordionAddCitys() {
		for(City c: planet.getAllCities())
		{
			VBox pane = new VBox();
			TitledPane titledPane;
			if(c.getParentCountry() == playersCountry)
			{
				pane.getChildren().add(new Text(c.toString()));
				Button button = new CityButton(c,"Go To City",this);
				pane.getChildren().add(button);
				titledPane = new TitledPane(c.name, pane);
				planetAccordion.getPanes().add(0,titledPane);
			}
			else
			{
				pane.getChildren().add(new Text(c.toString()));
				pane.getChildren().add(new Text("YOU DO NOT CONTROL THIS CITY"));
				Button button = new CityButton(c,"Go To City",this);
				pane.getChildren().add(button);
				titledPane = new TitledPane(c.name, pane);
				planetAccordion.getPanes().add(titledPane);
			}
		}
	}
	private void planetAccordionAddVehicles() {
		for(Vehicle v: planet.getAllVehicles()) {
			VBox pane = new VBox();
			pane.getChildren().add(new Text("Vehicle:" + v.getClass().getSimpleName()));
			if(v instanceof CityBuilder) {
				Button button = new Button("Build City"){{
					((CityBuilder)v).buildCity();
				}};
				pane.getChildren().add(button);
			}
			pane.getChildren().add(new Text("Going Towards:"));
			if(v.getDestination() != null)
				pane.getChildren().add(new Text(v.getDestination().toString()));
			else
				pane.getChildren().add(new Text("None"));
			planetAccordion.getPanes().add(new TitledPane(v.getClass().getName(),pane));
		}
	}
	private void initPlanetView() {
		try {
			planetViewScrollY = ((ScrollPane)planetBorderPane.getCenter()).getVvalue();
			planetViewScrollX = ((ScrollPane)planetBorderPane.getCenter()).getHvalue();
		}catch(Exception ignored) {}
		StackPane stackPane = new StackPane();
		GridPane gridPane = new GridPane();
		gridPane.setHgap(0);
		gridPane.setVgap(0);
		for(int y = 0; y < planet.getGrids().length;y++)
			for (int x = 0; x < planet.getGrids()[y].length; x++) {
				Grid grid = planet.getGrids()[y][x];
				Pane completeGridImage =  PlanetGroup.getPlanetGroup(grid,playersCountry,this);
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
		planetBorderPane.setCenter(new ScrollPane(stackPane){{
			setVvalue(planetViewScrollY);
			setHvalue(planetViewScrollX);
		}});
	}
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
	private static Image mountainImage = new Image(Controller.class.getResourceAsStream("mountainImage.jpg"));
	private static Image hillImage = new Image(Controller.class.getResourceAsStream("hillImage.jpg"));
	private static Image seaImage =  new Image(Controller.class.getResourceAsStream("seaImage.jpg"));
	private static Image landImage = new Image(Controller.class.getResourceAsStream("landImage.jpg"));
	private static Image wastelandImage =  new Image(Controller.class.getResourceAsStream("wastelandImage.jpg"));
	private static Image coastImage = new Image(Controller.class.getResourceAsStream("coastImage.jpg"));
	public static Image cityImage = new Image(Controller.class.getResourceAsStream("cityImage.jpg"));
	private static Image constructionSite = new Image(Controller.class.getResourceAsStream("constructionImage.jpg"));
	public static Image getImage(TerrainType terrainType) {
		switch (terrainType) {
			case Land:
				return landImage;
			case Sea:
				return seaImage;
			case Coast:
				return coastImage;
			case Mountains:
				return mountainImage;
			case Hills:
				return hillImage;
			case Wasteland:
				return wastelandImage;
		}
		throw  new IllegalStateException();
	}
	private void initCityTab(){
		getCityTab().setText("City:"  + city.name);
		initCityAccordion();
		initCityView();
		initCityAnchorPane();
	}
	private void initCityAccordion() {
		cityAccordion.getPanes().clear();
		for(Building b:city.getBuilding())
		{
			VBox pane = b.getPane();
			TitledPane titledPane = new TitledPane(b.name,pane);
			cityAccordion.getPanes().add(titledPane);
		}
	}
	public void selectVehicle(Vehicle vehicle) {
		System.out.println("click recieved");
		currentlySelectedVehicle = vehicle;
		initPlanetAccordion();
		initPlanetView();
	}
	private static class Point {
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Point)
				if(((Point) obj).x == x && ((Point) obj).y == y)
					return true;
			return false;
		}

		@Override
		public String toString() {
			return "x" + x + "y" + y  + "\n";
		}

		public boolean isValid() {
			if(x < 101 && x > -1)
				if(y < 101 && y > -1)
					return true;
			return false;
		}
	}
	public void initCityView() {
		System.out.println(""+System.nanoTime());
		GridPane gridPane = new GridPane();
		gridPane.setHgap(0);
		gridPane.setVgap(0);
		ArrayList<Point> points =  new ArrayList<>();

		for (Building b : city.getBuilding()) {
			int x = b.getParentBlock().x;
			int y = b.getParentBlock().y;

			ImageView buildingImageView = new ImageView();
			buildingImageView.setImage(getImage(b));
			buildingImageView.setPreserveRatio(true);
			buildingImageView.setFitHeight(200);
			buildingImageView.setFitWidth(200);
			buildingImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					focusBuildingInAccordion(b);
				}
			});
			points.add(new Point(x, y));
			gridPane.add(buildingImageView,x,y);
		}
		addEmptyWrapper(points,gridPane);//add new building locations
		cityScrollPane = new ScrollPane(gridPane);
		cityBorderPane.setCenter(cityScrollPane);
	}
	private void initCityAnchorPane(){
		VBox content = new VBox();
		content.getChildren().add(new Text("City Stats:"));
		content.getChildren().add(new Text("City Name:" + city.name));
		content.getChildren().add(new Text("Unemployment:" + city.getJobLessCount()));
		content.getChildren().add(new Button("Assign unemployed to Job"));// TODO: 5/19/2016
		content.getChildren().add(new Button("Automatically assign unemployed to Job"));// TODO: 5/19/2016
		content.getChildren().add(new Text("Homeless:" + city.getHomeLessCount()));
		content.getChildren().add(new Button("Assign homeless to housing")); // TODO: 5/19/2016
		content.getChildren().add(new Button("Automatically assign homeless to housing"));// TODO: 5/19/2016
		content.getChildren().add(new Text("Money Available:" + city.getMoneySource().getWealth()));
		citySpecificPane.getChildren().add(new ScrollPane(content));
	}
	private void addEmptyWrapper(ArrayList<Point> points, GridPane gridPane) {
		for(Point p:points)
			addEmpty(points,p,gridPane,2);
	}
	private void addEmpty(ArrayList<Point> points,Point p,GridPane gridPane,int depth) {
		Controller controller = this;
		if(!contains(points,p)) {
			if(p.isValid())
				gridPane.add(new ImageView(emptyImage){{setPreserveRatio(true);setFitHeight(200);setFitWidth(200);
					setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							int i = cityAccordion.getPanes().size() - 1;
							NewBuildingPane newBuildingPane;
							if(cityAccordion.getPanes().get(i) instanceof NewBuildingPane)
							{
								cityAccordion.getPanes().remove(i);
							}
							newBuildingPane = new NewBuildingPane(controller,city, p.x, p.y);
							cityAccordion.getPanes().add(newBuildingPane);
							cityScrollPane.setVvalue(cityScrollPane.getVmax());
							newBuildingPane.setExpanded(true);
						}
					});}}, p
						.x, p.y);
		}
		if(depth == 0)
			return;
		addEmpty(points, new Point(p.x + 1, p.y),gridPane,depth - 1);
		addEmpty(points, new Point(p.x + 1, p.y + 1),gridPane,depth - 1);
		addEmpty(points, new Point(p.x + 1, p.y - 1),gridPane,depth - 1);
		addEmpty(points, new Point(p.x, p.y + 1), gridPane, depth - 1);
		addEmpty(points, new Point(p.x, p.y - 1), gridPane, depth - 1);
		addEmpty(points, new Point(p.x - 1, p.y + 1),gridPane,depth - 1);
		addEmpty(points, new Point(p.x - 1, p.y), gridPane, depth - 1);
		addEmpty(points, new Point(p.x, p.y),gridPane,depth - 1);

	}
	private boolean contains(ArrayList<Point> points,Point point) {
		for(Point p:points)
			if(point.x == p.x && point.y == p.y)
				return true;
		return false;
	}
	private Image apartmentBlockImage = new Image(Controller.class.getResourceAsStream("apartmentBlockImage.jpg"));
	private Image houseBlockImage = new Image(Controller.class.getResourceAsStream("houseBlockImage.jpg"));
	private Image rulersHouseImage = new Image(Controller.class.getResourceAsStream("rulersHouseImage.jpg"));
	private Image dockYardImage = new Image(Controller.class.getResourceAsStream("dockYardImage.jpg"));
	private Image factoryImage = new Image(Controller.class.getResourceAsStream("factoryImage.jpg"));
	private Image hospitalImage = new Image(Controller.class.getResourceAsStream("hospitalImage.jpg"));
	private Image industrialDockImage = new Image(Controller.class.getResourceAsStream("industrialDockImage.jpg"));
	private Image researchAreaImage = new Image(Controller.class.getResourceAsStream("researchAreaImage.jpg"));
	private Image schoolImage = new Image(Controller.class.getResourceAsStream("schoolImage.jpg"));
	private Image townHallImage = new Image(Controller.class.getResourceAsStream("townHallImage.jpg"));
	private Image warehouseImage = new Image(Controller.class.getResourceAsStream("wareHouseImage.png"));
	private Image emptyImage = new Image(Controller.class.getResourceAsStream("emptyImage.jpg"));
	private Image getImage(Building building) {
		if(building instanceof Housing)
		{
			if(building instanceof ApartmentBlock)
				return apartmentBlockImage;
			if(building instanceof RulersHouse)
				return rulersHouseImage;
			if(building instanceof WorkersHouseBlock)
				return houseBlockImage;
		}
		else if(building instanceof Workplace)
		{
			if(building instanceof DockYard)
				return dockYardImage;
			if(building instanceof Factory)
				return factoryImage;
			if(building instanceof Hospital)
				return hospitalImage;
			if(building instanceof IndustrialDock)
				return industrialDockImage;
			if(building instanceof  ResearchArea)
				return researchAreaImage;
			if(building instanceof School)
				return schoolImage;
			if(building instanceof TownHall)
				return townHallImage;
			if(building instanceof Warehouse)
				return warehouseImage;
		}
		return null;
	}
	public void switchTo(Universe u) {
		//unlikely to have more than one universe
		tabPane.getSelectionModel().select(getUniverseTab());
	}
	public void switchTo(SolarSystem s) {
		solarSystem = s;
		initSolarSystemTab();
		tabPane.getSelectionModel().select(getSolarSystemTab());

	}
	public void switchTo(Planet p) {
		solarSystem = p.getParentSolarSystem();
		planet = p;
		initSolarSystemTab();
		tabPane.getSelectionModel().select(getPlanetTab());
		initPlanetTab();
	}
	public void switchTo(City c) {
		solarSystem = c.getGrid().getParentPlanet().getParentSolarSystem();
		planet = c.getGrid().getParentPlanet();
		city = c;
		initSolarSystemTab();
		initPlanetTab();
		initCityTab();
		tabPane.getSelectionModel().select(getCityTab());
	}
	public void focusCityInAccordion(City c) {
		for(TitledPane p:planetAccordion.getPanes())
		{
			if(p.getText().equals(c.name)) {
				p.setExpanded(true);
			}
		}
	}
	private void focusBuildingInAccordion(Building b) {
		int i = city.getBuilding().indexOf(b);
		cityAccordion.getPanes().get(i).setExpanded(true);
	}
	public Tab getUniverseTab() {
		try {
			return tabPane.getTabs().get(0);
		}
		catch(IndexOutOfBoundsException e) {
			return null;
		}
	}
	public Tab getSolarSystemTab() {
		try {
			return tabPane.getTabs().get(1);
		}
		catch(IndexOutOfBoundsException e) {
			return null;
		}
	}
	public Tab getPlanetTab() {
		try {
			return tabPane.getTabs().get(2);
		}
		catch(IndexOutOfBoundsException e) {
			return null;
		}
	}
	public Tab getCityTab() {
		try {
			return tabPane.getTabs().get(3);
		}
		catch(IndexOutOfBoundsException e) {
			return null;
		}
	}
}
