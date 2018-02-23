import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    Alex alex;
    Alien alien;
    House house;
    Fireball fireBall = new Fireball();

    Lumber lumber, lumber1;
    Brick brick, brick1;
    Material mat;
    int count = 0;
    int count_item = 0;
    int counterEnd = 300;
    TextPanel textPanel;
    boolean displayMessage = false;
    //private int OFFSET = alien.getImage().getWidth();

    private ArrayList<Material> materialList = new ArrayList<Material>();
    private ArrayList <Material> pickUpList = new ArrayList<Material>();
    public static GreenfootSound level0Sound = new GreenfootSound("level0.mp3");
    private GreenfootSound thankSound = new GreenfootSound("thank.wav");

    GreenfootImage img = new GreenfootImage("level0.png");

    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        setBackground(img);
        prepare(); 
        level0Sound.playLoop();
    }

    public void act(){
        boolean doNotMove = false;
        if (alien.getTalking() || house.getActive() || house.getEndOfUse() || alex.getIsExit() || (HealthBar.getHealth()<=0)){
            doNotMove  = true;
            fireBall.stop();
        }
        for (Material material : materialList){
            if(material.getWorldOfType(Level1.class) == null){
                pickUpList.add(material);
                mat = material; //save to material to mat so as to remove without concurrent exception
            }
            if (material.getActive()){
                doNotMove  = true;
                fireBall.stop();
            }
        }
        materialList.remove(mat);
        alex.setCanMove(!doNotMove);
        setHouseMatList(checkMatList());
        if (!doNotMove && alien.getDoneWithDialogue()){
            fireBall();
        }
        endGame();
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
        addObject(alien,950,523);

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

        Grass grass31 = new Grass();
        addObject(grass31,848,409);

        Grass grass32 = new Grass();
        addObject(grass32,837,434);

        Grass grass34 = new Grass();
        addObject(grass34,816,444);

        Grass grass35 = new Grass();
        addObject(grass35,859,445);

        setPaintOrder(Button.class,HealthLogo.class,HealthBar.class,
            InvBar.class, ExitBar.class,Wall.class);
    }

    /**
     * Method addWall. Builds the wall that holds healthbar, inventory and exit
     *
     */
    public void addWall(){
        Wall[] wall = new Wall[13];

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
        //makes the fireball appear within the borders
        if (fireBall.getSpeed() == 0){
            fireBall.addForce(new Vector(0.0, 2));
        }
        int random_x = Greenfoot.getRandomNumber(getWidth() - (alien.getImage().getWidth() + alien.getImage().getWidth()/2));
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

    public void endGame(){
        if (house.getEndOfUse()){
            counterEnd--;
            if (counterEnd<0 && !displayMessage){
                thankSound.play();
                displayMessage = true;
                textPanel = new TextPanel("wellDone");
                addObject(textPanel, getWidth()/2, getHeight()/2);
            }
            if (Greenfoot.isKeyDown("enter") && displayMessage){
                removeObject(textPanel);
                level0Sound.stop();
                LevelsScreen.writefile(2);
               // checkUnlockLevel();
                Greenfoot.setWorld(new LevelsScreen());              
            }
        }
    }	

    // /**
     // * Method checkUnlockLevel is to set the unlocked level only once, no matter how many times the
     // * player will play the same level
     // */
    // public void checkUnlockLevel(){
        // if (LevelsScreen.unlock.size() < 2)
        // {
            // LevelsScreen.unlock.add(1);
        // }
    // }

}
