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
    HiddenSprite hs;
    private int hsWidth, hsHeight;
    private final int HS_OFFSET_X = 0;
    private final int HS_OFFSET_Y = 0;

    public SpaceShip(){
        setImage(ss);
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
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
        //Alex.removeItem("Wood");
       // Alex.removeItem("Straw");
        buildSound.play();
        getWorld().removeObject(textField);
    }
}
