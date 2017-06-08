import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LockLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LockLevel extends Actor
{
    GreenfootImage myImage = getImage();
    GreenfootImage frame;
    HiddenSprite hs;

    public LockLevel(){
        frame = new GreenfootImage(myImage.getWidth()*2, myImage.getHeight()*2);
        frame.setColor(Color.LIGHT_GRAY);
        frame.fill();
        frame.setTransparency(100);
        //myImage.setTransparency(100);
        // setImage(frame);

    }

    /**
     * Act - do whatever the LockLevel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        planetHover();

    } 

    // protected void addedToWorld(World w){
        // addHiddenSprite();
    // }

    // protected void addHiddenSprite() {   
        // hs = new HiddenSprite(this, 100 , 100, 0, 5, true);  
        // getWorld().addObject(hs, 10, 10);
    // }

    public void planetHover(){
        if (Greenfoot.mouseMoved(this)){
            setImage(frame);
            //System.out.println(myImage);
            //frame.clear();
            //frame.drawImage(myImage, , getY());
        }
    }

}
