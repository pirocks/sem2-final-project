package ui.view;

import engine.buildings.Building;
import engine.cities.City;
import engine.planets.Grid;
import engine.planets.Planet;
import engine.planets.TerrainType;
import engine.universe.Country;
import engine.universe.SolarSystem;
import engine.universe.Universe;
import javafx.embed.swing.SwingNode;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ui.view.city.CityBlockPanel;
import ui.view.city.CityButton;
import ui.view.city.EmptyCityBlock;
import ui.view.planet.PlanetButton;
import ui.view.solarsystem.SolarSystemButton;
import ui.view.solarsystem.SolarSystemJPanel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by bob on 5/14/2016.
 *
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
	private void initPlanetView() {
		/*GridPane gridPane = new GridPane();
		gridPane.setVgap(0);
		gridPane.setHgap(0);
		for(int y = 0; y < planet.getGrids().length;y++)
			for(int x = 0; x < planet.getGrids()[y].length;x++)
			{
				JComponent content;
//				content = new GridPanel(planet.getGrids()[finalY][finalX]);
//              content = new JButton();
				content = new JPanel();
//				content.add(new JButton());
				content.add(new GridPanel(this, planet.getGrids()[y][x]));
				content.repaint();
				content.revalidate();
				gridPane.add(new SwingNode(){{setContent(content);}},x,y);
			}
		planetBorderPane.setCenter(new ScrollPane(gridPane));*/
		/*JPanel gridView = new GridViewPanel(planet,this);
		SwingNode swingNode = new SwingNode();
		swingNode.setContent(gridView);
		planetBorderPane.setCenter(new ScrollPane(swingNode));*/

		GridPane gridPane = new GridPane();
		gridPane.setHgap(0);
		gridPane.setHgap(0);
		gridPane.autosize();
		for(int y = 0; y < planet.getGrids().length;y++)
			for (int x = 0; x < planet.getGrids()[y].length; x++) {
				Grid grid = planet.getGrids()[y][x];
				ImageView terrainImageView = new ImageView();
				terrainImageView.setImage(getImage(grid.getTerrainType()));
				terrainImageView.setPreserveRatio(true);
				terrainImageView.setFitHeight(200);
				terrainImageView.setFitWidth(200);
				ArrayList<Node> imageList = new ArrayList<>();
				imageList.add(terrainImageView);
				for (City c : grid.getCitys()) {
					ImageView cityImageView = new ImageView();
					cityImageView.setOnMouseMoved(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							focusCityInAccordion(c);
						}
					});
					cityImageView.setImage(cityImage);
					cityImageView.setPreserveRatio(true);
					cityImageView.setFitWidth(150);
					cityImageView.setFitHeight(150);
					imageList.add(cityImageView);
				}
				Group completeGridImage = new Group(imageList);
				gridPane.add(completeGridImage, x, y);
			}
		planetBorderPane.setCenter(new ScrollPane(gridPane));
		System.out.print("done");
	}

	private static Image mountainImage = new Image("http://3.imimg.com/data3/FK/TS/MY-16623584/himalayan-gateway-tour-package-125x12.jpg");
	private static Image hillImage = new Image("http://s7.eu.is.pp.ru/l/larismilke/1/46299541Rkj.jpg");
	private static Image seaImage =  new Image("http://cs629408.vk.me/v629408061/2cabc/LoMYe0EB2HI.jpg");
	private static Image landImage = new Image("http://www.mayrwirt.at/wp-content/uploads/musik-haus.jpg");
	private static Image wastelandImage =  new Image("http://vignette4.wikia.nocookie.net/fallout/images/a/a0/WastelandPicture.jpg/revision/latest/scale-to-width-down/180?cb=20110309003621");
	private static Image coastImage = new Image("http://republic.pink/MyThumb.php?file=images/1/0/2/8/8/3/4/en/1-coastImage.jpg&size=200");
	private static Image cityImage = new Image("https://image.freepik" +
			".com/free-icon/set-of-buildings-in-a-city_318-41262" +
			".jpg");
	private static boolean resizedQ = false;


	private Image getImage(TerrainType terrainType) {
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
		return null;
	}
	private void initCityTab(){
		getCityTab().setText("City:"  + city.name);
		initCityAccordion();
		initCityView();

	}
	private void initCityAccordion() {
		cityAccordion.getPanes().clear();
		for(Building b:city.getBuilding())
		{
			VBox pane = new VBox();
			pane.getChildren().add(new Text(b.toString()));
			TitledPane titledPane = new TitledPane(b.name,pane);
			cityAccordion.getPanes().add(titledPane);
		}
	}
	private class Point {
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
	private void initCityView() {
		System.out.println(""+System.nanoTime());
		GridPane gridPane = new GridPane();
		gridPane.setHgap(0);
		gridPane.setVgap(0);
		ArrayList<Point> points =  new ArrayList<>();
		class Column {
			ArrayList<SwingNode> nodes;
			int y;
			public Column(ArrayList<SwingNode> nodes,int y)
			{
				this.y = y;
				this.nodes = nodes;
			}
		}

		ArrayList<Column> columns = new ArrayList<>();
		for (Building b : city.getBuilding()) {
			int x = b.getParentBlock().x;
			int y = b.getParentBlock().y;
			SwingNode node = new SwingNode();
			node.setContent(new CityBlockPanel(b.getParentBlock(), x, y));
			points.add(new Point(x,y));
			gridPane.add(node,x,y);
//			boolean foundQ = false;
//			for(Column c:columns)
//			{
//				if(c.y == y)
//				{
//					c.nodes.add(node);
//					foundQ = true;
//					break;
//				}
//			}
//			if(!foundQ) {
//				ArrayList<SwingNode> list = new ArrayList<>();
//				list.add(node);
//				columns.add(new Column(list, y));
//			}
		}
//		for(Column column:columns)
//		{
////			gridPane.addColumn(column.y, column.nodes);
//		}
		addEmptyWrapper(points,gridPane);
		cityBorderPane.setCenter(new ScrollPane(gridPane));
	}
	private void addEmptyWrapper(ArrayList<Point> points, GridPane gridPane) {
		for(Point p:points)
			addEmpty(points,p,gridPane,2);
	}
	private void addEmpty(ArrayList<Point> points,Point p,GridPane gridPane,int depth) {
		if(!contains(points,p)) {
			if(p.isValid())
				gridPane.add(new SwingNode() {{setContent(new EmptyCityBlock());}}, p.x, p.y);
		}
		if(depth == 0)
			return;
		addEmpty(points,new Point(p.x + 1,p.y),gridPane,depth - 1);
		addEmpty(points,new Point(p.x + 1,p.y + 1),gridPane,depth - 1);
		addEmpty(points,new Point(p.x + 1,p.y - 1),gridPane,depth - 1);
		addEmpty(points,new Point(p.x,p.y + 1), gridPane, depth - 1);
		addEmpty(points,new Point(p.x,p.y - 1), gridPane, depth - 1);
		addEmpty(points,new Point(p.x - 1,p.y + 1),gridPane,depth - 1);
		addEmpty(points,new Point(p.x - 1, p.y), gridPane, depth - 1);
		addEmpty(points,new Point(p.x,p.y),gridPane,depth - 1);

	}
	private boolean contains(ArrayList<Point> points,Point point) {
		for(Point p:points)
			if(point.x == p.x && point.y == p.y)
				return true;
		return false;
	}

	private Image apartmentBlockImage = new Image("https://photos.travelblog.org/Photos/12544/398145/f/3804575-Soviet-apartment-block-0.jpg");
	private Image houseBlockImage = new Image("http://www.fritzhaeg.com/wikidiary/wp-content/uploads/2010/04/2010-04-09-P1140314.jpg");
	private Image rulersHouseImage = new Image("http://joanneleedom-ackerman.com/wp-content/uploads/2016/02/WhiteHouseAerialView.jpg");
	private Image dockYardImage = new Image("http://antiguahistory.net/Museum/images/DockyardAirEastDec03-3.jpg");
	private Image factoryImage = new Image("");
	private Image hospitalImage = new Image("");
	private Image industrialDockImage = new Image("");
	private Image researchAreaImage = new Image("");
	private Image schoolImage = new Image("");
	private Image townHallImage = new Image("");
	private Image warehouseImage = new Image("");
	private Image workplaceImage = new Image("");

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
