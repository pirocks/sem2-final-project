package ui.view.city;

import engine.buildings.UnderConstruction;
import engine.buildings.housing.ApartmentBlock;
import engine.buildings.housing.RulersHouse;
import engine.buildings.housing.WorkersHouseBlock;
import engine.buildings.workplaces.*;
import engine.cities.City;
import engine.cities.CityBlock;
import engine.cities.Container;
import engine.planets.LocationPlanet;
import engine.tools.weapons.Attackable;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import ui.view.Controller;

/**
 * Created by bob on 5/22/2016.
 */
public class NewBuildingPane extends TitledPane implements Container{
	public NewBuildingPane(Controller controller,City city, int x, int y) {
		super();
		VBox content = new VBox();
		LocationPlanet locationPlanet = new LocationPlanet(city.getParentGrid(),x,y);
		CityBlock block = new CityBlock(city, x,y);
		registerContainer(block);
		addApartmentBlock(controller, city, content, locationPlanet, block);
		addRulersHouse(controller, city, content, locationPlanet, block);
		addWorkersHouseBlock(controller, city, content, locationPlanet, block);
		addDockYard(controller, city, content, locationPlanet, block);
		addFactory(controller, city, content, locationPlanet, block);
		addHospital(content, city, locationPlanet, block, controller);
		addIndustrialBlock(controller, city, content, locationPlanet, block);
		addResearchArea(controller, city, content, locationPlanet, block);
		addSchool(controller, city, content, locationPlanet, block);
		addTownHall(controller, city, content, locationPlanet, block);
		addWarehouse(controller, city, content, locationPlanet, block);
		super.setContent(content);
		Controller.controller.initCityView();
		controller.cityAccordionManager.init();
		Controller.controller.cityAccordionManager.init();
	}

	public boolean addWarehouse(final Controller controller, final City city, VBox content, final LocationPlanet locationPlanet, final CityBlock block) {
		return content.getChildren().add(new Button("Build New Warehouse"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					city.buildBuilding(new UnderConstruction<Warehouse>(locationPlanet,new Warehouse(block,city.getMoneySource()),
							city));
					controller.initCityView();
					controller.cityAccordionManager.init();
				}
			});
		}});
	}
	public boolean addTownHall(final Controller controller, final City city, VBox content, final LocationPlanet locationPlanet, final CityBlock block) {
		return content.getChildren().add(new Button("Build New Town Hall"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					city.buildBuilding(new UnderConstruction<TownHall>(locationPlanet,new TownHall(block,city.getMoneySource()),
							city));
					controller.initCityView();
					controller.cityAccordionManager.init();
				}
			});
		}});
	}
	public boolean addSchool(final Controller controller, final City city, VBox content, final LocationPlanet locationPlanet, final CityBlock block) {
		return content.getChildren().add(new Button("Build New School"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					city.buildBuilding(new UnderConstruction<School>(locationPlanet,new School(block,city
							.getMoneySource()),
							city));
					controller.initCityView();
					controller.cityAccordionManager.init();
				}
			});
		}});
	}
	public boolean addResearchArea(final Controller controller, final City city, VBox content, final LocationPlanet locationPlanet, final CityBlock block) {
		return content.getChildren().add(new Button("Build New Research Area"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					city.buildBuilding(new UnderConstruction<ResearchArea>(locationPlanet,new ResearchArea(block,city
							.getMoneySource()),
							city));
					controller.initCityView();
					controller.cityAccordionManager.init();
				}
			});
		}});
	}
	public boolean addIndustrialBlock(final Controller controller, final City city, VBox content, final LocationPlanet locationPlanet, final CityBlock block) {
		return content.getChildren().add(new Button("Build New Industrial Dock"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					city.buildBuilding(new UnderConstruction<IndustrialDock>(locationPlanet,new IndustrialDock(block,city.getMoneySource()),city));
					controller.initCityView();
					controller.cityAccordionManager.init();
				}
			});
		}});
	}
	public boolean addHospital(VBox content, City city, LocationPlanet locationPlanet, CityBlock block, Controller controller) {
		return content.getChildren().add(new Button("Build New Hospital"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					city.buildBuilding(new UnderConstruction<RulersHouse>(locationPlanet,new RulersHouse(block),city));
					controller.initCityView();
					controller.cityAccordionManager.init();

				}
			});
		}});
	}
	public boolean addFactory(final Controller controller, final City city, VBox content, final LocationPlanet locationPlanet, final CityBlock block) {
		return content.getChildren().add(new Button("Build New Factory"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					city.buildBuilding(new UnderConstruction<Factory>(locationPlanet,new Factory(block,city.getMoneySource()),city));
					controller.initCityView();
					controller.cityAccordionManager.init();
				}
			});
		}});
	}
	public boolean addDockYard(final Controller controller, final City city, VBox content, final LocationPlanet locationPlanet, final CityBlock block) {
		return content.getChildren().add(new Button("Build New Dock Yard"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					city.buildBuilding(new UnderConstruction<DockYard>(locationPlanet,new DockYard(block,city.getMoneySource()),city));
					controller.initCityView();
					controller.cityAccordionManager.init();
				}
			});
		}});
	}
	public boolean addWorkersHouseBlock(final Controller controller, final City city, VBox content, final LocationPlanet locationPlanet, final CityBlock block) {
		return content.getChildren().add(new Button("Build New Workers House Block"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					city.buildBuilding(new UnderConstruction<WorkersHouseBlock>(locationPlanet,new WorkersHouseBlock(block),city));
					controller.initCityView();
					controller.cityAccordionManager.init();
				}
			});
		}});
	}
	public boolean addRulersHouse(final Controller controller, final City city, VBox content, final LocationPlanet locationPlanet, final CityBlock block) {
		return content.getChildren().add(new Button("Build New Ruler's House"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					city.buildBuilding(new UnderConstruction<RulersHouse>(locationPlanet,new RulersHouse(block),city));
					controller.initCityView();
					controller.cityAccordionManager.init();
				}
			});
		}});
	}
	public boolean addApartmentBlock(final Controller controller, final City city, VBox content, final LocationPlanet locationPlanet, final CityBlock block) {
		return content.getChildren().add(new Button("Build New Apartment Block"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					city.buildBuilding(new UnderConstruction<ApartmentBlock>(locationPlanet,new ApartmentBlock(block),city));
					controller.initCityView();
					controller.cityAccordionManager.init();
				}
			});
		}});
	}

	@Override
	public void remove(Attackable attackable) {
		//do nothing
	}
}
