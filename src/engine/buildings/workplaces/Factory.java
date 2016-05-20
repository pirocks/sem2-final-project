package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.tools.AttackableConstants;
import engine.tools.Tool;
import engine.tools.ToolUnderConstruction;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

import java.util.ArrayList;

public class Factory extends Workplace
{
	public static double healthInitial;
	public static double resistanceInitial;
	// TODO: 4/9/2016 how is this going to work
	//only builds weapons/ vehicles roadgoing or otherwise
	public static int maxiWorkersInitial;// TODO: 5/19/2016
//	public double toolProgress = 0.0; //form 0 to 1
	public ArrayList<ToolUnderConstruction<Tool>> inProduction;

	public Factory(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(parentBlock.getLocation(),healthInitial,resistanceInitial), parentBlock, maxiWorkersInitial, owner);
		inProduction = new ArrayList<>();
	}

	@Override
	protected String getName() {
		return "factory";
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

}