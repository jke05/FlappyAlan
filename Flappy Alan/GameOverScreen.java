import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends World
{

    /**
     * Constructor for objects of class GameOverScreen.
     * 
     */
    public GameOverScreen()
    {    
        super(866, 600, 1);
        playDeath();
        addObject(new AlanOver(), 433, 365);
        addObject(new GameOverTitle(), 433, 100);
        addObject(new PlayAgain(), 433, 430);
        addObject(new YesButton(), 256, 510);
        addObject(new NoButton(), 609, 510);
        
        
        
    }
    
    public void playDeath(){
        Greenfoot.playSound("death.mp3");
    }
}