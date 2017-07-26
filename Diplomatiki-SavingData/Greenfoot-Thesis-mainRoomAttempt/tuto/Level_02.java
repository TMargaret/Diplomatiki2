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
    private Clay clay;
    private ArrayList <Hut> hutList = new ArrayList<Hut>();
    private ArrayList <Material> matList = new ArrayList<Material>();//this is the initial list that holds the world's materials

    private ArrayList <Material> pickUpList = new ArrayList<Material>(); //this is the list that Alex is retrieving
    boolean isEDown = false;
    boolean noMaterial = false;
    int counter = 100, btn_counter = 50;
    boolean isActive = false;
    private TextPanel textPanel;

    Material mat;

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
            }
        }
        matList.remove(mat);
        alex.setCanMove(!found);
        enterInRoom();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addGrass();
        addWall();

        addObject(alex,79,525);
        House2 house2 = new House2();
        addObject(house2,921,370);

        Grass grass26 = new Grass();
        addObject(grass26,400,400);
        Grass grass27 = new Grass();
        addObject(grass27,400,440);
        Grass grass28 = new Grass();
        addObject(grass28,400,480);
        Grass grass29 = new Grass();
        addObject(grass29,400,520);
        Grass grass34 = new Grass();
        addObject(grass34,400,560);
        Grass grass35 = new Grass();
        addObject(grass35,400,600);

        Grass grass30 = new Grass();
        addObject(grass30,630,400);
        Grass grass31 = new Grass();
        addObject(grass31,630,440);
        Grass grass32 = new Grass();
        addObject(grass32,630,480);
        Grass grass33 = new Grass();
        addObject(grass33,630,520);
        Grass grass36 = new Grass();
        addObject(grass36,630,560);
        Grass grass37 = new Grass();
        addObject(grass37,630,600);

        RedAlien redalien = new RedAlien();
        addObject(redalien,70,395);
        
        Sign sign = new Sign();
        addObject(sign,347,370);
        
        Sign sign2 = new Sign();
        addObject(sign2,347,560);
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

    public boolean dataToSave(){
        if (matList == null){
            return noMaterial = true;
        }else{
            return noMaterial = false;
        }    
    }
}
