import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class YouWin extends Animal
{
    GreenfootImage image = getImage();
    public int timer = 0;
    public int transparency = 0;
    public YouWin()
    {
        image.setTransparency(0);
        setImage(image);
    }
    public void act() 
    {
        fade();
    }
    public void fade()
    {
        if (timer > 80 && timer <= 90)
        {
            transparency += 26;
        }
        if (timer >= 110 && timer <= 120)
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
