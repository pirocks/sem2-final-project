package engine.universe;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;
public class utils
{
    public static int getRandomInt(int a,int b)
    {
        return ThreadLocalRandom.current().nextInt(a,b);
    }
    public static double getRandomDouble(double a, double b)
    {
        return ThreadLocalRandom.current().nextDouble(a,b);
    }
	public static BigDecimal getRandomBigDecimal(BigDecimal a,BigDecimal b){
		double randomNum = Math.random();
		return a.add((b.subtract(a)).multiply(new BigDecimal(randomNum)));
	}
	public static void sleep(double secs)
	{
		try {
			Thread.sleep((long) (1000*secs));                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
			System.out.print("something is wrong exception 1");
			Thread.currentThread().interrupt();
		}
	}

}