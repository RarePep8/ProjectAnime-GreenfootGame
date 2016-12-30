import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlatinumCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlatinumCount extends TopHudText
{
    int platinumCount = -1;
    String platinumCountStr = "";
    public PlatinumCount(){
        super("");
    }
    /**
     * Act - do whatever the PlatinumCount wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        updateCount();
    }
    public void updateCount(){
        MyWorld world = (MyWorld)getWorld();
        if(platinumCount != world.getPlatinumCount()){
            platinumCount = world.getPlatinumCount();
            platinumCountStr = Integer.toString(platinumCount);
            super.updateText(platinumCountStr);
        }
    }
}
