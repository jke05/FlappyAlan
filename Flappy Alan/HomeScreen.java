import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HomeScreen extends World
{

    public HomeScreen()
    {    
        super(866, 600, 1);
        playGuiSound();
        addObject(new AlanLogo(), 433, 385);
        addObject(new GameTitle(), 433, 130);
        addObject(new PlayButton(), 433, 450);
    }
    
    public void act(){
        
    }
    
    public void playGuiSound(){
        Greenfoot.playSound("gui.mp3");
    }

}
