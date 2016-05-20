package engine.buildings.workplaces;

import engine.tools.Tool;
import engine.tools.ToolUnderConstruction;
import engine.universe.ResourceDemand;

/**
 * Created by bob on 5/19/2016.
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
	default long getTimeRemaining(){
		return getToolUnderConstruction().getTimeRequired();
	}
	default ResourceDemand getResourcesRemaining(){
		return getToolUnderConstruction().getResourcesRequired();
	}
	default String getCurrentlyBuilding(){
		return getToolUnderConstruction().getName();
	}
}
