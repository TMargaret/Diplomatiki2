import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

/**
 * Write a description of class Place here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hut extends Actor implements Serializable
{
    int counter = 10;
    boolean isEDown = false;
    boolean isActive = false, displayMessage = false;
    private TextPanel textPanel;
    int isEDownTwice= 0;
    int countMat = 0;
    int countUse = 0;
    boolean endOfUse = false;
    boolean tryAgainOrLeave = false;
    boolean wrongCommand = false;
    boolean buildHouse = false;
    boolean enterHut = false;
    Level_1 lvl_1;
    TextField textField;
    String my_text = "";
    GreenfootImage bH = new GreenfootImage("fixedHut.png");
    Debugger db;
    GreenfootSound dropSound = new GreenfootSound("drop.wav");
    GreenfootSound buildSound = new GreenfootSound("build.mp3");

    /**
     * Act - do whatever the Place wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        canSeeAlex();
    } 

    public boolean getActive(){
        return isActive;
    }

    public void canSeeAlex(){
        if (isTouching(Alex.class))
        {
            counter--;
            if (Greenfoot.isKeyDown("e")){
                isEDown = true;
            }
            if (getCheckList() < 2){
                if (isEDown && !isActive && !displayMessage){
                    counter = 30;
                    textPanel = new TextPanel("BrokenHutMessage");
                    getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
                    isActive = true;
                    displayMessage = true;
                }

                if (Greenfoot.isKeyDown("enter")){
                    counter = 10;
                    getWorld().removeObject(textPanel);
                    isActive = false;
                    isEDown = false;

                }
            }
            if (getCheckList() == 2 && !endOfUse){
                if (isEDown && !isActive && !endOfUse){
                    isActive = true;
                    counter = 20;
                    textFieldCreation();
                }

                if (Greenfoot.mouseClicked(textField) && isEDown){
                    textField.setText("");
                }
                if (Greenfoot.isKeyDown("escape") && isEDown){
                    getWorld().removeObject(textField); 
                    isActive = false;
                    isEDown = false;
                } 
                if (counter < 0 && Greenfoot.isKeyDown("enter") && isEDown){
                    counter = 30;
                    db = new Debugger(textField.getText(),"1");
                    //db = new Debugger(textField.getText(),"Alex.use(wood,straw);");
                    if (db.checkSpelling())
                    {
                        Alex.removeFromInv(true);
                        Alex.removeFromInv(true);
                        buildSound.play();
                        getWorld().removeObject(textField);
                        // Alex.flagForRemovedItem = false;
                        isActive = false;
                        endOfUse = true;
                        setImage(bH);
                        setBuildHouse(true);                          

                    } 

                    else {
                        checkHealthBar();
                        getWorld().removeObject(textField);
                        if (HealthBar.getHealth()>0){                                 
                            textPanel= new TextPanel("wrongKey", db.feedback());
                            getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
                        }
                        tryAgainOrLeave = true;
                        isEDown = false;
                    }
                }

                if (Greenfoot.isKeyDown("enter") && counter < 0 && tryAgainOrLeave){
                    counter = 40;
                    isEDown = false;
                    isActive = false;
                    tryAgainOrLeave = false;
                    wrongCommand = false;
                    getWorld().removeObject(textPanel);
                }
            }
            // if (counter<0 && endOfUse && !enterHut){
                // counter = 100;
                // enterHut = true;
                // textPanel= new TextPanel("enteringRoom?", db.feedback());
                // getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
            // }
            // if (counter < 0 && enterHut){
                // getWorld().removeObject(textPanel);
                // counter = 100;
                // isActive = false;
                // isEDown = false;
                // // alex.setLocation(alex.getX(), alex.getY() + 100);
                // Greenfoot.setWorld(new mainHouseRoom());
            // }  
            // if (Greenfoot.isKeyDown("1") && counter < 0 && enterHut){
                // counter = 40;
                // isEDown = false;
                // isActive = false;
                // tryAgainOrLeave = false;
                // wrongCommand = false;
                // enterHut = false;
                // getWorld().removeObject(textPanel);
            // }
            // if (Greenfoot.isKeyDown("2") && counter < 0 && enterHut && isEDown){
                // counter = 40;
                // isEDown = false;
                // isActive = false;
                // tryAgainOrLeave = false;
                // wrongCommand = false;
                // enterHut = false;
                // getWorld().removeObject(textPanel);

            // }
        }
    }

    public void textFieldCreation(){
        textField = new TextField(700, 45,"Χρησιμοποίησε τα υλικά μαζί..");
        getWorld().addObject(textField, textField.getImage().getWidth()/2, getWorld().getHeight() - textField.getImage().getHeight()/2);
    }

    public void setCheckList(int count_mat){
        countMat = count_mat;
    }

    public int getCheckList(){
        return countMat;
    }

    public void setBuildHouse(boolean buildH){
        buildHouse = buildH;
    }

    public boolean getBuildHouse(){
        return buildHouse;
    }

    public boolean getEndOfUse(){
        return endOfUse;
    }

    public void checkHealthBar(){
        Level_1 lvl1 = (Level_1)getWorld();
        getWorld().removeObject(textField);
        if (!wrongCommand){
            wrongCommand = true;
            HealthBar.looseHealth();
        }
    }
}
