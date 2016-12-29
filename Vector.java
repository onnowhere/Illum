/**
 * Write a description of class Vector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vector  
{
    public double x;
    public double y;
    /**
     * Constructor for objects of class Vector
     */
    public Vector(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector add(Vector v)
    {
        return new Vector(this.x + v.x,this.y - v.y);
    }
    
    public Vector subtract(Vector v)
    {
        return new Vector(this.x - v.x,this.y - v.y);
    }
    
    public double dot(Vector v)
    {
        return this.x*v.x+this.y*v.y;
    }
    
    public Vector normal() {
        return new Vector(-y, x);
    }
    
    public Vector normalize()
    {
        double magnitude = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
        return new Vector(x/magnitude,y/magnitude);
    }
    
    public Vector scalarmultiply(double scalar)
    {
        return new Vector(x*scalar,y*scalar);
    }
    
    public double cross(Vector a) {
        return x*a.y - y*a.x;
    }
}
