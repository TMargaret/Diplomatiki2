import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StoneOven here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StoneOven extends Material
{
    HiddenSprite hs;
    private int hsWidth, hsHeight;
    private final int HS_OFFSET_X = 0;
    private final int HS_OFFSET_Y = 0;

    public StoneOven(){
        super.hsHeight = 300;
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
        String materialAnswer = "new Brick();";
        return materialAnswer;

    } 
}
