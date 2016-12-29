import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
public class Enemy extends Animal
{
    public char id;
    public int movement;
    public int x;
    public int y;
    public int xorigin;
    public int yorigin;
    public int timer;
    public int lifetime;
    public ArrayList<Vector> points = new ArrayList<Vector>();
    public Enemy(char charid)
    {
        GreenfootImage image = getImage();  
        image.scale(30, 30);
        setImage(image);
        this.timer = 0;
        this.lifetime = 0;
        this.movement = 0;
        this.id = charid;
    }
    public void act() 
    {
        if (lifetime == 0)
        {
            this.xorigin = getX();
            this.yorigin = getY();
            this.lifetime = 1;
        }
        this.x = getX();
        this.y = getY();
        movement();
        points.clear();
        points.add(new Vector(this.x,this.y));
    }
    public void movement()
    {
        if (id == '1')
        {   String[] directions = new String[]
            {
                "u.02.0000.0030",
                "r.02.0030.0060",
                "d.02.0060.0090",
                "l.02.0090.0120"
            };
            rundirections(directions);
            if (this.timer == 120) this.timer = -1;
        }
        
        if (id == '2')
        {
            String[] directions = new String[]
            {
                "u.02.0000.0010",
                "r.02.0010.0030",
                "d.02.0030.0040",
                "r.02.0040.0060",
                "u.02.0060.0080",
                "l.02.0080,0100",
                "u.02.0100.0120",
                "r.02.0120.0140",
                "d.02.0140.0170",
                "r.02.0170.0200",
                "d.02.0200.0210",
                "r.02.0210.0230",
                "d.02.0230.0240",
                "r.02.0240.0250",
                "d.02.0250.0270",
                "l.02.0270.0280",
                "d.02.0280.0300",
                "l.02.0300.0340",
                "u.02.0340.0360",
                "r.02.0360.0390",
                "u.02.0390.0410",
                "r.02.0410.0420",
                "u.02.0420.0450",
                "l.02.0450.0480",
                "d.02.0480.0490",
                "l.02.0490.0510",
                "d.02.0510.0520",
                "l.02.0520.0540",
                "d.02.0540.0550",
                "l.02.0550.0570",
                "u.02.0570.0580",
            };
            rundirections(directions);
            if (this.timer == 580) this.timer = -1;
        }
        
        if (id == '3')
        {   String[] directions = new String[]
            {
                "r.04.0000.0030",
                "u.04.0030.0060",
                "l.04.0060.0090",
                "d.04.0090.0120"
            };
            rundirections(directions);
            if (this.timer == 120) this.timer = -1;
        }

        if (id == '4')
        {   String[] directions = new String[]
            {
                "d.02.0000.0190",
                "r.02.0190.0210",
                "u.02.0210.0220",
                "l.02.0220.0230",
                "u.02.0230.0400",
                "r.02.0400.0450",
                "d.02.0450.0470",
                "l.02.0470.0500",
                "d.02.0500.0520",
                "r.02.0520.0570",
                "u.02.0570.0590",
                "l.02.0590.0600",
                "u.02.0600.0630",
                "l.04.0630.0665"
            };
            rundirections(directions);
            if (this.timer == 665) this.timer = -1;
        }
        this.timer++;
    }
    public void mRight(int z)
    {
        setLocation(this.x+z,this.y);
    }
    public void mDown(int z)
    {
        setLocation(this.x,this.y+z);
    }
    public void mLeft(int z)
    {
        setLocation(this.x-z,this.y);
    }
    public void mUp(int z)
    {
        setLocation(this.x,this.y-z);
    }
    public void rundirections(String[] directions)
    {
        for (String direction : directions)
        {
            int speed = Integer.parseInt(direction.substring(2,4));
            int tmin = Integer.parseInt(direction.substring(5,9));
            int tmax = Integer.parseInt(direction.substring(10,14));
            if (direction.substring(0,1).equals("u"))
            {
                if (timer >= tmin && timer < tmax) mUp(speed);
            }
            if (direction.substring(0,1).equals("d"))
            {
                if (timer >= tmin && timer < tmax) mDown(speed);
            }
            if (direction.substring(0,1).equals("l"))
            {
                if (timer >= tmin && timer < tmax) mLeft(speed);
            }
            if (direction.substring(0,1).equals("r"))
            {
                if (timer >= tmin && timer < tmax) mRight(speed);
            }
        }
    }
    public void reset()
    {
        this.timer = 0;
        setLocation(xorigin,yorigin);
    }
}
