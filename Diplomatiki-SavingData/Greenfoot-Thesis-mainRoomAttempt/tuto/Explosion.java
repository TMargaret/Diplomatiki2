import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends DropItem
{
    GreenfootImage explosion = new GreenfootImage("explosion.png");
    int img_cell = 128;
    final int IMG_WIDTH = explosion.getWidth()/8;
    final int IMG_HEIGHT = explosion.getHeight()/5;
    int count = 0;

    public Explosion(){
        setImage(SpriteSheet.getSprite(explosion, 0,  img_cell, img_cell, IMG_WIDTH, IMG_HEIGHT));

    }

    /**
     * Act - do whatever the explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        explosion();

    }

    public void explosion(){
        for (int i=0; i<40; i++){
            count++;
            if (count>200){
                setImage(SpriteSheet.getSprite(explosion, i,  img_cell, img_cell, IMG_WIDTH, IMG_HEIGHT));
                count = 0;
            }
        }
    }    
}
