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
    Label lbl;

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);       
        prepare();
        Greenfoot.start();
        
    }
    public void prepare(){
        lbl = new Label("Escape: exit", 30);
        lbl.setFillColor(Color.WHITE);
        addObject(lbl, 70, 30);
        
    }

    public void act(){
        if (Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new Senario());
        }
        if (Greenfoot.isKeyDown("escape")){
            System.exit(1);
        }
    }
    
    
    public void started(){
        startSound.playLoop();
    }
}
