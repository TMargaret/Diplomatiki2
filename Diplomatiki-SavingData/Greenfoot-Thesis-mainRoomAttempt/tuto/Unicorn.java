import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Unicorn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Unicorn extends Locals
{
    private GreenfootImage img = new GreenfootImage("uni.png");
    private GreenfootImage img2 = new GreenfootImage("uni2.png");
    int count = 0;

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
        setImage(img2);
    }
}
