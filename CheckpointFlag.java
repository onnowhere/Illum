import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CheckpointFlag extends Animal
{
    GreenfootImage image = new GreenfootImage("CheckpointFlag.png");
    public int timer = 0;
    public int scale = 0;
    public int transparency = 0;
    public CheckpointFlag()
    {
        image.setTransparency(0);
        image.scale(1,1);
        setImage(image);
    }
    public void act() 
    {
        animate();
    }
    public void animate()
    {
        if (timer == 2)
        {
            image.setTransparency(200);
        }
        if (timer > 2 && timer <= 4)
        {
            scale+=32;
            image = new GreenfootImage("CheckpointFlag.png");
            image.setTransparency(200);
            image.scale(scale,scale);
        }
        if (timer >= 10 && timer <= 12)
        {
            scale-=32;
            if (scale <= 0)
            {
                scale = 1;
            }
            image = new GreenfootImage("CheckpointFlag.png");
            image.setTransparency(200);
            image.scale(scale,scale);
        }
        if (timer > 0)
        {
            setImage(image);
            timer++;
        }
        if (timer == 12)
        {
            image.setTransparency(0);
            image.scale(1,1);
            setImage(image);
            timer = 0;
        }
    }
}
