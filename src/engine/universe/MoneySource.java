package engine.universe;

import java.io.Serializable;

public class MoneySource implements Serializable
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
    public void pay(MoneySource target,double amount)
    {
        target.recieve(amount);
        wealth -= amount;
    }
    public double getWealth()
    {
        return wealth;
    }
    public boolean canPay(double amount)
    {
        return amount <= wealth;
    }
    public void outOfMoneyHandler(double amount)//possibly abstract
    {
        //whatever
    }

}