import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.*;
//import java.awt.GraphicsEnvironment;
import java.util.*;
/**
 * Image of the main interface
 * 
 * @author erdelf
 * @version 1.0
 */
public class InvBar extends SpriteSheet
{

    GreenfootImage bar = new GreenfootImage("bar.png");
    GreenfootImage bar2 = new GreenfootImage("oldBar.jpg");
    GreenfootImage myEffect, myEffect2;

    int img_cell_x = 37;
    int img_cell_y = 43;

    int counter = 0;

    final int OFFSET = 4;

    public InvBar(){
        myEffect = getSprite(bar, img_cell_x*14,  0, img_cell_x*15, img_cell_y - OFFSET, img_cell_x, img_cell_y);
        setImage(myEffect);
    }

    public void act(){
    }

    public void specialEffect(){
        myEffect2 = getSprite(bar2, img_cell_x*14,  0, img_cell_x*15, img_cell_y - OFFSET, img_cell_x, img_cell_y);
        setImage(myEffect2);


    }

}