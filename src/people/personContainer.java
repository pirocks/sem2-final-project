package people;

/**
 * Created by bob on 4/4/2016.
	to handle dead people
 */
public interface PersonContainer
{
	public void remove(AbstractPerson person);
	default public void register()
	{
		PersonContainers.registerContainer(this);
	}
}
