import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Cube here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cube extends Animal
{
    public ArrayList<Line> lines = new ArrayList<Line>();
    public ArrayList<Vector> points = new ArrayList<Vector>();
    /**
     * Act - do whatever the Cube wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Cube()
    {
        GreenfootImage image = new GreenfootImage("Cube.png");
        image.scale(20,20);
        setImage(image);
    }
    public void act()
    {
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
        int xf1 = 10;
        int xf2 = 10;
        int yf1 = 10;
        int yf2 = 10;
        lines.add(new Line(new Vector(getX()-xf1,getY()-yf1),new Vector(getX()+xf2,getY()-yf1)));
        lines.add(new Line(new Vector(getX()-xf1,getY()+yf2),new Vector(getX()+xf2,getY()+yf2)));
        lines.add(new Line(new Vector(getX()-xf1,getY()-yf1),new Vector(getX()-xf1,getY()+yf2)));
        lines.add(new Line(new Vector(getX()+xf2,getY()-yf1),new Vector(getX()+xf2,getY()+yf2)));
        points.add(new Vector(getX()-xf1,getY()-yf1));
        points.add(new Vector(getX()-xf1,getY()+yf2));
        points.add(new Vector(getX()+xf2,getY()-yf1));
        points.add(new Vector(getX()+xf2,getY()+yf2));    
    }
    public void checkVisible()
    {
        
    }
    public void setInvisible()
    {
        GreenfootImage image = new GreenfootImage("transparent.png");  
        image.scale(20,20);
        setImage(image);
    }
    public void setVisible()
    {
        GreenfootImage image = new GreenfootImage("Cube.png");  
        image.scale(20,20);
        setImage(image);
    }
}
