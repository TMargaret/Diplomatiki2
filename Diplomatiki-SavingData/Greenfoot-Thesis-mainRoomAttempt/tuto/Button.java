import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Creates Buttons
 * 
 * @author erdelf
 * @version 1.0
 */
public class Button extends Actor
{
    private String function;
    private String[] functions = {"inventory", "inventoryClose"};

    private int version;
    
     public Button()
    {
        GreenfootImage img = new GreenfootImage(10,10);
        //         img.setColor(Color.RED); img.fill(); // only for development
        setImage(img);
        // function = function2;
        // version = versions;
    }
    public Button(int x, int y, String function2, int versions)
    {
        GreenfootImage img = new GreenfootImage(x,y);
        //         img.setColor(Color.RED); img.fill(); // only for development
        setImage(img);
        function = function2;
        version = versions;
    }

    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            if(functions[0] == function)
            {
                if(!Inventory.getOpen())
                {                    
                    int x,y;
                    x = 0;
                    y = 0;

                        x = getWorld().getWidth() - 150; y = ((Bar) getWorld().getObjects(Bar.class).get(0)).getY() - 110;
                       
   
                    getWorld().addObject(new Inventory(), x, y);
                    Inventory.setOpen(true);
                }else 
                {
                    Actor ac = ((Actor)getWorld().getObjects(Inventory.class).get(0));
                    int x = 0;
                    int y = 0;
                    x = ac.getX() + 127; y = ac.getY() - 50; 
                    getWorld().removeObject(((Actor)getWorld().getObjectsAt(x,y,Button.class).get(0)));
                    getWorld().removeObject(ac);
                    Inventory.setOpen(false);
                }
            }
            if(functions[1] == function)
            {
                Inventory.setOpen(false);
                getWorld().removeObject(((Actor)getWorld().getObjects(Inventory.class).get(0)));
                getWorld().removeObject(this);
            }
        }
    }    
}