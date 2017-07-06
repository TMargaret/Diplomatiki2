import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bubble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bubble extends Actor
{
    GreenfootImage bbl = new GreenfootImage("bbl.png");
    GreenfootImage bbl1 = new GreenfootImage("bbl2.png");
    private int counter = 0;
    /**
     * Act - do whatever the bubble wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        blink();
        
    }  
    
        public void blink(){
        if (++counter == 200){
            counter = 0;
            setImage(bbl);
        }
        else if (counter == 100){
            setImage(bbl1);
        }
    }
}
