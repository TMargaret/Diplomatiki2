import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpaceShipSparePart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boat extends Actor
{
    boolean eIsDown = false;
    Alex alex;
    
    public Boat(Alex alex){
        this.alex = alex;
    }
    /**
     * Act - do whatever the SpaceShipSparePart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("e")){
            eIsDown = true;
        }
        if (isTouching(Alex.class) && eIsDown){
            move(1);
            alex.setLocation(getX(),getY()-10);
            
        }
    }    
}
