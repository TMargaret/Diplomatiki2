import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class d4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class d4 extends Dragon
{
    boolean endLevel = false;
    int counter = 30;
    TextPanel textPanel;
    int count_enter = 0;
    /**
     * Act - do whatever the d4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animation();
        dragonDialogue();

    } 

    public void dragonDialogue(){
        counter--;
        if (count_enter == 0 && counter <0){
            counter = 30;
            textPanel = new TextPanel("dragon0");
            getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
            count_enter = 1;
        }
        if (Greenfoot.isKeyDown("enter") && count_enter == 1 && counter <0){
            counter = 30;
            getWorld().removeObject(textPanel);
            textPanel = new TextPanel("dragon1");
            getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
            count_enter = 2;
        }
        if (Greenfoot.isKeyDown("enter") && count_enter == 2 && counter <0){
            counter = 30;
            getWorld().removeObject(textPanel);
            textPanel = new TextPanel("dragon2");
            getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
            count_enter = 3;
        }
        if (Greenfoot.isKeyDown("enter") && count_enter == 3 && counter <0){
            counter = 30;
            getWorld().removeObject(textPanel);       
            getWorld().addObject(new Pic4(), getWorld().getWidth()/2, getWorld().getHeight()/2);
            count_enter = 4;
        }
    }
    
    

    public boolean endLevel(){
        return endLevel;
    }
}
