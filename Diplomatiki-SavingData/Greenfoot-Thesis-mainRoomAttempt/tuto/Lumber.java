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
    private String myAnswer;
    Lumber newLumber;
    private int version;

    /**
     * Lumber Constructor
     *
     */
    public Lumber() 
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 10, image.getHeight() - 10);
        setImage(image);
        myAnswer = "Alex.pickUp();";
        version = 0;
    }

    /**
     * Lumber Constructor
     *
     * @param newObjectVersion A parameter
     */
    public Lumber(int newObjectVersion) 
    {       
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 10, image.getHeight() - 10);
        setImage(image);  
        version = newObjectVersion;
        myAnswer = "new Wood();";
    }


    /**
     * Act - do whatever the Lumber wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
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
        return myAnswer;

    }

    @Override
    public void actionMat(){        
        switch(version){
            case 0:
            super.actionMat();
            break;
            case 1:
            newLumber = new Lumber();
            getWorld().addObject(newLumber, 40, 575);
            Level_02.matList.add(newLumber);
            getWorld().removeObject(this);
            pickupSound.play();
            break;
        }
    }
    
    @Override
    public String getTextFieldMessage(){    
        String msg = null;
        switch(version){
            case 0:
            msg =  super.getTextFieldMessage();
            break;
            case 1:
            msg = "Δημιούργησε ένα αντικείμενο " + getMaterial() + " και πάτα enter";
            break;
        }
        return msg;
    }
}
