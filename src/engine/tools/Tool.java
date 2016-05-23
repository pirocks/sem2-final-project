package engine.tools;

import engine.tools.vehicles.Weighable;
import engine.tools.weapons.Attackable;
import engine.universe.ResourceDemand;

import java.io.Serializable;

public abstract class Tool extends Attackable implements Serializable,Weighable
{
	protected int numTools;

	protected Tool(AttackableConstants attackableConstants, int numToolsConstructor)
	{
		super(attackableConstants);
		//TODO think of sme code to put here
		//what about construction costs
		//constructor from a another class
	}
	public abstract boolean vehicleQ();
	public abstract boolean weaponQ();
	public abstract ResourceDemand requiredResourcesForConstruction();
	public abstract double getConstructionManDays();//doesn't need o be abstract
	@Override
	public int getCount() {
		return numTools;
	}

	@Override
	public double getWeight() {
		return requiredResourcesForConstruction().getWeight();// TODO: 5/22/2016 go through and make sure that get weight actual is beiang used
	}
}