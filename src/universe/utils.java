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
}