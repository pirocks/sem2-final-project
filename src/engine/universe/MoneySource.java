package engine.universe;

public class MoneySource
{
    private double wealth;
    protected void setWealth(double in)
    {
        wealth = in;
    }
    public MoneySource(double wealth)
    {
        this.wealth = wealth;
    }
    public void recieve(double amount)
    {
        wealth += amount;
    }
    public void recieve(Resource r)
    {
        //TODO:implement me//figure ut wahat this is
    }
    public void pay(MoneySource target,double amount)
    {
        assert(canPay(amount));
        target.recieve(amount);
        wealth -= amount;
    }
    public double getWealth()
    {
        return wealth;
    }
    public boolean canPay(double amount)
    {
        if(amount > wealth)
            return false;
        return true;
    }
    public void outOfMoneyHandler(double amount)//possibly abstract
    {
        
    }

}