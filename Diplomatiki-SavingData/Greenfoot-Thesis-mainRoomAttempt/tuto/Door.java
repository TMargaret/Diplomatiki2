import greenfoot.*; 
import java.util.List; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Material
{
    int count = 0;

    /**
     * Door Constructor
     *
     */
    public Door(){

    }

    /**
     * Act - do whatever the Doorwants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkWorld();
        materialCreation();
    } 

    @Override
    public void actionMat(){
        for (Material mat: materialList){
            if (mat.getMaterial()=="Key")
            {
                mainHouseRoom.doorList.remove(this);
                getWorld().removeObject(this);
                pickupSound.play();
            }
        }
    }

    /**
     * Method getMaterial
     *
     * @return The material value, for the info message that appears in inputField
     */
    public String getMaterial(){
        String material = "Key";
        return material;
    }

    /**
     * Method checkMaterial
     *
     * @return The correct answer value to be check
     */
    public String checkMaterial(){
        String materialAnswer = "Alex.use(key);";
        return materialAnswer;
    }

}