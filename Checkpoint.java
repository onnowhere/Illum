import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
public class Checkpoint extends Animal
{
    public int x;
    public int y;
    public char id;
    public int activated;
    public Checkpoint(char charid)
    {
        GreenfootImage image = new GreenfootImage("Checkpoint.png");
        image.scale(30, 30);
        setImage(image);
        this.id = charid;
        this.activated = 0;
    }
    public void act() 
    {
        checkactive();
        this.x = getX();
        this.y = getY();
    }
    public void checkactive()
    {
        if (this.activated == -1)
        {
            GreenfootImage image = new GreenfootImage("Checkpoint.png");
            image.scale(30, 30);
            setImage(image);
            this.activated = 0;
        }
        if (this.activated == 1)
        {
            GreenfootImage image = new GreenfootImage("CheckpointFlag.png");
            image.scale(18, 18);
            setImage(image);
            this.activated = 2;
        }
    }
}
