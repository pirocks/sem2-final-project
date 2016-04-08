package engine.people;

/**
 * Created by bob on 4/4/2016.
	to handle dead engine.people
 */
public interface PersonContainer
{
	public void remove(AbstractPerson person);
	default public void registerPersonContainer()
	{
		PersonContainers.registerContainer(this);
	}
}
