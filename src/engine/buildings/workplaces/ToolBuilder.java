package engine.buildings.workplaces;

import engine.buildings.ResourceUser;
import engine.tools.Tool;
import engine.tools.ToolUnderConstruction;
import engine.universe.ResourceDemand;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Created by bob on 5/19/2016.
 *
 */
public interface ToolBuilder <Type extends Tool> extends ResourceUser {
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

	@Override
	default ResourceDemand getResourceDemand() {
		return getToolUnderConstruction().getResourcesRequired();
	}

	default void addSpecificToolBuilder(VBox in){
		if(getToolUnderConstruction() != null) {
			in.getChildren().add(new Text("" + getToolUnderConstruction().getClass().getSimpleName() + "under " +
					"construction: "));
			in.getChildren().add(new Text("Resources required:"));
			in.getChildren().add(new Text(getToolUnderConstruction().getResourcesRequired()
					.getResource().toString()));
			addAddResourcesButton(in);
			in.getChildren().add(new Text("Time Remaining:" + getToolUnderConstruction().getTimeRequired()));
		}
		else {
			in.getChildren().add(new Text("Nothing under construction"));
		}
		addBuildOptions(in);
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
