package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.people.cityworkers.ManualWorker;
import engine.planets.LocationPlanet;
import engine.tools.AttackableConstants;
import engine.tools.ToolUnderConstruction;
import engine.tools.vehicles.sea.SeaCraft;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class IndustrialDock extends Workplace implements ToolBuilder<SeaCraft>
{
	public static double resistanceInitial;// TODO: 5/23/2016
	public static double healthInitial;// TODO: 5/23/2016
	public static int maxWorkersInitial = 5000;
	private ToolUnderConstruction<SeaCraft> underConstruction;// TODO: 5/23/2016  make sure that this can bbe set by
	// user

	public IndustrialDock(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(healthInitial,resistanceInitial,parentBlock.getLocation()), parentBlock, maxWorkersInitial, owner);
	}

	@Override
	protected String getName() {
		return "IndustrialDock";
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

	@Override
	protected boolean isSuitableType(CityWorker cityWorker) {
		return cityWorker instanceof ManualWorker;
	}

	@Override
	public void addSpecific(VBox in) {
		in.getChildren().add(new Text("Currently Building" + underConstruction.getName()));
	}

	@Override
	public CityWorker createCorrectType() {
		return new ManualWorker(getParentCity(),new LocationPlanet(this));
	}

	@Override
	public SeaCraft setToolUnderConstruction(ToolUnderConstruction<SeaCraft> in) {
		assert (underConstruction.areWeDoneYet());
		SeaCraft temp = underConstruction.getFinishedTool();
		underConstruction = in;
		return temp;
	}

	@Override
	public ToolUnderConstruction<SeaCraft> getToolUnderConstruction() {
		return underConstruction;
	}
}