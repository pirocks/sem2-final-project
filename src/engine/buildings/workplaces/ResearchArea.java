package engine.buildings.workplaces;

import engine.cities.CityBlock;
import engine.people.cityworkers.CityWorker;
import engine.people.cityworkers.Researcher;
import engine.planets.LocationPlanet;
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
	protected boolean isSuitableType(CityWorker cityWorker) {
		return cityWorker instanceof Researcher;
	}

	@Override
	public void addSpecific(VBox in) {
		try {
			in.getChildren().add(new Text("working on:" + discovery.getClass().getCanonicalName()));
		} catch (NullPointerException ignored) {// TODO: 5/24/2016 be more graceful
			System.out.print("you probably shouldn't see this but its really not that bad");
		}
		try {
			in.getChildren().add(new Text("Percent complete:" + 100*discovery.getPercentComplete() + "%"));
		} catch (NullPointerException e) {// TODO: 5/24/2016 be more graceful
			System.out.print("you probably shouldn't see this but its really not that bad");
		}
	}

	@Override
	public CityWorker createCorrectType() {
		return new Researcher(getParentCity(),new LocationPlanet(this));
	}
}