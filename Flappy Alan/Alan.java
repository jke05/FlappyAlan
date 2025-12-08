import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Alan extends Actor
{
    private Point2D position;
    private Vector2D velocity;
    private Vector2D acceleration;
    
    private static final double GRAVITY = 9.8 * 150;
    public static boolean dead;
    
    private boolean spacePressed = false;
    
    private GreenfootSound backgroundMusic = new GreenfootSound("music.mp3");
    public Alan(){
        position = null;
        velocity = new Vector2D(0.0, 0.0);
        acceleration = new Vector2D(0.0, GRAVITY);
    }
    
    public void act() {
        JungleWorld world = (JungleWorld)getWorld();
        if (world != null && !world.isStarted()){
             return;
        }

        World w = getWorld();
        backgroundMusic.playLoop();
        setLocation(getX(), (int) (getY() + velocity.getY()));
        updatePhysics();
        if (Greenfoot.isKeyDown("space") || Greenfoot.mouseClicked(null)) {
            if (!spacePressed) {
               setVelocity(new Vector2D(0, -400));
               spacePressed = true;
           }
        } else {
            spacePressed = false;
        }
        
        if(getY() <= 0 || getY() >= getWorld().getHeight() -1){
            Greenfoot.setWorld(new GameOverScreen());
            Greenfoot.playSound("death.mp3");
            backgroundMusic.stop();
        }
        
        Tree tree = (Tree) getOneIntersectingObject(Tree.class);
        if (tree != null && pixelPerfectCollision(tree)) {
            Greenfoot.setWorld(new GameOverScreen());
            backgroundMusic.stop();
        }
        
        Banana banana = (Banana) getOneIntersectingObject(Banana.class);
        if(banana != null){
            ((JungleWorld)w).increaseScore(3);
            getWorld().removeObject(banana);
            Greenfoot.playSound("powerup.mp3");
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
    
    public boolean pixelPerfectCollision(Actor other) {
        GreenfootImage img1 = getImage();
        GreenfootImage img2 = other.getImage();

        int w1 = img1.getWidth();
        int h1 = img1.getHeight();
        int w2 = img2.getWidth();
        int h2 = img2.getHeight();

        int dx = other.getX() - getX() + (w1 / 2 - w2 / 2);
        int dy = other.getY() - getY() + (h1 / 2 - h2 / 2);

        for (int x2 = 0; x2 < w2; x2++) {
            for (int y2 = 0; y2 < h2; y2++) {
                int x1 = x2 + dx;
                int y1 = y2 + dy;

                if (x1 >= 0 && x1 < w1 && y1 >= 0 && y1 < h1) {
                    if (img1.getColorAt(x1, y1).getAlpha() > 0 &&
                        img2.getColorAt(x2, y2).getAlpha() > 0) {
                        return true;
                    }
                 }
            }
        }
        return false;
    }

}