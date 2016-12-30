import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RecruitHud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RecruitHud extends Actor
{
    /**
     * Act - do whatever the RecruitHud wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    public void checkIsRecruitScreen(){
        MyWorld world = (MyWorld)getWorld();
        if(world.currentScreen != "recruit"){
            world.removeObject(this);
        }
    }
}
