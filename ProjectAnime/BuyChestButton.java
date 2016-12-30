import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuyChestButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuyChestButton extends RecruitHud
{
    boolean clickedBefore = false;
    /**
     * Act - do whatever the BuyChestButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.checkIsRecruitScreen();
        checkClicked();
    }

    public void checkClicked(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null){
            MyWorld world = (MyWorld)getWorld();
            if(Greenfoot.mousePressed(this) && mouse.getButton() == 1 && world.getPlatinumCount()>=10){
                world.spendPlatinum(10);
                world.recruitAlly();
            }
        }
    }

    public void resetClickedBefore(){
        if(clickedBefore){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(mouse == null){
                clickedBefore = false;
            }
            else if(mouse.getButton() != 1){
                clickedBefore = false;
            }
        }
    }
}
