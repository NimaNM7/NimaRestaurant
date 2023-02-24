import java.util.ArrayList;

public class Order
{
    private int id;
    private User person;
    private ArrayList<Product> foods;
    private int orderPrice;

    public Order(int id , User person , ArrayList<Product> foods)
    {
        this.id = id;
        this.person = person;
        this.foods = foods;
        orderPrice = 0;
        for(int i = 0 ; i < foods.size() ; i++) {
            orderPrice += foods.get(i).price;
            for(int j = 0 ; j < foods.get(i).ingredients.size() ; j++)
            {
                foods.get(i).ingredients.get(j).use();
            }
        }
        person.loseMoney(orderPrice);
    }

    public int getId() {
        return id;
    }
    public void getItems()
    {
        for(int i = 0 ; i < foods.size() ; i++)
        {
            System.out.println(foods.get(i).Name);
        }
    }
    public void getBill()
    {
        System.out.println("Name : " + person.getName());
        System.out.println("Order ID : " + id);
        for(int i = 0 ; i < foods.size() ; i++)
        {
            System.out.println(foods.get(i).Name);
            for(int j = 0 ; j < foods.get(i).ingredients.size() ; j++)
            {
                System.out.print("----");
                System.out.println(foods.get(i).ingredients.get(j).getName());
            }
            System.out.println(foods.get(i).price);
        }
        System.out.println("All : " + orderPrice);
    }
    public int getOrderPrice()
    {
        return orderPrice;
    }
}
