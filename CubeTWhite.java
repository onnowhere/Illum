import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Cube here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CubeTWhite extends Animal
{
    public ArrayList<Line> lines = new ArrayList<Line>();
    /**
     * Act - do whatever the Cube wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CubeTWhite()
    { 
        GreenfootImage image = new GreenfootImage("CubeFade.png");
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
        lines.add(new Line(new Vector(getX()-10,getY()-10),new Vector(getX()+10,getY()-10)));
        lines.add(new Line(new Vector(getX()-10,getY()+10),new Vector(getX()+10,getY()+10)));
        lines.add(new Line(new Vector(getX()-10,getY()-10),new Vector(getX()-10,getY()+10)));
        lines.add(new Line(new Vector(getX()+10,getY()-10),new Vector(getX()+10,getY()+10)));
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
