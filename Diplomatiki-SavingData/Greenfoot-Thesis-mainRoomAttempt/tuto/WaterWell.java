import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WaterWell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaterWell extends Actor
{

    int counter = 10;
    boolean isEDown = false;
    boolean isActive = false, displayMessage = false;
    private TextPanel textPanel;

    GreenfootImage img = getImage();

    public WaterWell(){
        img.scale(img.getWidth()/4, img.getHeight()/4);
    }

    /**
     * Act - do whatever the WaterWell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        canSeeAlex();
    } 

    public boolean getActive(){
        return isActive;
    }

    public void canSeeAlex(){
        if (isTouching(Alex.class))
        {
            counter--;
            if (Greenfoot.isKeyDown("e")){
                isEDown = true;
            }
            if (isEDown && !isActive && !displayMessage){

                textPanel = new TextPanel("BrokenWellMessage");
                getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
                isActive = true;
                displayMessage = true;
            }

            if (Greenfoot.isKeyDown("enter")){
                counter = 10;
                getWorld().removeObject(textPanel);
                isActive = false;
                isEDown = false;

            }
            if (isEDown && displayMessage){
            }
        }
    }    
}
