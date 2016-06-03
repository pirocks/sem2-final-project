package engine.tools;

import engine.tools.vehicles.Weighable;
import engine.tools.weapons.Attackable;
import engine.universe.ResourceDemand;
import javafx.scene.image.Image;

import java.io.Serializable;

public abstract class Tool extends Attackable implements Serializable,Weighable
{
	// 5/25/2016 DO NOT OVERRIDE EQUALS AND HASHCODE FOR ANY TOOL SPECIFICALLY VEHICLE.
	protected int numTools;

	protected Tool(AttackableConstants attackableConstants, int numToolsConstructor) {
		super(attackableConstants);
		this.numTools = numToolsConstructor;
	}
	public abstract boolean vehicleQ();
	public abstract boolean weaponQ();
	public abstract Image getImage();
	public abstract ResourceDemand requiredResourcesForConstruction();
	public abstract double getConstructionManDays();//doesn't need o be abstract
	@Override
	public int getCount() {
		return numTools;
	}
	public int getNumTools() {
		return numTools;
	}
	@Override
	public double getWeight() {
		return requiredResourcesForConstruction().getWeight();
	}
	//  this really shouldn't be used once the vehicle is out in the real world
	public void setNumTools(int numTools) {
		this.numTools = numTools;
	}
}