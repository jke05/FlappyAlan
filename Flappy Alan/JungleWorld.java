import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class JungleWorld extends World{
    private int score = 0;
    
    private long lastFrameTimeMS;
    private double timeStepDuration;
    
    private boolean paused = false;
    private boolean gameStarted = false;
    private Spacefly spacefly;
    private boolean escReleased;
    
    public JungleWorld()
    {    
        super(866, 600, 1); 
        playGuiSound();
        spacefly = new Spacefly();
        addObject(spacefly, 433, 300);
        addObject(new Alan(), 203, 252);
        addObject(new Tree(), 400, 300);
        addObject(new Tree(), 800, 250);     
        

        lastFrameTimeMS = System.currentTimeMillis();
        timeStepDuration = 1.0 / 60;
        
    }
    
    public void playGuiSound(){
        Greenfoot.playSound("gui.mp3");
    }

    public void started(){
        lastFrameTimeMS = System.currentTimeMillis();
    }

    public boolean isStarted(){
        if(Greenfoot.isKeyDown("space")){
            gameStarted = true;
            lastFrameTimeMS = System.currentTimeMillis();
            }
        return gameStarted;
    }
    
    public void act(){
        showText("Score: " + score, 433, 150);
        timeStepDuration = (System.currentTimeMillis() - lastFrameTimeMS) / 1000.0;
        lastFrameTimeMS = System.currentTimeMillis();
    }
    
    public void increaseScore(int amount){
        score += amount;
    }

    public double getTimeStepDuration(){
        return timeStepDuration;
    }
}