package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.tools.AttackableConstants;
import engine.tools.ToolUnderConstruction;
import engine.tools.vehicles.sea.SeaCraft;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 4/9/2016.
 *
 */
public class DockYard extends Workplace implements ToolBuilder<SeaCraft> {
	public static double healthInitial;
	public static double resistanceInitial;

	public static int maxiWorkersInitial = -1;

	private ToolUnderConstruction<SeaCraft> seaCraftUnderConstruction;


	public DockYard(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(parentBlock.getLocation(),healthInitial,resistanceInitial), parentBlock, maxiWorkersInitial, owner);
	}

	@Override
	protected String getName() {
		return "DockYard";
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/10/2016
	}

	//the two classes bellow  should only be used by Toolbuilder
	@Override
	public ToolUnderConstruction<SeaCraft> getToolUnderConstruction() {
		return seaCraftUnderConstruction;
	}

	@Override
	public SeaCraft setToolUnderConstruction(ToolUnderConstruction<SeaCraft> seaCraftUnderConstruction) {
		assert (seaCraftUnderConstruction.areWeDoneYet());
		this.seaCraftUnderConstruction = seaCraftUnderConstruction;
		return seaCraftUnderConstruction.getFinishedTool();
	}

}
