import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StoneOven here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StoneOven extends Workshop
{
    HiddenSprite hs;

    public StoneOven(){
    }

    /**
     * Act - do whatever the StoveOven wants to do. This method is called whenever
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
        String material = "";
        return material;
    }

    /**
     * Method checkMaterial
     *
     * @return The correct answer value to be check
     */
    public String checkMaterial(){
        String materialAnswer = "putDown(clay)";
        return materialAnswer;

    } 
}