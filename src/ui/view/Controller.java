package ui.view;

import engine.buildings.Building;
import engine.buildings.UnderConstruction;
import engine.buildings.housing.ApartmentBlock;
import engine.buildings.housing.Housing;
import engine.buildings.housing.RulersHouse;
import engine.buildings.housing.WorkersHouseBlock;
import engine.buildings.workplaces.*;
import engine.cities.City;
import engine.cities.CityBlock;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ui.view.solarsystem.SolarSystemJPanel;

import java.net.URL;
import java.util.ResourceBundle;

/*
 * Created by bob on 5/14/2016.
 */
public class Controller implements Initializable{
	public static Controller controller;
	@FXML
	TabPane tabPane;
	@FXML
	BorderPane universeBorderPane;
	@FXML
	BorderPane solarSystemBorderPane;
	@FXML
	BorderPane planetBorderPane;
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

	public CityAccordion cityAccordionManager = new CityAccordion();
	CityBorderPane cityBorderPaneManager = new CityBorderPane();
	PlanetAccordion planetAccordionManager = new PlanetAccordion();
	public PlanetBorderPane planetBorderPaneManager=  new PlanetBorderPane();
	SolarSystemAccordion solarSystemAccordionManager = new SolarSystemAccordion();
	UniverseAccordion universeAccordionManager = new UniverseAccordion();
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
		initCityVars();
		initPlanetVars();
		initUniverseVars();
		return out;
	}
	private void initUniverseVars() {
		solarSystemAccordionManager.initVars(solarSystem,this,solarSystemAccordion);
		universeAccordionManager.initVars(universe,playersCountry,this,universeAccordion);
	}
	private void initPlanetVars() {
		planetAccordionManager.initVars(planet,playersCountry,this,planetAccordion);
		planetBorderPaneManager.initVars(planet,playersCountry,this,planetBorderPane);
	}
	private void initCityVars() {
		cityAccordionManager.initVars(city,cityAccordion);
		cityBorderPaneManager.initVars(city,this,cityBorderPane);
	}
	private void initUniverseTab(){
		universeAccordionManager.init();
	}
	private void initSolarSystemTab(){
		getSolarSystemTab().setText("Solar System:" + solarSystem.name);
		initSolarSystemAccordion();
		initSolarSystemView();
	}
	private void initSolarSystemAccordion() {
		solarSystemAccordionManager.init();
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
	public void initPlanetAccordion() {
		planetAccordionManager.init();
	}
	public void initPlanetView() {
		planetBorderPaneManager.init();
	}
	public static Image getImage(TerrainType type){
		switch(type){
			case Land:
				return images.landImage.getImage();
			case Sea:
				return images.seaImage.getImage();
			case Coast:
				return images.coastImage.getImage();
			case Mountains:
				return images.mountainImage.getImage();
			case Hills:
				return images.hillImage.getImage();
			case Wasteland:
				return images.wastelandImage.getImage();
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
		cityAccordionManager.init();
	}
	public void initCityView() {
		cityBorderPaneManager.init();
	}
	private void initCityAnchorPane(){
		VBox content = new VBox();
		content.getChildren().add(new Text("City Stats:"));
		content.getChildren().add(new Text("City Name:" + city.name));
		content.getChildren().add(new Text("Unemployment:" + city.getJobLessCount()));
		content.getChildren().add(new Button("Assign unemployed to Job"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					// TODO: 5/19/2016
				}
			});
		}});
		content.getChildren().add(new Text("Homeless:" + city.getHomeLessCount()));
		content.getChildren().add(new Button("Assign homeless to housing"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					// TODO: 5/19/2016
				}
			});
		}});
		content.getChildren().add(new Text("Money Available:" + city.getMoneySource().getWealth()));
		citySpecificPane.getChildren().add(new ScrollPane(content));
	}
	public ImageView getImage(Building building) {
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
			if(building instanceof UnderConstruction){
				return images.constructionSite;
			}
		}
		return null;
	}
	public void switchTo(Universe u) {
		//unlikely to have more than one universe
		tabPane.getSelectionModel().select(getUniverseTab());
	}
	public void switchTo(SolarSystem s) {
		solarSystem = s;
		initUniverseVars();
		initSolarSystemTab();
		tabPane.getSelectionModel().select(getSolarSystemTab());

	}
	public void switchTo(Planet p) {
		solarSystem = p.getParentSolarSystem();
		planet = p;
		initPlanetVars();
		initSolarSystemTab();
		tabPane.getSelectionModel().select(getPlanetTab());
		initPlanetTab();
	}
	public void switchTo(City c) {
		if(c == null)
			throw new IllegalArgumentException();
		solarSystem = c.getGrid().getParentPlanet().getParentSolarSystem();
		planet = c.getGrid().getParentPlanet();
		city = c;
		initVars();
		initSolarSystemTab();
		initPlanetTab();
		city = c;
		initCityVars();
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
	public void focusBuildingInAccordion(Building b) {
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
	public void liverUpdate() {
		cityAccordionManager.liverUpdate();
	}
	public void switchTo(CityBlock block) {
		switchTo(block.getParentCity());
		focusBuildingInAccordion(block.getBuilding());
	}
	public void updateResearchAreas() {
		cityAccordionManager.updateResearchAreas();
	}
	public static class images {
		public static ImageView wastelandImage =  new ImageView(){{setImage(new Image(Controller.class.getResourceAsStream("wastelandImage" +
				".jpg")));setPreserveRatio(true);setFitHeight(200);setFitHeight(200);}};
		public static ImageView coastImage = new ImageView(){{setImage(new Image(Controller.class.getResourceAsStream("coastImage.jpg")));setPreserveRatio(true);setFitHeight(200);setFitHeight(200);}};
		public static ImageView cityImage = new ImageView(){{setImage(new Image(Controller.class.getResourceAsStream("cityImage.jpg")));setPreserveRatio(true);setFitHeight(200);setFitHeight(200);}};
		public static ImageView landImage = new ImageView(){{setImage(new Image(Controller.class.getResourceAsStream("landImage.jpg")));setPreserveRatio(true);setFitHeight(200);setFitHeight(200);}};
		public static ImageView constructionSite = new ImageView(){{setImage(new Image(Controller.class.getResourceAsStream
				("constructionImage" +
				".jpg")));setPreserveRatio(true);setFitHeight(200);setFitHeight(200);}};
		public static ImageView apartmentBlockImage = new ImageView(){{setImage(new Image(Controller.class
				.getResourceAsStream
				("apartmentBlockImage" +
				".jpg")));setPreserveRatio(true);setFitHeight(200);setFitHeight(200);}};
		public static ImageView houseBlockImage = new ImageView(){{setImage(new Image(Controller.class.getResourceAsStream
				("houseBlockImage" +
				".jpg")));setPreserveRatio(true);setFitHeight(200);setFitHeight(200);}};
		public static ImageView rulersHouseImage = new ImageView(){{setImage(new Image(Controller.class.getResourceAsStream
				("rulersHouseImage" +
				".jpg")));setPreserveRatio(true);setFitHeight(200);setFitHeight(200);}};
		public static ImageView dockYardImage = new ImageView(){{setImage(new Image(Controller.class.getResourceAsStream("dockYardImage" +
				".jpg")));setPreserveRatio(true);setFitHeight(200);setFitHeight(200);}};
		public static ImageView factoryImage = new ImageView(){{setImage(new Image(Controller.class.getResourceAsStream("factoryImage.jpg")
		));setFitHeight(200);setFitHeight(200);}};
		public static ImageView hospitalImage = new ImageView(){{setImage(new Image(Controller.class.getResourceAsStream("hospitalImage" +
				".jpg")));setPreserveRatio(true);setFitHeight(200);setFitHeight(200);}};
		public static ImageView industrialDockImage = new ImageView(){{setImage(new Image(Controller.class.getResourceAsStream("industrialDockImage.jpg")));setPreserveRatio(true);setFitHeight(200);setFitHeight(200);}};
		public static ImageView researchAreaImage = new ImageView(){{setImage(new Image(Controller.class
				.getResourceAsStream
				("researchAreaImage" +
				".jpg")));setPreserveRatio(true);setFitHeight(200);setFitHeight(200);}};
		public static ImageView schoolImage = new ImageView(){{setImage(new Image(Controller.class.getResourceAsStream("schoolImage.jpg")));setPreserveRatio(true);setFitHeight(200);setFitHeight(200);}};
		public static ImageView townHallImage = new ImageView(){{setImage(new Image(Controller.class.getResourceAsStream("townHallImage" +
				".jpg")));setPreserveRatio(true);setFitHeight(200);setFitHeight(200);}};
		public static ImageView warehouseImage = new ImageView(){{setImage(new Image(Controller.class.getResourceAsStream("wareHouseImage" +
				                                                                                          ".png")));setPreserveRatio(true);setFitHeight(200);setFitHeight(200);}};
		public static ImageView emptyImage = new ImageView(){{setImage(new Image(Controller.class.getResourceAsStream("emptyImage.jpg")));setPreserveRatio(true);setFitHeight(200);setFitHeight(200);}};
		public static ImageView mountainImage = new ImageView(){{setImage(new Image(Controller.class.getResourceAsStream("mountainImage" +
				".jpg")));setPreserveRatio(true);setFitHeight(200);setFitHeight(200);}};
		public static ImageView hillImage = new ImageView(){{setImage(new Image(Controller.class.getResourceAsStream("hillImage.jpg")));setPreserveRatio(true);setFitHeight(200);setFitHeight(200);}};
		public static ImageView seaImage =  new ImageView(){{setImage(new Image(Controller.class.getResourceAsStream
				("seaImage" +
				".jpg")));setPreserveRatio(true);setFitHeight(200);setFitHeight(200);}};
	}
}
