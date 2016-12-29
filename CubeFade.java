import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Cube here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CubeFade extends Animal
{
    public ArrayList<Line> lines = new ArrayList<Line>();
    public ArrayList<Vector> points = new ArrayList<Vector>();
    public GreenfootImage image1;
    public GreenfootImage image2;
    public boolean faded;
    Timer timer = new Timer(0,80);
    /**
     * Act - do whatever the Cube wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CubeFade()
    { 
        image1 = new GreenfootImage("Cube.png");
        image2 = new GreenfootImage("CubeFade.png");
        image1.scale(20,20);
        image2.scale(20,20);
        setImage(image2);
        faded = false;
    }
    public void act() 
    {
        switchImage();
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
        if (faded == false)
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
    public void switchImage()
    {
        timer.addTimer();
        if (timer.x == 0)
        {
            setImage(image1);
            faded = false;
        }
        if (timer.x == 40)
        {
            setImage(image2);
            faded = true;
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
        GreenfootImage imagex = new GreenfootImage("CubeFade.png");  
        imagex.scale(24,24);
        setImage(imagex);
    }
}
