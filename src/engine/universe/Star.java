package engine.universe;

import java.io.Serializable;

/**
 * Created by bob on 3/5/2016.
 *
 */

public class Star implements Serializable
{
    private double x,y,z;
    private SolarSystem parentSolarSystem;//  5/11/2016 go through and make stuff like this final
    private double radius;
	public static final double maxRadius = 100000;
	public static final double minRadius = 100;
    private double energyEmitted;
	public static final double minEnergy = 100;
	public static final double maxRnergy = 10000;
    private double mass;
	public static final double starDensity = 10;
	public Star(double x, double y, double z, SolarSystem parentSolarSystem)
	{
		this.parentSolarSystem = parentSolarSystem;
		radius = utils.getRandomDouble(minRadius,maxRadius);
		energyEmitted = utils.getRandomDouble(minEnergy,maxRnergy);
		mass = ((starDensity * 4.0) / 3.0) * radius * radius * radius * Math.PI;
	}

	public SolarSystem getParentSolarSystem() {
		return parentSolarSystem;
	}
}
