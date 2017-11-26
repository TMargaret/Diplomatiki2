import greenfoot.*;
import java.util.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4 extends World
{
    private int xOffset = 0;
    //private alex alex;
    private Alex alex;
    private boolean found;
    Unicorn unicorn = new Unicorn();
    private final static int SWIDTH = 1000;
    private final static int SHEIGHT = 600;
    private final static int WWIDTH = 3000;
    private final static int TWIDTH = 45;
    private final static int THEIGHT = TWIDTH;
    private final static int TILEOFFSET = TWIDTH/3;
    private final static String validSpaces = "WG";
    private final static String[] WORLD = {
            "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW",
            "BWBWBWBWWWWWWWWBWWWWWTWWWWWWWWWWWWTWWWWWTWWWWWWWWWWWWWWWWTWUWWWWB",
            "WBWBWBWBWWWWWWWWWWWWWTWWWWWWWWWWWWTWWWWWTWWWWWWWWWWWWWWWWTWWUWWWWB",
            "BWBWBWBWWWWWWWWBWWWWWTWWWUUUUUUUUUTWWTWWTWWWUUUUUUUWWUUUUUUUWWWWWWUWWWWB",
            "WBWBWBWBWWWWWUUUUUUUUTWWWTWWWWWWWWWWWTWWWWWWTWWWWWWWWWWWWWWUWWWWUUUWWWB",
            "BWBWBWBWWWWWWWWWWWWWWWWWWTWWWWWWWWWWWTWWWWWWTSWWWWWWWWWWWWWWWWWWWWB",
            "WBWBWBWBWWWWWWWWWWWWWWWWSTWWTWWUUUUUUUUUUUUUUUUTWWWWWWWWWWWWWWWWWWWB",
            "BWBWBWBWWWWWWWWWWWWWWWWWWTWWTWWWWWWWWWWTWWWTWWWTWWWWWWWWWWWWWWWWWWWWWB",
            "WBWBWBWBWWWWWUUUUUUUUTWWWTWWTWWWWWWWWWSTWWWWWWWUUUUUUTWWWWWWWWWWWWWWWWWB",
            "BWBWBWBWWWWWWWWWWWWWWTWWWTWWUUUUUUTWWWWTWWWWWWWWWWWWWTWWWWWWWWWWWWUWWB",
            "WBWBWBWBWWWWWWWWWWWWWTWWWTWWWWWWWWTWWWWTWWWTWWWWWWWWWTWWWWWWWWWWWWWWWWWB",
            "BWBWBWBWWWWWWWWWWWWWWTWWWWWWWWWWWWTWWWWWWWWTWWWTWWWWWTWWWWWWWWWWWW",
            "WBWBWBWBWWWWWWWWWWWWWTWWWWWWTWWWWWTWWWWWWWWTWWWTWWWWWTWWWWWWWWWWWWWW",
            "UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU"
        };

    /**
     * Constructor for objects of class Level4.
     * 
     */
    public Level4()
    {    
        //super(1000, 600, 1, false); 
        super(SWIDTH, SHEIGHT, 1, false);       
        createWorldFromTiles();
        shiftWorld(0);
        prepare();

    }

    private void prepare()
    {
        addWall();
        alex = new Alex();
        addObject(alex, 450, 250);
        addObject(unicorn, 800,520);
        addObject(new Ant(), 2330,500);
        addObject(new Ant(), 2410,87);
        //addObject(new Spider(), 1050,250);
        addObject(new Snake(), 1470,90);
        // addObject(new Mouse(), 1000,200);
        addObject(new Snake(), 1470,500);
    }
    
    public void act(){
        boolean doNotMove = false;
        if (unicorn.getTalking()){
            doNotMove  = true;
        }
        System.out.println(doNotMove);
        alex.setCanMove(!doNotMove);
    }
    


    public void shiftWorld(int dx) {
        if( (xOffset + dx) <= 0 && (xOffset + dx) >= (SWIDTH - WWIDTH)) {
            xOffset = xOffset+dx;
            shiftWorldActors(dx);
        }

    }

    private void shiftWorldActors(int dx) {
        List<ScrollingActor> saList =
            getObjects(ScrollingActor.class);
        for( ScrollingActor a : saList ) {
            a.setAbsoluteLocation(dx);
        }
    }

    private void createWorldFromTiles() {
        for( int i=0; i < WORLD.length; i++ ) {
            for( int j=0; j < WORLD[i].length(); j++ ) {
                addActorAtTileLocation(WORLD[i].charAt(j), j, i);
            }
        }
    }

    private void addActorAtTileLocation(char c, int x, int y) {
        Actor tile = null;
        switch(c) {
            case 'W':
            tile = new Floor();
            break;
            case 'B':
            tile = new Rose();
            break;
            case 'U':
            tile = new WallBlock();
            break;
            case 'T':
            tile = new Wall3();
            break;
            case 'S':
            tile = new SignBlock();
            break;
        }
        if( tile != null) addObject(tile, TILEOFFSET+x*TWIDTH,
                TILEOFFSET+y*THEIGHT);
    }

    public int getTileWidth() {
        return TWIDTH;
    }

    public int getTileHeight() {
        return THEIGHT;
    }

    public int getTileOffset() {
        return TILEOFFSET;
    }

    public String[] getStringWorld() {
        return WORLD;
    }

    public int getXalex() {
        return alex.getX()-xOffset;
    }

    public int getYalex() {
        return alex.getY();
    }

    public String getValidSpaces() {
        return validSpaces;
    }

    
    /**
     * Method addWall. Builds the wall that holds healthbar, inventory and exit
     *
     */
    public void addWall(){
        Wall[] wall = new Wall[25];
        // Wall[] wall2 = new Wall[25];

        for(int j=0; j<wall.length; j++){
            wall[j]=new Wall();
            // wall2[j] = new Wall();
            addObject(wall[j],j*wall[j].getImage().getWidth(), wall[j].getImage().getHeight()/2);
            //addObject(wall2[j],j*wall2[j].getImage().getWidth(), getHeight() - wall[j].getImage().getHeight()/2);
        }
    }
    
    public void initVar(){
        if (HealthBar.getHealth()<=0){
            //lvl.stop();
            //found = false;
        }
    }
    
    
    /**
     * Method checkUnlockLevel is to set the unlocked level only once, no matter how many times the
     * player will play the same level
     */
    public void checkUnlockLevel(){
        if (LevelsScreen.unlock.size() < 4)
        {
            LevelsScreen.unlock.add(1);
        }
    }

}

