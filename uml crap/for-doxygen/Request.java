package ui.requests;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by user on 4/13/2016.
 * this class is used by the engine to send "requests to the ui for infomation
 * aka what to build next, what type of worker to train...
 */


public abstract class Request implements Serializable
{
	private static ArrayList<Request> requests = new ArrayList<>();
	public Request()
	{
		requests.add(this);
		askUser();// TODO: 4/13/2016 this is fucked up
		fullFillRequest();
	}
	public abstract void fullFillRequest();
	public abstract void askUser();
	public void remove()
	{
		requests.remove(this);//todo this arry thing is definitely not how things are supposed to work.
	}
}
