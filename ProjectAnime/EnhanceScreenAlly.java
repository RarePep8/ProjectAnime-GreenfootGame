import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnhanceScreenAlly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnhanceScreenAlly extends EnhanceHud
{
    Ally referenceAlly;
    public EnhanceScreenAlly(Ally ally){
        this.referenceAlly = ally;
        String fileName = ally.getName().concat("-unlock.png");
        setImage(fileName);
        
    }
    /**
     * Act - do whatever the EnhanceScreenAlly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.checkDeletion();
    }
}
