import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ally here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UnlockedAlly extends Actor
{
    int delay = 75;
    boolean displayingData = false;
    Ally referenceAlly;
    String type;
    public UnlockedAlly(Ally ally, String type){
        referenceAlly = ally;
        this.type = type;
        String fileName = ally.getName().concat("-unlock.png");
        setImage(fileName);
    }

    /**
     * Act - do whatever the Ally wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        checkScene();
    }

    public void move(){
        if(type=="preview"){
            delay = 0;
        }
        if(delay>0){
            delay--;
        }
        else if(delay ==0){
            if(getX()>80){
                setLocation(getX()-2,getY()-2);
            }
            else if(!displayingData){
                displayingData = true;
                MyWorld world = (MyWorld)getWorld();
                if(type == "unlockpreview"){
                    world.unlockPreview(referenceAlly);
                }
            }
        }
    }

    public void checkScene(){
        MyWorld world = (MyWorld)getWorld();
        if((type == "unlockpreview" || type == "preview") && !world.isPreview){
            world.removeObject(this);
        }
    }
}
