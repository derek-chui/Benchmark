package Personal.Projects.Benchmark.learnJava;
import java.io.Serializable;

public class profile implements Serializable
{
    private static final long serialVersionUID = 1;
    //if abstract then cannot implement in current class but child
    private String name;
    public int friends;
    public boolean adult;
    public static char symbol;
    //transient keyword means it's ignored when serialized

    public profile(String name, int friends)
    {
        this.name = name;
        this.friends = friends;
    }
    public profile(String name, int friends, boolean adult)
    {
        this.name = name;
        this.friends = friends;
        this.adult = adult;
    }
    public String toString()
    {
        return "This is " + name + "'s profile";
    }
    public void addFriend()
    {
        friends++;
        System.out.println("New Friend Added. Friends: " + friends);
    }
    public static void showSymbol()
    {
        System.out.println(symbol);
    }
    public void verify()
    {
        System.out.println("profile");
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void copyName(profile x)
    {
        this.setName(x.getName());
    }
}
