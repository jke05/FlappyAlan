import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Spacefly extends Actor
{
    /**
     * Act - do whatever the Spacefly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("space")){
            getWorld().removeObject(this);
        }
    }
}
