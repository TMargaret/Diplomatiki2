import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.awt.GraphicsEnvironment;
/**
 * Image of the main interface
 * 
 * @author erdelf
 * @version 1.0
 */
public class ExitBar extends SpriteSheet
{
    private boolean created;
    GreenfootImage hp;
    GreenfootImage lvl;
    GreenfootImage xp;

    GreenfootImage bar = new GreenfootImage("bar.png");;
    GreenfootImage stats;
    GreenfootImage img;
    int img_cell_x = 37;
    int img_cell_y = 43;

    private int[] coordinates = {0,0,0,0,0,0};
    private int version;
    final int OFFSET = 4;

    final int IMG_WIDTH = bar.getWidth()/4;
    final int IMG_HEIGHT =  img_cell_y - OFFSET;

    public ExitBar(){
        setImage(getSprite(bar, img_cell_x*15,  0, img_cell_x*16, img_cell_y - OFFSET, img_cell_x, img_cell_y));
        created = false;
    }

    public void act() 
    {

    }    

}
