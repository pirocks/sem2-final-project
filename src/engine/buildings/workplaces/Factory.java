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
import javafx.scene.layout.VBox;

public class Factory extends Workplace implements ToolBuilder<Tool>
{
	public static double healthInitial;
	public static double resistanceInitial;
	// TODO: 4/9/2016 how is this going to work
	//only builds weapons/ vehicles roadgoing or otherwise
	public static int maxiWorkersInitial;// TODO: 5/19/2016
//	public double toolProgress = 0.0; //form 0 to 1
	public ToolUnderConstruction<Tool> inProduction;

	public Factory(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(parentBlock.getLocation(),healthInitial,resistanceInitial), parentBlock, maxiWorkersInitial, owner);
	}

	@Override
	protected String getName() {
		return "factory";
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

	//Tool
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
	public void addSpecific(VBox in) {
		// TODO: 5/23/2016
	}

	@Override
	public CityWorker createCorrectType() {
		return new ManualWorker(getParentCity(),new LocationPlanet(this));
	}
}