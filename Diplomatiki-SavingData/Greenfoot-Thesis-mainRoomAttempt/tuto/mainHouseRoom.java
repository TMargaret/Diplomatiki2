import greenfoot.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mainHouseRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mainHouseRoom extends World
{

    SpriteSheet spriteSheet = new SpriteSheet();
    Alex alex;
    Elder elder;
    Door door, door2;
    Lumber lumber, lumber2;
    Clay clay, clay2;
    StoneOven stoneOven;
    Brick brick, brick2;
    Axe axe;
    int counter = 100, counter2 = 25, flag = 0;
    boolean isActive = false;
    boolean isEDown = false;
    TextPanel textPanel;
    private ArrayList <Door> doorList = new ArrayList<Door>();
    int img_cell = 32;
    GreenfootImage alexImg = new GreenfootImage("alex.png");
    final int IMG_WIDTH = alexImg.getWidth()/6;
    final int IMG_HEIGHT = alexImg.getHeight()/4;
    private ArrayList<Material> materialList = new ArrayList<Material>();
    private ArrayList <Material> pickUpList = new ArrayList<Material>();
    private static String[] items;
    public double time;
    Level_1 level1;
    Material mat;
    boolean flag2 = false;

    /**
     * Constructor for objects of class mainHouseRoom.
     * 
     */
    public mainHouseRoom()
    {
        super(1000, 600, 1);
        alex = new Alex();
        prepare();

    }

    public mainHouseRoom(Alex oldAlex, Level_1 oldLevel1)
    {
        super(1000, 600, 1);
        alex = oldAlex;
        level1 = oldLevel1;
        prepare();
    }

    public void act(){
        //gameOver();
        //enterRoomText();
        exitRoom();
        //checkAxe();
        boolean doNotMove = false;
        if (elder.getTalking() || (flag == 1) || (isActive)){
            doNotMove  = true;
        }
        for(Door door : doorList){
            if (door.getActive()){
                doNotMove  = true;
            }
        }
        for (Material material : materialList){
            if(material.getWorldOfType(mainHouseRoom.class) == null){
                pickUpList.add(material);
                mat = material; //save to material to mat so as to remove without concurrent exception

            }
            if (material.getActive()){
                doNotMove  = true;
            }
        }
        materialList.remove(mat);
        alex.setCanMove(!doNotMove);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void prepare()
    {
        // put your code here
        GreenfootImage image = new GreenfootImage(getWidth(), getHeight());
        image.setColor(Color.BLACK);
        image.fill();
        setBackground(image);

        door = new Door();
        addObject(door,713,225);

        door2 = new Door();
        addObject(door2,420,406);

        doorList.add(door);
        doorList.add(door2);

        addWall();

        alex.setImage(SpriteSheet.getSprite(alexImg, img_cell*3,  img_cell*2, img_cell*4, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
        addObject(alex,80, 90);

        elder = new Elder();
        addObject(elder,900,500);

        brick = new Brick();
        addObject(brick,100,260);
        brick.getImage().setTransparency(0);        

        brick2 = new Brick();
        addObject(brick2,100,460);
        brick2.getImage().setTransparency(0);


        // lumber = new Lumber();
        // addObject(lumber,100,400);
        // lumber2 = new Lumber();
        // addObject(lumber2,100,528);  

        // materialList.add(lumber);
        // materialList.add(lumber2);
        materialList.add(brick);
        materialList.add(brick2);

        StoneOven stoneoven = new StoneOven();
        addObject(stoneoven,910,129);
    }

    public void addWall(){
        Wall[] wall = new Wall[25];
        Wall[] wall2 = new Wall[25];

        //Room with Clay
        Wall wall79 = new Wall();
        addObject(wall79,712,81);
        wall79.setRotation(90);

        Wall wall80 = new Wall();
        addObject(wall80,958,294);

        Wall wall81 = new Wall();
        addObject(wall81,876,294);

        Wall wall82 = new Wall();
        addObject(wall82,795,294);

        Wall wall83 = new Wall();
        addObject(wall83,735,294);

        Wall wall84 = new Wall();
        addObject(wall84,712,137);
        wall84.setRotation(90);

        //Room with Wood      
        Wall wall70 = new Wall();
        addObject(wall70,400,200);

        Wall wall71 = new Wall();
        addObject(wall71,82,200);

        Wall wall72 = new Wall();
        addObject(wall72,164,200);

        Wall wall73 = new Wall();
        addObject(wall73,246,200);

        Wall wall74 = new Wall();
        addObject(wall74,328,200);

        Wall wall75 = new Wall();
        addObject(wall75,420,547);
        wall75.setRotation(90);

        Wall wall76 = new Wall();
        addObject(wall76,420,490);
        wall76.setRotation(90);

        Wall wall77 = new Wall();
        addObject(wall77,420,240);
        wall77.setRotation(90);

        Wall wall78 = new Wall();
        addObject(wall78,420,320);
        wall78.setRotation(90);

        //builds the right vertical paths
        for(int i=0; i<=getHeight(); i+= 80)
        {
            Wall wall_vert = new Wall();
            addObject(wall_vert, getWidth() - wall_vert.getImage().getWidth()/4,i);
            wall_vert.setRotation(90);
        }

        //builds the left vertical paths
        for(int i=150; i<=getHeight(); i+= 80)
        {
            Wall wall_vert2 = new Wall();
            addObject(wall_vert2, wall_vert2.getImage().getWidth()/4 ,i );
            wall_vert2.setRotation(90);
        }

        for(int j=0; j<wall.length; j++){
            wall[j]=new Wall();
            wall2[j] = new Wall();
            addObject(wall[j],j*wall[j].getImage().getWidth(), wall[j].getImage().getHeight()/2);
            addObject(wall2[j],j*wall2[j].getImage().getWidth(), getHeight() - wall[j].getImage().getHeight()/2);
        }

    }

    // public void enterRoomText(){
    // counter2--;
    // if (counter2 < 0 && flag == 0){
    // entranceText = new TextPanel("RoomEntranceText");
    // addObject(entranceText, getWidth()/2, getHeight()/2);
    // flag = 1;
    // }
    // if (Greenfoot.isKeyDown("enter")){
    // counter2 = 50;
    // removeObject(entranceText);
    // flag = 2;
    // }
    // }

    public void exitRoom(){
        if (alex.getX()<alex.getImage().getWidth()- alex.getImage().getWidth()/3){
            counter--;
            if (!isActive){
                textPanel = new TextPanel("exitRoom");
                addObject(textPanel, getWidth()/2, getHeight()/2);
                isActive = true;
            }
        }
        if (counter < 0){
            int img_cell = 32;
            counter = 50;
            removeObject(textPanel);
            initVariables();
            alex.setImage(spriteSheet.getSprite(alexImg, img_cell*3,  img_cell*2, img_cell*4, img_cell*3, 64, 64));
            alex.setLocation(alex.getX() + 100, alex.getY());
            level1.setAlex(alex);
            Greenfoot.setWorld(level1);
        }      
    }

    public void initVariables(){
        flag = 0;
        isActive = false;
    }

    public ArrayList getMaterialList(){
        return pickUpList;
    }

    // public void checkAxe(){
        // if (elder.addAxe() && !flag2){
            // flag2 = true;
            // axe = new Axe(); 
            // addObject(axe, 650, 100);
            // materialList.add(axe);
        // }
    // }
}
