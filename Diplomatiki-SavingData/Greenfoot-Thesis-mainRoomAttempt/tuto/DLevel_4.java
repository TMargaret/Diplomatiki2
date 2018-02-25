import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level_4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DLevel_4 extends DragonLevel
{
    d4 dragon4;
    boolean endLevel = false;
    int counter = 50;
    boolean isTrans = false;
    int countDown = 200;
    int i = 0;
    private SimpleTimer timer = new SimpleTimer();
    SpaceShip spaceship = new SpaceShip();
    GreenfootSound thankSound = new GreenfootSound("thank.wav");
    TextPanel textPanel;
    boolean displayMessage = false;

    /**
     * Constructor for objects of class Level_4.
     * 
     */
    public DLevel_4()
    {
        initVar();

    }

    public DLevel_4(Alex oldAlex)
    {
        super(oldAlex);
        alex = oldAlex;        
        alex.setCanMove(false);
        initVar();
        suspenseSound.playLoop();
    }

    public void initVar(){
        boolean endLevel = false;
        int counter = 50;
        boolean isTrans = false;
        int i = 0;
        dragon4 = new d4();
        addObject(dragon4,865,153);
        spaceship.getImage().setTransparency(0);
        addObject(spaceship,844,412);
    }

    public void act(){
        checkEnd();
        checkDragon();
        if (dragon4.getWorldOfType(DLevel_4.class)!=null){
            specialEffect();
        }
    }

    public void checkDragon(){
        if (getObjects(d4.class).isEmpty()){           
            counter--;
            if (counter<0){
                if (!isTrans){
                    isTrans = true;
                    timer.mark();
                }
                if (timer.millisElapsed()>5 && i<=255){               
                    isTrans = false;
                    spaceship.getImage().setTransparency(i);
                    timer.mark();
                    i++;
                }
                if (i>=255){
                    alex.setCanMove(true);
                }
            }
        }
    }

    public void checkEnd(){

        if (spaceship.getIsDone()){
            countDown--;
            if (countDown<0 && !displayMessage){
                thankSound.play();
                displayMessage = true;
                textPanel = new TextPanel("wellDone2");
                addObject(textPanel, getWidth()/2, getHeight()/2);
            }
            if (Greenfoot.isKeyDown("enter") && displayMessage){
                removeObject(textPanel);
                LevelsScreen.writefile(5);
                suspenseSound.stop();
                spaceship.stopSound();
                Greenfoot.setWorld(new LevelsScreen());
            }
        }
    }
}
