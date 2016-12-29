import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ResetImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResetImage extends Animal
{
    GreenfootImage image = getImage();
    public int timer = 0;
    public int transparency = 0;
    public ResetImage()
    {
        image.setTransparency(0);
        setImage(image);
    }
    /**
     * Act - do whatever the ResetImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fade();
        // Add your action code here.
    }
    public void fade()
    {
        if (timer > 0 && timer <= 10)
        {
            transparency += 26;
        }
        if (timer >= 10 && timer <= 20)
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
        if (timer == 20)
        {
            timer = 0;
        }
    }
}
