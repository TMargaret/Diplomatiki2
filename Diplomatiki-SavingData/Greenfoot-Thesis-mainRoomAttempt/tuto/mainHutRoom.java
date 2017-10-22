import greenfoot.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mainHutRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mainHutRoom extends World
{

    SpriteSheet spriteSheet = new SpriteSheet();
    Alex alex;
    Elder elder;
    Door door, door2;
    Lumber lumber, lumber2;
    Clay clay, clay2;
    StoneOven stoneOven;
    Brick brick, brick2;
    Key key;
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
     * Constructor for objects of class mainHutRoom.
     * 
     */
    public mainHutRoom()
    {
        super(1000, 600, 1);
        alex = new Alex();
        prepare();

    }

    public mainHutRoom(Alex oldAlex, Level_1 oldLevel1)
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
        if ((flag == 1) || (isActive)){
            doNotMove  = true;
        }
        for (Material material : materialList){
            if(material.getWorldOfType(mainHutRoom.class) == null){
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

        addWall();

        alex.setImage(SpriteSheet.getSprite(alexImg, img_cell*3,  img_cell*2, img_cell*4, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
        addObject(alex,90, 380);

        Barrel barrel = new Barrel();
        addObject(barrel,700,150);
        Barrel barrel2 = new Barrel();
        addObject(barrel2,712,180);
        Barrel barrel3 = new Barrel();
        addObject(barrel3,680,174);
        Barrel barrel4 = new Barrel();
        addObject(barrel4,712,203);
        Barrel barrel5 = new Barrel();
        addObject(barrel5,685,228);

        Barrel barrel6 = new Barrel();
        addObject(barrel6,329,158);
        Barrel barrel7 = new Barrel();
        addObject(barrel7,363,160);
        Barrel barrel8 = new Barrel();
        addObject(barrel8,343,187);
        Barrel barrel9 = new Barrel();
        addObject(barrel9,375,204);
        Barrel barrel10 = new Barrel();
        addObject(barrel10,335,221);

        Barrel barrel11 = new Barrel();
        addObject(barrel11,330,474);
        Barrel barrel12 = new Barrel();
        addObject(barrel12,342,503);
        Barrel barrel13 = new Barrel();
        addObject(barrel13,339,520);

        Crate crate = new Crate();
        addObject(crate,490,170);
        Crate crate2 = new Crate();
        addObject(crate2,540,171);
        Crate crate3 = new Crate();
        addObject(crate3,400,505);
        Crate crate4 = new Crate();
        addObject(crate4,500,200);
        
        key = new Key();
        addObject(key,702,556);
        materialList.add(key);
    }

    public void addWall(){
        //horizontal entrance up
        Wall wall72 = new Wall();
        addObject(wall72,42,300);
        Wall wall3 = new Wall();
        addObject(wall3,123,300);
        Wall wall4 = new Wall();
        addObject(wall4,197,300);
        Wall wall5 = new Wall();
        addObject(wall5,263,300);

        //horizontal entrance down
        Wall wall73 = new Wall();
        addObject(wall73,42,450);
        Wall wall6 = new Wall();      
        addObject(wall6,121,450);
        Wall wall7 = new Wall();
        addObject(wall7,191,450);
        Wall wall8 = new Wall();
        addObject(wall8,264,450);

        //vertical first up
        Wall wall10 = new Wall();
        addObject(wall10,283,240);
        wall10.setRotation(90);
        Wall wall11 = new Wall();
        addObject(wall11,283,180);
        wall11.setRotation(90);

        //horizontal up
        Wall wall12 = new Wall();
        addObject(wall12,305,120);      
        Wall wall13 = new Wall();
        addObject(wall13,385,120);
        Wall wall14 = new Wall();
        addObject(wall14,465,120);
        Wall wall15 = new Wall();
        addObject(wall15,540,120);
        Wall wall16 = new Wall();
        addObject(wall16,620,120);
        Wall wall9 = new Wall();
        addObject(wall9,700,120);

        //vertical path
        Wall wall17 = new Wall();
        addObject(wall17,750,140);
        wall17.setRotation(90);
        Wall wall18 = new Wall();
        addObject(wall18,750,220);
        wall18.setRotation(90);
        Wall wall19 = new Wall();
        addObject(wall19,750,300);
        wall19.setRotation(90);
        Wall wall20 = new Wall();
        addObject(wall20,750,380);
        wall20.setRotation(90);
        Wall wall21 = new Wall();
        addObject(wall21,750,460);
        wall21.setRotation(90);
        Wall wall22 = new Wall();
        addObject(wall22,750,540);
        wall22.setRotation(90);
        Wall wall23 = new Wall();
        addObject(wall23,750,573);
        wall23.setRotation(90);

        //vertical entrance down
        Wall wall24 = new Wall();
        addObject(wall24,285,470);
        wall24.setRotation(90);
        Wall wall25 = new Wall();
        addObject(wall25,285,550);
        wall25.setRotation(90);
        Wall wall26 = new Wall();
        addObject(wall26,285,630);
        wall26.setRotation(90);

        //horizontal down
        Wall wall27 = new Wall();
        addObject(wall27,315,590);
        Wall wall28 = new Wall();
        addObject(wall28,390,590);
        Wall wall29 = new Wall();
        addObject(wall29,470,590);
        Wall wall30 = new Wall();
        addObject(wall30,550,590);
        Wall wall31 = new Wall();
        addObject(wall31,630,590);
        Wall wall32 = new Wall();
        addObject(wall32,690,590);

        //shadow wall up
        Wall2 wall210 = new Wall2();
        addObject(wall210,40,319);
        Wall2 wall211 = new Wall2();
        addObject(wall211,120,319);
        Wall2 wall212 = new Wall2();
        addObject(wall212,200,319);
        Wall2 wall213 = new Wall2();
        addObject(wall213,264,319);
        //shadow wall
        Wall2 wall214 = new Wall2();
        addObject(wall214,345,140);
        Wall2 wall215 = new Wall2();
        addObject(wall215,420,140);
        Wall2 wall216 = new Wall2();
        addObject(wall216,500,140);
        Wall2 wall217 = new Wall2();
        addObject(wall217,570,140);
        Wall2 wall222 = new Wall2();
        addObject(wall222,650,140);
        Wall2 wall223 = new Wall2();
        addObject(wall223,690,140);

        //shadow wall down
        Wall2 wall218 = new Wall2();
        addObject(wall218,40,470);
        Wall2 wall219 = new Wall2();
        addObject(wall219,120,470);
        Wall2 wall220 = new Wall2();
        addObject(wall220,200,470);
        Wall2 wall221 = new Wall2();
        addObject(wall221,225,470); 
        
        Wall[] wall = new Wall[25];
        Wall[] wall2 = new Wall[25];

        for(int j=0; j<wall.length; j++){
            wall[j]=new Wall();
            wall2[j] = new Wall();
            addObject(wall[j],j*wall[j].getImage().getWidth(), wall[j].getImage().getHeight()/2);
        }
        
        

    }

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

}
