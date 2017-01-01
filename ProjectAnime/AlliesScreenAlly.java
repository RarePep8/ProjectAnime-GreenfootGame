import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AliesScreenAlly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AlliesScreenAlly extends AlliesHud
{
    int index;
    boolean init = true;
    int size = 0;
    String fileName;
    GreenfootImage img;
    int defaultWidth;
    int defaultHeight;
    boolean hovering = false;
    public AlliesScreenAlly(int index){
        this.index = index;

    }

    /**
     * Act - do whatever the AliesScreenAlly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(init){
            init = false;
            updateImage();
        }
        checkHover();
        if(size>0 && !hovering){
            size--;
            scaleImage();
        }
        super.checkIsAlliesScreen();
    }    

    public void updateImage(){
        MyWorld world = (MyWorld)getWorld();
        if(world.getNumOwnedAllies()-1>=index){
            fileName = world.getAllyObjAtIndex(index).getName() + ".png";
            img = new GreenfootImage(fileName);
            defaultWidth = img.getWidth();
            defaultHeight = img.getHeight();
            setImage(fileName);
        }
    }

    public void checkHover(){
        
        if(Greenfoot.mouseMoved(null)){
            if(hovering != Greenfoot.mouseMoved(this)){
                hovering = !hovering;
            }
            
        }
        if(hovering){
                if(size<20){
                    size +=5;
                    scaleImage();
                }
            }
    }

    public void scaleImage(){
        if(fileName!=null){
            img = new GreenfootImage(fileName);
            img.scale(defaultWidth+size,defaultHeight+size);
            setImage(img);
        }
    }

}
