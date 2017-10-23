import greenfoot.*;
import java.io.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_1 extends World
{
    public int X_ROAD_HUT = 130;
    public int X_ROAD_HOUSE = 550;
    public int X_ROAD_HUT2 = 885;
    private Alex alex;
    private mainHouse my_mainHouse;
    private Straw straw, straw2;
    private Clay clay;
    private ArrayList <Hut> hutList = new ArrayList<Hut>();
    public static ArrayList <Material> matList = new ArrayList<Material>();//this is the initial list that holds the world's materials
    public static GreenfootSound lvl = new GreenfootSound("level3.mp3");
    private ArrayList <Material> pickUpList = new ArrayList<Material>(); //this is the list that Alex is retrieving
    boolean isEDown = false;
    boolean noMaterial = false;
    int counter = 100, btn_counter = 50;
    boolean isActive = false;
    boolean hasEnter = false;
    private TextPanel textPanel;
    boolean displayMessage = false;
    WaterWell waterwell;
    Lumber lumber;
    Hut oldHut;
    int count = 0;
    mainHouseRoom mainHouseRoom;
    int counterEnd = 300;
    Material mat;
    private GreenfootSound thankSound = new GreenfootSound("thank.wav");

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Level_1()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        alex = new Alex();
        prepare();
        //lvl.playLoop();
    }

    public Level_1(Level_1 level1, mainHouseRoom oldMainHouseRoom)
    {
        super(1000, 600, 1);
        //alex = oldAlex;
        mainHouseRoom = oldMainHouseRoom;
        level1.prepare();
    }

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public void setAlex(Alex oldAlex){
        alex = oldAlex;
        addObject(alex,79,525);
    }

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public void setmainHouseRoom(mainHouseRoom oldMainHouseRoom){
        mainHouseRoom = oldMainHouseRoom;
    }

    public void act(){
        boolean found = false;
        for(Hut hut : hutList){
            if ((hut.getActive()) || (isActive) || waterwell.getActive()){
                found  = true;

            }
        }
        for(Material material : matList){
            if(material.getWorldOfType(Level_1.class) == null){
                pickUpList.add(material);
                mat = material; //save material to mat so as to remove without concurrent exception

            }
            if (material.getActive()){
                found  = true;
            }
        }
        matList.remove(mat);
        alex.setCanMove(!found);
        setHouseMatList(checkMatList());
        setWaterWellList(checkMatList());
        System.out.println("mat"+matList.size());
        System.out.println(pickUpList.size());
        System.out.println(checkMatList());
        enterInRoom();
        endGame();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addGrass();
        addRoad();
        addHut();
        addWall();

        my_mainHouse = new mainHouse();
        addObject(my_mainHouse,506,303);

        waterwell = new WaterWell();
        addObject(waterwell,880,301);

        addObject(alex,79,525);

        straw = new Straw();
        addObject(straw,610,480);
        matList.add(straw);  

        lumber = new Lumber(2, 1);
        addObject(lumber,283,521);
        matList.add(lumber);
    }

    /**
     * Method addWall. Builds the wall that holds healthbar, inventory and exit
     *
     */
    public void addWall(){
        Wall[] wall = new Wall[25];

        for(int j=0; j<wall.length; j++){
            wall[j]=new Wall();
            addObject(wall[j],j*wall[j].getImage().getWidth(), wall[j].getImage().getHeight()/2);
        }
    }

    /**
     *Adds the olds hut in the world
     *
     * @param     none
     * @return    void
     */
    public void addHut()
    {
        // put your code here
        oldHut = new Hut();
        addObject(oldHut,129,287);
        hutList.add(oldHut);
    }

    /**
     * Adds the walkable paths
     */
    public void addRoad(){
        //creates a new array that holds the road actor
        Road[] roadArray=new Road[25];
        Road[] roadArray2=new Road[25];

        //iteration in order to build a horizontal path
        for(int j=0; j<roadArray.length; j++){
            roadArray[j]=new Road();
            roadArray2[j]=new Road();
            addObject(roadArray[j],j*roadArray[j].getImage().getWidth(),getHeight()- roadArray[j].getImage().getHeight()/2);
            // addObject(roadArray2[j],j*roadArray[j].getImage().getWidth(),getHeight()- roadArray[j].getImage().getHeight());
        }

        //builds the vertical paths
        for(int i=390; i<=540; i+=50)
        {
            Road road = new Road();
            Road road2 = new Road();
            Road road3 = new Road();
            addObject(road,X_ROAD_HUT,i);
            addObject(road2,X_ROAD_HOUSE,i);
            addObject(road3,X_ROAD_HUT2,i);
        }
    }

    /**
     * Method that adds the grass to the scenery
     *
     */
    public void addGrass(){
        //creates a new array that holds the grass actor
        Grass[] grass =new Grass[25];
        Grass[] grass2 =new Grass[25];

        //iteration in order to build a horizontal path
        for(int j=0;j<grass.length;j++){
            grass[j]=new Grass();
            grass2[j]=new Grass();
            addObject(grass[j],j*grass[j].getImage().getWidth(),getHeight()/2);
            addObject(grass2[j],j*grass[j].getImage().getWidth(),getHeight()/2 + grass[j].getImage().getHeight()/2); 
        }
    }

    /**
     * shows a message before entering the house
     */
    public void enterInRoom(){
        if (alex.getAnIntersectingObject(mainHouse.class) != null){
            counter--;
            if (Greenfoot.isKeyDown("e")){
                isEDown = true;
            }
            if (isEDown && !isActive){
                counter = 100;
                textPanel = new TextPanel("enteringRoom");
                addObject(textPanel, getWidth()/2, getHeight()/2);
                isActive = true;
            }
            if (counter < 0 && isEDown && isActive && !hasEnter){
                removeObject(textPanel);
                counter = 100;
                isActive = false;
                isEDown = false;
                alex.setLocation(alex.getX(), alex.getY() + 100);
                Greenfoot.setWorld(new mainHouseRoom(alex,this));
                hasEnter = true;
            }
            if (counter < 0 && isEDown && isActive && hasEnter){
                removeObject(textPanel);
                counter = 100;
                isActive = false;
                isEDown = false;
                mainHouseRoom.setAlex(alex);               
                Greenfoot.setWorld(mainHouseRoom);
            }
        }
        if ((alex.getAnIntersectingObject(Hut.class) != null) && oldHut.getEndOfUse()){
            counter--;
            if (Greenfoot.isKeyDown("e")){
                isEDown = true;
            }
            if (isEDown && !isActive){
                counter = 100;
                textPanel = new TextPanel("enteringRoom");
                addObject(textPanel, getWidth()/2, getHeight()/2);
                isActive = true;
            }
            if (counter < 0 && isEDown && isActive){
                removeObject(textPanel);
                counter = 100;
                isActive = false;
                isEDown = false;
                //alex.setLocation(alex.getX(), alex.getY() + 100);
                Greenfoot.setWorld(new mainHutRoom(alex,this));
            }  
        } 
    }

    /**
     * Method getMaterialList
     *
     * @return The return value
     */
    public ArrayList getMaterialList(){
        return pickUpList;
    }

    // public boolean dataToSave(){
    // if (matList == null){
    // return noMaterial = true;
    // }else{
    // return noMaterial = false;
    // }    
    // }

    public int checkMatList(){
        if (pickUpList != null){
            if (pickUpList.contains(straw)){
                count++;
            }
            if (pickUpList.contains(lumber)){
                count++;
            }
            if (pickUpList.contains(brick)){
                count++;
            }
        }
        return count;
    }

    public void setHouseMatList(int count){
        oldHut.setCheckList(count);
    }

    public void setWaterWellList(int count){
        waterwell.setCheckList(count);
    }

    public void endGame(){
        if (waterwell.getEndOfUse()){
            counterEnd--;
            if (counterEnd<0 && !displayMessage){
                thankSound.play();
                displayMessage = true;
                textPanel = new TextPanel("wellDone");
                addObject(textPanel, getWidth()/2, getHeight()/2);
            }
            if (Greenfoot.isKeyDown("enter") && displayMessage){
                removeObject(textPanel);
                Greenfoot.setWorld(new LevelsScreen());
                lvl.stop();
                checkUnlockLevel();
            }
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
