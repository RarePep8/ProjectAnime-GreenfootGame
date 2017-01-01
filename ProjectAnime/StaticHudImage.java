import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class StaticHudImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StaticHudImage extends Hud
{
    public StaticHudImage(String fileName){
        setImage(fileName);
    }

    /**
     * Act - do whatever the StaticHudImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }

    public void test(){
        GreenfootImage image = new GreenfootImage(200,200);
        image.drawLine(25,0,150,0);
        image.drawLine(0,15,125,15);
        image.drawLine(0,15,25,0);
        image.drawLine(150,0,125,15);
        setImage(image);
    }

    
}
