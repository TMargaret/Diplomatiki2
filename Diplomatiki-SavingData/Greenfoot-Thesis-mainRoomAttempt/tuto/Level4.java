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
    private boolean found, isOn = false, getAnswer = false, notEnough = false;
    boolean isOnDoor = false, evaluate = false;
    String correctAns;
    Actor tile;
    int signNum = 0;
    int counter = 150;
    String answer = "";
    String wrightAnswer = "0011";
    private ArrayList<SignBlock> sbList = new ArrayList<SignBlock>();
    private ArrayList<Material> materialList = new ArrayList<Material>();
    private ArrayList <Material> pickUpList = new ArrayList<Material>();
    static GreenfootSound lvl4 = new GreenfootSound("level4.wav");
    Unicorn unicorn = new Unicorn();
    Material mat;
    SignBlock signB;
    Axe axe, axe2, axe3;
    TextPanel textPanel;
    Button btn1 = new Button();
    Button btn2 = new Button();
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
        super(SWIDTH, SHEIGHT, 1, false);       
        createWorldFromTiles();
        shiftWorld(0);
        prepare();
        lvl4.playLoop();

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
        if (unicorn.getTalking() || isOnDoor || alex.getIsExit() || HealthBar.getHealth()<=0){
            doNotMove  = true;
        }

        for (SignBlock act : sbList){
            if ((act.getTalking())){
                doNotMove  = true;
                if (!isOn) {
                    isOn = true;
                    signNum++;
                    act.setSignNum(signNum);                  
                }
            }
            if(act.getWorldOfType(Level4.class) == null){
                signB = act;
                if (!getAnswer){
                    getAnswer = true;
                    answer += act.getCorrectAnswer();
                }
                getAnswer = false;
            }
        }
        sbList.remove(signB);
        for (Material material : materialList){
            if(material.getWorldOfType(Level4.class) == null){
                pickUpList.add(material);
                mat = material; //save to material to mat so as to remove without concurrent exception
            }
            if (material.getActive()){
                doNotMove  = true;
            }
        }
        if (doNotMove==false){
            isOn = false;
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
            isOnDoor = true;
            counter--;
            if (answer.length() < wrightAnswer.length() && !notEnough && isOnDoor){
                notEnough = true;
                textPanel = new TextPanel("notEnough");            
                addObject(textPanel, getWidth()/2, getHeight()/2);
            }
            if (Greenfoot.isKeyDown("enter") && notEnough){
                removeObject(textPanel);
                isOnDoor = false;
                notEnough =false;
                counter = 50;
                alex.setLocation(alex.getX() - 10, alex.getY());
            }
            if (answer.length() == wrightAnswer.length() && !(answer.contentEquals(wrightAnswer)) && counter<0 && !evaluate){
                evaluate = true;
                textPanel = new TextPanel("playOrLeave");            
                addObject(textPanel, getWidth()/2, getHeight()/2);
                addButton2();
                setBtn2();
                counter = 50;
            }
            if (Greenfoot.mouseClicked(btn1)){
                initVar();
                Greenfoot.setWorld(new Level4());                
            }
            if (Greenfoot.mouseClicked(btn2)){
                initVar();
                Greenfoot.setWorld(new LevelsScreen());              
            }
            if (answer.length() == wrightAnswer.length() && answer.contentEquals(wrightAnswer) && counter<0){               
                initVar();
                Greenfoot.setWorld(new DLevel_4(alex));               
            }
        }
    }

    public void addButton2(){
        addObject(btn1, textPanel.getImage().getWidth(), textPanel.getImage().getHeight());
        addObject(btn2, textPanel.getImage().getWidth(), textPanel.getImage().getHeight()+40);
    }

    public void setBtn2(){
        btn1.setTitle("NAI");
        btn2.setTitle("OXI");
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
        lvl4.stop();
        int signNum = 0;
        int counter = 150;
        String answer = "";
        evaluate = false;

    }

}
