/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer  
{
    public int x;
    public int xreset;
    /**
     * Constructor for objects of class Timer
     */
    public Timer(int x, int xreset)
    {
        this.x = x;
        this.xreset = xreset;
    }
    public Timer addTimer()
    {
        x++;
        if (x == xreset) x = 0;
        return new Timer(x,xreset);
    }
}
