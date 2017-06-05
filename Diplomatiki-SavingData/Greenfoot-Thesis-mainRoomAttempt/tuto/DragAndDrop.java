import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class DragAndDrop extends Actor
{
    int dragX;
    int dragY;
    boolean dragging;
    
    public DragAndDrop()
    {
        dragX = 0;
        dragY = 0;
        dragging = false;
    }
    public void act() 
    {
        // Add your action code here.
        drag();
    }   
    public void open()
    {
        
    }
    public void close()
    {
        
    }
    public void drag()
    {
        if(mouseOver() && leftMousePress())
        {
            //has started dragging this menu
            dragging = true;
            dragX = Greenfoot.getMouseInfo().getX() - getX();
            dragY = Greenfoot.getMouseInfo().getY() - getY();
        }
        else if(leftMouseRelease())
        {
            //dragging as ended
            dragging = false;
        }
        
        if(dragging && Greenfoot.getMouseInfo() != null)
        {
            int newX = Greenfoot.getMouseInfo().getX() - dragX;
            int newY = Greenfoot.getMouseInfo().getY() - dragY;
            if(newX - getImage().getWidth()/2 < 0)//makes sure x inbound
            {
                newX = getImage().getWidth()/2;
            }
            if(newX + getImage().getWidth()/2 > getWorld().getWidth()-1)
            {
                newX = getWorld().getWidth()-1 - getImage().getWidth()/2;
            }
            if(newY - getImage().getHeight()/2 < 0)//makes sure y inbound
            {
                newY = getImage().getHeight()/2;
            }
            if(newY + getImage().getHeight()/2 > getWorld().getHeight()-1)
            {
                newY = getWorld().getHeight()-1 - getImage().getHeight()/2;
            }
            
            setLocation(newX, newY);
        }
    }
    public boolean mouseOver()
    {
        if(Greenfoot.getMouseInfo() == null) return false;
        int mouseX = Greenfoot.getMouseInfo().getX();
        int mouseY = Greenfoot.getMouseInfo().getY();
        return mouseX > getX() - getImage().getWidth()/2 && 
               mouseX < getX() + getImage().getWidth()/2 &&
               mouseY > getY() - getImage().getHeight()/2 && 
               mouseY < getY() + getImage().getHeight()/2 ;
    }//return true if mouse is within this object('s image)
    public boolean leftMousePress()
    {
        if(Greenfoot.getMouseInfo() == null) return false;
        return Greenfoot.getMouseInfo().getButton() == 1 && Greenfoot.mousePressed(null);
    }
    public boolean rightMousePress()
    {
        if(Greenfoot.getMouseInfo() == null) return false;
        return Greenfoot.getMouseInfo().getButton() == 3 && Greenfoot.mousePressed(null);
    }
    public boolean leftMouseRelease()
    {
        if(Greenfoot.getMouseInfo() == null) return false;
        return Greenfoot.getMouseInfo().getButton() == 1 && Greenfoot.mouseClicked(null);
    }
    public boolean rightMouseRelease()
    {
        if(Greenfoot.getMouseInfo() == null) return false;
        return Greenfoot.getMouseInfo().getButton() == 3 && Greenfoot.mouseClicked(null);
    }
}

