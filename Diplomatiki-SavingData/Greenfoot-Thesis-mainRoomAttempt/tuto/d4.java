import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class d4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class d4 extends Dragon
{
    
    int counter = 30;
    TextPanel textPanel;
    int count_enter = 0;
    int i=255;
    boolean isTrans=false;
    private SimpleTimer timer = new SimpleTimer();
    
    public d4(){
        isTrans=false;
        i=255;
        count_enter = 0;
 
        counter = 30;
    }
    /**
     * Act - do whatever the d4 wants to do. This method is called whenever
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
            getWorld().addObject(new Pic4(), getWorld().getWidth()/2, getWorld().getHeight()/2);
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
            counter = 50;
            getWorld().removeObject(textPanel);
            count_enter=6;
        }

        if (count_enter==6){
            if (!isTrans){
                isTrans = true;
                timer.mark();
            }
            if (timer.millisElapsed()>10 && i>=0){               
                isTrans = false;
                getImage().setTransparency(i);
                timer.mark();
                i--;
            }
            if (i<0){
                getWorld().removeObject(this);
            }
        }

    }


}
