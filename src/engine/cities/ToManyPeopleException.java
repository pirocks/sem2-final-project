package engine.cities;

/**
 * Created by bob on 5/10/2016.
 *
 */
public class ToManyPeopleException extends Throwable {
	int population;
	int available;
	/**
	 * Constructs a new throwable with {@code null} as its detail message.
	 * The cause is not initialized, and may subsequently be initialized by a
	 * call to {@link #initCause}.
	 * <p>
	 * <p>The {@link #fillInStackTrace()} method is called to initialize
	 * the stack trace data in the newly created throwable.
	 */
	public ToManyPeopleException(int population,int available) {
		super();
		this.population = population;
		this.available = available;
	}
}
