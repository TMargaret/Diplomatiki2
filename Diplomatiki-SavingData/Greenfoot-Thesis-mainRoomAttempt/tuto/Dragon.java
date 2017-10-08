import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragon extends SpriteSheet
{
    GreenfootImage dragon = new GreenfootImage("drag.png");
    GreenfootSound expSound = new GreenfootSound("dragon_fly.wav");
    int img_cell = 96;
    final int IMG_WIDTH = dragon.getWidth()/2;
    final int IMG_HEIGHT = dragon.getHeight()/2;
    int imageID = 5;
    int delay = 14;
    int counter = 30;
    int count_enter = 0;
    private TextPanel textPanel;
    boolean endLevel = false;

    public Dragon(){
        expSound.setVolume(90);
        setImage(getSprite(dragon, 0,  img_cell, img_cell, img_cell*2, IMG_WIDTH, IMG_HEIGHT));
    }

    /**
     * Act - do whatever the Dragon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animation();
        dragonDialogue();
        endGame();
    } 

    public void animation(){
        delay--;
        if (imageID < 8 && delay <0 ){   
            delay = 12;
            setImage(SpriteSheet.getSprite(dragon, imageID,  img_cell, img_cell,IMG_WIDTH, IMG_HEIGHT));
            imageID++;

        }
        if (imageID==8){
            imageID=5;
        }
        expSound.play();
    }

    public void dragonDialogue(){
        counter--;
        if (count_enter == 0 && counter <0){
            counter = 30;
            textPanel = new TextPanel("dragon0");
            getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
            count_enter = 1;
        }
        if (Greenfoot.isKeyDown("enter") && count_enter == 1 && counter <0){
            counter = 30;
            getWorld().removeObject(textPanel);
            textPanel = new TextPanel("dragon1");
            getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
            count_enter = 2;
        }
        if (Greenfoot.isKeyDown("enter") && count_enter == 2 && counter <0){
            counter = 30;
            getWorld().removeObject(textPanel);
            textPanel = new TextPanel("dragon2");
            getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
            count_enter = 3;
        }
        if (Greenfoot.isKeyDown("enter") && count_enter == 3 && counter <0){
            counter = 30;
            getWorld().removeObject(textPanel);       
            // textPanel = new TextPanel("dragon2");
            getWorld().addObject(new QuizPic(), getWorld().getWidth()/2, getWorld().getHeight()/2);
            count_enter = 4;
        }
    }

    public void endGame(){
        counter--;
        if (QuizPic.endLevel()){
            if (count_enter == 4 && counter <0){
                counter = 30;
                textPanel = new TextPanel("dragon3");
                getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
                count_enter = 5;
            }          
        }
        if (Greenfoot.isKeyDown("enter") && count_enter == 5 && counter < 0){
            endLevel = true;
            getWorld().removeObject(textPanel);
        }
    }

    public boolean endLevel(){
        return endLevel;
    }
}
