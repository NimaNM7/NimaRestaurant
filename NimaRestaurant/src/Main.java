import java.util.*;

public class Main
{
    static ArrayList<User> ourUsers = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static User nowUser;
    static User admin = new User(Type.MANAGER , "admin" , "admin" , 10000000);

    static String personName;
    static String personPassword;

    static HashMap<Product,Integer> allFoodMenu = new HashMap<>();
    static HashMap<Things,Integer> thingsLeft = new HashMap<>();

    static void updateleft(Things thingAdded)
    {
        thingsLeft.put(thingAdded,thingAdded.getAmountLeft());
    }

    static void addToleftList(Things[] thingsAdded)
    {
        for(int i = 0 ; i < thingsAdded.length ; i++)
            thingsLeft.put(thingsAdded[i],thingsAdded[i].getAmountLeft());
    }

    static void updateMenu(Product foodAdded)
    {
        allFoodMenu.put(foodAdded,foodAdded.price);
    }
    static void addToMenu(Product[] foodsAdded)
    {
        for(int i = 0 ; i < foodsAdded.length ; i++)
            allFoodMenu.put(foodsAdded[i],foodsAdded[i].price);
    }

    public static void main(String[] args) {
        //Initalizing the foods
        Random rand = new Random();
        Things Flour = new Things("Floor", rand.nextInt(10), 10000);
        Things Cheese = new Things("Cheese", rand.nextInt(10), 50000);
        Things Meat = new Things("Meat", rand.nextInt(10),70000);
        Things Bread = new Things("Bread", rand.nextInt(10),5000);
        Things Vegetable = new Things("Vegetable", rand.nextInt(10),5000);
        Things Chicken = new Things("Chicken", rand.nextInt(10),50000);
        Things Potato = new Things("Potato", rand.nextInt(10),5000);
        Things coffee = new Things("Coffee", rand.nextInt(10),23000);
        Things Beans = new Things("Beans", rand.nextInt(10),5000);
        Things tea = new Things("Tea", rand.nextInt(10),15000);
        Things Chocolate = new Things("Chocolate", rand.nextInt(10),15000);
        Things soda = new Things("Soda", rand.nextInt(10),10000);
        Things iceCream = new Things("IceCream", rand.nextInt(10),15000);
        Things Egg = new Things("Egg", rand.nextInt(10),10000);
        Things Vanilla = new Things("Vanilla", rand.nextInt(10),5000);
        Things water = new Things("Water", 1000,0);
        Things Sugar = new Things("Sugar", rand.nextInt(10),10000);
        Product Burger = new Product("Burger",120000,TypeOfProduct.MAIN);
        Burger.ingredients = new ArrayList<Things>(List.of(Meat, Bread,Cheese));
        Product Pizza = new Product("Pizza",180000,TypeOfProduct.MAIN);
        Pizza.ingredients = new ArrayList<Things>(List.of(Meat, Cheese, Chicken));
        Product Stake = new Product("Stake",210000,TypeOfProduct.MAIN);
        Stake.ingredients = new ArrayList<Things>(List.of(Meat, Vegetable, Beans));
        Product friedChicken = new Product("Fried Chicken",140000,TypeOfProduct.MAIN);
        friedChicken.ingredients = new ArrayList<Things>(List.of(Chicken, Potato));
        Product Coffee = new Product("Coffee",40000,TypeOfProduct.DRINK);
        Coffee.ingredients = new ArrayList<Things>(List.of(coffee,Sugar));
        Product Tea= new Product("Tea",20000,TypeOfProduct.DRINK);
        Tea.ingredients = new ArrayList<Things>(List.of(tea,water,Sugar));
        Product HotChocolate = new Product("Hot Chocolate",30000,TypeOfProduct.DRINK);
        HotChocolate.ingredients = new ArrayList<Things>(List.of(Chocolate));
        Product Soda = new Product("Soda",13000,TypeOfProduct.DRINK);
        Soda.ingredients = new ArrayList<Things>(List.of(soda));
        Product Water = new Product("Water",10000,TypeOfProduct.DRINK);
        Water.ingredients = new ArrayList<Things>(List.of(water));
        Product ChocolateCake = new Product("Chocolate Cake",50000,TypeOfProduct.DESSERT);
        ChocolateCake.ingredients = new ArrayList<Things>(List.of(Chocolate,Flour,Sugar,Egg));
        Product VanillaCake = new Product("Vanilla Cake",49000,TypeOfProduct.DESSERT);
        VanillaCake.ingredients = new ArrayList<Things>(List.of(Vanilla,Flour,Sugar,Egg));
        Product IceCream = new Product("Ice Cream",30000,TypeOfProduct.DESSERT);
        IceCream.ingredients = new ArrayList<Things>(List.of(iceCream));
        Product Salad = new Product("Salad",50000,TypeOfProduct.APPETIZER);
        Salad.ingredients = new ArrayList<Things>(List.of(Vegetable,Cheese,Chicken));
        Product FriedPotato = new Product("Fried Potato",50000,TypeOfProduct.APPETIZER);
        FriedPotato.ingredients = new ArrayList<Things>(List.of(Potato,Cheese,Vegetable));

        Product[] allFoods = {Burger,Pizza,Stake,FriedPotato,friedChicken,Coffee,Tea,HotChocolate,Soda,Salad,Water,ChocolateCake,VanillaCake,IceCream};
        addToMenu(allFoods);
        Things[] ingres = {Flour, Cheese, Meat, Bread, Vegetable, Chicken, Potato, coffee, Beans, tea, Chocolate, soda, iceCream, Egg, Vanilla, water , Sugar};
        addToleftList(ingres);
        //Finally initializing foods is over!!

        //Starting the program
        int countOfOrders = 1 ,numberOfCostumers = 0;
        ourUsers.add(admin); //Adding the manager at first place
        System.out.println("hello welcome to NimaNM7 restaurant");
        int number = 0;
        int counter = 0;
        //getting input and writing the help section
        outer:
        while(number != -1) {
            counter++;
            if(counter == 1 || nowUser.isCustomer())
                System.out.println("\nLogin : 1\nRegister : 2\nOrder : 3\nAccount Info : 4\nChange info : 5\nExit : -1");
            else
                System.out.println("\nLogin : 1\nRegister : 2\nOrder : 3\nAccount Info : 4\nChange info : 5\nCheck Storage : 6\nCheck Prices : 7\nChange Prices : 8\nAdd Manager : 9\nExit : -1");
            number = input.nextInt();
            //Login
            if (number == 1) {
                int flag = 0;
                System.out.println("Login\n");
                System.out.print("Name : ");
                personName = input.nextLine();
                personName = input.nextLine();
                System.out.print("Password : ");
                personPassword = input.nextLine();
                for (int i = 0; i < ourUsers.size(); i++) {
                    if (ourUsers.get(i).getName().equals(personName)) {
                        if (ourUsers.get(i).getPassword().equals(personPassword)) {
                            System.out.println("your logged in dear " + personName + " . I hope you enjoy."); //Success
                            nowUser = ourUsers.get(i);
                            flag = 1;
                        } else {
                            System.out.println("your password is incorrect. Please try again!"); //Incorrect Password
                            flag = 1;
                        }
                    }
                }
                if (flag == 0) {
                    System.out.println("there isnt any accounts with this name. You can register"); //No Such Username
                }
                }
            //Registering
            if (number == 2) {
                System.out.println("Register\n");
                System.out.print("Name : ");
                personName = input.nextLine();
                personName = input.nextLine();
                System.out.print("Password : ");
                personPassword = input.nextLine();
                System.out.println("How much money do you have?");
                int personMoney = input.nextInt();
                for (int i = 0 ; i < ourUsers.size() ; i++)
                {
                    if (ourUsers.get(i).getName().equals(personName))
                    {
                        System.out.println("There is already an account with this name"); //Repeated
                        continue outer;
                    }
                }
                User newUser = new User(Type.COSTUMER, personName, personPassword , personMoney);
                ourUsers.add(newUser);
                nowUser = newUser;
                System.out.println("Congratulations. you registered successfully!"); //Success
                numberOfCostumers++;
            }

            //Ordering (the most important part)
            if(number == 3)
            {
                ArrayList<Product> pros = new ArrayList<>();

                while(nowUser.isCustomer()) {
                    System.out.println("this is our menu. what you want?\nMain Food : 1\nDrink : 2\nDessert : 3\nAppetizer : 4\nDone : 5"); //Overall Menu
                    int orderNumber = input.nextInt();
                    int orderNumber1;
                    if (orderNumber == 1) //Main Food
                    {
                        System.out.println("what main food do you want ?\nBurger : 1\nPizza : 2\nStake : 3\nFried Chicken : 4"); //Main Food Menu
                        orderNumber1 = input.nextInt();
                        if (orderNumber1 == 1) pros.add(Burger);
                        if (orderNumber1 == 2) pros.add(Pizza);
                        if (orderNumber1 == 3) pros.add(Stake);
                        if (orderNumber1 == 4) pros.add(friedChicken);
                    }
                    if(orderNumber == 2) //Drink
                    {
                        System.out.println("What drink do you want?\nCoffee : 1\nTea : 2\nHot Chockolate : 3\nSoda : 4\nWater : 5"); //Drink Menu
                        orderNumber1 = input.nextInt();
                        if (orderNumber1 == 1) pros.add(Coffee);
                        if (orderNumber1 == 2) pros.add(Tea);
                        if (orderNumber1 == 3) pros.add(HotChocolate);
                        if (orderNumber1 == 4) pros.add(Soda);
                        if (orderNumber1 == 5) pros.add(Water);
                    }
                    if(orderNumber == 3) //Dessert
                    {
                        System.out.println("What dessert do you want?\nChocolate Cake : 1\nVanilla Cake : 2\nIce Cream : 3"); //Dessert Menu
                        orderNumber1 = input.nextInt();
                        if (orderNumber1 == 1) pros.add(ChocolateCake);
                        if (orderNumber1 == 2) pros.add(VanillaCake);
                        if (orderNumber1 == 3) pros.add(IceCream);
                    }
                    if(orderNumber == 4) //Appetizer
                    {
                        System.out.println("What appetizer do you want?\nSalad : 1\nFried Potato : 2"); //Appetizer Menu
                        orderNumber1 = input.nextInt();
                        if (orderNumber1 == 1) pros.add(Salad);
                        if (orderNumber1 == 2) pros.add(FriedPotato);
                    }
                    if(orderNumber == 5) //The order is done (time to calculate the price, give order ID and ...)
                    {
                        Order myOrder = new Order(countOfOrders , nowUser , pros);
                        //if the costumer doesn't have enough money!
                        if(nowUser.getMoney() < 0)
                        {
                            System.out.println("You dont have enough money!");
                            nowUser.gainMoney(myOrder.getOrderPrice());
                            countOfOrders--;
                            break ;
                        }
                        //if our ingredients are running out!
                        for(int i = 0 ; i < pros.size() ; i++)
                        {
                            for(int j = 0 ; j < pros.get(i).ingredients.size() ; j++)
                            {
                                while(pros.get(i).ingredients.get(j).getAmountLeft() < 0)
                                {
                                    pros.get(i).ingredients.get(j).buy(pros.get(i).ingredients.get(j) , 10 , admin);
                                }
                            }
                        }
                        admin.gainMoney(myOrder.getOrderPrice()); //Manager getting paid
                        countOfOrders++;
                        myOrder.getBill(); //giving bill
                        break;
                    }
                }
            }

            //Checking the profile
            if (number == 4)
            {
                nowUser.info();
            }

            //Changing the profile
            if(number == 5)
            {
                //Privacy check (checking if the user knows the current password to give him access)
                System.out.println("input your current password");
                personPassword = input.nextLine();
                personPassword = input.nextLine();
                if(!nowUser.getPassword().equals(personPassword))
                {
                    System.out.println("this is wrong");
                    continue ;
                }
                System.out.println("input your new username");
                personName = input.nextLine();
                System.out.println("input your new password");
                personPassword = input.nextLine();
                nowUser.changeName(personName);
                nowUser.changePassword(personPassword);
                System.out.println("changes are done succesfully!"); //Done!
            }

            //Checking the storage (just for managers)
            if(number == 6 && !nowUser.isCustomer())
            {
                addToleftList(ingres); //updating the hashmap
                for(Things a : thingsLeft.keySet())
                {
                    System.out.println(a.getName() + " : " + thingsLeft.get(a));
                }
            }

            //Checking the prices (just for managers)
            String foodname;
            if(number == 7 && !nowUser.isCustomer())
            {
                addToMenu(allFoods); //updating the hashmap
                System.out.println("What food's price do you want to see? (write all if you want to see the whole menu)");
                foodname = input.nextLine();
                foodname = input.nextLine();
                if(foodname.equals("all")) //all option
                {
                    for(Product a : allFoodMenu.keySet())
                        System.out.println(a.Name + " " + allFoodMenu.get(a));
                    continue ;
                }
                for(Product a : allFoodMenu.keySet()) //regular situation
                {
                    if(a.Name.equals(foodname)) {
                        System.out.println(a.Name + "'s price is  " + allFoodMenu.get(a));
                        continue outer;
                    }
                }
                System.out.println("No food with this name!"); //when the name is not in list
            }

            //Changing the prices (just for managers)
            if(number == 8 && !nowUser.isCustomer())
            {
                System.out.println("What food's price do you want to change?");
                foodname = input.nextLine();
                foodname = input.nextLine();
                for(int i = 0 ; i < allFoods.length ; i++)
                {
                    if(allFoods[i].Name.equals(foodname))
                    {
                        System.out.println("Current price is " + allFoods[i].price);
                        System.out.println("What is going to be the new price?");
                        int newprice = input.nextInt();
                        allFoods[i].changePrice(newprice);
                        addToMenu(allFoods); //update our menu for preventing buggs (not neccesary)
                    }
                }
            }

            //Adding another manager (just for managers)
            if(number == 9 && !nowUser.isCustomer())
            {
                System.out.println("input your name");
                personName = input.nextLine();
                personName = input.nextLine();
                System.out.println("input your password");
                personPassword = input.nextLine();
                for (int i = 0 ; i < ourUsers.size() ; i++)
                {
                    if (ourUsers.get(i).getName().equals(personName))
                    {
                        System.out.println("There is already an account with this name"); //Repeated
                        continue outer;
                    }
                }
                User newUser = new User(Type.MANAGER,personName,personPassword,10000000);
                nowUser = newUser;
                ourUsers.add(newUser);
                System.out.println("Hello boss. You are successfully registered!");
                numberOfCostumers++;
            }
        }
    }
}
