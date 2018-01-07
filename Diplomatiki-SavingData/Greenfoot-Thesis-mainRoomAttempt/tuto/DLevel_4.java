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
    int i = 0;
    private SimpleTimer timer = new SimpleTimer();
    SpaceShip spaceship = new SpaceShip();

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
        //suspenseSound.playLoop();
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
        endGame();
        checkDragon();
    }

    public void endGame(){
        if (endLevel()){
            Greenfoot.setWorld(new LevelsScreen());
            suspenseSound.stop();
            checkUnlockLevel();
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

    public boolean endLevel(){
        return endLevel;
    }

    /**
     * Method checkUnlockLevel is to set the unlocked level only once, no matter how many times the
     * player will play the same level
     */
    public void checkUnlockLevel(){
        if (LevelsScreen.unlock.size() < 5)
        {
            LevelsScreen.unlock.add(1);
        }
    }
}
