import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class butterfly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class CopyOfButterfly extends SmoothMover
{
    GreenfootImage butterfly = new GreenfootImage("butterfly.png");
    Explosion exp = new Explosion();
    int img_cell = 100;
    final int IMG_WIDTH = butterfly.getWidth()/10;
    final int IMG_HEIGHT = butterfly.getHeight()/10;
    int count = 0;
    private boolean isGrabbed;
    public CopyOfButterfly(){

        //GreenfootImage img = getImage();

        //img.scale(img.getWidth()/10, img.getHeight()/10);
    }

    /**
     * Act - do whatever the butterfly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        /* in the 'act' method in the class of the Actor object to be dragged */
        // check for initial pressing down of mouse button
        if (Greenfoot.mousePressed(this) && !isGrabbed)
        {
            // grab the object
            isGrabbed = true;
            // the rest of this block will avoid this object being dragged UNDER other objects
            World world = getWorld();
            MouseInfo mi = Greenfoot.getMouseInfo();
            world.removeObject(this);
            world.addObject(this, mi.getX(), mi.getY());
            return;
        }
        // check for actual dragging of the object
        if ((Greenfoot.mouseDragged(this)) && isGrabbed)
        {
            // follow the mouse
            MouseInfo mi = Greenfoot.getMouseInfo();
            setLocation(mi.getX(), mi.getY());
            return;
        }
        // check for mouse button release
        if (Greenfoot.mouseDragEnded(this) && isGrabbed)
        {
            // release the object
            isGrabbed = false;
            return;
        }
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

