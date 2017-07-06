import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien extends Locals
{

    private GreenfootImage img = getImage();
    private GreenfootImage img_eyes = new GreenfootImage("alien2.png");

    public Alien(){
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
        img.scale(img.getWidth()/4, img.getHeight()/5);
        img_eyes.scale(img_eyes.getWidth()/4, img_eyes.getHeight()/5);

    }

    public String getTextMessage(){
        String text = "";
        int textCase = getCount_Enter();
        switch (textCase){
            case 0: text = "welcomeMsgL0";
            break;
            case 1: text = "taskText1L0";
            break;
            case 2: text = "taskText2L0";
            break;
            case 3: text = "taskText3L0";
            break;
            case 4: text = "taskText4L0";
            break;
            case 5: text = "taskText5L0";
            break;
            case 6: text = "taskText6L0";
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