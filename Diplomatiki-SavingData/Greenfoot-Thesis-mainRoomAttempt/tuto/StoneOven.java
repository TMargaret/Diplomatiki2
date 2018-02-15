import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

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
    Brick brick, brick2;
    List<Brick> a;

    public StoneOven(){
        super.hsHeight = 300;
    }

    /**
     * Act - do whatever the StoveOven wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkWorld();
        materialCreation();

    } 

    public void actionMat(){
        a = getWorld().getObjects(Brick.class);
        for (Brick brick: a){
            if(brick.getImage().getTransparency() == 0){
                brick.getImage().setTransparency(255);
                break;
            }
        }
    }

    /**
     * Method getMaterial
     *
     * @return The material value, for the info message that appears in inputField
     */
    public String getMaterial(){
        String material = "Brick";
        return material;
    }
    
    @Override
    public String getTextFieldMessage(){
        String textMsg = "Δημιούργησε ένα αντικείμενο "+ getMaterial();
        return textMsg;
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
