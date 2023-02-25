public class User
{
    private Type myType;
    private String Name;
    private String Password;
    private int money;

    public User(Type type,String name,String password , int money)
    {
        this.myType = type;
        this.Name = name;
        this.Password = password;
        this.money = money;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    public boolean isCustomer()
    {
        if(myType == Type.COSTUMER)
            return true;
        return false;
    }

    public int getMoney()
    {
        return money;
    }
    public void loseMoney(int amount)
    {
        money-=amount;
    }
    public void gainMoney(int amount)
    {
        money += amount;
    }

    public void changePassword(String newPassword)
    {
        this.Password = newPassword;
    }
    public void changeName(String newName)
    {
        this.Name = newName;
    }
    public void info()
    {
        System.out.println("Name : " + Name);
        System.out.println("Money : " + money);
        if(isCustomer()) System.out.println("Type : Customer");
        else System.out.println("Type : Manager");
    }
}
