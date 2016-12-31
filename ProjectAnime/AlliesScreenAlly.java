import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AliesScreenAlly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AlliesScreenAlly extends AlliesHud
{
    int index;
    boolean init = true;
    public AlliesScreenAlly(int index){
        this.index = index;
        
    }

    /**
     * Act - do whatever the AliesScreenAlly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(init){
            init = false;
            updateImage();
        }
        super.checkIsAlliesScreen();
    }    
    public void updateImage(){
        MyWorld world = (MyWorld)getWorld();
        if(world.getNumOwnedAllies()-1>=index){
            String fileName = world.getAllyObjAtIndex(index).getName() + ".png";
            setImage(fileName);
        }
    }

}
