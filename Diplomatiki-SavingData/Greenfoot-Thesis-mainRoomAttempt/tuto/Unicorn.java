import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Unicorn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Unicorn extends ScrollingObstacle
{
    private GreenfootImage img = new GreenfootImage("uni.png");
    private GreenfootImage img2 = new GreenfootImage("uni2.png");
    int count = 0;
    private int counter = 10;
    private HiddenSprite hs;
    private boolean isActive = false, doNotMoveWhileTalking = false, isEDown = false;
    int count_enter = 0;
    private boolean doneDialogue = false;
    private TextPanel taskText;
    Bubble bubble;
    GreenfootSound hiSound = new GreenfootSound("hello.wav");
    
    private static Counter counterLife;
    private Button exit_button, forward_button, backward_button, count_button;
    private boolean flag_for_menu, flag_forward, flag_backward;
    private GreenfootImage quiz1 = new GreenfootImage("inhe.jpg");
    private int count_image;
    private String quiz = "quiz";

    public Unicorn(){
        scaleImage();
        setImage(img);
        count_image = 1;
        flag_for_menu = false;
        flag_forward= false;
        flag_backward = false;
        
        //shows how many questions are left
        count_button = new Button();
       // addObject(count_button, getWidth() - count_button.getImage().getWidth()/2, count_button.getImage().getHeight()/2);
        
        forward_button = new Button();
        forward_button.setTitle("ΕΠΟΜΕΝΟ");
        //addObject(forward_button, getWidth() - forward_button.getImage().getWidth()/2, getHeight() - forward_button.getImage().getHeight()/2);
        
        backward_button = new Button();
        backward_button.setTitle("ΠΡΟΗΓΟΥΜΕΝΟ");
        //addObject(backward_button, backward_button.getImage().getWidth()/2, getHeight() - backward_button.getImage().getHeight()/2);

    }

    /**
     * Act - do whatever the Alien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        localsDialogue();
        blink();
    } 

    public void scaleImage(){
        img.scale(img.getWidth()+(img.getWidth()/2), img.getHeight()+(img.getHeight()/2));
        img2.scale(img2.getWidth()+(img2.getWidth()/2), img2.getHeight()+(img2.getHeight()/2));

    }

    protected void addedToWorld(World w){
        addHiddenSprite();
        bubble = new Bubble();
        getWorld().addObject(bubble,hs.getX() - 20,hs.getY() -  100);
    }

    protected void addHiddenSprite() {   
        hs = new HiddenSprite(this, getImage().getWidth() + getImage().getWidth()/2 , getImage().getHeight() + getImage().getHeight()/5, 0, 5, true);  
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
                            hiSound.play();
                            isEDown = true;
                            getWorld().removeObject(bubble);
                        }
                        if (counter<0 && !isActive && isEDown && count_enter == 0){
                           // taskText = new TextPanel(getTextMessage());
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
    
    
    // public void checkImage()
    // {
        // if (((Greenfoot.isKeyDown("enter")) & (flag_for_menu == false)))
        // {
            // this.setBackground(quiz1);
            // count_button.setTitle("1/14");
            // flag_forward = true;
        // }
        // //forwarding images
        // if (count_image < 14){
            // if ((Greenfoot.mouseClicked(forward_button) & (flag_forward == true)))
            // {
                // count_image++;
                // this.setBackground(quiz+count_image+".jpg");
                // count_button.setTitle(count_image+"/14");
                // flag_backward = true;
            // }
        // }
        // //backwarding images
        // if (count_image>1){
            // if ((Greenfoot.mouseClicked(backward_button) & (flag_backward==true)))
            // {
                // count_image--;
                // forward_button.setTitle("ΕΠΟΜΕΝΟ");
                // this.setBackground(quiz+count_image+".jpg");
                // count_button.setTitle(count_image+"/14");
            // }
        // }
        // if (count_image >= 14){
            // forward_button.setTitle("ΤΕΛΟΣ");
        // }
    // }

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

    public void blink(){
        count++;
        if (count == 50){           
            setImage1();
        }
        if (count == 100){
            setImage2();
            count = 0;
        }
    }

    public String getTextMessage(){
        String text = "";
        int textCase = getCount_Enter();
        switch (textCase){
            case 0: text = "welcomeMsgL4";
            break;
            case 1: text = "taskText1L4";
            break;
            case 2: text = "taskText2L4";
            break;
            case 3: text = "taskText3L4";
            break;
            case 4: text = "taskText4L4";
            break;
            case 5: text = "taskText5L4";
            break;
            case 6: text = "taskText6L4";
            break;
        }
        return text;
    }

    public void setImage1(){
        setImage(img);

    }

    public void setImage2(){       
        setImage(img2);
    }
}
