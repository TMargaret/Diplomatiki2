import greenfoot.*;
import java.io.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends World
{
    public int X_ROAD_HUT = 130;
    public int X_ROAD_HOUSE = 550;
    public int X_ROAD_HUT2 = 885;
    private Alex alex;
    private mainHouse my_mainHouse;
    private Straw straw, straw2;
    private Brick brick;
    private ArrayList <Hut> hutList = new ArrayList<Hut>();
    public static ArrayList <Material> matList = new ArrayList<Material>();//this is the initial list that holds the world's materials
    public static GreenfootSound lvl = new GreenfootSound("level3.mp3");
    private static ArrayList <Material> pickUpList; //this is the list that Alex is retrieving
    boolean isEDown = false;
    boolean noMaterial = false;
    int counter = 100, btn_counter = 50;
    boolean isActive = false;
    boolean hasEnter = false, hasEnter2 = false;
    private TextPanel textPanel;
    boolean displayMessage = false;
    boolean matIsTrue = false;
    boolean found = false;
    WaterWell waterwell;
    Lumber lumber;
    Hut oldHut;
    int count = 0;
    int count2 =0;
    int count_item = 0;
    mainHouseRoom mainHouseRoom;
    mainHutRoom mainHutRoom;
    int counterEnd = 300;
    Material mat;
    private GreenfootSound thankSound = new GreenfootSound("thank.wav");
    Snail snail;
    

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Level3()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        alex = new Alex();
        prepare();
        //found = false;
        pickUpList = new ArrayList<Material>();
        lvl.playLoop();
    }

    public Level3(Level3 level3, mainHouseRoom oldMainHouseRoom)
    {
        super(1000, 600, 1);
        //alex = oldAlex;
        mainHouseRoom = oldMainHouseRoom;
        level3.prepare();
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

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public void setmainHutRoom(mainHutRoom oldMainHutRoom){
        mainHutRoom = oldMainHutRoom;
    }

    public void act(){
        found = false;
        for(Hut hut : hutList){
            if ((hut.getActive()) || (isActive) || waterwell.getActive() ){
                found  = true;

            }
        }
        if (alex.getIsExit() || HealthBar.getHealth()<=0){
            found = true;
        }
        for(Material material : matList){
            if(material.getWorldOfType(Level3.class) == null){
                pickUpList.add(material);
                mat = material; //save material to mat so as to remove without concurrent exception

            }
            if (material.getActive()){
                found  = true;
            }
        }
        matList.remove(mat);
        alex.setCanMove(!found);
        setHutMatList(checkMatHutList());
        if (mainHouseRoom != null){
            setWaterWellList(mainHouseRoom.checkWellList());
        }
        enterInRoom();
        snail();
        endGame();
        initVar();  
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

        snail = new Snail();

        straw = new Straw();
        addObject(straw,680,520);
        matList.add(straw);  

        lumber = new Lumber(2, 1);
        addObject(lumber,283,485);
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
            if (counter < 0 && isEDown && isActive && !hasEnter2){
                removeObject(textPanel);
                counter = 100;
                isActive = false;
                isEDown = false;
                Greenfoot.setWorld(new mainHutRoom(alex,this));
                hasEnter2 = true;
            }  
            if (counter < 0 && isEDown && isActive && hasEnter2){
                removeObject(textPanel);
                counter = 100;
                isActive = false;
                isEDown = false;
                mainHutRoom.setAlex(alex);               
                Greenfoot.setWorld(mainHutRoom);
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

    public int checkMatHutList(){
        if (pickUpList != null){
            for (Material mat: pickUpList){
                if (mat.getMaterial() == "Wood"){
                    count++;
                }
                if (mat.getMaterial() == "Straw"){
                    count++;
                }
            }
        }
        return count;
    }

    public void setHutMatList(int count){
        oldHut.setCheckList(count);
    }

    public void setWaterWellList(int count){
        waterwell.setCheckList(count);
    }

    public int getRandomNumber(int start,int end)
    {
        int normal = Greenfoot.getRandomNumber(end-start+1);
        return normal+start;
    }

    public void snail(){
        //makes the snail appear within the borders
        // if (snail.getSpeed() == 0){
        // snail.addForce(new Vector(-3.0, 0));
        // }
        int random_y = getRandomNumber(getHeight()/2, getHeight()-snail.getImage().getHeight());
        random_y += 20;
        int random = Greenfoot.getRandomNumber(1);
        count_item++;
        for (int i = 0; i < 4; i++)
        {
            if (random == 0 & count_item == 80)
            {             
                addObject(snail, getWidth(), random_y);
                count_item = 0;
            }
        }
        
    }
    
    public void initVar(){
        if (HealthBar.getHealth()<=0){
            snail.stop();
            lvl.stop();
            found = false;
        }
    }

    public void endGame(){
        if (waterwell.getEndOfUse()){
            counterEnd--;
            if (counterEnd<0 && !displayMessage){
                thankSound.play();
                displayMessage = true;
                textPanel = new TextPanel("wellDone2");
                addObject(textPanel, getWidth()/2, getHeight()/2);
            }
            if (Greenfoot.isKeyDown("enter") && displayMessage){
                removeObject(textPanel);
                lvl.stop();
                checkUnlockLevel();
                Greenfoot.setWorld(new LevelsScreen());               
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
