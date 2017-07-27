import greenfoot.*;
import java.util.List;   // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Lumber class is a material that must be collected in order to use it during the mission
 * 
 * @author (Margaret) 
 * @version (30/4/2017)
 */
public class Lumber extends Material
{

    
    /**
     * Lumber Constructor
     *
     */
    public Lumber() 
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 10, image.getHeight() - 10);
        setImage(image);

        
    }

    /**
     * Act - do whatever the Lumber wants to do. This method is called whenever
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
        String material = "Wood";
        return material;
    }

    /**
     * Method checkMaterial
     *
     * @return The correct answer value to be check
     */
    public String checkMaterial(){
        String materialAnswer = "";
        switch(version){
            case 0: materialAnswer = "Alex.pickUp();"; break;
            case 1:
            case 2: materialAnswer = "new Wood();"; break;
        }
        return materialAnswer;

    }
}
