import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelsScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelsScreen extends World implements ButtonResponder
{
    Label lbl;
    Button menuBtn;
    LockLevel locklevel, locklevel2, locklevel3, locklevel4, locklevel5;
    boolean mouseOver = false;
    /**
     * Constructor for objects of class LevelsScreen.
     * 
     */
    public LevelsScreen()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        prepare();
    }

    public void act(){
        menuHover();
    }

    public void prepare(){
        lbl = new Label("Μενού", 50);
        lbl.setFillColor(Color.WHITE);
        addObject(lbl, 70, 30);

        menuBtn = new Button(lbl.getImage().getWidth(), lbl.getImage().getHeight());
        addObject(menuBtn, 70, 30);
        menuBtn.setResponder(this);

        locklevel = new LockLevel();
        addObject(locklevel,806,440);

        locklevel2 = new LockLevel();
        addObject(locklevel2,471,440);

        locklevel3 = new LockLevel();
        addObject(locklevel3,804,170);

        locklevel4 = new LockLevel();
        addObject(locklevel4,153,440);

        locklevel5 = new LockLevel();
        addObject(locklevel5,473,170);
    }

    public void menuHover(){
        if (Greenfoot.mouseMoved(menuBtn))
        {
            lbl.setFillColor(Color.RED);
            mouseOver = true;
        }
        if (mouseOver && !Greenfoot.mouseMoved(menuBtn) && Greenfoot.mouseMoved(null))
        {
            lbl.setFillColor(Color.WHITE);
            mouseOver = false;
        }
    }

    public void buttonClicked(Button button){
        if (Greenfoot.mouseClicked(menuBtn)){
            Greenfoot.setWorld(new StartScreen());
        }

    }

}
