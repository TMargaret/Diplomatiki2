import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.io.*;

/**
 * Write a description of class LevelsScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelsScreen extends World implements ButtonResponder
{
    Label lbl, lbl1;
    Button menuBtn, menuBtn1; 
    HoverFrame hoverFrame1, hoverFrame2, hoverFrame3, hoverFrame4, hoverFrame5, hoverFrame6;
    LockLevel locklevel6, locklevel2, locklevel3, locklevel4, locklevel5;

    boolean mouseOver = false, mouseOver2 = false;

    GreenfootSound enterSound = new GreenfootSound("enter.wav");

    ArrayList<HoverFrame> hoverFrame = new ArrayList<HoverFrame>();
    public static ArrayList<Integer> unlock = new ArrayList<Integer>(){
            {
                add(1);
                add(1);
                add(1);
                add(1);
                //add(1);
            }
        }; //1 for unlocked level0
    SaveState st;
    private int lvlState = 0;

    /**
     * Constructor for objects of class LevelsScreen.
     * 
     */
    public LevelsScreen()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        prepare();
        enterSound.setVolume(100);
        if (!StartScreen.startSound.isPlaying()){
            StartScreen.startSound.playLoop();
        }
    }

    public void act(){
        menuHover();
        planetHover();
        setLevel();  
        unlockLevel(); 
    }

    public void prepare(){
        lbl = new Label("Menu", 50);
        lbl.setFillColor(Color.WHITE);
        addObject(lbl, 70, 30);

        menuBtn = new Button(lbl.getImage().getWidth(), lbl.getImage().getHeight());
        addObject(menuBtn, 70, 30);
        menuBtn.setResponder(this);

        lbl1 = new Label("Rules", 50);
        lbl1.setFillColor(Color.WHITE);
        addObject(lbl1, 900, 30);

        menuBtn1 = new Button(lbl1.getImage().getWidth(), lbl1.getImage().getHeight());
        addObject(menuBtn1, 900, 30);
        menuBtn1.setResponder(this);

        locklevel2 = new LockLevel();
        addObject(locklevel2,473,170);      

        locklevel3 = new LockLevel();
        addObject(locklevel3,804,170);

        locklevel4 = new LockLevel();
        addObject(locklevel4,153,440);

        locklevel5 = new LockLevel();
        addObject(locklevel5,471,440);

        //locklevel6 = new LockLevel();
        //addObject(locklevel6,806,440);

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
            StartScreen.startSound.stop();
            enterSound.play();
            Greenfoot.setWorld(new Level1());
        }
        if (Greenfoot.mouseClicked(hoverFrame2) && !(getObjects(LockLevel.class).contains(locklevel2))){ 
            StartScreen.startSound.stop();
            enterSound.play();
            Greenfoot.setWorld(new Level2());
        }
        if (Greenfoot.mouseClicked(hoverFrame3) && !(getObjects(LockLevel.class).contains(locklevel3))){ 
            StartScreen.startSound.stop();
            enterSound.play();
            Greenfoot.setWorld(new Level3());
        }
        if (Greenfoot.mouseClicked(hoverFrame4) && !(getObjects(LockLevel.class).contains(locklevel4))){ 
            StartScreen.startSound.stop();
            enterSound.play();
            Greenfoot.setWorld(new Level4());
        }
        if (Greenfoot.mouseClicked(hoverFrame5) && !(getObjects(LockLevel.class).contains(locklevel5))){ 
            StartScreen.startSound.stop();
            enterSound.play();
            Greenfoot.setWorld(new Level5());
        }
        if (Greenfoot.mouseClicked(hoverFrame6)){ 
            StartScreen.startSound.stop();
            enterSound.play();
            Greenfoot.setWorld(new Fun());
        }
    }

    public void unlockLevel(){
        int size = readfile();
        switch (size){
            case 2:
            removeObject(locklevel2);
            break;
            case 3:
            removeObject(locklevel2);
            removeObject(locklevel3);
            break;
            case 4:
            removeObject(locklevel2);
            removeObject(locklevel3);
            removeObject(locklevel4);
            break;
            case 5:
            removeObject(locklevel2);
            removeObject(locklevel3);
            removeObject(locklevel4);
            removeObject(locklevel5);
            break;
            // case 6:
            // removeObject(locklevel6);
            // break;
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
        if (Greenfoot.mouseMoved(menuBtn1))
        {
            lbl1.setFillColor(new Color(128,128,128));
            mouseOver = true;
        }
        if (mouseOver && !Greenfoot.mouseMoved(menuBtn1) && Greenfoot.mouseMoved(null))
        {
            lbl1.setFillColor(Color.WHITE);
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
        if (Greenfoot.mouseClicked(menuBtn1)){
            Greenfoot.setWorld(new Rules());
        }
    }

  public static void writefile(int lvlSize)
    {
        FileWriter fw = null;
        try
        {
            fw = new FileWriter("data.txt");
            fw.write(Integer.toString(lvlSize));
        }
        catch (Exception e){ e.printStackTrace(); }
        finally
        {
            if(fw != null)
            {
                try { fw.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
    }

    public static int readfile()
    {
        String line = null;
        int value=0;
        FileReader file = null;
        try
        {
            file = new FileReader("data.txt");
            BufferedReader reader = new BufferedReader(file);
            line = reader.readLine();
            value = Integer.parseInt(line);
        }
        catch (FileNotFoundException e) {throw new RuntimeException("Error");}
        catch (IOException e) {throw new RuntimeException("Error");}
        finally
        {
            if(file != null)
                try {file.close();}
                catch (IOException e) {e.printStackTrace();}
        }

        return value;
    }

}
