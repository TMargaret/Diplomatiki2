import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    public static GreenfootSound startSound = new GreenfootSound("intro.mp3");

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
    }

    public void act(){
        if (Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new LevelsScreen());
        }

    }
    
    public void started(){
        startSound.playLoop();
    }
}
