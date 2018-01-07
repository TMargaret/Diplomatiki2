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
    Actor tile;
    int counter = 150;
    private ArrayList<SignBlock> sbList = new ArrayList<SignBlock>();
    private ArrayList<Material> materialList = new ArrayList<Material>();
    private ArrayList <Material> pickUpList = new ArrayList<Material>();
    GreenfootSound lvl4 = new GreenfootSound("level4.wav");
    Unicorn unicorn = new Unicorn();
    Material mat;
    Axe axe, axe2, axe3;
    private final static int SWIDTH = 1000;
    private final static int SHEIGHT = 600;
    private final static int WWIDTH = 3800;
    private final static int TWIDTH = 45;
    private final static int THEIGHT = TWIDTH;
    private final static int TILEOFFSET = TWIDTH/3;
    private final static String validSpaces = "WG";
    private final static String[] WORLD = {
            "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWTBBBBBB",
            "BWBWBWBWWWWWWWWBWWWWWTWWWWWWWWWWWWTWWWWWTWWWWWWWWWWWWWWWWTWWWWWWWWWWWWWWWWWWTBBBBBB",
            "WBWBWBWBWWWWWWWWWWWWWTWWWWWWWWWWWWTWWWWWTWWWWWWWWWWWWWWWWTWWWWWWWWWWWWWWWWWDTBBBBBB",
            "BWBWBWBWWWWWWWWBWWWWWTWWWUUUUUUUUUTWWTWWTWWWUUUUUUUWWUUUUTWWWUUUUUUUUUUUUUUUTBBBBBB",
            "WBWBWBWBWWWWWUUUUUUUUTWWWTWWWWWWWWWWWTWWWWWWTWWWWWWWWWWWWWWWWTBWBBWWWWWBWBWBWBBBBBB",
            "BWBWBWBWWWWWWWWWWWWWWWWWWTWWWWWWWWWWWTWWWWWWTWSWWWWWWWWWWWWWWTWBWWBBWWWBWBWBWBBBBBB",
            "WBWBWBWBWWWWWWWWWWWWWWWWSTWWTWWUUUUUUUUUUUUUUUUTWWWWWWWWWUUUUUUUUUUUUUUUTWWWWWBBBBB",
            "BWBWBWBWWWWWWWWWWWWWWWWWWTWWTWWWWWWWWWWTWWWTWWWTWWWWWWWWWTWWWWWSWTWWWWWWTWWWWWBBBBB",
            "WBWBWBWBWWWWWUUUUUUUUTWWWTWWTWWWWWWWWWSTWWWWWWWUUUUUUTWWWTWWWWWWWTWWWWWWTWWWWWBBBBB",
            "BWBWBWBWWWWWWWWWWWWWWTWWWTWWUUUUUUTWWWWTWWWWWWWWWWWWWTWWWTWWWWWWWTWWWUUUTWWWWWBBBBB",
            "WBWBWBWBWWWWWWWWWWWWWTWWWTWWWWWWWWTWWWWTWWWTWWWWWWWWWTWWWTWWWTWWWTWWWTWWWWWWWWBBBBB",
            "BWBWBWBWWWWWWWWWWWWWWTWWWWWWWWWWWWTWWWWWWWWTWWWTWWWWWTWWWWWWWTWWWWWWWTWWWWWWWWBBBBB",
            "WBWBWBWBWWWWWWWWWWWWWTWWWWWWTWWWWWTWWWWWWWWTWWWTWWWWWTWWWWWWWTWWWWWWWTWWWWWWWWBBBBB",
            "UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU"
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
        //lvl4.playLoop();

    }

    private void prepare()
    {
        addWall();
        alex = new Alex();
        axe = new Axe();
        axe2 = new Axe();
        axe3 = new Axe();
        materialList.add(axe);
        materialList.add(axe2);
        materialList.add(axe3);
        addObject(alex, 450, 250);
        addObject(unicorn, 800,520);
        addObject(new Ant(), 2330,500);
        addObject(new Ant(), 2410,87);
        addObject(new Snake(), 1470,90);
        addObject(new Snake(), 3200,360);
        addObject(new Snake(), 1470,500);
    }

    public void act(){
        boolean doNotMove = false;
        if (unicorn.getTalking() || (alex.getAnIntersectingObject(DoorBlock.class) != null)){
            doNotMove  = true;
        }
        for(SignBlock act : sbList){
            if ((act.getTalking())){
                doNotMove  = true;
            }
        }
        for (Material material : materialList){
            if(material.getWorldOfType(Level4.class) == null){
                pickUpList.add(material);
                mat = material; //save to material to mat so as to remove without concurrent exception
            }
            if (material.getActive()){
                doNotMove  = true;
            }
        }
        endGame();
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
        tile = null;
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
            sbList.add((SignBlock)tile);
            break;
            case 'D':
            tile = new DoorBlock();         
            break;
        }
        if( tile != null) addObject(tile, TILEOFFSET+x*TWIDTH,
                TILEOFFSET+y*THEIGHT);
    }

    public void endGame(){

        if ((alex.getAnIntersectingObject(DoorBlock.class) != null)){
            counter--;
            if (counter<0){               
                Greenfoot.setWorld(new DLevel_4(alex));

            }
        }
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

}
