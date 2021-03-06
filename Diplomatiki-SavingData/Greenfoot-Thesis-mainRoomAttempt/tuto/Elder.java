import greenfoot.*;
import java.util.List;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elder extends Locals
{
    private GreenfootImage knight = getImage();
    private GreenfootImage knight_eyes = new GreenfootImage("knight41.png");
    int countEnterTotal = 8;

    public Elder(){
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

    public String getTextMessage(){
        String text = "";
        int textCase = getCount_Enter();
        switch (textCase){
            case 0: text = "welcomeMsg";
            break;
            case 1: text = "taskText1";
            break;
            case 2: text = "taskText2";
            break;
            case 3: text = "taskText3";
            break;
            case 4: text = "taskText4";
            break;
            case 5: text = "taskText5";
            break;
            case 6: text = "taskText6";
            break;
            case 7: text = "taskText7";
            break;
            case 8: text = "taskText8";
            break;
        }
        return text;
    }

    public void setImage1(){
        setImage(knight);
    }

    public void setImage2(){
        setImage(knight_eyes);
    }
    
    public int getCountEnterTotal(){
        return countEnterTotal;
    }
}
