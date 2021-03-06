import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class butterfly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Butterfly extends SmoothMover
{
    GreenfootImage butterfly = new GreenfootImage("butterfly.png");
    Explosion exp = new Explosion();
    int img_cell = 100;
    final int IMG_WIDTH = butterfly.getWidth()/10;
    final int IMG_HEIGHT = butterfly.getHeight()/10;
    int count = 0;

    public Butterfly(){
        super(new Vector(-5.0, 0));
        setImage(SpriteSheet.getSprite(butterfly, 0,  0, img_cell, img_cell, IMG_WIDTH, IMG_HEIGHT));
    }

    /**
     * Act - do whatever the butterfly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        explosion();
        butterflyAnimation();
        move();
    }

    public void butterflyAnimation(){
        for (int i=1;i<=10;i++){
            count++;
            if (count>50){
                setImage(SpriteSheet.getSprite(butterfly, img_cell*(i-1),  0, img_cell*i, img_cell, IMG_WIDTH, IMG_HEIGHT));
                count = 0;
            }
        }
    }

    public void explosion(){
        if (getX() <= 0){         
            getWorld().addObject(exp, getX(), getY());
            getWorld().removeObject(this);
        }
        else if (isTouching(Alex.class)){
            HealthBar.looseHealth();
            getWorld().addObject(exp, getX(), getY());
            getWorld().removeObject(this);
        }
    }
}

