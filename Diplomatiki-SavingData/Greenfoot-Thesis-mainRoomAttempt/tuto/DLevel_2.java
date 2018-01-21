import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DLevel_2 extends DragonLevel
{
    Alex alex;
    d2 dragon2;

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public DLevel_2()
    {
        //prepare();
        dragon2 = new d2();
        addObject(dragon2,865,153);

    }

    public DLevel_2(Alex oldAlex)
    {
        super(oldAlex);
        alex = oldAlex;
        //prepare(); 
        dragon2 = new d2();
        addObject(dragon2,865,153);
        //suspenseSound.playLoop();
    }
    
    public void act(){
        endGame();
    }

    public void endGame(){
        if (dragon2.endLevel()){
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
        if (LevelsScreen.unlock.size() < 4)
        {
            LevelsScreen.unlock.add(1);
        }
    }

}