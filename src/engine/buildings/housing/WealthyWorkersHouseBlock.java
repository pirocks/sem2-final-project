package engine.buildings.housing;

import engine.cities.CityBlock;
import engine.tools.AttackableConstants;
import engine.universe.ResourceDemand;
import javafx.scene.layout.VBox;


@Deprecated class WealthyWorkersHouseBlock extends Housing
{
	public static int maximumOccupancyInitial = 500;
	public static double resistanceInitial;

	public WealthyWorkersHouseBlock(AttackableConstants attackableConstants, CityBlock parentBlock) {
		super(attackableConstants,parentBlock);
	}

	@Override
	protected String getName() {
		return "you shouldn't be seeing this";
	}

	@Override
	public ResourceDemand getResourceCost() {
		return null;// TODO: 4/9/2016
	}

	@Override
	public VBox getPane() {
		return new VBox();// TODO: 5/23/2016
	}

//these classes do't really do anything
}