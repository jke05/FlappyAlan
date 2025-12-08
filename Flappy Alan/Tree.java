import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tree extends Actor{
    private int speedCounter = 0; //counts frames 
    public static double speed = 2.2; //starting speed 
    private static int treeCount = 0; 
    private static int nextBanana = Greenfoot.getRandomNumber(3) + 2;//number between 2 and 4
    private boolean scored = false;
    public void act(){
        JungleWorld world = (JungleWorld)getWorld();
        if (world != null && !world.isStarted()) return;
        
        World w = getWorld();
        Alan alan = (Alan) getWorld().getObjects(Alan.class).get(0);
        
        if(!scored && getX() < alan.getX()){
            ((JungleWorld)w).increaseScore(1);
            scored = true;
        }
        
        if (Alan.isAlive()){
            speedCounter++;
            if(speedCounter ==  230){
                speed += 0.1;
                speedCounter = 0;
            }
            setLocation((int)(getX() - speed), getY());
        }
        
        if(getX() <= 1){
            //Spawn tree and random height on the right side
            int treeX = getX() + (int)(900 + speed*300);
            int treeY = 150 + Greenfoot.getRandomNumber(275);
            setLocation(treeX, treeY);
            scored = false;
            treeCount++;
            
            //Spawn Banana in the same spot
            if(treeCount >= nextBanana){
                JungleWorld worldRef = (JungleWorld) getWorld();
                Banana banana = new Banana();
                world.addObject(banana, treeX, treeY);
                treeCount = 0;
                nextBanana = Greenfoot.getRandomNumber(3) + 2; //Picks number between 2 and 4
            }
        }
    }
}