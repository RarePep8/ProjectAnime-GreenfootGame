import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ally here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ally extends Actor
{
    String name;
    int level,attack,defense,speed;
    public Ally(String name, int attack, int defense, int speed){
        this.name = name;
        this.level = 1;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }
    public String getName(){
        return name;
    }
    /**
     * Act - do whatever the Ally wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    public int getAttack(){
        return attack;
    }
    public int getDefense(){
        return defense;
    }
    public int getSpeed(){
        return speed;
    }
}
