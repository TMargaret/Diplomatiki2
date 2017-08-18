import greenfoot.*;

/**
 * 
 * 
 * @author (Trifou Margaret) 
 * @version (1.0.0)
 */
public class DropItem extends SmoothMover
{
    
    /**
     * gives a random number so as to 
     */
    public DropItem()
    {
       //this(0,3);
    }

    /**
     * creates random new Vector for e
     */
    public DropItem(int direction)
    {
        super(new Vector(0, direction));
    }
    
    /**
     * creates random new Vector for ea
     */
    public DropItem(double x, double y)
    {
        super(new Vector(x, y));
    }

    //sets the speed of every vector
    public void setSpeed(int y)
    {
        new Vector(0.0, y);
    }

    /**
     * every will inherit the move method
     */
    public void act()
    {         
        move();
    }

}
