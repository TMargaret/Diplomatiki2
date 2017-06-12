import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class House here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class House extends Actor
{
    int counter = 10;
    boolean isEDown = false;
    boolean isActive = false, displayMessage = false;
    private TextPanel textPanel;

    public House(){
    }
    /**
     * Act - do whatever the House wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        canSeeAlex();
    } 

    public boolean getActive(){
        return isActive;
    }
     public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }

    public void canSeeAlex(){
        if (getOneIntersectingObject(Alex.class) != null)
        {
            counter--;
            if (Greenfoot.isKeyDown("e")){
                isEDown = true;
            }
            if (isEDown && !isActive){

                textPanel = new TextPanel("houseMsgL0");
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
