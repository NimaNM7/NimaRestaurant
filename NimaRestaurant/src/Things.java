import java.util.HashMap;

public class Things
{
    private String Name;
    private int amountLeft;
    private int price;

    public Things(String name,int amountLeft,int price)
    {
        this.Name = name;
        this.amountLeft = amountLeft;
        this.price = price;
    }

    public void buy(Things someFood,int numbers , User admin)
    {
        for(int i = 0 ; i < numbers ; i++)
        {
            someFood.increase();
            admin.loseMoney(someFood.price());
        }
    }

    public String getName()
    {
        return Name;
    }
    public int getAmountLeft()
    {
        return amountLeft;
    }
    public void use()
    {
        amountLeft--;
    }
    public void increase()
    {
        amountLeft++;
    }
    public int price()
    {
        return price;
    }
}
