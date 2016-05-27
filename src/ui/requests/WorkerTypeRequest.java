package ui.requests;

import engine.buildings.workplaces.School;

/**
 * Created by user on 4/13/2016.
 *
 */
public class WorkerTypeRequest extends Request
{
	private School school;
	public WorkerTypeRequest(School school){
		super();
		this.school = school;
	}

		// TODO: 4/13/2016  implment this
		//todo also think about wether this will be imediately callled or request will be run through afterward, I think tht imediately called is a better Idea,, so call in constructor.

	@Override
	public String askUser() {
		return null;
	}
}
