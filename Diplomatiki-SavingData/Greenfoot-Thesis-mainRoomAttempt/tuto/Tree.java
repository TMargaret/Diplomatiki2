import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tree extends Material
{
    GreenfootImage img = getImage();
    private String myAnswer;
    
    public Tree(){
        img.scale(img.getWidth()/2, img.getHeight()/2);
    }
    /**
     * Act - do whatever the Tree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkWorld();
        checkMaterial();
      
    } 
    
    /**
     * Method getMaterial
     *
     * @return The material value, for the info message that appears in inputField
     */
    @Override
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
        String materialAnswer = "new Brick();";
        return materialAnswer;
    } 
}
