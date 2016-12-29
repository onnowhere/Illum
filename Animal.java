import greenfoot.*;

import java.util.List;
import java.util.ArrayList;

/**
 * Animal. This is the base class for all animals. In addition to the standard Actor
 * methods, it provides the ability to move and turn.
 * 
 * @author Michael Kolling
 * @version 1.0
 */
public class Animal extends Actor{  
    public static double WALKING_SPEED = 5.0;
    public static double MOVE_UP = 0.0;
    public static double MOVE_DOWN = 0.0;
    public static double MOVE_LEFT = 0.0;
    public static double MOVE_RIGHT = 0.0;
    public static int FADE_TIMER = 0;
    
    /**
     * Constructor for Animal - nothing to do.z
     */
    public Animal()
    {
        MOVE_RIGHT = 0;
        MOVE_LEFT = 0;
        MOVE_UP = 0;
        MOVE_DOWN = 0;
    }

    /**
     * Act - empty method. Animals have no default action.
     */
    public void act()
    {
        
        //move();
        //if(canSee(Worm.class))
        //{
        //   eat(Worm.class);
        //}
        //else if( atWorldEdge() )
        //{
        //   turn(15);
        //}

    }
    
    
    /**
     * Turn 'angle' degrees towards the right (clockwise).
     */
    public void turn(int angle)
    {
        setRotation(getRotation() + angle);
    }

    /**
     * Move forward in the current direction.
     */
    public void move()
    {
        double angle = Math.toRadians( getRotation() );
        int x = (int) Math.round(getX() + Math.cos(angle) * WALKING_SPEED);
        int y = (int) Math.round(getY() + Math.sin(angle) * WALKING_SPEED);
        setLocation(x, y);
    }
    
