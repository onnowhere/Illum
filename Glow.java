import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Glow extends Animal
{
    public static GreenfootImage image = new GreenfootImage("Glow2.png");
    public Glow()
    {
        image.scale(1600,1600);
        setImage(image);
    }
    public void act() 
    {
        IllumWorld illumWorld = (IllumWorld) getWorld();
        Player player = illumWorld.getPlayer();
        setpos(player.x,player.y);
    }
    public void setpos(int x, int y)
    {
        setLocation(x,y);
    }
}
