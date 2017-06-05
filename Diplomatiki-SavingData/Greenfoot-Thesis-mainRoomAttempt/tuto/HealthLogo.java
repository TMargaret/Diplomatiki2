import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

/**
 * Write a description of class HealthLogo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthLogo extends SpriteSheet implements Serializable
{
    //GreenfootImage bar = new GreenfootImage("bar.png");;

    int img_cell_x = 37;
    int img_cell_y = 43;

    // final int OFFSET = 4;
    // final int IMG_WIDTH = bar.getWidth()/4;
    // final int IMG_HEIGHT =  img_cell_y - OFFSET;

    public HealthLogo(){
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 30, image.getHeight() - 30);
        setImage(image);

        //  setImage(getSprite(bar, img_cell_x*6 + OFFSET,  0, img_cell_x*7 + OFFSET, img_cell_y - OFFSET, img_cell_x, img_cell_y));
    }
    /**
     * Act - do whatever the HealthLogo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }

}
