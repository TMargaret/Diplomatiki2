import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpecialEffect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpecialEffect extends SpriteSheet
{
    GreenfootImage explosion = new GreenfootImage("light.png");
    GreenfootSound expSound = new GreenfootSound("light.wav");
    int img_cell = 128;
    final int IMG_WIDTH = explosion.getWidth()/4;
    final int IMG_HEIGHT = explosion.getHeight();
    int imageID = 0;
    int delay = 5;

    public SpecialEffect(){
        setImage(SpriteSheet.getSprite(explosion, 0,  0, img_cell, img_cell, IMG_WIDTH, IMG_HEIGHT));
        expSound.setVolume(90);

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
        if (imageID < 8){
            delay--;
            if (delay<=0){
                setImage(SpriteSheet.getSprite(explosion, imageID,  img_cell, img_cell, IMG_WIDTH, IMG_HEIGHT));
                imageID++;
                delay = 5;
            }
            expSound.play();

        }else {
            imageID = 0;
            getWorld().removeObject(this);
        }
    }   
}
