package engine.universe;

/**
 * Created by bob on 4/6/2016.
 *
 */
public interface MoneySourceContainer
{
	void remove(MoneySource in);
	default void registerMoneySourceContainer()
	{
		MoneySourceContainers.registerContainer(this);
	}
}
