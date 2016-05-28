package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.people.cityworkers.ManualWorker;
import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.Tool;
import engine.tools.ToolUnderConstruction;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

public class Factory extends Workplace implements ToolBuilder<Tool>
{
	public static double healthInitial;// TODO: 5/27/2016
	public static double resistanceInitial;// TODO: 5/27/2016
	//only builds weapons/ vehicles roadgoing or otherwise
	public static int maxWorkersInitial = 1000;// TODO: 5/19/2016
	public ToolUnderConstruction<Tool> inProduction;
	public Factory(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(parentBlock.getLocation(),healthInitial,resistanceInitial), parentBlock, maxWorkersInitial, owner);
	}
	@Override
	protected String getName() {
		return "factory";
	}
	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}
	@Override
	public Tool setToolUnderConstruction(ToolUnderConstruction<Tool> in) {
		inProduction = in;
		return inProduction.getFinishedTool();
	}
	@Override
	public ToolUnderConstruction<Tool> getToolUnderConstruction() {
		return inProduction;
	}
	@Override
	protected boolean isSuitableType(CityWorker cityWorker) {
		return cityWorker instanceof ManualWorker;
	}
	@Override
	public CityWorker createCorrectType() {
		return new ManualWorker(getParentCity(),new LocationPlanet(this));
	}
}