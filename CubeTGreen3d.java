import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Cube here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CubeTGreen3d extends Animal
{
    public ArrayList<Line> lines = new ArrayList<Line>();
    /**
     * Act - do whatever the Cube wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CubeTGreen3d()
    { 
        GreenfootImage image = new GreenfootImage("CubeGreen3d.png");
        image.scale(24,24);
        setImage(image);
    }
    public void act() 
    {
        // Add your action code here.
    }
    public void setInvisible()
    {
        GreenfootImage imagex = new GreenfootImage("transparent.png");  
        imagex.scale(24,24);
        setImage(imagex);
    }
    public void setVisible()
    {
        GreenfootImage imagex = new GreenfootImage("CubeGreen3d.png");  
        imagex.scale(24,24);
        setImage(imagex);
    }
}
