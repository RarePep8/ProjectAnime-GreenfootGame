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
            if(scene == "preview" || scene == "unlockpreview"){
                world.exitPreview();
                world.addBottomHudIcons();
                world.setPaintOrder(BlackFade.class);
                world.setPaintOrder(UnlockedAlly.class);
                world.setPaintOrder(DynamicHudBar.class);
                world.setPaintOrder(OkButton.class);
                world.setPaintOrder(White.class);
            }
            world.removeObject(this);
        }
    }
}
