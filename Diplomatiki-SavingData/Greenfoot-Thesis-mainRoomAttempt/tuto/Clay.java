import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List; 

/**
 * Write a description of class Clay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clay extends Material
{  
    Clay2 clay2 = new Clay2();
    
    /**
     * Clay Constructor
     *
     */
    public Clay() 
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 10, image.getHeight() - 10);
        setImage(image);
    }

    /**
     * Act - do whatever the Clay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkWorld();
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
    
    public void actionMat(){
        getWorld().addObject(clay2, 40, 480);
        Level_02.matList.add(clay2);
        getWorld().removeObject(this);        
        pickupSound.play();
    }

    /**
     * Method checkMaterial
     *
     * @return The correct answer value to be check
     */
    public String checkMaterial(){
        String materialAnswer = "new Clay();";
        return materialAnswer;

    }
}
