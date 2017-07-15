import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//public class Fireball extends SpriteSheet
public class Fireball extends DropItem
{
    GreenfootImage fireball = new GreenfootImage("fireball.png");
    int img_cell = 64;
    final int IMG_WIDTH = fireball.getWidth()/8;
    final int IMG_HEIGHT = fireball.getHeight()/8;
    int count = 0;

    public Fireball(){
        setImage(SpriteSheet.getSprite(fireball, 0,  img_cell*6, img_cell, img_cell*7, IMG_WIDTH, IMG_HEIGHT));

    }

    /**
     * Act - do whatever the FireBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
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
}
    
