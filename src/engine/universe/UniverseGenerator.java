package engine.universe;

import ui.view.Main;

/**
 * Created by bob on 5/7/2016.
 *
 */
public class UniverseGenerator implements Runnable
{
	public static Universe universe;
	private UniverseConstructionContext universeConstructionContext;
	public UniverseGenerator(UniverseConstructionContext universeConstructionContext)
	{
		this.universeConstructionContext = universeConstructionContext;
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
		universe = new Universe(universeConstructionContext);
		Universe.universe = universe;
		new Main().run();
	}
}
