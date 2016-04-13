package engine.universe;

import java.io.Serializable;

/**
 * Created by bob on 3/5/2016.
 *
 */

public class Star implements Serializable
{
    private SolarSystem parentSolarSystem;
    private double radius;
    private double energyEmitted;
    private double mass;
}
