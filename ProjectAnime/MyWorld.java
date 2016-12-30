import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int numPlatinum = 100;
    String currentScreen = "home";
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    

        super(320, 480, 1); 
        prepare();
    }
    public void spendPlatinum(int spent){
        numPlatinum -= spent;
    }
    public int getPlatinumCount(){
        return numPlatinum;
    }
    public void recruitAlly(){
        addObject(new BlackBG(),160,240);
    }
    public void toHomeScreen(){
        if(currentScreen!="home"){
            currentScreen = "home";
        }
    }
    public void toRecruitScreen(){
        if(currentScreen!="recruit"){
            currentScreen = "recruit";
            addObject(new PremiumChestWithKey(),160,270);
            addObject(new BuyChestButton(),160,370);
        }
    }

    private void prepare(){
        setBackground(new GreenfootImage("bg.jpg"));
        RightBlackRect rightblackrect = new RightBlackRect();
        addObject(rightblackrect,268,27);
        SmallPlatinum smallplatinum = new SmallPlatinum();
        addObject(smallplatinum,242,27);
        PlatinumCount pc = new PlatinumCount();
        addObject(pc,285,27);
        RecruitIcon recruiticon = new RecruitIcon();
        addObject(recruiticon,274,451);
        HomeIcon homeicon = new HomeIcon();
        addObject(homeicon,160,445);
    }
}
