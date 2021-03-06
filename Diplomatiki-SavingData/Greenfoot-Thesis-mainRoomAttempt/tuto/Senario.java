import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Senario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Senario extends World
{
    int counter = 1600;
    Label lbl;
    TextMessage tm = new TextMessage("HOPE",1100);

    /**
     * Constructor for objects of class Senario.
     * 
     */
    public Senario()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        addObject(new TextMessage("ALEX",50),380,50);
        addObject(new TextMessage("PLEASE",250),620,150);
        addObject(new TextMessage("HELP US",430),280,250);

        addObject(new TextMessage("YOU ARE",600),100,300);
        addObject(new TextMessage("OUR ONLY",850),820,380);
        
        tm.getImage().scale(tm.getImage().getWidth()*4, tm.getImage().getHeight()*4);
        addObject(tm,500,300);

        lbl = new Label("press enter", 30);
        lbl.setFillColor(Color.WHITE);

    }
    public void act(){
        counter--;
        if (counter<0){
            Greenfoot.setWorld(new LevelsScreen());
        }
        if (counter<1300){
            addObject(lbl, 480, 580);

            if (Greenfoot.isKeyDown("enter")){
                Greenfoot.setWorld(new LevelsScreen());
            }
        }
        if (Greenfoot.isKeyDown("escape")){
            System.exit(0);
        }
    }
}
