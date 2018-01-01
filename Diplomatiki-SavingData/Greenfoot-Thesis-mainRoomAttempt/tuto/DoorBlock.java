import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoorBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoorBlock extends ScrollingObstacle
{
    HiddenSprite hs;
    public int hsWidth = getImage().getWidth()*3; 
    public int hsHeight = 70;
    private final int HS_OFFSET_X = 0;
    private final int HS_OFFSET_Y = 0;
    /**
     * Act - do whatever the DoorBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    protected void addedToWorld(World w)
    {
        addHiddenSprite(w);
    }

    public void addHiddenSprite(World w) {   
        hs = new HiddenSprite(this, hsWidth , hsHeight/2, HS_OFFSET_X, HS_OFFSET_Y, true);  
        w.addObject(hs, getX(), getY()); 
    }
}
