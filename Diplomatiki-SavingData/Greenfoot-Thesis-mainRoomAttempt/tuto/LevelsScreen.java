import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

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
    HoverFrame hoverFrame1, hoverFrame2, hoverFrame3, hoverFrame4, hoverFrame5, hoverFrame6;

    LockLevel locklevel, locklevel2, locklevel3, locklevel4, locklevel5;
    boolean mouseOver = false, mouseOver2 = false;

    ArrayList<HoverFrame> hoverFrame = new ArrayList<HoverFrame>();
    /**
     * Constructor for objects of class LevelsScreen.
     * 
     */
    public LevelsScreen()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        prepare();
        StartScreen.startSound.play();
    }

    public void act(){
        menuHover();
        planetHover();
        setLevel();      
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
        
        hoverFrame1 = new HoverFrame();
        addObject(hoverFrame1,165,200);
        hoverFrame.add(hoverFrame1);
        
        hoverFrame2 = new HoverFrame();
        addObject(hoverFrame2,490,200);
        hoverFrame.add(hoverFrame2);

        hoverFrame3 = new HoverFrame();
        addObject(hoverFrame3,815,200);
        hoverFrame.add(hoverFrame3);

        hoverFrame4 = new HoverFrame();
        addObject(hoverFrame4,165,460);
        hoverFrame.add(hoverFrame4);

        hoverFrame5 = new HoverFrame();
        addObject(hoverFrame5,490,460);
        hoverFrame.add(hoverFrame5);

        hoverFrame6 = new HoverFrame();
        addObject(hoverFrame6,815,460);
        hoverFrame.add(hoverFrame6);

    }
    
    public void setLevel(){
        if (Greenfoot.mouseClicked(hoverFrame1)){
            Greenfoot.setWorld(new Level_0());
            StartScreen.startSound.stop();
        }
    }

    public void menuHover(){
        if (Greenfoot.mouseMoved(menuBtn))
        {
            lbl.setFillColor(new Color(128,128,128));
            mouseOver = true;
        }
        if (mouseOver && !Greenfoot.mouseMoved(menuBtn) && Greenfoot.mouseMoved(null))
        {
            lbl.setFillColor(Color.WHITE);
            mouseOver = false;
        }
    }

    public void planetHover(){
        if (mouseOver2 && Greenfoot.mouseMoved(null)){
            hoverFrame1.setTrans(0);
            hoverFrame2.setTrans(0);
            hoverFrame3.setTrans(0);
            hoverFrame4.setTrans(0);
            hoverFrame5.setTrans(0);
            hoverFrame6.setTrans(0);
            mouseOver2 = false;
        }
        for (HoverFrame h: hoverFrame){
            if (Greenfoot.mouseMoved(h))
            {
                h.setTrans(100);
                mouseOver2 = true;
            }
        }
    }

    public void buttonClicked(Button button){
        if (Greenfoot.mouseClicked(menuBtn)){
            Greenfoot.setWorld(new StartScreen());
        }
        

    }

}
