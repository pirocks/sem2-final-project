package engine.buildings.workplaces;

import engine.tools.Tool;
import engine.tools.ToolUnderConstruction;
import engine.universe.ResourceDemand;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Created by bob on 5/19/2016.
 *
 */
public interface ToolBuilder <Type extends Tool>
{
	Type setToolUnderConstruction(ToolUnderConstruction<Type> in);
	ToolUnderConstruction<Type> getToolUnderConstruction();
	default Type getFinishedTool() {
		if(areWeDoneYet())
			return setToolUnderConstruction(null);
		return null;
	}
	default boolean areWeDoneYet()
	{
		return getToolUnderConstruction().areWeDoneYet();
	}
	default double getTimeRemaining(){
		return getToolUnderConstruction().getTimeRequired();
	}
	default ResourceDemand getResourcesRemaining(){
		return getToolUnderConstruction().getResourcesRequired();
	}
	default String getCurrentlyBuilding(){
		return getToolUnderConstruction().getName();
	}
	default void addSpecificToolBuilder(VBox in){
		in.getChildren().add(new Text("Type of" + getToolUnderConstruction().getClass().getTypeName() + "under " +
				"construction: "));
		in.getChildren().add(new Text("Resources required:" + getToolUnderConstruction().getResourcesRequired()
				.getResource().toTable()));
		in.getChildren().add(new Text("Time Remaining:" + getToolUnderConstruction().getTimeRequired()));
		addBuildOptions(in);
	}
	void addBuildOptions(VBox in);

	default void makeProgress(double time){
		getToolUnderConstruction().pay(time);
	}
}
