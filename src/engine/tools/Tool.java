package engine.tools;

import engine.tools.vehicles.Weighable;
import engine.tools.weapons.Attackable;
import engine.universe.ResourceDemand;

import java.io.Serializable;

public abstract class Tool extends Attackable implements Serializable,Weighable
{
	protected Tool(AttackableConstants attackableConstants)
	{
		super(attackableConstants);
		//TODO think of sme code to put here
		//what about construction costs
		//constructor from a another class
	}
	public abstract boolean vehicleQ();
	public abstract boolean weaponQ();
	public abstract ResourceDemand requiredResourcesForConstruction();
	public abstract double getconstructionManDays();//doesn't need o be abstract
}