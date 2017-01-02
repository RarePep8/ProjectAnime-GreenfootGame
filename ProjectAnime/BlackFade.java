import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlackBG here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackFade extends Actor
{
    boolean disappear = false;
    int transparency = 0;
    String scene;
    public BlackFade(String scene){
        this.scene = scene;
        getImage().setTransparency(0);
    }

    /**
     * Act - do whatever the BlackBG wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkScene();
        if(disappear){
            decreaseTransparency();
        }
        else{
            increaseTransparency();
        }

    }

    public void increaseTransparency(){
        if(transparency<255){
            transparency+=5;
            getImage().setTransparency(transparency);
        }
        if(transparency==250){
            MyWorld world = (MyWorld)getWorld();
            if(scene =="unlockpreview"){
                world.removeHudObjects();
                world.addObject(new PremiumChest(),160,270);
            }
            else if(scene == "preview"){
                world.removeHudObjects();
                world.preview();
            }
        }
    }

    public void decreaseTransparency(){
        if(transparency>0){
            getImage().setTransparency(transparency);
            transparency-=5;
        }
        else if(transparency==0){
            getWorld().removeObject(this);
        }
    }

    public void checkScene(){
        MyWorld world = (MyWorld)getWorld();
        if((scene == "unlockpreview" || scene == "preview") && !world.isPreview){
            disappear = true;
        }
    }
}
