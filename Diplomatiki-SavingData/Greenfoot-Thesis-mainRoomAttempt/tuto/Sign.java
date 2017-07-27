import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sign here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sign extends Material
{
    GreenfootImage imgW = new GreenfootImage("signW.png");
    GreenfootImage imgC = new GreenfootImage("signC.png");

    public Sign(){
        super.hsWidth = 200;
        super.hsHeight = 200;
    }

    public Sign(GreenfootImage img){
        setImage(img);
    }

    /**
     * Act - do whatever the Sign wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkWorld();
        materialCreation();
        check();

    } 

    public void check(){
        if (getImage().equals(imgW)){
            System.out.println("ok");
        }
    }

}
