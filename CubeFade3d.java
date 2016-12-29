import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Cube here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CubeFade3d extends Animal
{
    public GreenfootImage image1;
    public GreenfootImage image2;
    public ArrayList<Line> lines = new ArrayList<Line>();
    Timer timer = new Timer(0,80);
    /**
     * Act - do whatever the Cube wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CubeFade3d()
    { 
        image1 = new GreenfootImage("Cube3d.png");
        image2 = new GreenfootImage("CubeFade3d.png");
        image1.scale(24,24);
        image2.scale(24,24);
        setImage(image1);
    }
    public void act() 
    {
        switchImage();
        // Add your action code here.
    }
    public void switchImage()
    {
        timer.addTimer();
        if (timer.x == 0)
        {
            setImage(image1);
        }
        if (timer.x == 40)
        {
            setImage(image2);
        }
    }
    public void setInvisible()
    {
        GreenfootImage imagex = new GreenfootImage("transparent.png");  
        imagex.scale(24,24);
        setImage(imagex);
    }
    public void setVisible()
    {
        GreenfootImage imagex = new GreenfootImage("CubeFade3d.png");  
        imagex.scale(24,24);
        setImage(imagex);
    }
}
