import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpaceShipSparePart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boat extends Actor
{
    boolean eIsDown = false;
    int count_enter=0;
    Alex alex;
    TextPanel tp;
    boolean isActive = false;
    boolean tryAgainOrLeave = false;
    boolean wrongCommand = false;
    boolean thisLvl = false;
    TextField textField;
    int counter = 30;
    String my_text = "";
    Debugger db;
    GreenfootSound pickupSound = new GreenfootSound("pickUp.wav");

    public Boat(Alex alex){
        this.alex = alex;

    }

    /**
     * Act - do whatever the SpaceShipSparePart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (isTouching(Alex.class) && count_enter==0){

            // count_enter++;
            // move(1);
            // alex.setLocation(getX(),getY()-10);
            printAnswer();

        }
    } 

    public void printAnswer(){
        counter--;
                     
        if (Greenfoot.isKeyDown("e") && !isActive && !eIsDown){
            isActive = true;
            eIsDown = true; 
            /*count_enter++;*/
            textFieldCreation();
            tp = new TextPanel("boat", 650, 480);
            getWorld().addObject(tp, getWorld().getWidth()/2, getWorld().getHeight()/2);
        }
        if (Greenfoot.isKeyDown("escape") && eIsDown){
            getWorld().removeObject(textField); 
            getWorld().removeObject(tp);
            isActive = false;
            eIsDown = false;
        }   
        if (Greenfoot.isKeyDown("enter") && eIsDown && !tryAgainOrLeave){
            eIsDown = false;
            counter = 30;
            db = new Debugger(textField.getText(), "3");
            if (db.checkSpelling())
            {
                actionSpelling();
            }
            else {
                checkHealthBar();
                if (HealthBar.getHealth()>0){
                    tp= new TextPanel("wrong");
                    getWorld().addObject(tp, getWorld().getWidth()/2, getWorld().getHeight()/2);
                    tryAgainOrLeave = true;
                    //eIsDown = false;
                }
            }
        }
        if (Greenfoot.isKeyDown("enter") && counter < 0 && tryAgainOrLeave){
            counter = 40;
            eIsDown = false;
            isActive = false;
            tryAgainOrLeave = false;
            getWorld().removeObject(tp);
        }

        wrongCommand = false;
    }

    public void textFieldCreation(){
        textField = new TextField(700, 45,"");
        getWorld().addObject(textField, textField.getImage().getWidth()/2, getWorld().getHeight() - textField.getImage().getHeight()/2);
    }

    public void actionSpelling(){
        getWorld().removeObject(tp);
        getWorld().removeObject(textField); 
        pickupSound.play();
        isActive = false;
        eIsDown = false;
    }

    public void checkHealthBar(){
        getWorld().removeObject(textField);
        getWorld().removeObject(tp);
        if (!wrongCommand){
            wrongCommand = true;
            HealthBar.looseHealth();
        }
        if (HealthBar.getHealth()<=0){
            isActive = false;
            eIsDown = false;
            tryAgainOrLeave = false;
            wrongCommand = false;
            int counter = 30;
            int version = 0;
            my_text = "";
        }
    }

    public boolean getActive(){
        return isActive;
    }
}
