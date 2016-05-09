package engine.universe;

/**
 * Created by bob on 5/8/2016.
 *
 */
public class MainGame implements Runnable {
	public MainGame()
	{

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
		Universe universe = Universe.universe;

	}
}
