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
     * gives a random number so as to create a food
     */
    public DropItem()
    {
        this(2);
    }

    /**
     * creates random new Vector for each food
     */
    public DropItem(int y)
    {
        super(new Vector(0.0, y));
    }

    //sets the speed of every vector
    public void setSpeed(int y)
    {
        new Vector(0.0, y);
    }

    /**
     * every food will inherit the move method
     */
    public void act()
    {         
        move();
    }

}
