import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Cube here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SwitchRed extends Animal
{
    public char id;
    public char color;
    public boolean on;
    public ArrayList<Vector> points = new ArrayList<Vector>();
    /**
     * Act - do whatever the Cube wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SwitchRed(char charid)
    { 
        GreenfootImage image = new GreenfootImage("RedSwitchOff.png");
        image.scale(15,15);
        setImage(image);
        this.id = charid;
        this.color = 'r';
        this.on = false;
    }
    public void act() 
    {
        openGate();
        // Add your action code here.
    }
    public int cubeX()
    {
        return getX();
    }
    public int cubeY()
    {
        return getY();
    }
    public void setPoints()
    {
        double xf1 = 7.5;
        double xf2 = 7.5;
        double yf1 = 7.5;
        double yf2 = 7.5;
        points.add(new Vector(getX()-xf1,getY()-yf1));
        points.add(new Vector(getX()-xf1,getY()+yf2));
        points.add(new Vector(getX()+xf2,getY()-yf1));
        points.add(new Vector(getX()+xf2,getY()+yf2));
    }
    public void setOff()
    {
        GreenfootImage imagex = new GreenfootImage("RedSwitchOff.png");  
        imagex.scale(15,15);
        setImage(imagex);
        this.on = false;
    }
    public void setOn()
    {
        GreenfootImage imagex = new GreenfootImage("RedSwitchOn.png");  
        imagex.scale(15,15);
        setImage(imagex);
        this.on = true;
    }
    public void openGate()
    {
        int timer = 0;
        if (this.id == '1') timer = 100;
        if (this.id == '2') timer = 1000000;
        if (this.on == true)
        {
            for (Object cubeDoorTemp : (ArrayList<CubeDoor>)getWorld().getObjects(CubeDoor.class))
            {
                CubeDoor cubeDoor = (CubeDoor)cubeDoorTemp;
                if (this.id == cubeDoor.id && this.color == cubeDoor.color)
                {
                    cubeDoor.setInvisible(timer);
                }
            }
            for (Object cubeDoor3dTemp : (ArrayList<CubeDoor3d>)getWorld().getObjects(CubeDoor3d.class))
            {
                CubeDoor3d cubeDoor3d = (CubeDoor3d)cubeDoor3dTemp;
                if (this.id == cubeDoor3d.id && this.color == cubeDoor3d.color)
                {
                    cubeDoor3d.setInvisible(timer);
                }
            }
        }
    }
}
