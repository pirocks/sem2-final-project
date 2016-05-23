package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.science.Discovery;
import engine.tools.AttackableConstants;
import engine.universe.MoneySource;
import engine.universe.ResourceDemand;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ResearchArea extends Workplace
{
	public static double healthInitial;
	public static double resistanceInitial;
	public static int maxWorkersInitial; // TODO: 5/19/2016
	private Discovery discovery;

	public ResearchArea(CityBlock parentBlock, MoneySource owner) {
		super(new AttackableConstants(healthInitial,resistanceInitial,parentBlock.getLocation()), parentBlock, maxWorkersInitial, owner);
	}

	@Override
	protected String getName() {
		return "ResearchArea";
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

	public Discovery getDiscovery() {
		return discovery;
	}

	public void setDiscovery(Discovery discovery) {
		this.discovery = discovery;
	}

	@Override
	public void addSpecific(VBox in) {
		in.getChildren().add(new Text("working on:" + discovery.getClass().getCanonicalName()));
		in.getChildren().add(new Text("Percent complete:" + 100*discovery.getPercentComplete() + "%"));
	}
}