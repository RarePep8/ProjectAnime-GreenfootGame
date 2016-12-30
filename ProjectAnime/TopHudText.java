import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TopHudText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TopHudText extends Text
{
    public TopHudText(String text){
        super(text,24,"white");
    }
    /**
     * Act - do whatever the TopHudText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    public void updateText(String text){
        super.updateText(text,24,"white");
    }
}
