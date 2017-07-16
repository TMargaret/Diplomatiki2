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
    int imageID = 0;

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

    /**
     * Method explosion - gets the spritesheet of explosion image and show the images based on ID
     *
     */
    public void explosion(){
        if (imageID < 41){
            setImage(SpriteSheet.getSprite(explosion, imageID,  img_cell, img_cell, IMG_WIDTH, IMG_HEIGHT));
            imageID++;
        }else {
            imageID = 0;
            getWorld().removeObject(this);
        }
    }    
}
