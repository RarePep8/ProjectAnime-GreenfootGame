import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BottomHudIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BottomHudIcon extends Hud
{
    String fileName = "";
    public BottomHudIcon(String fileName){
        this.fileName = fileName;
        updateImage();
    }

    /**
     * Act - do whatever the BottomHudIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkClicked();
    }
    public void checkClicked(){
        if(isClicked()){
            MyWorld world = (MyWorld)getWorld();
            if(fileName == "homeicon.png"){
                world.toHomeScreen();
            }
            else if(fileName == "recruiticon.png"){
                world.toRecruitScreen();
            }
            else if(fileName == "alliesicon.png"){
                world.toAlliesScreen();
            }
            else if(fileName == "battleicon.png"){
                world.toBattleScreen();
            }
            else if(fileName == "powerupicon.png"){
                world.toPowerUpScreen();
            }
        }
    }

    public boolean isClicked(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null){

            if(mouse.getActor() == this && mouse.getButton() == 1){
                return true;
            }

        }
        return false;
    }

    public void updateImage(){
        setImage(fileName);
    }

    public void checkHover(){

    }
}
