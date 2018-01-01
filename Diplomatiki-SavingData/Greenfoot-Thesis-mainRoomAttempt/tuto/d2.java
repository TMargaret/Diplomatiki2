import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class d2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class d2 extends Dragon
{
    private TextPanel textPanel;
    int counter = 30;
    int count_enter = 0;
    boolean endLevel = false;
    /**
     * Act - do whatever the d2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animation();
        dragonDialogue();
        endGame();
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
            // textPanel = new TextPanel("dragon2");
            getWorld().addObject(new QuizPic(), getWorld().getWidth()/2, getWorld().getHeight()/2);
            count_enter = 4;
        }
    }

    public void endGame(){
        counter--;
        if (QuizPic.endLevel()){
            if (count_enter == 4 && counter <0){
                counter = 30;
                textPanel = new TextPanel("dragon3");
                getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
                count_enter = 5;
            }          
        }
        if (Greenfoot.isKeyDown("enter") && count_enter == 5 && counter < 0){
            endLevel = true;
            getWorld().removeObject(textPanel);
        }
    }

    public boolean endLevel(){
        return endLevel;
    }
}
