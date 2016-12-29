import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FinishImage extends Animal
{
    GreenfootImage image = getImage();
    public int timer = 0;
    public int transparency = 0;
    public FinishImage()
    {
        image.setTransparency(0);
        image.scale(1000,600);
        setImage(image);
    }
    public void act() 
    {
        fade();
    }
    public void fade()
    {
        if (timer > 0 && timer <= 10)
        {
            transparency += 26;
        }
        if (timer >= 190 && timer <= 200)
        {
            transparency -= 26;
        }
        if (timer > 0)
        {
            int transparency2 = transparency;
            if (transparency2 > 254)
            {
                transparency2 = 254;
            }
            if (transparency2 < 0)
            {
                transparency2 = 0;
            }
            image.setTransparency(transparency2);
            setImage(image);
            timer++;
        }
        if (timer == 200)
        {
            timer = 0;
        }
    }
}
