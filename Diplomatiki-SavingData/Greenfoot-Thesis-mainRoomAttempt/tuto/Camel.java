import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Camel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Camel extends Locals
{
    private GreenfootImage img = getImage();
    private GreenfootImage img_eyes = new GreenfootImage("camel2.png");
    /**
     * Act - do whatever the Camel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        localsDialogue();
        blink();
    }   
    
        public void setImage1(){
        setImage(img);

    }

    public void setImage2(){       
        setImage(img_eyes);
    }
}
