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
    int delay = 50;
    GreenfootImage img = getImage();
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
        if(size<30){

            shake();
            time();

            checkClicked();
        }
        else if(delay>0){
            size+=10;
            updateSize();
            delay--;
        }
        else{
            MyWorld world = (MyWorld)getWorld();
            world.unlockAlly();
            getWorld().removeObject(this);
        }
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
        
        img.scale(defaultWidth+size,defaultHeight+size);
        setImage(img);
    }

    public void checkClicked(){
        if(Greenfoot.mousePressed(this)){
            size += 10;
            updateSize();
            if(size == 30){
                getWorld().addObject(new White(),160,240);
            }
        }
    }
}
