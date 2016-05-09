package ui.view.solarsystem;

import engine.universe.SolarSystem;

/**
 * Created by bob on 5/9/2016.
 *
 */
public class SolarSystemThread implements Runnable {
	private SolarSystem solarSystem;
	public SolarSystemThread(SolarSystem s)
	{
		solarSystem = s;
	}
	/**
	 * When an object implementing interface <code>Runnable</code> is used
	 * to create a thread, starting the thread causes the object's
	 * <code>run</code> method to be called in that separately executing
	 * thread.
	 * <p>
	 * The general contract of the method <code>run</code> is that it may
	 * take any action whatsoever.
	 *
	 * @see Thread#run()
	 */
	@Override
	public void run() {

	}
}
