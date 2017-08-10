import greenfoot.*;
import java.util.List;   // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Lumber2 class is a material that must be collected in order to use it during the mission
 * 
 * @author (Margaret) 
 * @version (30/4/2017)
 */
public class Lumber2 extends Material
{

    Lumber lumber = new Lumber();
    /**
     * Lumber2 Constructor
     *
     */
    public Lumber2() 
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 10, image.getHeight() - 10);
        setImage(image);

    }

    /**
     * Act - do whatever the Lumber2 wants to do. This method is called whenever
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

    public void actionMat(){
        getWorld().addObject(lumber, 40, 570);
        Level_02.matList.add(lumber);
        getWorld().removeObject(this);        
        pickupSound.play();
    }

    /**
     * Method checkMaterial
     *
     * @return The correct answer value to be check
     */
    public String checkMaterial(){
        String materialAnswer = "new Wood();"; 
        return materialAnswer;

    }
}
