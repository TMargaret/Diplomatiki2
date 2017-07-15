import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Level_0 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_0 extends World
{
    Alex alex;
    Alien alien;
    House house;

    Lumber lumber, lumber1;
    Brick brick, brick1;
    Material mat;
    int count = 0;
    int count_item = 0;
    private int OFFSET = 30;

    private ArrayList<Material> materialList = new ArrayList<Material>();
    private ArrayList <Material> pickUpList = new ArrayList<Material>();

    GreenfootImage img = new GreenfootImage("level0.png");

    /**
     * Constructor for objects of class Level_0.
     * 
     */
    public Level_0()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        setBackground(img);
        prepare();       
    }

    public void act(){
        boolean doNotMove = false;
        if (alien.getTalking() || house.getActive()){
            doNotMove  = true;
        }
        for (Material material : materialList){
            if(material.getWorldOfType(Level_0.class) == null){
                pickUpList.add(material);

                mat = material; //save to material to mat so as to remove without concurrent exception
            }
            if (material.getActive()){
                doNotMove  = true;
            }
        }
        materialList.remove(mat);
        alex.setCanMove(!doNotMove);
        setHouseMatList(checkMatList());
        fireBall();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addWall();
        addGrass();

        alien = new Alien();
        addObject(alien,941,490);

        house = new House();
        addObject(house,728,380);

        alex = new Alex();
        addObject(alex,679,525);

        lumber = new Lumber();
        addObject(lumber,71,564);

        lumber1 = new Lumber();
        addObject(lumber1,54,402);

        brick1 = new Brick();
        addObject(brick1,385,395);

        brick = new Brick();
        addObject(brick,399,571);

        materialList.add(lumber);
        materialList.add(lumber1);
        materialList.add(brick);
        materialList.add(brick1);

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
        Grass grass51 = new Grass();
        addObject(grass51,684,370);

        Grass grass52 = new Grass();
        addObject(grass52,727,370);

        Grass grass53 = new Grass();
        addObject(grass53,768,370);

        Grass grass54 = new Grass();
        addObject(grass54,812,370);

        Grass grass55 = new Grass();
        addObject(grass55,651,360);

        //creates a new array that holds the grass actor
        Grass[] grass =new Grass[25];
        Grass[] grass2 =new Grass[25];

        //iteration in order to build a horizontal path
        for(int j=0;j<grass.length;j++){
            grass[j]=new Grass();
            addObject(grass[j],j*grass[j].getImage().getWidth(),getHeight()/2+getHeight()/11);
        }
    }

    public ArrayList getMaterialList(){
        return pickUpList;
    }

    public int checkMatList(){
        if (pickUpList != null){
            for (Material mat: pickUpList){
                if (mat.getMaterial() == "Wood"){
                    count++;
                }
                if (mat.getMaterial() == "Brick"){
                    count++;
                }
            }
        }
        return count;
    }

    public void setHouseMatList(int count){
        house.setCheckList(count);
    }

    public void fireBall(){
        //makes the food appear within the borders

        Tree tree  = new Tree();
        Fireball fireBall = new Fireball();
        int random_x = Greenfoot.getRandomNumber(getWidth() - (OFFSET*2));
        random_x += 20;

        int random = Greenfoot.getRandomNumber(1);
        count_item++;
        for (int i = 0; i < 4; i++)
        {
            if (random == 0 & count_item == 80)
            {
                addObject(fireBall, random_x, -fireBall.getImage().getHeight());
                count_item = 0;
            }
        }
    }

    
}
