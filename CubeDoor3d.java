import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cube here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CubeDoor3d extends Animal
{
    public char id;
    public char color;
    public int timer;
    /**
     * Act - do whatever the Cube wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CubeDoor3d(char charid, char charcolor)
    {
        GreenfootImage image = new GreenfootImage("CubeDoor3d.png");  
        image.scale(24,24);
        setImage(image);
        this.id = charid;
        this.color = charcolor;
        this.timer = 0;
    }
    public void act() 
    {
        countdown();
        setVisible();
        // Add your action code here.
    }
    public void setInvisible(int timerx)
    {
        GreenfootImage image = new GreenfootImage("transparent.png");  
        image.scale(24,24);
        setImage(image);
        this.timer = timerx;
    }
    public void setVisible()
    {
        if (this.timer == 0)
        {
            GreenfootImage image = new GreenfootImage("CubeDoor3d.png");  
            image.scale(24,24);
            setImage(image);
        }
    }
    public void countdown()
    {
        if (this.timer > 0 && this.timer < 1000000) this.timer--;
        if (!getWorld().getObjectsAt(getX(),getY(),Player.class).isEmpty() && this.timer == 0)
        {
            this.timer = 1;
        }
    }
}
