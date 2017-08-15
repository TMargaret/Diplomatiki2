import greenfoot.*;

/**
 * Write a description of class CopyOfTree here.
 * @author (your name) @version (a version number or a date)
 */
public class CopyOfTree extends DropItem
{
    
   public CopyOfTree(){
       getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
    }

    /* (World, Actor, GreenfootImage, Greenfoot and MouseInfo)*/

    /**
     * Act - do whatever the CopyOfTree wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (getY() >= getWorld().getHeight() - 40) {
            getWorld().removeObject(this);
        }
        move();
    }
}
