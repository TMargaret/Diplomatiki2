import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien extends Locals
{

    private GreenfootImage img = getImage();
    private GreenfootImage img_eyes = new GreenfootImage("alien2.png");

    public Alien(){
        scaleImage();
        setImage(img);
    }

    /**
     * Act - do whatever the Alien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //localsDialogue();
        blink();
    } 

    public void scaleImage(){
        img.scale(img.getWidth()/4, img.getHeight()/4);
        img_eyes.scale(img_eyes.getWidth()/4, img_eyes.getHeight()/4);

    }

    public void setImage1(){
        setImage(img);

    }

    public void setImage2(){       
        setImage(img_eyes);
    }
}
