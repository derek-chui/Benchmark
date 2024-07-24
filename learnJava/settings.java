public class settings extends profile
{
    public settings(String name, int friends)
    {
        super(name, friends); //refers to profile
    }
    @Override
    public void verify()
    {
        System.out.println("settings");
    }
}