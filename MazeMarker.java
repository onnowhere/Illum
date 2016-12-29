import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class MazeMarker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeMarker extends Animal
{
    /**
     * Act - do whatever the MazeMarker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MazeMarker()
    {
        GreenfootImage image = getImage();
        image.scale(20,20);
        setImage(image);
    }
    public void act()
    {
        // Add your action code here.
    }
}
