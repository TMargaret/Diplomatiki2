import greenfoot.*;

/**
 * Write a description of class Bridge here.
 * @author (your name) @version (a version number or a date)
 */
public class Bridge extends Material
{
    String myAnswer = "1";
    int count = 0;
    boolean isFixed = false;

    GreenfootImage bB = new GreenfootImage("bB2.png");
    GreenfootSound buildSound = new GreenfootSound("build.mp3");

    public Bridge(){
        super.hsWidth = super.hsWidth/2;
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
        //myAnswer = "Alex.useAll();";
    }

    /* (World, Actor, GreenfootImage, Greenfoot and MouseInfo)*/

    /**
     * Act - do whatever the Bridge wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        materialCreation();

    }
    
    public void extraAction(){
      //  if (super.materialList.size()>=2){
            thisLvl = true;
        //}
    }

    public void actionSpelling(){
        getWorld().removeObject(textField);      
        isActive = false;
        isEDown = false;                         
    }

    @Override
    public void actionMat(){      
        getImage().clear();
        getWorld().getBackground().drawImage(bB, 380, 450);
        getWorld().removeObject(this);
        buildSound.play();
        isFixed = true;
    }

    public boolean getIsFixed(){
        return isFixed;
    }

    /**
     * Method checkMaterial
     *
     * @return The correct answer value to be check 
     */
    @Override
    public String checkMaterial(){
        return myAnswer;
    }
}
