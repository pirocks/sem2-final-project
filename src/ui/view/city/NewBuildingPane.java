package ui.view.city;

import engine.buildings.UnderConstruction;
import engine.buildings.housing.ApartmentBlock;
import engine.buildings.housing.RulersHouse;
import engine.buildings.housing.WorkersHouseBlock;
import engine.buildings.workplaces.*;
import engine.cities.City;
import engine.cities.CityBlock;
import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import ui.view.Controller;

/**
 * Created by bob on 5/22/2016.
 */
public class NewBuildingPane extends TitledPane {
	public NewBuildingPane(Controller controller,City city, int x, int y) {
		super();
		VBox content = new VBox();
		content.getChildren().add(new Button("Build New Apartment Block"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					LocationPlanet locationPlanet = new LocationPlanet(city.getParentGrid(),x,y);
					city.buildBuilding(new UnderConstruction<ApartmentBlock>(locationPlanet,new ApartmentBlock(
							new CityBlock(
									new AttackableConstants(0,0,locationPlanet),
									locationPlanet.getGrid(),
									null,
									city,
									x,y
							)
					),city));// TODO: 5/22/2016 this is horrifying fix it

				}
			});
		}});
		content.getChildren().add(new Button("Build New Ruler's House"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					LocationPlanet locationPlanet = new LocationPlanet(city.getParentGrid(),x,y);
					city.buildBuilding(new UnderConstruction<RulersHouse>(locationPlanet,new RulersHouse(new CityBlock(
							new AttackableConstants(0,0,locationPlanet),city.getParentGrid(),null,city,x,y)
					),city));// TODO: 5/22/2016 this is horrifying fix it
controller.initCityView();
				}
			});
		}});
		content.getChildren().add(new Button("Build New Workers House Block"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					LocationPlanet locationPlanet = new LocationPlanet(city.getParentGrid(),x,y);
					city.buildBuilding(new UnderConstruction<WorkersHouseBlock>(locationPlanet,new WorkersHouseBlock(new CityBlock(
							new AttackableConstants(0,0,locationPlanet),city.getParentGrid(),null,city,x,y)
					),city));// TODO: 5/22/2016 this is horrifying fix it
controller.initCityView();
				}
			});
		}});
		content.getChildren().add(new Button("Build New Dock Yard"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					LocationPlanet locationPlanet = new LocationPlanet(city.getParentGrid(),x,y);
					city.buildBuilding(new UnderConstruction<DockYard>(locationPlanet,new DockYard(new CityBlock(
							new AttackableConstants(0,0,locationPlanet),city.getParentGrid(),null,city,x,y),city.getMoneySource()
					),city));// TODO: 5/22/2016 this is horrifying fix it
controller.initCityView();
				}
			});
		}});
		content.getChildren().add(new Button("Build New Factory"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					LocationPlanet locationPlanet = new LocationPlanet(city.getParentGrid(),x,y);
					city.buildBuilding(new UnderConstruction<Factory>(locationPlanet,new Factory(new CityBlock(
							new AttackableConstants(0,0,locationPlanet),city.getParentGrid(),null,city,x,y),city.getMoneySource()
					),city));// TODO: 5/22/2016 this is horrifying fix it
controller.initCityView();
				}
			});
		}});
		content.getChildren().add(new Button("Build New Hospital"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					LocationPlanet locationPlanet = new LocationPlanet(city.getParentGrid(),x,y);
					city.buildBuilding(new UnderConstruction<Hospital>(locationPlanet,new Hospital(new CityBlock(
							new AttackableConstants(0,0,locationPlanet),city.getParentGrid(),null,city,x,y),city.getMoneySource()
					),city));// TODO: 5/22/2016 this is horrifying fix it
controller.initCityView();
				}
			});
		}});
		content.getChildren().add(new Button("Build New Industrial Dock"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					LocationPlanet locationPlanet = new LocationPlanet(city.getParentGrid(),x,y);
					city.buildBuilding(new UnderConstruction<IndustrialDock>(locationPlanet,new IndustrialDock(new CityBlock(
							new AttackableConstants(0,0,locationPlanet),city.getParentGrid(),null,city,x,y),city.getMoneySource()
					),city));// TODO: 5/22/2016 this is horrifying fix it
controller.initCityView();
				}
			});
		}});
		content.getChildren().add(new Button("Build New Research Area"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					LocationPlanet locationPlanet = new LocationPlanet(city.getParentGrid(),x,y);
					city.buildBuilding(new UnderConstruction<ResearchArea>(locationPlanet,new ResearchArea(new CityBlock(
							new AttackableConstants(0,0,locationPlanet),city.getParentGrid(),null,city,x,y),city.getMoneySource()
					),city));// TODO: 5/22/2016 this is horrifying fix it
controller.initCityView();
				}
			});
		}});
		content.getChildren().add(new Button("Build New School"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					LocationPlanet locationPlanet = new LocationPlanet(city.getParentGrid(),x,y);
					city.buildBuilding(new UnderConstruction<School>(locationPlanet,new School(new CityBlock(
							new AttackableConstants(0,0,locationPlanet),city.getParentGrid(),null,city,x,y),city.getMoneySource()
					),city));// TODO: 5/22/2016 this is horrifying fix it
controller.initCityView();
				}
			});
		}});
		content.getChildren().add(new Button("Build New Town Hall"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					LocationPlanet locationPlanet = new LocationPlanet(city.getParentGrid(),x,y);
					city.buildBuilding(new UnderConstruction<TownHall>(locationPlanet,new TownHall(new CityBlock(
							new AttackableConstants(0,0,locationPlanet),city.getParentGrid(),null,city,x,y),city.getMoneySource()
					),city));// TODO: 5/22/2016 this is horrifying fix it
controller.initCityView();
				}
			});
		}});
		content.getChildren().add(new Button("Build New Warehouse"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					LocationPlanet locationPlanet = new LocationPlanet(city.getParentGrid(),x,y);
					city.buildBuilding(new UnderConstruction<Warehouse>(locationPlanet,new Warehouse(new CityBlock(
							new AttackableConstants(0,0,locationPlanet),city.getParentGrid(),null,city,x,y),city.getMoneySource()
					),city));// TODO: 5/22/2016 this is horrifying fix it
controller.initCityView();
				}
			});
		}});
		super.setContent(content);
	}
}
