package engine.tools;

import engine.planets.Grid;
import engine.planets.LocationPlanet;

import java.util.ArrayList;

/**
 * Created by bob on 4/9/2016.
 *
 */
public class AttackableConstants {
	public double health;
	public double resistance;
	public ArrayList<LocationPlanet> locationPlanet;


	public AttackableConstants(double healthInitial, double resistanceInitial, LocationPlanet locationPlanet) {
		if(healthInitial <= 0)
			throw new IllegalArgumentException();
		this.health= healthInitial;
		this.resistance = resistanceInitial;
		this.locationPlanet = new ArrayList<>(1);
		this.locationPlanet.add(locationPlanet);
	}

	public AttackableConstants(double healthInitial, double resistanceInitial, ArrayList<LocationPlanet> location) {
		if(healthInitial <= 0)
			throw new IllegalArgumentException();
		this.health= healthInitial;
		this.resistance = resistanceInitial;
		this.locationPlanet = location;
	}

	public AttackableConstants(ArrayList<LocationPlanet> location, double healthInitial, double resistanceInitial) {
		this(healthInitial,resistanceInitial,location);
	}

	public Grid getGrid() {
		return  locationPlanet.get(0).getGrid();
	}

	public void addHealth(double startHealthAdd) {
		health += startHealthAdd;
	}

	public void startHealthMult(double startHealthMult) {
		health *= startHealthMult;
	}
}
