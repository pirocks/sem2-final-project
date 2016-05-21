package engine.buildings;

import java.io.Serializable;

class UnderConstruction<Type extends Building> implements Serializable
{
	private Type type;
	private double progress = 0.0;
	public UnderConstruction()
	{
		//make call to super but then change resistance etc.
	}
}