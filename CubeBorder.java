import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Cube here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CubeBorder extends Animal
{
    public ArrayList<Line> lines = new ArrayList<Line>();
    public ArrayList<Vector> points = new ArrayList<Vector>();
    public int x;
    public int y;
    /**
     * Act - do whatever the Cube wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CubeBorder(int x, int y)
    {
        GreenfootImage image = getImage();  
        image.scale(x, y);  
        setImage(image);
        this.x = x;
        this.y = y;
    }
    public void act() 
    {
        // Add your action code here.
    }
    public void setLines()
    {
        double xf1 = (x/2+4);
        double xf2 = (x/2-4);
        double yf1 = (y/2-4);
        double yf2 = (y/2+4);
        lines.add(new Line(new Vector(getX()-xf1,getY()-yf1),new Vector(getX()+xf2,getY()-yf1)));
        lines.add(new Line(new Vector(getX()-xf1,getY()+yf2),new Vector(getX()+xf2,getY()+yf2)));
        lines.add(new Line(new Vector(getX()-xf1,getY()-yf1),new Vector(getX()-xf1,getY()+yf2)));
        lines.add(new Line(new Vector(getX()+xf2,getY()-yf1),new Vector(getX()+xf2,getY()+yf2)));
        points.add(new Vector(getX()-xf1,getY()-yf1));
        points.add(new Vector(getX()-xf1,getY()+yf2));
        points.add(new Vector(getX()+xf2,getY()-yf1));
        points.add(new Vector(getX()+xf2,getY()+yf2));
        points.add(new Vector(getX()-xf1+20,getY()-yf1+20));
        points.add(new Vector(getX()-xf1+20,getY()+yf2-20));
        points.add(new Vector(getX()+xf2-20,getY()-yf1+20));
        points.add(new Vector(getX()+xf2-20,getY()+yf2-20));
    }
}
