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
    //private InvBar invBar;
    private mainHouse my_mainHouse;
    private Straw straw, straw2;
    private Clay clay;
    private ArrayList <Hut> hutList = new ArrayList<Hut>();

    private ArrayList <Material> matList = new ArrayList<Material>();
    //Inventory inv;
    boolean isEDown = false;
    //boolean invIsOpen = false;

    mainHouseRoom usedMainHouseRoom;
    Level_1 level1;

    int counter = 100, btn_counter = 50;
    boolean isActive = false;
    private TextPanel textPanel;

    //Button inventoryBtn, exitBtn;
    //private static String[] items;
    public double time;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Level_1()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);       
        prepare();
        // items = new String[1];
        //usedMainHouseRoom = new mainHouseRoom(this);
    }

    public void act(){
        boolean found = false;
        for(Hut hut : hutList){
            if ((hut.getActive()) || (isActive) ){
                found  = true;
            }
        }
        for(Material material : matList){
            if (material.getActive()){
                found  = true;
            }
        }
        alex.setCanMove(!found);
        enterInRoom();

        //addToInventory();
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

        alex = new Alex();
        addObject(alex,79,525);

        ExitBar exitBar = new ExitBar();
        addObject(exitBar,984,18);

        // invBar = new InvBar();
        // addObject(invBar,947,18);

        // inventoryBtn = new Button(invBar.getImage().getWidth(), invBar.getImage().getHeight());
        // inventoryBtn.setResponder(this);
        // addObject(inventoryBtn, 947, 18);

        straw = new Straw();
        addObject(straw,957,513);

        straw2 = new Straw();
        addObject(straw2,614,511);

        matList.add(straw);
        matList.add(straw2);
        
        clay = new Clay();
        addObject(clay,309,389);
        matList.add(clay);
    }

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
        Hut oldHut = new Hut();
        addObject(oldHut,129,287);

        Hut oldHut2 = new Hut();
        addObject(oldHut2,883,287); 

        hutList.add(oldHut);
        hutList.add(oldHut2);
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
            if (counter < 0 && isEDown && isActive){
                removeObject(textPanel);
                counter = 100;
                isActive = false;
                isEDown = false;
                alex.setLocation(alex.getX(), alex.getY() + 100);

                // Greenfoot.setWorld(new mainHouseRoom());
            }  

        } 
    }

    // public void buttonClicked(Button button)
    // {   
        // //button event listener
        // if (Greenfoot.mouseClicked(inventoryBtn) && !invIsOpen)
        // {
            // inv = new Inventory();
            // addObject(inv, invBar.getX() - (inv.getImage().getWidth()/2), 
                // invBar.getY() + (invBar.getImage().getHeight()/3) + (inv.getImage().getHeight()/2));
            // invIsOpen = true;
        // }
        // else if (Greenfoot.mouseClicked(inventoryBtn) && invIsOpen)
        // {
            // removeObject(inv);
            // invIsOpen = false;
        // }

    // }

    // public void addToInventory(){
        // if(System.currentTimeMillis() > time + 500){
            // if(straw.getAddToInv())
            // {
                // addItem("straw");
                // straw.setAddToInv();
                // time = System.currentTimeMillis();
            // }
            // if(straw2.getAddToInv())
            // {
                // addItem("straw");
                // straw2.setAddToInv();
                // time = System.currentTimeMillis();
            // }
            // if(clay.getAddToInv())
            // {
                // addItem("clay");
                // clay.setAddToInv();
                // time = System.currentTimeMillis();
            // }

        // }
    // }

    // public static String[] getItems()
    // {
        // return items;
    // }

    // public static void changeItems(String[] newItems)
    // {
        // items = newItems;
    // }

    // public static void addItem(String newItem)  
    // {  
        // int x = items.length;  
        // String[] temp = new String[x];  
        // for (int i = 0; i < x; i++) 
            // temp[i] = items[i];  
        // items = new String[x + 1];  
        // for (int i = 0; i < x; i++) 
            // items[i] = temp[i];  
        // items[x] = newItem;  
    // }
}
