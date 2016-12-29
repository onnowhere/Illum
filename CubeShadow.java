import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cube here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CubeShadow extends Animal
{
    /**
     * Act - do whatever the Cube wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CubeShadow(int x, int y)
    {
        GreenfootImage image = getImage();  
        image.scale(x, y);  
        setImage(image); 
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
