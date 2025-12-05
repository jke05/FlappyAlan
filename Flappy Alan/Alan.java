import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alan extends Actor
{
    private Point2D position;
    private Vector2D velocity;
    private Vector2D acceleration;
    
    private static final double GRAVITY = 9.8 * 150;
    public static boolean dead;
    
    private boolean spacePressed = false;
    
    public Alan(){
        position = null;
        velocity = new Vector2D(0.0, 0.0);
        acceleration = new Vector2D(0.0, GRAVITY);
    }
    
    public void act() {
        updatePhysics();
        if (Greenfoot.isKeyDown("space") || Greenfoot.mouseClicked(null)) {
            if (!spacePressed) {
            setVelocity(new Vector2D(0, -600));
            spacePressed = true;
           }
        } else {
            spacePressed = false;
         }
    }
    
    public void setVelocity(Vector2D newValue){
        velocity = newValue;
    }
    
    public void updatePhysics(){
        if(position == null){
            position = new Point2D(getX(), getY());
        }
        
        JungleWorld world = (JungleWorld) getWorld();
        double dt = world.getTimeStepDuration();
        
        Vector2D velocityVariation = Vector2D.multiply(acceleration, dt);
        velocity = Vector2D.add(velocity, velocityVariation);
        
        Vector2D positionVariation = Vector2D.multiply(velocity, dt);
        position.add(positionVariation);
        
        setLocation((int) position.getX(), (int) position.getY());
    }
    
    public static boolean isAlive(){
        return !dead;
    }
}
