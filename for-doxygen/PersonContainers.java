package engine.people;

import java.util.ArrayList;

/**
 * Created by bob on 4/5/2016.
 *
 */
@Deprecated public class PersonContainers
{
	private static ArrayList<PersonContainer> containers = new ArrayList<>();
	public static void registerContainer(PersonContainer personContainer)
	{
		containers.add(personContainer);
	}
	public static void remove(AbstractPerson person)
	{
		for(PersonContainer personContainer: containers)
		{
			personContainer.remove(person);
		}
	}
}
