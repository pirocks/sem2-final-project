package ui.view;

import engine.buildings.Building;
import engine.buildings.housing.ApartmentBlock;
import engine.buildings.housing.Housing;
import engine.buildings.housing.RulersHouse;
import engine.buildings.housing.WorkersHouseBlock;
import engine.buildings.workplaces.*;
import engine.cities.City;
import engine.planets.LocationPlanet;
import engine.planets.Planet;
import engine.planets.TerrainType;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ui.view.city.NewBuildingPane;
import ui.view.solarsystem.SolarSystemJPanel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/*
 * Created by bob on 5/14/2016.
 */
public class Controller implements Initializable{
	public static Controller controller;
	//despite the vast number of vars having this all in one class seems like the best way. having multiple
	// controller classes gets very messy with controller class references all over the place
	@FXML
	TabPane tabPane;
	@FXML
	BorderPane universeBorderPane;
	@FXML
	BorderPane solarSystemBorderPane;
	@FXML
	PlanetBorderPane planetBorderPane;
	@FXML
	BorderPane cityBorderPane;
	@FXML
	UniverseAccordion universeAccordion;
	@FXML
	SolarSystemAccordion solarSystemAccordion;
	@FXML
	PlanetAccordion planetAccordion;
	@FXML
	CityAccordion cityAccordion;
	@FXML
	AnchorPane citySpecificPane;

	private ScrollPane cityScrollPane;
	private Universe universe;
	private Country playersCountry;
	private SolarSystem solarSystem;
	private Planet planet;
	private City city;


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
		controller = this;
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
		boolean out = false;
		playersCountry = Universe.playersCountry;
		city = Universe.playersCountry.getCapitalCity();
		universe = Main.getUniverse();
		if(city == null) {
			LocationPlanet locationPlanet = playersCountry.initialBuilder.getLocation().get(0);
			planet = locationPlanet.getPlanet();
			solarSystem = planet.getParentSolarSystem();
			out = false;
		}
		else {
			planet = city.getParentGrid().getParentPlanet();
			solarSystem = planet.getParentSolarSystem();
			out =  true;
		}
		planetAccordion.initVars(planet,playersCountry,this);
		planetBorderPane.initVars(planet,playersCountry,this);
		solarSystemAccordion.initVars(solarSystem,this);
		universeAccordion.initVars(universe,playersCountry,this);
		return out;
	}
	private void initUniverseTab(){
		universeAccordion.init();
	}
	private void initSolarSystemTab(){
		getSolarSystemTab().setText("Solar System:" + solarSystem.name);
		initSolarSystemAccordion();
		initSolarSystemView();
	}
	private void initSolarSystemAccordion() {
		solarSystemAccordion.init();
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
	void initPlanetAccordion() {
		planetAccordion.init();
	}
	void initPlanetView() {
		planetBorderPane.init();
	}
	public static Image getImage(TerrainType type){
		switch(type){
			case Land:
				return images.landImage;
			case Sea:
				return images.seaImage;
			case Coast:
				return images.coastImage;
			case Mountains:
				return images.mountainImage;
			case Hills:
				return images.hillImage;
			case Wasteland:
				return images.wastelandImage;
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
				gridPane.add(new ImageView(images.emptyImage){{setPreserveRatio(true);setFitHeight(200);setFitWidth(200);
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
	private Image getImage(Building building) {
		if(building instanceof Housing)
		{
			if(building instanceof ApartmentBlock)
				return images.apartmentBlockImage;
			if(building instanceof RulersHouse)
				return images.rulersHouseImage;
			if(building instanceof WorkersHouseBlock)
				return images.houseBlockImage;
		}
		else if(building instanceof Workplace)
		{
			if(building instanceof DockYard)
				return images.dockYardImage;
			if(building instanceof Factory)
				return images.factoryImage;
			if(building instanceof Hospital)
				return images.hospitalImage;
			if(building instanceof IndustrialDock)
				return images.industrialDockImage;
			if(building instanceof  ResearchArea)
				return images.researchAreaImage;
			if(building instanceof School)
				return images.schoolImage;
			if(building instanceof TownHall)
				return images.townHallImage;
			if(building instanceof Warehouse)
				return images.warehouseImage;
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

	public static class images {
		public static Image wastelandImage =  new Image(Controller.class.getResourceAsStream("wastelandImage.jpg"));
		public static Image coastImage = new Image(Controller.class.getResourceAsStream("coastImage.jpg"));
		public static Image cityImage = new Image(Controller.class.getResourceAsStream("cityImage.jpg"));
		public static Image landImage = new Image(Controller.class.getResourceAsStream("landImage.jpg"));
		public static Image constructionSite = new Image(Controller.class.getResourceAsStream("constructionImage.jpg"));
		public static Image apartmentBlockImage = new Image(Controller.class.getResourceAsStream("apartmentBlockImage" +
				".jpg"));
		public static Image houseBlockImage = new Image(Controller.class.getResourceAsStream("houseBlockImage.jpg"));
		public static Image rulersHouseImage = new Image(Controller.class.getResourceAsStream("rulersHouseImage.jpg"));
		public static Image dockYardImage = new Image(Controller.class.getResourceAsStream("dockYardImage.jpg"));
		public static Image factoryImage = new Image(Controller.class.getResourceAsStream("factoryImage.jpg"));
		public static Image hospitalImage = new Image(Controller.class.getResourceAsStream("hospitalImage.jpg"));
		public static Image industrialDockImage = new Image(Controller.class.getResourceAsStream("industrialDockImage.jpg"));
		public static Image researchAreaImage = new Image(Controller.class.getResourceAsStream("researchAreaImage.jpg"));
		public static Image schoolImage = new Image(Controller.class.getResourceAsStream("schoolImage.jpg"));
		public static Image townHallImage = new Image(Controller.class.getResourceAsStream("townHallImage.jpg"));
		public static Image warehouseImage = new Image(Controller.class.getResourceAsStream("wareHouseImage.png"));
		public static Image emptyImage = new Image(Controller.class.getResourceAsStream("emptyImage.jpg"));
		public static Image mountainImage = new Image(Controller.class.getResourceAsStream("mountainImage.jpg"));
		public static Image hillImage = new Image(Controller.class.getResourceAsStream("hillImage.jpg"));
		public static Image seaImage =  new Image(Controller.class.getResourceAsStream("seaImage.jpg"));
	}
}
