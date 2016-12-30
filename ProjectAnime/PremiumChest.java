import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PremiumChest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PremiumChest extends Actor
{
    int frame = 20;
    int timer = 100;
    int size = 0;
    int defaultWidth;
    int defaultHeight;
    public PremiumChest(){
        defaultWidth = getImage().getWidth();
        defaultHeight = getImage().getHeight();
    }

    /**
     * Act - do whatever the PremiumChest wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {


        shake();
        time();

        checkClicked();
    }

    public void shake(){
        if(frame>0){
            if(frame%2==0){
                setRotation(getRotation()+frame);

            }
            else{
                setRotation(getRotation()-frame);
            }

        }
        frame--;
        if(frame==0){
            setRotation(getRotation()-10);
        }
    }

    public void time(){
        timer--;
        if(timer<=0){
            timer = 150;
            frame = 20;
        }
    }

    public void updateSize(){
        GreenfootImage img = getImage();
        img.scale(defaultWidth+size,defaultHeight+size);
        setImage(img);
    }

    public void checkClicked(){
        if(Greenfoot.mouseClicked(this)){
            size += 10;
            updateSize();
        }
    }
}
