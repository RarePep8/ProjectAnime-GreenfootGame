import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnhanceHud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnhanceHud extends Hud
{
    /**
     * Act - do whatever the EnhanceHud wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    public void checkDeletion(){
        MyWorld world = (MyWorld)getWorld();
        if(world.currentScreen != "enhance"){
            world.removeObject(this);
        }
    }
}
