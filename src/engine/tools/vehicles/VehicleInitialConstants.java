package engine.tools.vehicles;

import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;

/**
 * Created by bob on 4/9/2016.
 *
 */
public class VehicleInitialConstants {
	public AttackableConstants attackableConstants;
	public int maxPassengers;
	public double maxWeight;
	public double speed;
	public VehicleInitialConstants(AttackableConstants attackableConstants, int maxPassengers, double maxWeight){
		this.attackableConstants = attackableConstants;
		this.maxPassengers = maxPassengers;
		this.maxWeight = maxWeight;
	}
	public VehicleInitialConstants(LocationPlanet location, double health,double resistance,int maxPassengers,double maxWeight){
		this(new AttackableConstants(health,resistance,location),
				maxPassengers,
				maxWeight);
	}
}
