import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class snail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Snail extends SmoothMover
{
    GreenfootImage snail = new GreenfootImage("snail.png");
    Explosion exp = new Explosion();
    int img_cell = 50;
    final int IMG_WIDTH = snail.getWidth()/6;
    final int IMG_HEIGHT = snail.getHeight()/3;
    int count = 0;
    int counter=0;

    public Snail(){
        super(new Vector(-3.0, 0));
        setImage(SpriteSheet.getSprite(snail, img_cell,  img_cell*3, img_cell*2, img_cell*4, IMG_WIDTH, IMG_HEIGHT));
    }

    /**
     * Act - do whatever the snail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        explosion();
        snailAnimation();
        move();
    }

    public void snailAnimation(){
        for (int i=1;i<10;i++){
            count++;
            if (count>150){
                setImage(SpriteSheet.getSprite(snail, img_cell*(i-1),  img_cell*3, img_cell*i, img_cell*4, IMG_WIDTH, IMG_HEIGHT));
                count = 0;
            }
        }
    }

    public void explosion(){
        counter++;
        if (getX() <= 0){         
            getWorld().addObject(exp, getX(), getY());
            getWorld().removeObject(this);
        }
        else if (isTouching(Alex.class) && counter > 300){
            HealthBar.looseHealth();
            counter = 0;
            getWorld().addObject(exp, getX(), getY());
            getWorld().removeObject(this);
        }

    }
}

