import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HintBar extends SpriteSheet
{
    GreenfootImage hint = new GreenfootImage("bar.png");;

    int img_cell_x = 37;
    int img_cell_y = 43;

    private int[] coordinates = {0,0,0,0,0,0};

    final int OFFSET = 4;

    public HintBar(){
        setImage(getSprite(hint, 0,  0, img_cell_x, img_cell_y - OFFSET, img_cell_x, img_cell_y));
    }   
}
