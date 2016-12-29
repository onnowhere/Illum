import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cube here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cube3d extends Animal
{
    /**
     * Act - do whatever the Cube wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Cube3d()
    {
        GreenfootImage image = new GreenfootImage("Cube3d.png");  
        image.scale(24,24);
        setImage(image); 
    }
    public void act() 
    {
        // Add your action code here.
    }
    public void setInvisible()
    {
        GreenfootImage image = new GreenfootImage("transparent.png");  
        image.scale(24,24);
        setImage(image);
    }
    public void setVisible()
    {
        GreenfootImage image = new GreenfootImage("Cube3d.png");  
        image.scale(24,24);
        setImage(image);
    }
}
