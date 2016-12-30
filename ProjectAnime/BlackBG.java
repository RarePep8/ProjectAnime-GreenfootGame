import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlackBG here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackBG extends Actor
{
    int transparency = 0;
    public BlackBG(){
        getImage().setTransparency(0);
    }
    /**
     * Act - do whatever the BlackBG wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       increaseTransparency();
    }
    public void increaseTransparency(){
        if(transparency<=255){
            
            getImage().setTransparency(transparency);
            transparency+=5;
        }
        if(transparency==255){
            MyWorld world = (MyWorld)getWorld();
            world.addObject(new PremiumChest(),160,270);
        }
    }
}
