import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PremiumChest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PremiumChest extends Actor
{
    int frame = 100;
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
        if(size==0){
            shake();
            time();
        }
        if(size<30){
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
            int rotation = frame/10;
            if(frame%20==0){
                setRotation(getRotation()+rotation+8);

            }
            else{
                setRotation(getRotation()-rotation);
            }

        }
        frame-=5;

    }

    public void time(){
        timer--;
        if(timer<=0){
            timer = 100;
            frame = 100;
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
