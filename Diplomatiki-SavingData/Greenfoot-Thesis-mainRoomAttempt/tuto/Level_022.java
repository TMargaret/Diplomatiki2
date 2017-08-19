import greenfoot.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_022 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_022 extends World
{

    SpriteSheet spriteSheet = new SpriteSheet();
    Alex alex;
    int img_cell = 32;
    GreenfootImage alexImg = new GreenfootImage("alex.png");
    final int IMG_WIDTH = alexImg.getWidth()/6;
    final int IMG_HEIGHT = alexImg.getHeight()/4;
    Material mat;
    SpecialEffect specialEffect;
    int count_item = 0;
    Dragon dragon;

    /**
     * Constructor for objects of class Level_022.
     * 
     */
    public Level_022()
    {
        super(1000, 600, 1);
        alex = new Alex();
        prepare();

    }

    public Level_022(Alex oldAlex)
    {
        super(1000, 600, 1);
        alex = oldAlex;
        prepare();
    }

    public void act(){
        //gameOver();
        specialEffect();
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
        image.setColor(new Color(40,40,40));
        image.fill();
        setBackground(image);

        addWall();

        alex.setImage(SpriteSheet.getSprite(alexImg, img_cell*3,  img_cell*2, img_cell*4, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
        addObject(alex,80, 500);

        dragon = new Dragon();
        addObject(dragon,830,153);

        specialEffect = new SpecialEffect();

    }

    public void addWall(){
        Wall[] wall = new Wall[25];
        Wall[] wall2 = new Wall[25];

        //builds the right vertical paths
        for(int i=0; i<=getHeight(); i+= 80)
        {
            Wall wall_vert = new Wall();
            addObject(wall_vert, getWidth() - wall_vert.getImage().getWidth()/4,i);
            wall_vert.setRotation(90);
        }

        //builds the left vertical paths
        for(int i=0; i<=getHeight()-160; i+= 80)
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

    public int getRandomNumber(int start,int end)
    {
        int normal = Greenfoot.getRandomNumber(end-start+1);
        return normal+start;
    }

    public void specialEffect(){
        //makes the specialEffect appear within the borders
        int random_x = getRandomNumber(alex.getImage().getWidth()*2,getWidth() - alex.getImage().getWidth()*4);
        random_x += 20;
        int random = Greenfoot.getRandomNumber(1);
        count_item++;
        for (int i = 0; i < 4; i++)
        {
            if (random == 0 & count_item == 80)
            {             
                addObject(specialEffect, random_x, specialEffect.getImage().getHeight()/2+45);
                count_item = 0;
            }
        }
    }
}
