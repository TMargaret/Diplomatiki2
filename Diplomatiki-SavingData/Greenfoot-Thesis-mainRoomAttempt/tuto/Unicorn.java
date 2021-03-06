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
    
    

    public Unicorn(){
        scaleImage();
        setImage(img);


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
                           ImageTheory imgT = new ImageTheory("inhe",16, "jpg");
                            getWorld().addObject(imgT, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            setActive(true);
                            setTalking(true);
                            count_enter = 1;
                            counter = 30;
                        }
                        if ((getWorld().getObjects(ImageTheory.class).size() == 0) && count_enter == 1 && counter<0 && isEDown){
                            counter = 20;
                            setActive(false);
                            setTalking(false);
                            isEDown = false;
                        }

                    }

                }
            }
        }
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

    public void setImage1(){
        setImage(img);

    }

    public void setImage2(){       
        setImage(img2);
    }
}
