import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List; 

/**
 * Write a description of class Clay2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clay2 extends Material
{  
    /**
     * Clay2 Constructor
     *
     */
    public Clay2() 
    {
        // GreenfootImage image = getImage();
        // image.scale(image.getWidth() - 10, image.getHeight() - 10);
        // setImage(image);
    }

    /**
     * Act - do whatever the Clay2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // checkWorld();
        materialCreation();
    } 

    /**
     * Method getMaterial
     *
     * @return The material value, for the info message that appears in inputField
     */
    public String getMaterial(){
        String material = "Clay";
        return material;
    }

    /**
     * Method checkMaterial
     *
     * @return The correct answer value to be check
     */
    public String checkMaterial(){
        String materialAnswer = "Alex.pickUp();";
        return materialAnswer;

    }
}
