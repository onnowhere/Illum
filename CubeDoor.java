import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Cube here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CubeDoor extends Animal
{
    public ArrayList<Line> lines = new ArrayList<Line>();
    public ArrayList<Vector> points = new ArrayList<Vector>();
    public char id;
    public char color;
    public boolean visible;
    public int timer;
    /**
     * Act - do whatever the Cube wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CubeDoor(char charid, char charcolor)
    {
        GreenfootImage image = new GreenfootImage("Cube.png");
        image.scale(20,20);
        setImage(image);
        this.id = charid;
        this.color = charcolor;
        this.visible = true;
        this.timer = 0;
    }
    public void act()
    {
        countdown();
        setVisible();
        setLines();
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
    public void setLines()
    {
        lines.clear();
        points.clear();
        if (visible == true)
        {
            int xf1 = 10;
            int xf2 = 10;
            int yf1 = 10;
            int yf2 = 10;
            lines.add(new Line(new Vector(getX()-xf1,getY()-yf1),new Vector(getX()+xf2,getY()-yf1)));
            lines.add(new Line(new Vector(getX()-xf1,getY()+yf2),new Vector(getX()+xf2,getY()+yf2)));
            lines.add(new Line(new Vector(getX()-xf1,getY()-yf1),new Vector(getX()-xf1,getY()+yf2)));
            lines.add(new Line(new Vector(getX()+xf2,getY()-yf1),new Vector(getX()+xf2,getY()+yf2)));
        }
    }
    public void setPoints()
    {
        int xf1 = 10;
        int xf2 = 10;
        int yf1 = 10;
        int yf2 = 10;
        points.add(new Vector(getX()-xf1,getY()-yf1));
        points.add(new Vector(getX()-xf1,getY()+yf2));
        points.add(new Vector(getX()+xf2,getY()-yf1));
        points.add(new Vector(getX()+xf2,getY()+yf2));
    }
    public void setInvisible(int timer)
    {
        GreenfootImage image = new GreenfootImage("transparent.png");  
        image.scale(20,20);
        setImage(image);
        this.visible = false;
        this.timer = timer;
    }
    public void setVisible()
    {
        if (this.timer == 0)
        {
            GreenfootImage image = new GreenfootImage("Cube.png");  
            image.scale(20,20);
            setImage(image);
            this.visible = true;
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
