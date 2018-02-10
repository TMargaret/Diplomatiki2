import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fun extends World
{
    private TextPanel startImage;
    private Button exit_button, forward_button, backward_button, count_button;
    private boolean flag_for_menu, flag_forward, flag_backward;
    private GreenfootImage fun_bk_img = new GreenfootImage("fun1.jpg");
    private int count_image;
    private String fun = "fun";

    /**
     * Constructor for objects of class Fun.
     * 
     */
    public Fun()
    {    
        // Create a new world
        super(1000, 600, 1);
        count_image = 1;
        flag_for_menu = false;
        flag_forward= false;
        flag_backward = false;
        setBackground(fun_bk_img);

        exit_button = new Button();
        exit_button.setTitle("ΜENOY");
        addObject(exit_button, exit_button.getImage().getWidth()/2, exit_button.getImage().getHeight()/2);

        //shows how many questions are left
        count_button = new Button();
        addObject(count_button, getWidth() - count_button.getImage().getWidth()/2, count_button.getImage().getHeight()/2);

        forward_button = new Button();
        forward_button.setTitle("ΕΠΟΜΕΝΟ");
        addObject(forward_button, getWidth() - forward_button.getImage().getWidth()/2, getHeight() - forward_button.getImage().getHeight()/2);

        backward_button = new Button();
        backward_button.setTitle("ΠΡΟΗΓΟΥΜΕΝΟ");
        addObject(backward_button, backward_button.getImage().getWidth()/2, getHeight() - backward_button.getImage().getHeight()/2);

        this.startImage = new TextPanel("start");
        addObject(startImage, getWidth()/2, getHeight()/2);

    }

    public void act()
    {
        checkImage();
    }

    public void checkImage()
    {
        //go back to main menu
        if (Greenfoot.mouseClicked(exit_button))
        {
            Greenfoot.setWorld(new LevelsScreen());
            flag_for_menu = true;
            flag_forward = false;
            flag_backward = false;
        }
        //removes textImage
        if (((Greenfoot.isKeyDown("enter")) & (flag_for_menu == false)))
        {
            removeObject(startImage);
            count_button.setTitle("1/14");
            flag_forward = true;
        }
        //forwarding images
        if (count_image < 14){
            if ((Greenfoot.mouseClicked(forward_button) & (flag_forward == true)))
            {
                count_image++;
                this.setBackground(fun+count_image+".jpg");
                count_button.setTitle(count_image+"/14");
                flag_backward = true;
            }
        }
        //backwarding images
        if (count_image>1){
            if ((Greenfoot.mouseClicked(backward_button) & (flag_backward==true)))
            {
                count_image--;
                forward_button.setTitle("ΕΠΟΜΕΝΟ");
                this.setBackground(fun+count_image+".jpg");
                count_button.setTitle(count_image+"/14");
            }
        }
        if (count_image >= 14){
            forward_button.setTitle("ΤΕΛΟΣ");
        }
    }
}
