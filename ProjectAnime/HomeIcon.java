import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HomeIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HomeIcon extends BottomHudIcon
{
    public HomeIcon(){
        super("home");
    }
    /**
     * Act - do whatever the HomeIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkClicked();
    }    
    public void checkClicked(){
        if(super.isClicked()){
            MyWorld world = (MyWorld)getWorld();
            world.toHomeScreen();
        }
    }
}
