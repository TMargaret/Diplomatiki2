import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Straw here.
 * 
 * @author (Margaret) 
 * @version (30/4/2017)
 */
public class Straw extends Material
{

    private String myAnswer;
    private int version = 0;
    /**
     * Straw Constructor
     *
     */
    public Straw(){
        //myAnswer = "Alex.pickUp(straw);";
        myAnswer = "";
    }

    public Straw(int newObjectVersion) 
    {       
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 10, image.getHeight() - 10);
        setImage(image);  
        version = newObjectVersion;
        myAnswer = "Alex.pickUp();";
    }

    /**
     * Act - do whatever the Straw wants to do. This method is called whenever
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
        String material = "Straw";
        return material;
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
