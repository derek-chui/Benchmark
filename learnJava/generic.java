public class generic <T extends Number, U extends Number>
{
    //extends Number so can pass in anything within Number subclass
    T x;
    U y;
    generic(T x, U y)
    {
        this.x = x;
        this.y = y;
    }
    public U getVal()
    {
        return y;
    }
}
