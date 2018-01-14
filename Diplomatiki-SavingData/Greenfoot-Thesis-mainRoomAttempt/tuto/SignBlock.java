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
    private int counter = 10;
    private boolean isActive = false, doNotMoveWhileTalking = false, isEDown = false;
    GreenfootSound pickupSound = new GreenfootSound("pickUp.wav");
    ArrayList<HoverFrame> hoverFrame = new ArrayList<HoverFrame>();
    HoverFrame hoverFrame1, hoverFrame2;
    private boolean doneDialogue = false;
    private TextPanel taskText;
    Button btn1, btn2;
    Button ba = new Button();
    Button bb = new Button();
    int signNum = 0;
    boolean sb = false;
    String correctAnswer;

    public SignBlock(){

    }

    /**
     * Act - do whatever the SignBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        signDialogue();  

    } 

    protected void addedToWorld(World w)
    {
        addHiddenSprite(w);
    }

    public void addHiddenSprite(World w) {   
        hs = new HiddenSprite(this, hsWidth , hsHeight/2, HS_OFFSET_X, HS_OFFSET_Y, true);  
        w.addObject(hs, getX(), getY()); 
    }

    public void signDialogue(){

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
                        if (counter<0  && isEDown){
                            drawText();
                            setActive(true);
                            setTalking(true);
                        }
                        if (Greenfoot.isKeyDown("escape") && isEDown && taskText!=null){
                            getWorld().removeObject(taskText); 
                            setActive(false);
                            setTalking(false);
                            isEDown = false;
                            removeButton();
                            sb = false;
                        } 
                        if (Greenfoot.mouseClicked(ba)){
                            counter = 20;
                            getWorld().removeObject(taskText);
                            removeButton();
                            setActive(false);
                            setTalking(false);
                            sb = false;
                            isEDown = false;
                            setCorrectAnswer("0");
                            getWorld().removeObject(this);
                        }
                        if (Greenfoot.mouseClicked(bb)){
                            counter = 20;
                            getWorld().removeObject(taskText);
                            removeButton();
                            setActive(false);
                            setTalking(false);
                            sb = false;
                            isEDown = false;
                            setCorrectAnswer("1");
                            pickupSound.play();
                            getWorld().removeObject(this);
                        }
                    }

                }
            }
        }
    }
    
    
    public void setCorrectAnswer(String ca){
        correctAnswer = ca;
    }
    
    public String getCorrectAnswer(){
        return correctAnswer;
    }

    public void drawText(){

        switch (signNum){
            case 1:
            if (!sb){
                sb = true;
                taskText = new TextPanel("hello");
                taskText.setImage("bk"+signNum+".png");            
                getWorld().addObject(taskText, getWorld().getWidth()/2, getWorld().getHeight()/2);
                addButtons();
                //correct 1
                setBtnTitle("SubSpaceShip method\nSuperSpaceShip method", "SuperSpaceShip method\nSubSpaceShip method");
            }
            break;
            case 2:
            if (!sb){
                sb = true;
                taskText = new TextPanel("hello");
                taskText.setImage("bk"+signNum+".png");            
                getWorld().addObject(taskText, getWorld().getWidth()/2, getWorld().getHeight()/2);
                addButtons();
                //correct 1
                setBtnTitle("SubSpaceShip method", "SuperSpaceShip method");
            } 
            break;
            case 3:
            if (!sb){
                sb = true;
                taskText = new TextPanel("hello");
                taskText.setImage("bk"+signNum+".png");            
                getWorld().addObject(taskText, getWorld().getWidth()/2, getWorld().getHeight()/2);
                addButtons();
                //correct 2
                setBtnTitle("SubSpaceShip\nSuperSpaceShip", "SuperSpaceShip\nSubSpaceShip");
            }
            break;
            case 4:
            if (!sb){
                sb = true;
                taskText = new TextPanel("hello");
                taskText.setImage("bk"+signNum+".png");            
                getWorld().addObject(taskText, getWorld().getWidth()/2, getWorld().getHeight()/2);
                addButtons();
                //correct 2
                setBtnTitle("SubSpaceShip and SuperSpaceShip", "SuperSpaceShip and SubSpaceShip");
            }
            break;
        }
    }
    
    public void removeButton(){
        if (getWorld().getObjects(Button.class) != null){
            getWorld().removeObjects(getWorld().getObjects(Button.class));
        }
    }

    public void setSignNum(int sn){
        signNum = sn;

    }

    public int getSignNum(){
        return signNum;
    }

    public void setBtnTitle(String ba1, String bb1){
        ba.setTitle(ba1);
        bb.setTitle(bb1);
    }

    public void addButtons(){
        getWorld().addObject(ba, 700, 390);      
        getWorld().addObject(bb, 700, 470);
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
        //count_enter =0;
    }
}
