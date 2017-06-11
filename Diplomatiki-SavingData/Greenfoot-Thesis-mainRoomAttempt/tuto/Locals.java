import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List; 

/**
 * Write a description of class Locals here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Locals extends Actor
{    
    private HiddenSprite hs;
    private int counter = 10, eyes_counter, me = 0;
    private boolean isActive = false, doNotMoveWhileTalking = false, isEDown = false;
    private int count_enter = 0;
    private boolean doneDialogue = false;
    private TextPanel helloText, taskText1, taskText2, taskText3, taskText4, taskText5, taskText6, taskTextEnd;

    public Locals(){
    }

    /**
     * Act - do whatever the Elder wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        localsDialogue();
        blink();   
    }

    protected void addedToWorld(World w){
        addHiddenSprite();
    }

    public void blink(){
        if (++eyes_counter == 150){
            eyes_counter = 0;
            setImage1();
        }
        else if (eyes_counter == 140){
            setImage2();
        }
    }

    protected void addHiddenSprite() {   
        hs = new HiddenSprite(this, getImage().getWidth() + getImage().getWidth()/8 , getImage().getHeight() + getImage().getHeight()/4, 0, 5, true);  
        getWorld().addObject(hs, getX(), getY()); 
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
                            helloText = new TextPanel(getTextMessage());
                            getWorld().addObject(helloText, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            setActive(true);
                            setTalking(true);
                            count_enter = 1;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 1 && counter<0 && isEDown){
                            counter = 20;
                            getWorld().removeObject(helloText);
                            taskText1 = new TextPanel(getTextMessage());
                            getWorld().addObject(taskText1, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            count_enter = 2;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 2 && counter <0 && isEDown){
                            counter = 30;
                            getWorld().removeObject(taskText1);
                            taskText2 = new TextPanel(getTextMessage());
                            getWorld().addObject(taskText2, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            count_enter = 3;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 3 && counter <0 && isEDown){
                            counter = 30;
                            getWorld().removeObject(taskText2);
                            taskText3 = new TextPanel(getTextMessage());
                            getWorld().addObject(taskText3, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            count_enter = 4;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 4 && counter <0 && isEDown){
                            counter = 30;
                            getWorld().removeObject(taskText3);
                            taskText4 = new TextPanel(getTextMessage());
                            getWorld().addObject(taskText4, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            count_enter = 5;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 5 && counter <0 && isEDown){
                            counter = 30;
                            getWorld().removeObject(taskText4);
                            taskText5 = new TextPanel(getTextMessage());
                            getWorld().addObject(taskText5, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            count_enter = 6;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 6 && counter <0 && isEDown){
                            counter = 30;
                            getWorld().removeObject(taskText5);
                            taskText6 = new TextPanel(getTextMessage());
                            getWorld().addObject(taskText6, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            count_enter = 7;
                        }
                        if (Greenfoot.isKeyDown("enter") && count_enter == 7 && counter <0 && isEDown){
                            counter = 30;
                            getWorld().removeObject(taskText6);
                            count_enter = 0;
                            isEDown = false;
                            setActive(false);
                            setTalking(false);

                        }
                    }

                }
            }
        }
    }

    public int getCount_Enter(){
        return count_enter;
    }

    public String getTextMessage(){
        String textMsg = "";
        return textMsg;
    }

    //if isItTalking is true, then the robot can't move
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

    public void setImage1(){

    }

    public void setImage2(){

    }
}
