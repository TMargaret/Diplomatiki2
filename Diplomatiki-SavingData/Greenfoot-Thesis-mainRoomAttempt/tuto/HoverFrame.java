import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HoverFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HoverFrame extends Actor
{
    GreenfootImage frame;
    
    public HoverFrame(){
        frame = new GreenfootImage(250, 220);
        frame.setColor(Color.LIGHT_GRAY);
        frame.fill();
        frame.setTransparency(0);
        setImage(frame);
    }
    /**
     * Act - do whatever the HoverFrame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }  
    
    public void setTrans(int t){
        frame.setTransparency(t);
        setImage(frame);
    }
}
