package engine.buildings.workplaces;

import engine.tools.Tool;
import engine.tools.ToolUnderConstruction;
import engine.universe.ResourceDemand;
import javafx.scene.Node;
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
		if(getToolUnderConstruction() != null) {
			in.getChildren().add(0,new Text("Type of" + getToolUnderConstruction().getClass().getTypeName() + "under " +
					"construction: "));
			if(getToolUnderConstruction().getResourcesRequired().getResource() != null)
			in.getChildren().add(1,new Text("Resources required:" + getToolUnderConstruction().getResourcesRequired()
					.getResource().toTable()));// TODO: 5/30/2016remove if later
			in.getChildren().add(2,new Text("Time Remaining:" + getToolUnderConstruction().getTimeRequired()));
		}
		else {
			in.getChildren().add(0,new Text("Nothing under construction"));
		}
		addBuildOptions(in);
		if(getToolUnderConstruction() != null) {
			for (Node node : in.getChildren()) {
				node.setDisable(true);
			}

		}
	}
	void addBuildOptions(VBox in);
	default void makeProgress(double time){
		if(getToolUnderConstruction() == null) {
			//assume nothing is being built
			return;
		}
		getToolUnderConstruction().pay(time);
	}
}
