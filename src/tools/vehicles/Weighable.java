package tools.vehicles;

/**
 * Created by bob on 4/7/2016.
 *
 */
public interface Weighable
{
	public double getWeight();
	public class ToHeavyException extends Exception
	{
		public Weighable weighable;
		public ToHeavyException(Weighable weighable)
		{
			super();
			this.weighable = weighable;
		}
	}
}
