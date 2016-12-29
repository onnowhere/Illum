import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
public class Finish extends Animal
{
    public int x;
    public int y;
    public Finish()
    {
        GreenfootImage image = getImage();  
        image.scale(30, 30);
        setImage(image);
    }
    public void act() 
    {
        this.x = getX();
        this.y = getY();
    }
}
