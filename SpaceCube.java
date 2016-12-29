import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
public class SpaceCube extends Animal
{
    public int x;
    public int y;
    public int timer = 0;
    public static GifImage image = new GifImage("SpaceCube.gif");
    public SpaceCube()
    {
    }
    public void act() 
    {
        setImage(image.getCurrentImage());
        this.x = getX();
        this.y = getY();
        popup();
    }
    public void popup()
    {
        if (timer == 0)
        {
            setLocation(500,800);
        }
        if (timer > 40 && timer <= 50)
        {
            setLocation(x,y-40);
        }
        if (timer > 51 && timer <= 55)
        {
            setLocation(x,y-15);
        }
        if (timer > 56 && timer <= 58)
        {
            setLocation(x,y-5);
        }
        if (timer > 59 && timer <= 60)
        {
            setLocation(x,y-1);
        }
        if (timer > 61 && timer <= 62)
        {
            setLocation(x,y+1);
        }
        if (timer > 63 && timer <= 66)
        {
            setLocation(x,y+5);
        }
        if (timer > 67 && timer <= 70)
        {
            setLocation(x,y+1);
        }
        
        //
        
        if (timer > 140 && timer <= 141)
        {
            setLocation(x,y+1);
        }
        if (timer > 142 && timer <= 144)
        {
            setLocation(x,y+5);
        }
        if (timer > 145&& timer <= 149)
        {
            setLocation(x,y+15);
        }
        if (timer > 150 && timer <= 160)
        {
            setLocation(x,y+40);
        }
        if (timer > 0)
        {
            timer++;
        }
        if (timer == 200)
        {
            timer = 0;
        }
    }
}
