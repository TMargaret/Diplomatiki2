import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragon extends SpriteSheet
{
    GreenfootImage dragon = new GreenfootImage("drag.png");
    int img_cell = 96;
    final int IMG_WIDTH = dragon.getWidth()/2;
    final int IMG_HEIGHT = dragon.getHeight()/2;
    int imageID = 5;
    int delay = 14;

    public Dragon(){
       setImage(getSprite(dragon, 0,  img_cell, img_cell, img_cell*2, IMG_WIDTH, IMG_HEIGHT));
    }

    /**
     * Act - do whatever the Dragon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        delay--;
        if (imageID < 8 && delay <0 ){   
            delay = 14;
            setImage(SpriteSheet.getSprite(dragon, imageID,  img_cell, img_cell,IMG_WIDTH, IMG_HEIGHT));
            imageID++;
            // expSound.play();
        }
        if (imageID==8){
            imageID=5;
        }
        // Add your action code here.
    }    
}
