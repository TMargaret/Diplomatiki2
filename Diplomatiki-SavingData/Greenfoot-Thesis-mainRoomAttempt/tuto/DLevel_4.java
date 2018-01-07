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

    /**
     * Constructor for objects of class Level_4.
     * 
     */
    public DLevel_4()
    {
        dragon4 = new d4();
        addObject(dragon4,865,153);
    }

    public DLevel_4(Alex oldAlex)
    {
        super(oldAlex);
        alex = oldAlex; 
        dragon4 = new d4();
        addObject(dragon4,865,153);
        alex.setCanMove(false);
        //suspenseSound.playLoop();
    }
    
     public void act(){
        endGame();
    }

    public void endGame(){
        if (dragon4.endLevel()){
            Greenfoot.setWorld(new LevelsScreen());
            suspenseSound.stop();
            checkUnlockLevel();
        }
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
