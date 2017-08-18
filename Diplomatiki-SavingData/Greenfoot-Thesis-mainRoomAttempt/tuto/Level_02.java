import greenfoot.*;
import java.io.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_02 extends World
{

    public int X_ROAD_HUT = 130;
    public int X_ROAD_HOUSE = 550;
    public int X_ROAD_HUT2 = 885;
    private Alex alex;
    Clay clay;
    Lumber lumber;
    Bridge bridge;
    House2 house2;
    RedAlien redalien;
    Grass grass27, grass28, grass31, grass32;
    private ArrayList <Hut> hutList = new ArrayList<Hut>();
    public static ArrayList <Material> matList = new ArrayList<Material>();//this is the initial list that holds the world's materials

    private ArrayList <Material> pickUpList = new ArrayList<Material>(); //this is the list that Alex is retrieving
    boolean isEDown = false;
    boolean noMaterial = false;
    int counter = 100, btn_counter = 50;
    boolean isActive = false;
    private TextPanel textPanel;
    int count_item = 0;
    int counterEnd = 200;
    boolean displayMessage = false;
    private GreenfootSound thankSound = new GreenfootSound("thank.wav");

    Material mat;
    Butterfly butterfly;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Level_02()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        alex = new Alex();
        prepare();
    }

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public void setAlex(Alex oldAlex){
        alex = oldAlex;
        addObject(alex,79,525);
    }

    public void act(){
        boolean found = false;
        for(Material material : matList){
            if(material.getWorldOfType(Level_02.class) == null){
                pickUpList.add(material);
                mat = material; //save material to mat so as to remove without concurrent exception

            }
            if (material.getActive()){
                found  = true;
                butterfly.stop();
            }
        }
        matList.remove(mat);
        alex.setCanMove(!found);
        enterInRoom();
        isBridgeFixed();
        if (!found && redalien.getDoneWithDialogue() && !displayMessage){
           butterfly();
        }
        endGame();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addGrass();
        addWall();

        bridge = new Bridge();
        addObject(bridge,400,455);

        house2 = new House2();
        addObject(house2,921,370);

        Grass grass42 = new Grass();
        addObject(grass42,938,471);
        Grass grass43 = new Grass();
        addObject(grass43,979,470);

        addObject(alex,79,525);

        redalien = new RedAlien();
        addObject(redalien,70,350);

        Sign sign = new Sign();
        addObject(sign,347,380);

        Sign sign2 = new Sign();
        addObject(sign2,347,560);

        lumber = new Lumber(1);
        lumber.getImage().scale(lumber.getImage().getWidth()/2, lumber.getImage().getHeight()/2);
        addObject(lumber,342,550);
        clay = new Clay(1);
        clay.getImage().scale(clay.getImage().getWidth()/2, clay.getImage().getHeight()/2);
        addObject(clay,342,375);
        
        butterfly = new Butterfly();

        matList.add(bridge);
        matList.add(lumber);
        matList.add(clay);     
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
     * Method that adds the grass to the scenery
     *
     */
    public void addGrass(){
        Grass grass26 = new Grass();
        addObject(grass26,400,400);
        grass27 = new Grass();
        addObject(grass27,400,440);
        grass28 = new Grass();
        addObject(grass28,400,480);
        Grass grass29 = new Grass();
        addObject(grass29,400,530);
        Grass grass34 = new Grass();
        addObject(grass34,400,560);
        Grass grass35 = new Grass();
        addObject(grass35,400,600);

        Grass grass30 = new Grass();
        addObject(grass30,630,400);
        grass31 = new Grass();
        addObject(grass31,630,440);
        grass32 = new Grass();
        addObject(grass32,630,480);
        Grass grass33 = new Grass();
        addObject(grass33,630,520);
        Grass grass36 = new Grass();
        addObject(grass36,630,560);
        Grass grass37 = new Grass();
        addObject(grass37,630,600);
        Grass grass75 = new Grass();
        addObject(grass75,464,405);
        Grass grass76 = new Grass();
        addObject(grass76,547,405);
        Grass grass77 = new Grass();
        addObject(grass77,470,529);
        Grass grass78 = new Grass();
        addObject(grass78,557,533);

        Grass grass44 = new Grass();
        addObject(grass44,836,404);
        Grass grass45 = new Grass();
        addObject(grass45,894,433);    
        //creates a new array that holds the grass actor
        Grass[] grass =new Grass[25];
        Grass[] grass2 =new Grass[25];

        //iteration in order to build a horizontal path
        for(int j=0;j<grass.length;j++){
            grass[j]=new Grass();
            grass2[j]=new Grass();
            addObject(grass[j],j*grass[j].getImage().getWidth(),getHeight()-235);
            // addObject(grass2[j],j*grass[j].getImage().getWidth(),getHeight()/2 + grass[j].getImage().getHeight()/2); 
        }
    }

    /**
     * shows a message before entering the house
     */
    public void enterInRoom(){
        if (alex.getAnIntersectingObject(House2.class) != null){
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
                alex.setLocation(alex.getX(), alex.getY() + 100);
                Greenfoot.setWorld(new Level_022(alex,this));
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

    public void isBridgeFixed(){
        if (bridge.getIsFixed()){
            removeObject(grass27);
            removeObject(grass28);
            removeObject(grass31);
            removeObject(grass32);
            for (Material mat: matList){
                Alex.flagForRemovedItem = false;
                Alex.removeFromInv(true);
            }
        }
    }
    
    public int getRandomNumber(int start,int end)
{
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
}

    public void butterfly(){
        //makes the butterfly appear within the borders
        if (butterfly.getSpeed() == 0){
            butterfly.addForce(new Vector(-3.0, 0));
        }
        int random_y = getRandomNumber(getHeight()/2, getHeight()-butterfly.getImage().getHeight()/2);
        random_y += 20;
        int random = Greenfoot.getRandomNumber(1);
        count_item++;
        for (int i = 0; i < 4; i++)
        {
            if (random == 0 & count_item == 80)
            {             
                addObject(butterfly, getWidth(), random_y);
                count_item = 0;
            }
        }
    }
    
        public void endGame(){
        if (bridge.getIsFixed()){
            counterEnd--;
            if (counterEnd<0 && !displayMessage){
                thankSound.play();
                displayMessage = true;
                textPanel = new TextPanel("wellDonelvl2");
                addObject(textPanel, getWidth()/2, getHeight()/2);
            }
            if (Greenfoot.isKeyDown("enter") && displayMessage){
                removeObject(textPanel);
                // Greenfoot.setWorld(new LevelsScreen());
                // level0Sound.stop();
                // checkUnlockLevel();
            }
        }
    }	
}
