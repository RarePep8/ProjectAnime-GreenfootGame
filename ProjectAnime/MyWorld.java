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
    private int numPlatinum = 100;
    String currentScreen = "home";
    List<Ally> allyDatabase = new ArrayList<Ally>();
    List<Ally> ownedAllies = new ArrayList<Ally>();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    

        super(320, 480, 1); 
        prepare();
    }

    public void unlockAlly(){
        addObject(new UnlockedAlly(),160,240);
        ownedAllies.add(allyDatabase.get(0));
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
        allyDatabase.add(new Ally("Kageyama",10,10,10));

        ownedAllies.add(allyDatabase.get(0));
        
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
