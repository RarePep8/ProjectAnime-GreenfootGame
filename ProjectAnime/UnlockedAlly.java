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
    /**
     * Act - do whatever the Ally wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
    }
    public void move(){
        if(delay>0){
            delay--;
        }
        else if(delay ==0){
            if(getX()>80){
                setLocation(getX()-2,getY()-2);
            }
            else if(!displayingData){
                displayingData = true;
                getWorld().addObject(new Text("Top Kek",20,"white"),80,80);
            }
        }
    }
}
