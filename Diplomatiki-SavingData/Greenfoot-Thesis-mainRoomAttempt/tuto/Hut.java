import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

/**
 * Write a description of class Place here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hut extends Actor implements Serializable
{
    int counter = 10;
    boolean isEDown = false;
    boolean isActive = false, displayMessage = false;
    private TextPanel textPanel;

    /**
     * Act - do whatever the Place wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        canSeeAlex();
    } 

    public boolean getActive(){
        return isActive;
    }

    public void canSeeAlex(){
        if (isTouching(Alex.class))
        {
            counter--;
            if (Greenfoot.isKeyDown("e")){
                isEDown = true;
            }
            if (isEDown && !isActive && !displayMessage){

                textPanel = new TextPanel("BrokenHutMessage");
                getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
                isActive = true;
                displayMessage = true;
            }

            if (Greenfoot.isKeyDown("enter")){
                counter = 10;
                getWorld().removeObject(textPanel);
                isActive = false;
                isEDown = false;

            }
            if (isEDown && displayMessage){
            }
        }
    }
}