    public boolean moveCheck(int x1, int y1, int x2, int y2, int x3, int y3, Class type)
    {
        if (
        getWorld().getObjectsAt(getX()+x1,getY()+y1,type).isEmpty()
        && getWorld().getObjectsAt(getX()+x2,getY()+y2,type).isEmpty()
        && getWorld().getObjectsAt(getX()+x3,getY()+y3,type).isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean moveCheckList(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        Class[] types = {
            Cube.class,
            CubeFade.class,
            CubeInvisible.class,
            CubeTWhite.class,
            CubeTGreen.class,
            CubeTRed.class,
            SwitchGreen.class,
            SwitchRed.class
        };
        boolean check = true;
        for (Class type : types)
        {
            if (
            getWorld().getObjectsAt(getX()+x1,getY()+y1,type).isEmpty()
            && getWorld().getObjectsAt(getX()+x2,getY()+y2,type).isEmpty()
            && getWorld().getObjectsAt(getX()+x3,getY()+y3,type).isEmpty())
            {
            }
            else
            {
                check = false;
            }
        }
        return check;
    }
    
    public boolean moveCheckDoor(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        boolean check = true;
        if (
        !getWorld().getObjectsAt(getX()+x1,getY()+y1,CubeDoor.class).isEmpty())
        {
            CubeDoor cubeDoor = (CubeDoor)getWorld().getObjectsAt(getX()+x1,getY()+y1,CubeDoor.class).get(0);
            if (cubeDoor.visible == true) check = false;
        }
        if (
        !getWorld().getObjectsAt(getX()+x2,getY()+y2,CubeDoor.class).isEmpty())
        {
            CubeDoor cubeDoor = (CubeDoor)getWorld().getObjectsAt(getX()+x2,getY()+y2,CubeDoor.class).get(0);
            if (cubeDoor.visible == true) check = false;
        }
        if (
        !getWorld().getObjectsAt(getX()+x3,getY()+y3,CubeDoor.class).isEmpty())
        {
            CubeDoor cubeDoor = (CubeDoor)getWorld().getObjectsAt(getX()+x3,getY()+y3,CubeDoor.class).get(0);
            if (cubeDoor.visible == true) check = false;
        }
        return check;
    }
    
    public void moveUp()
    {
        if ((Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up"))
        && moveCheckList(-6, -12, 0, -12, 6, -12) == true
        && moveCheckDoor(-6, -12, 0, -12, 6, -12) == true
        && moveCheck(-4, -16, 0, -16, 4, -16, CubeBorder.class) == true)
        {
                MOVE_UP = 2*2.5;
                if (MOVE_LEFT > 0 || MOVE_RIGHT > 0)
                {
                    MOVE_UP = 1.414*2.5;
                }
                MOVE_DOWN = 0;
        }
        else
        {
            if (MOVE_UP > 0
            && moveCheckList(-6, -12, 0, -12, 6, -12) == true
            && moveCheckDoor(-6, -12, 0, -12, 6, -12) == true
            && moveCheck(-4, -16, 0, -16, 4, -16, CubeBorder.class) == true)
            {
                MOVE_UP -= 0.2*2.5;
            }
            else
            {
                MOVE_UP = 0;
            }
        }
        setLocation(getX(), getY()-(int)Math.round(MOVE_UP));
    }
    
    public void moveDown()
    {
        if ((Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down"))
        && moveCheckList(-6, 12, 0, 12, 6, 12) == true
        && moveCheckDoor(-6, 12, 0, 12, 6, 12) == true
        && moveCheck(-4, 10, 0, 10, 4, 10, CubeBorder.class) == true)
        {
            MOVE_DOWN = 2*2.5;
            if (MOVE_LEFT > 0 || MOVE_RIGHT > 0)
            {
                MOVE_DOWN = 1.414*2.5;
            }
            MOVE_UP = 0;
        }
        else
        {
            if (MOVE_DOWN > 0
            && moveCheckList(-6, 12, 0, 12, 6, 12) == true
            && moveCheckDoor(-6, 12, 0, 12, 6, 12) == true
            && moveCheck(-6, 12, 0, 12, 6, 12, CubeBorder.class) == true)
            {
                MOVE_DOWN -= 0.2*2.5;
            }
            else
            {
                MOVE_DOWN = 0;
            }
        }
        setLocation(getX(), getY()+(int)Math.round(MOVE_DOWN));
    }
    
    public void moveLeft()
    {
        if ((Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left"))
        && moveCheckList(-12, -6, -12, 0, -12, 6) == true
        && moveCheckDoor(-12, -6, -12, 0, -12, 6) == true
        && moveCheck(-10, -4, -10, 0, -10, 4, CubeBorder.class) == true)
        {
            MOVE_LEFT = 2*2.5;
            if (MOVE_UP > 0 || MOVE_DOWN > 0)
            {
                MOVE_LEFT = 1.414*2.5;
            }
            MOVE_RIGHT = 0;
        }
        else
        {
            if (MOVE_LEFT > 0
            && moveCheckList(-12, -6, -12, 0, -12, 6) == true
            && moveCheckDoor(-12, -6, -12, 0, -12, 6) == true
            && moveCheck(-10, -4, -10, 0, -10, 4, CubeBorder.class) == true)
            {
                MOVE_LEFT -= 0.2*2.5;
            }
            else
            {
                MOVE_LEFT = 0;
            }
        }
        setLocation(getX()-(int)Math.round(MOVE_LEFT), getY());
    }
    
    public void moveRight()
    {
        if ((Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right"))
        && moveCheckList(12, -6, 12, 0, 12, 6) == true
        && moveCheckDoor(12, -6, 12, 0, 12, 6) == true
        && moveCheck(16, -4, 16, 0, 16, 4, CubeBorder.class) == true)
        {
            MOVE_RIGHT = 2*2.5;
            if (MOVE_UP > 0 || MOVE_DOWN > 0)
            {
                MOVE_RIGHT = 1.414*2.5;
            }
            MOVE_LEFT = 0;
        }
        else
        {
            if (MOVE_RIGHT > 0
            && moveCheckList(12, -6, 12, 0, 12, 6) == true
            && moveCheckDoor(12, -6, 12, 0, 12, 6) == true
            && moveCheck(16, -4, 16, 0, 16, 4, CubeBorder.class) == true)
            {
                MOVE_RIGHT -= 0.2*2.5;
            }
            else
            {
                MOVE_RIGHT = 0;
            }
        }
        setLocation(getX()+(int)Math.round(MOVE_RIGHT), getY());
    }
    
    public void showLight()
    {
    }
    
    /**
     * Test if we are close to one of the edges of the world. Return true is we are.
     */
    public boolean atWorldEdge()
    {
        if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
    }
    
    
    /**
     * Return true if we can see an object of class 'clss' right where we are. 
     * False if there is no such object here.
     */
    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }

    
    /**
     * Try to eat an object of class 'clss'. This is only successful if there
     * is such an object where we currently are. Otherwise this method does
     * nothing.
     */
    public void eat(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) {
            getWorld().removeObject(actor);
        }
    }
}