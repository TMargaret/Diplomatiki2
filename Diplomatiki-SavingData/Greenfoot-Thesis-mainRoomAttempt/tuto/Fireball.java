import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class FireBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//public class Fireball extends SpriteSheet
public class Fireball extends SmoothMover
{
    GreenfootImage fireball = new GreenfootImage("fireball.png");
    Explosion exp = new Explosion();
    int img_cell = 64;
    final int IMG_WIDTH = fireball.getWidth()/8;
    final int IMG_HEIGHT = fireball.getHeight()/8;
    int count = 0;

    public Fireball(){
        super(new Vector(0.0, 3));
        setImage(SpriteSheet.getSprite(fireball, 0,  img_cell*6, img_cell, img_cell*7, IMG_WIDTH, IMG_HEIGHT));
    }

    /**
     * Act - do whatever the FireBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        explosion();
        fireballAnimation();
        move();
    }

    public void fireballAnimation(){
        for (int i=1;i<=8;i++){
            count++;
            if (count>50){
                setImage(SpriteSheet.getSprite(fireball, img_cell*(i-1),  img_cell*6, img_cell*i, img_cell*7, IMG_WIDTH, IMG_HEIGHT));
                count = 0;
            }
        }
    }

    public void explosion(){
        if ((getY() >= getWorld().getHeight() - getWorld().getHeight()/4) || isTouching(House.class) || isTouching(Lumber.class) || isTouching(Brick.class)){         
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

