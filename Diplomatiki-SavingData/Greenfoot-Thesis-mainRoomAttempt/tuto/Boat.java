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
    int rightMat = 3;
    Alex alex;
    TextPanel tp;
    int endGame = -1;
    boolean isActive = false;
    boolean tryAgainOrLeave = false;
    boolean wrongCommand = false;
    boolean flag = false;    
    TextField textField;
    int counter = 30;
    int countMat = 0;
    String my_text = "";
    Debugger db;
    Button btn1, btn2;
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
        if (isTouching(Alex.class) && Greenfoot.isKeyDown("e") && !eIsDown && !isActive){
            eIsDown = true;
            isActive = true;
            Greenfoot.getKey().replaceAll("e", "");
            tp = new TextPanel("moveOrStudy", 650, 480);
            getWorld().addObject(tp, getWorld().getWidth()/2, getWorld().getHeight()/2);
            btn1 = new Button();
            btn1.setTitle("Έλεγχος φορτίου βάρκας");
            getWorld().addObject(btn1, 500, 200);
            btn2 = new Button();
            btn2.setTitle("Θέλω να περάσω απέναντι");
            getWorld().addObject(btn2, 500, 400);           
        }
        if (Greenfoot.isKeyDown("escape") && eIsDown && isActive){
            removeObj();
            isActive = false;
            eIsDown = false;
        }
        printAnswer();
        moveBoat();
        if (flag && getX()< 680){
            move(1);
            alex.setLocation(getX(),getY()-10);
        }
        else if (flag && getX()>= 680){
            isActive = false;  
        }
    } 

    public void moveBoat(){
        if (Greenfoot.mouseClicked(btn2) && isActive && eIsDown){
            if (getCheckList()==rightMat){
                removeObj();
                flag = true;                 
            }
            else{
                removeObj();
                setEnd(0);              
            }
        }
    }

    public void removeObj(){
        getWorld().removeObject(btn1);
        getWorld().removeObject(btn2);
        getWorld().removeObject(tp);
        getWorld().removeObject(textField);
    }

    public void printAnswer(){
        counter--;                     
        if (Greenfoot.mouseClicked(btn1) && isActive && eIsDown){          
            getWorld().removeObject(tp);
            getWorld().removeObject(btn1);
            getWorld().removeObject(btn2);
            textFieldCreation();
            tp = new TextPanel("boat", 650, 480);
            getWorld().addObject(tp, getWorld().getWidth()/2, getWorld().getHeight()/2);
        }  
        if (Greenfoot.isKeyDown("enter") && eIsDown && !tryAgainOrLeave && !flag){
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

    public void setCheckList(int count_mat){
        countMat = count_mat;
    }

    public int getCheckList(){
        return countMat;
    }

    public void setEnd(int end){
        endGame = end;
    }

    public int getEnd(){
        return endGame;
    }
}
