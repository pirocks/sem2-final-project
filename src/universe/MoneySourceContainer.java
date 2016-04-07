package universe;

/**
 * Created by bob on 4/6/2016.
 *
 */
public interface MoneySourceContainer
{
	public void remove(MoneySource in);
	default public void registerMoneySourceContainer()
	{
		MoneySourceContainers.registerContainer(this);
	}
}
