import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    public Text(String text, int size, String color){
        Color textColor = Color.white;
        if(color == "white"){
            textColor = Color.white;
        }
        GreenfootImage img = new GreenfootImage(text, size, textColor, new Color(0,0,0,0));
        setImage(img);
    }
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    public void updateText(String text, int size, String color){
       Color textColor = Color.white;
        if(color == "white"){
            textColor = Color.white;
        }
        GreenfootImage img = new GreenfootImage(text, size, textColor, new Color(0,0,0,0));
        setImage(img); 
    }
}
