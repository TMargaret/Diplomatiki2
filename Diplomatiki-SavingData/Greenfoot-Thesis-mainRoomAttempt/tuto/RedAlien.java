import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedAlien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedAlien extends Locals
{

    private GreenfootImage img = getImage();
    private GreenfootImage img_eyes = new GreenfootImage("alienRed2.png");
    /**
     * Act - do whatever the RedAlien wants to do. This method is called whenever
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
            case 0: text = "welcomeMsgL02";
            break;
            case 1: text = "taskText1L02";
            break;
            case 2: text = "taskText2L02";
            break;
            case 3: text = "taskText3L02";
            break;
            case 4: text = "taskText4L02";
            break;
            case 5: text = "taskText5L02";
            break;
            case 6: text = "taskText6L02";
            break;
        }
        return text;
    }

    public void setImage1(){
        setImage(img);

    }

    public void setImage2(){       
        setImage(img_eyes);
    }
}
