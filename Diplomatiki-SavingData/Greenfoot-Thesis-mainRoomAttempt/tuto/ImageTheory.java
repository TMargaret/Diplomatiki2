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
    private Button next_button = new Button();
    private Button before_button = new Button();
    Button count_button = new Button();
    private boolean flag_for_menu, flag_forward, flag_backward;
    private GreenfootImage img;
    private int count_image = 1;
    boolean isOn = false;
    private int slides = 0;
    boolean isTwo = false;
    String myImg;
    String typeOfImg;

    public ImageTheory(){
        setImage(img);
    }
    
    public ImageTheory(String image, int slideNum, String typeOfImage){
        myImg = image;
        typeOfImg = typeOfImage;
        img = new GreenfootImage(myImg + count_image + "." + typeOfImg);
        slides = slideNum;
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
        count_button.setTitle("1/"+slides);
        getWorld().addObject(count_button, 690, 550);
        
        getWorld().addObject(next_button, 690, 50);
        before_button.setTitle("ΠΙΣΩ");
        
    }

    public void checkImage()
    {
        next_button.setTitle("ΕΠΟΜΕΝΟ");
        if (count_image==1 && before_button.getWorldOfType(getWorld().getClass())!=null){
            isTwo=false;
            getWorld().removeObject(before_button);
        }
        if (count_image==2 && !isTwo){
            isTwo=true;
            getWorld().addObject(before_button, 310, 50);
        }
        if (Greenfoot.mouseClicked(next_button))
        {           
            if (count_image < slides){
                
                count_image++;
                getImage().clear();
                setImage(new GreenfootImage(myImg + count_image + "." + typeOfImg));
                count_button.setTitle(count_image+"/"+slides);
            }
            if (count_image == slides){          
                next_button.setTitle("ΤΕΛΟΣ");
                count_image++;
                
            }
            else if (count_image > slides){
                removeButton();
                getWorld().removeObject(this);

            }
        }
        if (Greenfoot.mouseClicked(before_button))
        {
            if (count_image > slides){  
                count_image--;
            }
            
            if (count_image <= (slides+1)){
                
                count_image--;
                getImage().clear();
                setImage(new GreenfootImage(myImg+count_image+".jpg"));
                count_button.setTitle(count_image+"/"+slides);
            }


        }
    }

    public void removeButton(){
        if (getWorld().getObjects(Button.class) != null){
            getWorld().removeObjects(getWorld().getObjects(Button.class));
        }
    }

}
