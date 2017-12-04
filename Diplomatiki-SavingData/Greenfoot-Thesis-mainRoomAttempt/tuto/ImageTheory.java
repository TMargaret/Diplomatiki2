import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class butterfly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ImageTheory extends Actor
{
    private static Counter counterLife;
    private Button next_button = new Button();
    Button count_button = new Button();
    private boolean flag_for_menu, flag_forward, flag_backward;
    private GreenfootImage img = new GreenfootImage("inhe.jpg");
    private int count_image = 1;
    private String quiz = "quiz";
    boolean isOn = false;

    public ImageTheory(){
        setImage(img);
    }

    /**
     * Act - do whatever the butterfly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (!isOn){
            isOn =true;
            addButtons();           
        }
        checkImage();
    }

    public void addButtons(){
        count_button.setTitle("1/7");
        getWorld().addObject(count_button, 665, count_button.getImage().getHeight()+count_button.getImage().getHeight()/4);
        next_button.setTitle("ΕΠΟΜΕΝΟ");
        getWorld().addObject(next_button, 665, 530);
    }

    public void checkImage()
    {
        if (Greenfoot.mouseClicked(next_button))
        {
            
            if (count_image < 7){
                count_image++;
                getImage().clear();
                setImage(new GreenfootImage("inhe"+count_image+".jpg"));
                count_button.setTitle(count_image+"/7");
            }
            if (count_image == 7){          
                next_button.setTitle("ΤΕΛΟΣ");
                count_image++;
                
            }
            else if (count_image > 7){
                removeButton();
                getWorld().removeObject(this);

            }
        }
    }

    public void removeButton(){
        if (getWorld().getObjects(Button.class) != null){
            getWorld().removeObjects(getWorld().getObjects(Button.class));
        }
    }

}
