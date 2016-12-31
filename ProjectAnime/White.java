import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class White here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class White extends Actor
{
    int transparency = 0;
    boolean spiked = false;
    public White(){
        getImage().setTransparency(0);
    }

    /**
     * Act - do whatever the White wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        spikeTransparency();
    }    

    public void spikeTransparency(){
        if(!spiked){
            if(transparency<=255){

                getImage().setTransparency(transparency);
                transparency+=5;

            }
            if(transparency==255){
                spiked = true;
            }
        }
        else{
            if(transparency>=0){
                getImage().setTransparency(transparency);
                transparency-=5;
            }
        }
    }
}
