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

        //addWall();

        alex.setImage(SpriteSheet.getSprite(alexImg, img_cell*3,  img_cell*2, img_cell*4, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
        addObject(alex,80, 90);

        //horizontal entrance up
        Wall wall2 = new Wall();
        addObject(wall2,42,300);
        Wall wall3 = new Wall();
        addObject(wall3,123,300);
        Wall wall4 = new Wall();
        addObject(wall4,197,300);
        Wall wall5 = new Wall();
        addObject(wall5,264,300);
        
        //horizontal entrance down
        Wall wall = new Wall();
        addObject(wall,42,450);
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
        addObject(wall27,315,600);
        Wall wall28 = new Wall();
        addObject(wall28,390,600);
        Wall wall29 = new Wall();
        addObject(wall29,470,600);
        Wall wall30 = new Wall();
        addObject(wall30,550,600);
        Wall wall31 = new Wall();
        addObject(wall31,630,600);
        Wall wall32 = new Wall();
        addObject(wall32,690,600);
  
        Wall2 wall210 = new Wall2();
        addObject(wall210,48,327);
        Wall2 wall211 = new Wall2();
        addObject(wall211,126,333);
        Wall2 wall212 = new Wall2();
        addObject(wall212,215,331);
        Wall2 wall213 = new Wall2();
        addObject(wall213,289,332);
        Wall2 wall214 = new Wall2();
        addObject(wall214,355,149);
        Wall2 wall215 = new Wall2();
        addObject(wall215,426,154);
        Wall2 wall216 = new Wall2();
        addObject(wall216,502,155);
        Wall2 wall217 = new Wall2();
        addObject(wall217,570,157);
        Wall2 wall218 = new Wall2();
        addObject(wall218,38,493);
        Wall2 wall219 = new Wall2();
        addObject(wall219,126,485);
        Wall2 wall220 = new Wall2();
        addObject(wall220,204,485);
        Wall2 wall221 = new Wall2();
        addObject(wall221,238,488);
   



        Wall2 wall222 = new Wall2();
        addObject(wall222,657,163);
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
        addObject(wall70,400,100);

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
        for(int i=0; i<=getHeight() - 160; i+= 80)
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
