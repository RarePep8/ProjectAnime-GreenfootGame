import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BottomHudIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BottomHudIcon extends Actor
{
    String fileName = "";
    public BottomHudIcon(String type){
        fileName = type + "icon.png";
        updateImage();
    }
    /**
     * Act - do whatever the BottomHudIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
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
