package engine.universe;

/**
 * Created by bob on 5/7/2016.
 *
 */
public class UniverseGenerator implements Runnable
{
	public static Universe universe;
	private UniverseRandomConstructionContext universeRandomConstructionContext;
	public UniverseGenerator(UniverseRandomConstructionContext universeRandomConstructionContext)
	{
		this.universeRandomConstructionContext = universeRandomConstructionContext;
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
		universe = new Universe(universeRandomConstructionContext);
		Universe.universe = universe;
		Thread mainGame = new Thread(new MainGame());
	}
}
