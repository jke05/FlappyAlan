import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PlayButton extends Actor
{
    private GreenfootSound backgroundMusic = new GreenfootSound("music.mp3");
    
    public void act(){
        backgroundMusic.playLoop();
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new JungleWorld());
            Greenfoot.playSound("gui.mp3");
            backgroundMusic.stop();
        }
    }
}