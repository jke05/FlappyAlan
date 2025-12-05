import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Banana extends Actor{
    private int bananaCounter = 0;
    private double speed = 3;
    
    public Banana(){
        GreenfootImage image = getImage();
        image.scale(121, 100);
    }
    
    public void act(){
        if(Alan.isAlive()){
            bananaCounter++;
            if(bananaCounter == 250){
                speed += 0.3;
                bananaCounter = 0;
            }
            setLocation((int)(getX() - Tree.speed), getY());
        }
        
        if(getX() <= 1){
            getWorld().removeObject(this);
            }
    }
}