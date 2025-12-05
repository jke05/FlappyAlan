import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class JungleWorld extends World{
    private int score = 0;
    
    private long lastFrameTimeMS;
    private double timeStepDuration;

    public JungleWorld()
    {    
        super(866, 600, 1); 
        addObject(new Alan(), 203, 252);
        addObject(new Trees(), 400, 300);
        addObject(new Trees(), 800, 250);        

        lastFrameTimeMS = System.currentTimeMillis();
        timeStepDuration = 1.0 / 60;
        
    }
    
    public void started(){
        lastFrameTimeMS = System.currentTimeMillis();
    }
    
    public void act(){
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

