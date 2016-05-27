package ui.requests;

import java.io.Serializable;

/**
 * Created by user on 4/13/2016.
 * this class is used by the engine to send "requests to the ui for infomation
 * aka what to build next, what types of worker to train...
 */


public abstract class Request implements Serializable
{
	public abstract String askUser();
}
