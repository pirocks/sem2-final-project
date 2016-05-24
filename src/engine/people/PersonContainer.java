package engine.people;

/**
 * Created by bob on 4/4/2016.
	to handle dead engine.people
 */
public interface PersonContainer
{
	// TODO: 5/24/2016
	void remove(AbstractPerson person);
	default void registerPersonContainer()
	{
		PersonContainers.registerContainer(this);
	}
}
