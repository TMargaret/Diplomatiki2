import greenfoot.*; 
import java.util.ArrayList; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Material
{
    int count = 0;
    private ArrayList<Material> myList2 = new ArrayList<Material>();

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
        if (myList2 !=null){
            myList2 = getWorldOfType(mainHouseRoom.class).getInvList();
            for (Material mat: myList2){
                if (mat.getMaterial()=="Key")
                {
                    setLocation(getX(),getY()-getImage().getHeight());
                    //getWorld().removeObject(this);
                    mainHouseRoom.doorList.remove(this);               
                    pickupSound.play();
                }
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