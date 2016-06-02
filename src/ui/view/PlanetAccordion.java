package ui.view;

import engine.cities.City;
import engine.people.AbstractPerson;
import engine.people.Soldier;
import engine.people.cityworkers.*;
import engine.planets.Planet;
import engine.tools.vehicles.CityBuilder;
import engine.tools.vehicles.Vehicle;
import engine.universe.Country;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ui.view.city.CityButton;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by bob on 5/31/2016.
 */
public class PlanetAccordion
{
	private Planet planet;
	private Country playersCountry;
	private Controller controller;
	private Accordion accordion;

	public void initVars(Planet planet, Country playersCountry,Controller  controller,Accordion  accordion) {
		this.planet = planet;
		this.playersCountry = playersCountry;
		this.controller = controller;
		this.accordion = accordion;
	}
	public void init() {
		accordion.getPanes().clear();
		addCitys();
		addVehicles();
	}
	private void addVehicles() {
		for(Vehicle v: planet.getAllVehicles()) {
			VBox pane = new VBox();
			pane.getChildren().add(new Text("Vehicle:" + v.getClass().getSimpleName()));
			if(v instanceof CityBuilder) {
				Button button = new Button("Build City"){{
					setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							((CityBuilder)v).buildCity();
						}
					});
				}};
				pane.getChildren().add(button);
			}
			pane.getChildren().add(new Text("Going Towards:"));
			if(v.getDestination() != null)
				pane.getChildren().add(new Text(v.getDestination().toString()));
			else
				pane.getChildren().add(new Text("None"));
			accordion.getPanes().add(new TitledPane(v.getClass().getName(),pane));
			addVehicleContents(v,pane);
		}
	}
	private void addVehicleContents(Vehicle v, VBox in) {
		//I think that this is the best way to do things despite appearances
		//well I could do something with a hashmap, but that  seems more liable to break and harder to maintain
		ArrayList<Soldier> soldiers = new ArrayList<>();
		ArrayList<Bureaucrat> bureaucrats = new ArrayList<>();
		ArrayList<Doctor> doctors = new ArrayList<>();
		ArrayList<ManualWorker> manualWorkers = new ArrayList<>();
		ArrayList<Researcher> researchers = new ArrayList<>();
		ArrayList<Teacher> teachers = new ArrayList<>();
		ArrayList<Ruler> rulers = new ArrayList<>();
		addPeople(v, soldiers, bureaucrats, doctors, manualWorkers, researchers, teachers, rulers);
		addDetails(soldiers,in,"soldiers",v);
		addDetails(bureaucrats,in,"bureaucrats",v);
		addDetails(doctors,in,"doctors",v);
		addDetails(manualWorkers,in,"manual workers",v);
		addDetails(researchers,in,"researchers",v);
		addDetails(teachers,in,"teachers",v);
		addDetails(rulers,in,"rulers",v);
		// TODO: 5/31/2016 what about boarding?

	}
	private void disembark(int num,ArrayList<? extends AbstractPerson> persons,Vehicle vehicle){
		// TODO: 5/31/2016
	}
	private void addDetails(ArrayList<? extends AbstractPerson> persons,VBox in,String name,Vehicle vehicle){
		int numPeople = 0;
		for (AbstractPerson person : persons) {
			numPeople += person.getPopulation();
		}
		final int copy = numPeople;
		in.getChildren().add(new Text("There are " + numPeople + " " + name + " on " + "this " + "vehicle"));
		in.getChildren().add(new Button("Disembark all " + name + " from this vehicle"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					disembark(copy,persons,vehicle);
				}
			});
		}});
		in.getChildren().add(new HBox(){{
			Button button = new Button("Disembark some soldiers");
			button.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					TextInputDialog dialog = new TextInputDialog("10");
					dialog.setTitle("Select Quantity");
					dialog.setHeaderText("Enter the number of "+ name + " to disembark");
					Optional<String> result = dialog.showAndWait();
					String entered = "10";
					if (result.isPresent()) {
						entered = result.get();
					}
					int numPeople = 1;
					try{
						numPeople = Integer.parseInt(entered);
						if(numPeople <= 0)
							throw new NumberFormatException();
						if(numPeople >= numPeople + 1)
							throw new NumberFormatException();
					}catch (NumberFormatException e){
						Alert alert = new Alert(Alert.AlertType.WARNING,"not a valid integer. Please enter a valid integer value, greater than 0 and less than " + numPeople + 1 + ".");
						alert.showAndWait();
						handle(event);// TODO: 5/31/2016 go through and add this
						return;
					}
					disembark(numPeople,persons,vehicle);
				}
			});
			getChildren().add(button);
		}});
	}
	private void addPeople(Vehicle v, ArrayList<Soldier> soldiers, ArrayList<Bureaucrat> bureaucrats, ArrayList<Doctor> doctors, ArrayList<ManualWorker> manualWorkers, ArrayList<Researcher> researchers, ArrayList<Teacher> teachers, ArrayList<Ruler> rulers) {
		for (AbstractPerson abstractPerson : v.getPassengers()) {
			if(abstractPerson instanceof CityWorker){
				if(abstractPerson instanceof Bureaucrat){
					bureaucrats.add((Bureaucrat) abstractPerson);
				}
				else if(abstractPerson instanceof Doctor){
					doctors.add((Doctor) abstractPerson);
				}
				else if(abstractPerson instanceof ManualWorker){
					manualWorkers.add((ManualWorker) abstractPerson);
				}
				else if(abstractPerson instanceof Researcher){
					researchers.add((Researcher) abstractPerson);
				}
				else if(abstractPerson instanceof Teacher){
					teachers.add((Teacher) abstractPerson);
				}
				else if(abstractPerson instanceof Ruler){
					rulers.add((Ruler) abstractPerson);
				}
				else
					throw new IllegalStateException();
			}
			else if(abstractPerson instanceof Soldier){
				soldiers.add((Soldier) abstractPerson);
			}
			else
				throw new IllegalStateException();
		}
	}
	private void addCitys() {
		for(City c: planet.getAllCities())
		{
			VBox pane = new VBox();
			TitledPane titledPane;
			if(c.getParentCountry() == playersCountry)
			{
				pane.getChildren().add(new Text(c.toString()));
				Button button = new CityButton(c,"Go To City",controller);
				pane.getChildren().add(button);
				titledPane = new TitledPane(c.name, pane);
				accordion.getPanes().add(0,titledPane);
			}
			else
			{
				pane.getChildren().add(new Text(c.toString()));
				pane.getChildren().add(new Text("YOU DO NOT CONTROL THIS CITY"));
				Button button = new CityButton(c,"Go To City",controller);
				pane.getChildren().add(button);
				titledPane = new TitledPane(c.name, pane);
				accordion.getPanes().add(titledPane);
			}
		}
	}
	public void liverUpdate() {

	}
}
