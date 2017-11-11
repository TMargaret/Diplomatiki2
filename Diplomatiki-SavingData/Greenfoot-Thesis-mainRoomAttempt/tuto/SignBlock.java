import greenfoot.*;
import java.util.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SignBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SignBlock extends ScrollingObstacle
{
    HiddenSprite hs;
    public int hsWidth = getImage().getWidth()*3; 
    public int hsHeight = 70;
    private final int HS_OFFSET_X = 0;
    private final int HS_OFFSET_Y = 0;
    private int counter = 10, eyes_counter, me = 0;
    private boolean isActive = false, doNotMoveWhileTalking = false, isEDown = false;
    int count_enter = 0;
    private boolean doneDialogue = false;
    private TextPanel taskText;
    /**
     * Act - do whatever the SignBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    protected void addedToWorld(World w)
    {
        addHiddenSprite(w);
    }

    public void addHiddenSprite(World w) {   
        hs = new HiddenSprite(this, hsWidth , hsHeight/2, HS_OFFSET_X, HS_OFFSET_Y, true);  
        w.addObject(hs, getX(), getY()); 
    }
    
    public void localsDialogue(){

        if( hs.getWorld() != null ) {   
            List<Actor> things = hs.getHitBoxIntersections();    
            if( things.size() > 1 ) {      
                int infront = 0;      
                for(int i=0; i < things.size(); i++ ) {       
                    Actor a = things.get(i);
                    if(a instanceof HiddenSprite)        
                        continue;        
                    if( a instanceof Alex) {  
                        counter--;
                        if (Greenfoot.isKeyDown("e")){
                            isEDown = true;
                        }
                        if (counter<0 && !isActive && isEDown && count_enter == 0){
                            taskText = new TextPanel(getTextMessage());
                            getWorld().addObject(taskText, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            setActive(true);
                            setTalking(true);
                            count_enter = 1;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 1 && counter<0 && isEDown){
                            counter = 20;
                            actionInDialogue();
                            count_enter = 2;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 2 && counter <0 && isEDown){
                            counter = 30;
                            actionInDialogue();
                            count_enter = 3;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 3 && counter <0 && isEDown){
                            counter = 30;
                            actionInDialogue();
                            count_enter = 4;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 4 && counter <0 && isEDown){
                            counter = 30;
                            actionInDialogue();
                            count_enter = 5;                            
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 5 && counter <0 && isEDown){
                            counter = 30;
                            actionInDialogue();                          
                            count_enter = 6;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 6 && counter <0 && isEDown){
                            counter = 30;
                            actionInDialogue();
                            count_enter = 7;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 7 && counter <0 && isEDown){
                            counter = 30;
                            getWorld().removeObject(taskText);
                            count_enter = 0;
                            isEDown = false;
                            setActive(false);
                            setTalking(false);
                            setDialogue(true);

                        }
                    }

                }
            }
        }
    }

    public void actionInDialogue(){
        getWorld().removeObject(taskText);
        taskText = new TextPanel(getTextMessage());
        getWorld().addObject(taskText, getWorld().getWidth()/2, getWorld().getHeight()/2);
    }
    
    public void extraAction(){
        
    }

    public int getCount_Enter(){
        return count_enter;
    }

    public String getTextMessage(){
        String textMsg = "";
        return textMsg;
    }

    //if isItTalking is true, then alex can't move
    public void setTalking(boolean isItTalking){
        doNotMoveWhileTalking = isItTalking;
    }

    public boolean getTalking(){
        return doNotMoveWhileTalking;
    }

    //if the dialogue has ended return true
    public boolean getDoneWithDialogue(){
        return doneDialogue;
    }

    public void setDialogue(boolean dialogue){
        doneDialogue = dialogue;
    }

    public void setActive(boolean forActive){
        isActive = forActive;
        count_enter =0;
    }
}