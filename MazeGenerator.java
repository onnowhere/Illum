import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class MazeGenerator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeGenerator extends Animal
{
    public int x;
    public int y;
    public boolean generating;
    /**
     * Act - do whatever the MazeGenerator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MazeGenerator(int x, int y)
    {
        GreenfootImage image = getImage();
        image.scale(20,20);
        setImage(image);
        this.x = x;
        this.y = y;
        this.generating = true;
    }
    public void act()
    {
        /*
        this.x = getX();
        this.y = getY();
        this.generating = true;
        generateMaze();
        IllumWorld illumWorld = (IllumWorld) getWorld();
        illumWorld.removeObject(this);
        */
        // Add your action code here.
    }
    public void generateMaze()
    {
        IllumWorld illumWorld = (IllumWorld) getWorld();
        ArrayList<String> directions = new ArrayList<String>();
        String direction = "None";
        while (this.generating == true)
        {
            directions.clear();
            direction = "None";
            if (!illumWorld.getObjectsAt(this.x,this.y-40,CubeInvisible.class).isEmpty())
            {
                directions.add("North");
            }
            if (!illumWorld.getObjectsAt(this.x+40,this.y,CubeInvisible.class).isEmpty())
            {
                directions.add("East");
            }
            if (!illumWorld.getObjectsAt(this.x,this.y+40,CubeInvisible.class).isEmpty())
            {
                directions.add("South");
            }
            if (!illumWorld.getObjectsAt(this.x-40,this.y,CubeInvisible.class).isEmpty())
            {
                directions.add("West");
            }
            if (!directions.isEmpty())
            {
                direction = randChoice(directions);
                if (direction == "North")
                {
                    illumWorld.removeObject((Actor)illumWorld.getObjectsAt(this.x,this.y-20,CubeInvisible.class).get(0));
                    illumWorld.removeObject((Actor)illumWorld.getObjectsAt(this.x,this.y-40,CubeInvisible.class).get(0));
                    illumWorld.addObject(new MazeMarker(),this.x,this.y-40);
                    this.y -= 40;
                }
                if (direction == "East")
                {
                    illumWorld.removeObject((Actor)illumWorld.getObjectsAt(this.x+20,this.y,CubeInvisible.class).get(0));
                    illumWorld.removeObject((Actor)illumWorld.getObjectsAt(this.x+40,this.y,CubeInvisible.class).get(0));
                    illumWorld.addObject(new MazeMarker(),this.x+40,this.y);
                    this.x += 40;
                }
                if (direction == "South")
                {
                    illumWorld.removeObject((Actor)illumWorld.getObjectsAt(this.x,this.y+20,CubeInvisible.class).get(0));
                    illumWorld.removeObject((Actor)illumWorld.getObjectsAt(this.x,this.y+40,CubeInvisible.class).get(0));
                    illumWorld.addObject(new MazeMarker(),this.x,this.y+40);
                    this.y += 40;
                }
                if (direction == "West")
                {
                    illumWorld.removeObject((Actor)illumWorld.getObjectsAt(this.x-20,this.y,CubeInvisible.class).get(0));
                    illumWorld.removeObject((Actor)illumWorld.getObjectsAt(this.x-40,this.y,CubeInvisible.class).get(0));
                    illumWorld.addObject(new MazeMarker(),this.x-40,this.y);
                    this.x -= 40;
                }
            }
            if (direction == "None")
            {
                directions.clear();
                String direction2 = "None";
                if (!illumWorld.getObjectsAt(this.x,this.y,MazeMarker.class).isEmpty())
                {
                    illumWorld.removeObject((Actor)illumWorld.getObjectsAt(this.x,this.y,MazeMarker.class).get(0));
                }
                if (!illumWorld.getObjectsAt(this.x,this.y-40,MazeMarker.class).isEmpty() && illumWorld.getObjectsAt(this.x,this.y-20,CubeInvisible.class).isEmpty())
                {
                    directions.add("North");
                }
                if (!illumWorld.getObjectsAt(this.x+40,this.y,MazeMarker.class).isEmpty() && illumWorld.getObjectsAt(this.x+20,this.y,CubeInvisible.class).isEmpty())
                {
                    directions.add("East");
                }
                if (!illumWorld.getObjectsAt(this.x,this.y+40,MazeMarker.class).isEmpty() && illumWorld.getObjectsAt(this.x,this.y+20,CubeInvisible.class).isEmpty())
                {
                    directions.add("South");
                }
                if (!illumWorld.getObjectsAt(this.x-40,this.y,MazeMarker.class).isEmpty() && illumWorld.getObjectsAt(this.x-20,this.y,CubeInvisible.class).isEmpty())
                {
                    directions.add("West");
                }
                if (!directions.isEmpty())
                {
                    direction2 = randChoice(directions);
                    if (direction2 == "North")
                    {
                        this.y -= 40;
                    }
                    if (direction2 == "East")
                    {
                        this.x += 40;
                    }
                    if (direction2 == "South")
                    {
                        this.y += 40;
                    }
                    if (direction2 == "West")
                    {
                        this.x -= 40;
                    }
                }
                if (direction2 == "None")
                {
                    this.generating = false;
                    break;
                }
            }
        }
        removeCubeInvisible(430,230);
        removeCubeInvisible(450,230);
        removeCubeInvisible(470,230);
        removeCubeInvisible(490,230);
        removeCubeInvisible(510,230);
        removeCubeInvisible(530,230);
        removeCubeInvisible(550,230);
        removeCubeInvisible(570,230);
        
        removeCubeInvisible(430,250);
        removeCubeInvisible(450,250);//
        removeCubeInvisible(470,250);
        removeCubeInvisible(490,250);
        removeCubeInvisible(510,250);
        removeCubeInvisible(530,250);
        removeCubeInvisible(550,250);//
        removeCubeInvisible(570,250);
        
        removeCubeInvisible(430,270);
        removeCubeInvisible(450,270);
        removeCubeInvisible(470,270);
        removeCubeInvisible(490,270);
        removeCubeInvisible(510,270);
        removeCubeInvisible(530,270);
        removeCubeInvisible(550,270);
        removeCubeInvisible(570,270);
        
        removeCubeInvisible(430,290);
        removeCubeInvisible(450,290);
        removeCubeInvisible(470,290);
        removeCubeInvisible(490,290);//
        removeCubeInvisible(510,290);//
        removeCubeInvisible(530,290);
        removeCubeInvisible(550,290);
        removeCubeInvisible(570,290);
        
        removeCubeInvisible(430,310);
        removeCubeInvisible(450,310);
        removeCubeInvisible(470,310);
        removeCubeInvisible(490,310);//
        removeCubeInvisible(510,310);//
        removeCubeInvisible(530,310);
        removeCubeInvisible(550,310);
        removeCubeInvisible(570,310);
        
        removeCubeInvisible(430,330);
        removeCubeInvisible(450,330);
        removeCubeInvisible(470,330);
        removeCubeInvisible(490,330);
        removeCubeInvisible(510,330);
        removeCubeInvisible(530,330);
        removeCubeInvisible(550,330);
        removeCubeInvisible(570,330);
        
        removeCubeInvisible(430,350);
        removeCubeInvisible(450,350);//
        removeCubeInvisible(470,350);
        removeCubeInvisible(490,350);
        removeCubeInvisible(510,350);
        removeCubeInvisible(530,350);
        removeCubeInvisible(550,350);//
        removeCubeInvisible(570,350);
        
        removeCubeInvisible(430,370);
        removeCubeInvisible(450,370);
        removeCubeInvisible(470,370);
        removeCubeInvisible(490,370);
        removeCubeInvisible(510,370);
        removeCubeInvisible(530,370);
        removeCubeInvisible(550,370);
        removeCubeInvisible(570,370);
        
        addCubeInvisible(446,254);
        addCubeInvisible(546,254);
        addCubeInvisible(446,354);
        addCubeInvisible(546,354);
        illumWorld.removeObject(this);
    }
    public void removeCubeInvisible(int x, int y)
    {
        IllumWorld illumWorld = (IllumWorld) getWorld();
        if (!illumWorld.getObjectsAt(x,y,CubeInvisible.class).isEmpty())
        {
            illumWorld.removeObject((Actor)illumWorld.getObjectsAt(x,y,CubeInvisible.class).get(0));
        }
    }
    public void addCubeInvisible(int x, int y)
    {
        IllumWorld illumWorld = (IllumWorld) getWorld();
        CubeInvisible cubeInvisible = new CubeInvisible();
        illumWorld.addObject(cubeInvisible,x,y);
        cubeInvisible.setLines();
    }
    public int randInt(int min, int max)
    {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    public String randChoice(ArrayList<String> directions) {
        return directions.get(new Random().nextInt(directions.size()));
    }
}
