import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Camel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Camel extends Locals
{
    private GreenfootImage img = getImage();
    private GreenfootImage img_eyes = new GreenfootImage("camel2.png");
    /**
     * Act - do whatever the Camel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        localsDialogue();
        blink();
    }  

    @Override
    public void inAction(){
        if (super.counter<0 && !super.isActive && super.isEDown && super.count_enter == 0){
            ImageTheory imgT = new ImageTheory("array",11, "jpg");
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

    public void setImage1(){
        setImage(img);

    }

    public void setImage2(){       
        setImage(img_eyes);
    }
}
