import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Windmill here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceShip extends Material
{
    GreenfootImage ss = new GreenfootImage("spaceship.png");
    GreenfootImage ss2 = new GreenfootImage("spaceship2.png");
    GreenfootSound buildSound = new GreenfootSound("build.mp3");
    GreenfootSound startEngine = new GreenfootSound("startEngine.wav");
    int i=0;
    HiddenSprite hs;
    private int hsWidth, hsHeight;
    private final int HS_OFFSET_X = 0;
    private final int HS_OFFSET_Y = 0;
    boolean isDone = false;

    public SpaceShip(){
        setImage(ss);
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
        ss2.scale(ss2.getWidth()/2, ss2.getHeight()/2);
        super.hsHeight = 650;
        super.hsWidth = 320;
    }

    /**
     * Act - do whatever the Windmill wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        materialCreation();
        finish();
    } 

    /**
     * Method checkMaterial
     *
     * @return The correct answer value to be check
     */
    public String checkMaterial(){
        String materialAnswer = "Alex.useAll();";
        return materialAnswer;

    }

    public void actionMat(){
        buildSound.play();
        getWorld().removeObject(textField);
        setImage(ss2);
        isDone = true;
    }

    public void finish(){
        int counter = 200;
        if (isDone){
            counter--;
            startEngine.play();
            if (++i == 10){
                i = 0;
                setImage(ss2);
            }
            else if (i == 5){
                setImage(ss);               
            }
        }
    }
    
    public boolean getIsDone(){
        return isDone;
    }
    
    public void stopSound(){
        startEngine.stop();
    }

}
