/**
 * Write a description of class Ray here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ray  
{
    public Vector source;
    public Vector direction;
    /**
     * Constructor for objects of class Line
     */
    public Ray(Vector source, Vector direction)
    {
        this.source = source;
        this.direction = direction;
    }
    
    public Vector intersect(Line l)
    {
        Vector a = l.a;
        Vector b = l.b.subtract(l.a).normalize();
        Vector c = source;
        Vector d = direction;
        double u = (b.x*(c.y-a.y)+b.y*(a.x-c.y))/(d.x*b.y-d.y*b.x);
        Vector intersection = source.add(direction.scalarmultiply(u));
        return intersection;
    }
}
