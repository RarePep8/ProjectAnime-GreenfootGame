import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int unlockPreviewFrame = 100;
    private int numPlatinum = 696;
    boolean isPreview = false;
    boolean isUnlockPreview = false;
    String currentScreen = "home";
    List<Ally> allyDatabase = new ArrayList<Ally>();
    List<Ally> ownedAllies = new ArrayList<Ally>();
    Ally currentPreviewAlly;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    

        super(320, 480, 1); 
        prepare();
    }
    public void act(){
        if(isUnlockPreview){
            unlockPreview(currentPreviewAlly);
        }
    }
    public void unlockAlly(){
        int randomIndex = Greenfoot.getRandomNumber(allyDatabase.size());
        Ally wonAlly = allyDatabase.get(randomIndex);
        addObject(new UnlockedAlly(wonAlly,"unlockpreview"),160,240);
        ownedAllies.add(wonAlly);
    }
    public void changeCurrentPreviewAlly(Ally ally){
        currentPreviewAlly = ally;
    }
    public void enterPreview(boolean isUnlockPreview){
        isPreview = true;
        if(!isUnlockPreview){
            addObject(new BlackFade("preview"),160,240);
        }
    }
    public void exitPreview(){
        isPreview = false;
    }
    public void unlockPreview(Ally ally){
        currentPreviewAlly = ally;
        if(unlockPreviewFrame == 100){
            isUnlockPreview = true;
        }
        else if(unlockPreviewFrame == 75){
            addObject(new DynamicHudBar(false, "Attack"),160,350);
        }
        else if(unlockPreviewFrame == 50){
            addObject(new DynamicHudBar(false, "Defense"),160,400);
        }
        else if(unlockPreviewFrame == 25){
            addObject(new DynamicHudBar(false, "Speed"),160,450);
        }
        else if(unlockPreviewFrame == 0){
            unlockPreviewFrame = 101;
            isUnlockPreview = false;
            addObject(new OkButton("unlockpreview"),160,430);
        }
        unlockPreviewFrame--;
        
        
    }
    public void preview(){
        addObject(new UnlockedAlly(currentPreviewAlly,"preview"),80,160);
        addObject(new DynamicHudBar(false, "Attack"),160,350);
        addObject(new DynamicHudBar(false, "Defense"),160,400);
        addObject(new DynamicHudBar(false, "Speed"),160,450);
        addObject(new OkButton("preview"),160,430);
    }
    public int getNumOwnedAllies(){
        return ownedAllies.size();
    }
    public Ally getAllyObjAtIndex(int index){
        return ownedAllies.get(index);
    }
    public void spendPlatinum(int spent){
        numPlatinum -= spent;
    }

    public int getPlatinumCount(){
        return numPlatinum;
    }

    public void recruitAlly(){
        addObject(new BlackFade("unlockpreview"),160,240);
        isPreview = true;
    }
    public float getDecimalPercentOfStat(String type){
        int max = 1000;
        int current=0;
        
        if(type == "Attack"){
            current = currentPreviewAlly.getAttack();
        }
        else if(type == "Defense"){
            current = currentPreviewAlly.getDefense();
        }
        else if(type == "Speed"){
            current = currentPreviewAlly.getSpeed();
        }
        float decimalPercent = (float)current/max;
        return decimalPercent;
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

    public void toAlliesScreen(){
        if(currentScreen!="allies"){
            currentScreen = "allies";
            addObject(new AlliesScreenAlly(0),60,160);
            addObject(new AlliesScreenAlly(1),160,160);
            addObject(new AlliesScreenAlly(2),260,160);
            addObject(new AlliesScreenAlly(3),60,260);
            addObject(new AlliesScreenAlly(4),160,260);
            addObject(new AlliesScreenAlly(5),260,260);
            addObject(new AlliesScreenAlly(6),60,360);
            addObject(new AlliesScreenAlly(7),160,360);
            addObject(new AlliesScreenAlly(8),260,360);
        }
    }
    public void toBattleScreen(){
        if(currentScreen!="battle"){
            currentScreen = "battle";
        }
    }
    public void toPowerUpScreen(){
        if(currentScreen!="powerup"){
            currentScreen = "powerup";
        }
    }
    public void displayOwnedAllies(){

    }

    private void prepare(){
        allyDatabase.add(new Ally("Kageyama",700,250,250));
        allyDatabase.add(new Ally("Saitama",600,600,600));
        allyDatabase.add(new Ally("Kirito",500,300,600));
        
        setBackground(new GreenfootImage("bg.jpg"));
        StaticHudImage platinumBackDrop = new StaticHudImage("blackrectangle2.png");
        addObject(platinumBackDrop,268,27);
        StaticHudImage platinum = new StaticHudImage("platinum.png");
        addObject(platinum,242,27);
        PlatinumCount pc = new PlatinumCount();
        addObject(pc,285,27);
        BottomHudIcon recruiticon = new BottomHudIcon("recruiticon.png");
        addObject(recruiticon,275,450);
        BottomHudIcon homeicon = new BottomHudIcon("homeicon.png");
        addObject(homeicon,160,445);
        BottomHudIcon alliesicon = new BottomHudIcon("alliesicon.png");
        addObject(alliesicon, 100,448);
        BottomHudIcon battleicon = new BottomHudIcon("battleicon.png");
        addObject(battleicon, 45,446);
        BottomHudIcon powerupicon = new BottomHudIcon("powerupicon.png");
        addObject(powerupicon,220,452);
        setPaintOrder(White.class);
        

    }
}
