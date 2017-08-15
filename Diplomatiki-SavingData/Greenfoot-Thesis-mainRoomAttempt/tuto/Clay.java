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
    private String myAnswer;
    Clay newClay;
    private int version;

    /**
     * Clay Constructor. By default, this construstor uses the Alex.pickUp answer.
     *
     */
    public Clay() 
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 10, image.getHeight() - 10);
        setImage(image);
        myAnswer = "Alex.pickUp();";
        version = 0;
    }

    /**
     * Clay Constructor. The parameter helps to define if the actionMat method should be overriden or not
     *
     * @param answer int parameter
     */
    public Clay(int newObjectVersion) 
    {     
        version = newObjectVersion;
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 10, image.getHeight() - 10);
        setImage(image);
        myAnswer = "new Clay();";
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
        
        switch(version){
            case 0:
            super.actionMat();
            break;
            case 1:
            newClay = new Clay();
            getWorld().addObject(newClay, 80, 480);
            Level_02.matList.add(newClay);
            getWorld().removeObject(this);
            pickupSound.play();
            break;
        }
    }

    /**
     * Method checkMaterial
     *
     * @return The correct answer value to be check
     */
    public String checkMaterial(){
        return myAnswer;
    }
}
