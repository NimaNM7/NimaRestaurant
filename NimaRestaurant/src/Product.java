import java.util.ArrayList;
import java.lang.String;
import java.util.HashMap;

public class Product
{
    TypeOfProduct type;
    String Name;
    ArrayList<Things> ingredients;

    int price;

    public Product(String name , int price , TypeOfProduct type)
    {
        this.Name = name;
        this.price = price;
        this.type = type;
    }

    public void changePrice(int newPrice)
    {
        price = newPrice;
    }
}
