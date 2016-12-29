import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
public class Player extends Animal
{
    public int x;
    public int y;
    public int xspawn;
    public int yspawn;
    public boolean reset;
    public int resettimer;
    public char checkpoint;
    public Player()
    {
        GreenfootImage image = getImage();  
        image.scale(30, 30);
        setImage(image);
        reset = false;
        resettimer = 0;
        this.checkpoint = '0';
    }
    public void act() 
    {
        /*
        if (Greenfoot.isKeyDown("b"))
        {
             Greenfoot.setWorld(new IllumWorld());
        }
        */
        reset();
        checkfinish();
        checkpoint();
        if (reset == false)
        {
            moveUp();
            moveDown();
            moveLeft();
            moveRight();
        }
        this.x = getX();
        this.y = getY();
        if (Greenfoot.isKeyDown("1"))
        {
            Greenfoot.setWorld(new IllumWorld(1));
        }
        if (Greenfoot.isKeyDown("2"))
        {
            Greenfoot.setWorld(new IllumWorld(2));
        }
        if (Greenfoot.isKeyDown("3"))
        {
            Greenfoot.setWorld(new IllumWorld(-1));
        }
        if (Greenfoot.isKeyDown("4"))
        {
            Greenfoot.setWorld(new IllumWorld(0));
        }
        /*
        if (!getWorld().getObjects(Cube3d.class).isEmpty())
        {
            getWorld().removeObject(getWorld().getObjects(Cube3d.class).get(0));
        }
        */
    }
    public void reset()
    {
        if (reset == true)
        {
            if (resettimer > 1)
            {
                IllumWorld illumWorld = (IllumWorld) getWorld();
                illumWorld.getLight().setBlack = true;
                resettimer --;
            }
            if (resettimer == 1)
            {
                resettimer = 0;
                IllumWorld illumWorld = (IllumWorld) getWorld();
                illumWorld.getLight().setBlack = false;
                MOVE_RIGHT = 0;
                MOVE_LEFT = 0;
                MOVE_UP = 0;
                MOVE_DOWN = 0;
                setLocation(this.xspawn,this.yspawn);
                illumWorld.getLight().setLocation(this.xspawn,this.yspawn);
                checkpointreset();
                reset = false;
            }
        }
    }
    public void checkfinish()
    {
        if (!getWorld().getObjectsAt(this.x,this.y,Finish.class).isEmpty())
        {
            IllumWorld illumWorld = (IllumWorld) getWorld();
            FinishImage finishImage = illumWorld.getFinishImage();
            YouWin youWin = illumWorld.getYouWin();
            SpaceCube spaceCube = illumWorld.getSpaceCube();
            ArrayList<CubeDoor> cubeDoorList = (ArrayList<CubeDoor>)illumWorld.getObjects(CubeDoor.class);
            ArrayList<CubeDoor3d> cubeDoor3dList = (ArrayList<CubeDoor3d>)illumWorld.getObjects(CubeDoor3d.class);
            ArrayList<Enemy> enemies = (ArrayList<Enemy>)illumWorld.getObjects(Enemy.class);
            ArrayList<Checkpoint> checkpointList = (ArrayList<Checkpoint>)illumWorld.getObjects(Checkpoint.class);
            if (this.resettimer == 0)
            {
                finishImage.timer = 1;
                youWin.timer = 1;
                spaceCube.timer = 1;
                for (CubeDoor cubeDoor : cubeDoorList)
                {
                    cubeDoor.timer = 0;
                }
                for (CubeDoor3d cubeDoor3d : cubeDoor3dList)
                {
                    cubeDoor3d.timer = 0;
                }
                for (Enemy enemy : enemies)
                {
                    enemy.reset();
                }
                for (Checkpoint checkpoint : checkpointList)
                {
                    checkpoint.activated = -1;
                }
                setLocation(110,300);
                this.xspawn = 110;
                this.yspawn = 300;
                this.checkpoint = '0';
                this.resettimer = 200;
            }
            this.reset = true;
        }
    }
    public void checkpoint()
    {
        if (!getWorld().getObjectsAt(this.x,this.y,Checkpoint.class).isEmpty())
        {
            IllumWorld illumWorld = (IllumWorld) getWorld();
            Checkpoint checkpoint = (Checkpoint)illumWorld.getObjectsAt(this.x,this.y,Checkpoint.class).get(0);
            if (checkpoint.activated == 0)
            {
                this.xspawn = checkpoint.x;
                this.yspawn = checkpoint.y;
                CheckpointFlag checkpointFlag = (CheckpointFlag)illumWorld.getObjects(CheckpointFlag.class).get(0);
                if (checkpointFlag.timer <= 2)
                {
                    checkpointFlag.timer = 1;
                }
                this.checkpoint = checkpoint.id;
                checkpoint.activated = 1;
            }
        }
    }
    public void checkpointreset()
    {
        IllumWorld illumWorld = (IllumWorld) getWorld();
        ArrayList<CubeDoor> cubeDoorList = (ArrayList<CubeDoor>)illumWorld.getObjects(CubeDoor.class);
        ArrayList<CubeDoor3d> cubeDoor3dList = (ArrayList<CubeDoor3d>)illumWorld.getObjects(CubeDoor3d.class);
        ArrayList<Enemy> enemies = (ArrayList<Enemy>)illumWorld.getObjects(Enemy.class);
        for (Enemy enemy : enemies)
        {
            enemy.reset();
        }
        for (CubeDoor cubeDoor : cubeDoorList)
        {
            if (this.checkpoint == '0' && 
            (cubeDoor.id == '2' && cubeDoor.color == 'g')
            )
            {
                cubeDoor.timer = 0;
            }
            if (this.checkpoint == '1' && (
            (cubeDoor.id == '1' && cubeDoor.color == 'g') ||
            (cubeDoor.id == '1' && cubeDoor.color == 'r') ||
            (cubeDoor.id == '3' && cubeDoor.color == 'g')
            ))
            {
                cubeDoor.timer = 0;
            }
            if (this.checkpoint == '2' && (
            (cubeDoor.id == '3' && cubeDoor.color == 'g')
            ))
            {
                cubeDoor.timer = 0;
            }
            if (this.checkpoint == '3' && (
            (cubeDoor.id == '2' && cubeDoor.color == 'r')
            ))
            {
                cubeDoor.timer = 0;
            }
        }
        for (CubeDoor3d cubeDoor3d : cubeDoor3dList)
        {
            if (this.checkpoint == '0' && 
            (cubeDoor3d.id == '2' && cubeDoor3d.color == 'g')
            )
            {
                cubeDoor3d.timer = 0;
            }
            if (this.checkpoint == '1' && (
            (cubeDoor3d.id == '1' && cubeDoor3d.color == 'g') ||
            (cubeDoor3d.id == '1' && cubeDoor3d.color == 'r') ||
            (cubeDoor3d.id == '3' && cubeDoor3d.color == 'g')
            ))
            {
                cubeDoor3d.timer = 0;
            }
            if (this.checkpoint == '2' && (
            (cubeDoor3d.id == '3' && cubeDoor3d.color == 'g')
            ))
            {
                cubeDoor3d.timer = 0;
            }
            if (this.checkpoint == '3' && (
            (cubeDoor3d.id == '2' && cubeDoor3d.color == 'r')
            ))
            {
                cubeDoor3d.timer = 0;
            }
        }
    }
}
