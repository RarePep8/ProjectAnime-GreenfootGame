import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class DynamicHudBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DynamicHudBar extends Hud
{
    boolean isDynamic = false;
    String type;
    int maxLength;
    int currentLength = 0;
    int maxAdditionalLength;
    int additionalLength = 0;
    boolean init = true;
    GreenfootImage image;
    boolean toIncrease = true;
    boolean toDecrease = false;
    public DynamicHudBar(boolean isDynamic, String type){
        this.isDynamic = isDynamic;
        this.type = type;
    }

    /**
     * Act - do whatever the DynamicHudBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(init){
            init = false;
            fillUnlockedAllyBar();
            drawUnlockedAllyBar();
        }
        if(currentLength != maxLength){
            if(currentLength<=maxLength){
                this.image = drawUnlockedAllyBar();
                setImage(this.image);
                currentLength+=5;
                if(currentLength>maxLength){
                    currentLength = maxLength;
                }
            }

        }
        else if(additionalLength != maxAdditionalLength){
            if(additionalLength<=maxAdditionalLength){
                this.image = drawUnlockedAllyBar();
                setImage(this.image);
                additionalLength+=1;
                if(additionalLength>maxAdditionalLength){
                    additionalLength = maxAdditionalLength;
                }
            }
            else if(additionalLength>=maxAdditionalLength){

            }

        }
        checkScene();
    }    
    public void test(){
        maxAdditionalLength += 50;
    }
    public void checkScene(){
        MyWorld world = (MyWorld)getWorld();
        if(!isDynamic && !world.isPreview){
            world.removeObject(this);
        }
    }

    public void fillUnlockedAllyBar(){
        MyWorld world = (MyWorld)getWorld();
        float decimalPercent = world.getDecimalPercentOfStat(type);
        float widthOfBar = 220;
        float width = widthOfBar*decimalPercent;
        maxLength = (int)width;
    }

    public GreenfootImage drawUnlockedAllyBar(){

        GreenfootImage image = new GreenfootImage(250,250);

        int[] xs = { 25, 250, 225, 0 };
        int[] ys = { 50, 50, 65, 65 };

        image.setColor(Color.gray);
        image.fillPolygon(xs, ys, 4);

        image.setColor(Color.black);
        image.drawPolygon(xs,ys,4);

        int[] xs2 = {26,245,224,5};
        int[] ys2 = {52,52,64,64};

        image.setColor(Color.white);
        image.fillPolygon(xs2,ys2,4);

        int topX = 26+currentLength;
        int bottomX = 5+currentLength;
        int[] xs3 = {26,topX,bottomX,5};
        int[] ys3 = {52,52,64,64};      

        if(type == "Attack")
            image.setColor(Color.red);
        else if(type == "Defense"){
            image.setColor(Color.blue);
        }
        else if(type == "Speed"){
            image.setColor(Color.green);
        }
        image.fillPolygon(xs3,ys3,4);

        image.setColor(Color.gray);
        int[] xs4 = {topX,topX+additionalLength,bottomX+additionalLength,bottomX};
        int[] ys4 = {52,52,64,64};
        image.fillPolygon(xs4,ys4,4);

        image.setColor(Color.white);
        image.setFont(image.getFont().deriveFont(11f));
        image.drawString(type,30,50);

        return image;
    }
}
