import greenfoot.*;

/**
 * Write a description of class Bridge here.
 * @author (your name) @version (a version number or a date)
 */
public class Bridge extends Material
{
    String myAnswer;
    
   public Bridge(){
       super.hsWidth = super.hsWidth/2;
       getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
       myAnswer = "Alex.use();";
    }

    /* (World, Actor, GreenfootImage, Greenfoot and MouseInfo)*/

    /**
     * Act - do whatever the Bridge wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        materialCreation();
    }
    
     
    /**
     * Method checkMaterial
     *
     * @return The correct answer value to be check 
     */
    @Override
    public String checkMaterial(){
        return myAnswer;
    }
}
