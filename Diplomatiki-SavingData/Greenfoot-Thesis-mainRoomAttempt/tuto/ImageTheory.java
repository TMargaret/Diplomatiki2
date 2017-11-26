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
    private Button exit_button, forward_button, backward_button;
    Button count_button = new Button();
    private boolean flag_for_menu, flag_forward, flag_backward;
    private GreenfootImage img = new GreenfootImage("inhe.jpg");
    private int count_image;
    private String quiz = "quiz";
    boolean isOn = false;

    public ImageTheory(){
        setImage(img);
        img.setTransparency(200);
        count_image = 1;
        flag_for_menu = false;
        flag_forward= false;
        flag_backward = false;

        //shows how many questions are left
        // getWorld().addObject(count_button, 10, 10);

        forward_button = new Button();
        forward_button.setTitle("ΕΠΟΜΕΝΟ");
        //addObject(forward_button, img.getWidth() - forward_button.getImage().getWidth()/2, getHeight() - forward_button.getImage().getHeight()/2);

        backward_button = new Button();
        //backward_button.setTitle("ΠΡΟΗΓΟΥΜΕΝΟ");
        //addObject(backward_button, backward_button.getImage().getWidth()/2, getHeight() - backward_button.getImage().getHeight()/2);

    }

    /**
     * Act - do whatever the butterfly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (!isOn){
            isOn =true;
            getWorld().addObject(count_button, img.getWidth(), count_button.getImage().getHeight()+count_button.getImage().getHeight()/4);
        }
    }

    // public void checkImage()
    // {
    // if (((Greenfoot.isKeyDown("enter")) & (flag_for_menu == false)))
    // {
    // this.setBackground(img);
    // count_button.setTitle("1/14");
    // flag_forward = true;
    // }
    // //forwarding images
    // if (count_image < 14){
    // if ((Greenfoot.mouseClicked(forward_button) & (flag_forward == true)))
    // {
    // count_image++;
    // this.setBackground(quiz+count_image+".jpg");
    // count_button.setTitle(count_image+"/14");
    // flag_backward = true;
    // }
    // }
    // //backwarding images
    // if (count_image>1){
    // if ((Greenfoot.mouseClicked(backward_button) & (flag_backward==true)))
    // {
    // count_image--;
    // forward_button.setTitle("ΕΠΟΜΕΝΟ");
    // this.setBackground(quiz+count_image+".jpg");
    // count_button.setTitle(count_image+"/14");
    // }
    // }
    // if (count_image >= 14){
    // forward_button.setTitle("ΤΕΛΟΣ");
    // }
    // }

}
