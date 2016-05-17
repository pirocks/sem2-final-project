package ui.view;

import engine.buildings.Building;
import engine.cities.City;
import engine.planets.Planet;
import engine.universe.Country;
import engine.universe.SolarSystem;
import engine.universe.Universe;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ui.view.city.CityBlockPanel;
import ui.view.city.CityButton;
import ui.view.city.EmptyCityBlock;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by bob on 5/14/2016.
 *
 */
public class Controller implements Initializable{
	//despite the vast number of vars having this all in one class seems good
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
//	@FXML
//	SwingNode citySwingNode;

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
		initVars();
		initUniverseTab();
		initSolarSystemTab();
		initPlanetTab();
		initCityTab();
		switchTo(city);
	}
	private void initVars(){
		playersCountry = Universe.playersCountry;
		city = Universe.playersCountry.getCapitalCity();
		planet = city.getParentGrid().getParentPlanet();
		solarSystem = planet.getParentSolarSystem();
		universe = Main.getUniverse();
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
		solarSystemAccordion.getPanes().clear();
		for(Planet planet:solarSystem.getPlanets())
		{
			VBox pane = new VBox();
			pane.getChildren().add(new Text(planet.name));
			pane.getChildren().add(new PlanetButton(planet,"Go To Planet",this));
			solarSystemAccordion.getPanes().add(new TitledPane(planet.name,pane));
		}
	}
	private void initPlanetTab(){
		getPlanetTab().setText("Planet:" + planet.name);
		planetAccordion.getPanes().clear();
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
	private void initCityTab(){
		getCityTab().setText("City:"  + city.name);
		initCityAccordion();
		initCityView();

	}
	private void initCityAccordion()
	{
		cityAccordion.getPanes().clear();
		for(Building b:city.getBuilding())
		{
			VBox pane = new VBox();
			pane.getChildren().add(new Text(b.toString()));
			TitledPane titledPane = new TitledPane(b.name,pane);
			cityAccordion.getPanes().add(titledPane);
		}
	}
	class Point {
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
	}
	private void initCityView() {
		GridPane gridPane = new GridPane();
		gridPane.setHgap(0);
		gridPane.setVgap(0);
		ArrayList<Point> points =  new ArrayList<>();
		for (Building b : city.getBuilding()) {
			int x = b.getParentBlock().x;
			int y = b.getParentBlock().y;
			SwingNode node = new SwingNode();
			node.setContent(new CityBlockPanel(b.getParentBlock(), x, y));
			gridPane.add(node, x, y);
			points.add(new Point(x,y));
		}
		addEmptyWrapper(points,gridPane);
		cityBorderPane.setCenter(new ScrollPane(gridPane));
	}
	private void addEmptyWrapper(ArrayList<Point> points, GridPane gridPane)
	{
		for(Point p:points)
			addEmpty(points,p,gridPane,0);
	}
	private void addEmpty(ArrayList<Point> points,Point p,GridPane gridPane,int depth)
	{
		gridPane.add(new SwingNode(){{setContent(new EmptyCityBlock());}},p.x,p.y);
		if(depth == 0)
			return;
		if(!contains(points,(new Point(p.x + 1,p.y))))
			addEmpty(points,new Point(p.x + 1,p.y),gridPane,depth - 1);
		if(!contains(points,(new Point(p.x + 1,p.y + 1))))
			addEmpty(points,new Point(p.x + 1,p.y + 1),gridPane,depth - 1);
		if(!contains(points,(new Point(p.x + 1,p.y - 1))))
			addEmpty(points,new Point(p.x + 1,p.y - 1),gridPane,depth - 1);
		if(!contains(points,(new Point(p.x,p.y + 1))))
			addEmpty(points,new Point(p.x,p.y + 1), gridPane, depth - 1);
		if(!contains(points,(new Point(p.x,p.y - 1))))
			addEmpty(points,new Point(p.x,p.y - 1), gridPane, depth - 1);
		if(!contains(points,(new Point(p.x - 1,p.y + 1))))
			addEmpty(points,new Point(p.x - 1,p.y + 1),gridPane,depth - 1);
		if(!contains(points,(new Point(p.x - 1,p.y))))
			addEmpty(points,new Point(p.x - 1, p.y), gridPane, depth - 1);
		if(!contains(points,(new Point(p.x,p.y))))
			addEmpty(points,new Point(p.x,p.y),gridPane,depth - 1);

	}
	public boolean contains(ArrayList<Point> points,Point point)
	{
		for(Point p:points)
			if(p.equals(points.get(0)))
				return true;
		return false;
	}
	public void switchTo(Universe u)
	{
		//unlikely to have more than one universe
		tabPane.getSelectionModel().select(getUniverseTab());
	}
	public void switchTo(SolarSystem s)
	{
		solarSystem = s;
		initSolarSystemTab();
		tabPane.getSelectionModel().select(getSolarSystemTab());

	}
	public void switchTo(Planet p)
	{
		solarSystem = p.getParentSolarSystem();
		planet = p;
		initSolarSystemTab();
		initPlanetTab();
		tabPane.getSelectionModel().select(getPlanetTab());
	}
	public void switchTo(City c)
	{
		solarSystem = c.getGrid().getParentPlanet().getParentSolarSystem();
		planet = c.getGrid().getParentPlanet();
		city = c;
		initSolarSystemTab();
		initPlanetTab();
		initCityTab();
		tabPane.getSelectionModel().select(getCityTab());
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
