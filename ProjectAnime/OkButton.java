import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OkButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OkButton extends Actor
{
    String scene;
    public OkButton(String scene){
        this.scene = scene;
    }
    /**
     * Act - do whatever the OkButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkClicked();
    }
    public void checkClicked(){
        if(Greenfoot.mousePressed(this)){
            MyWorld world = (MyWorld)getWorld();
            if(scene == "unlockpreview"){
                world.exitUnlock();
            }
            world.removeObject(this);
        }
    }
}
