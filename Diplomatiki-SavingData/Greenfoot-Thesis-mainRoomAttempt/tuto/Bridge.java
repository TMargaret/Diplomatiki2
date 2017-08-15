import greenfoot.*;

/**
 * Write a description of class Bridge here.
 * @author (your name) @version (a version number or a date)
 */
public class Bridge extends Material
{
    String myAnswer;
    int count = 0;
    boolean thisLvl = false;

    public Bridge(){
        super.hsWidth = super.hsWidth/2;
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
        myAnswer = "Alex.use();";
    }

    /* (World, Actor, GreenfootImage, Greenfoot and MouseInfo)*/

    /**
     * Act - do whatever the Bridge wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        materialCreation();
        
    }

    public int checkMatList(){
        if (super.materialList != null){
            for (Material mat: materialList){
                if (mat.getMaterial() == "Clay"){
                    count++;
                }
                if (mat.getMaterial() == "Lumber"){
                    count++;
                }
            }
        }
        return count;
    }

    public void actionSpelling(){
        // switch(countUse){
        // case 0: 
        // dropSound.play();
        // countUse++;
        // textField.setText("Μένουν ακόμα: " + (getCheckList()-countUse));
        // Alex.removeFromInv(true);
        // break;
        // case 1:
        // dropSound.play();
        // countUse++;
        // textField.setText("Μένουν ακόμα: " + (getCheckList()-countUse));
        // Alex.flagForRemovedItem = false;
        // Alex.removeFromInv(true);
        // break;
        // case 2:
        // dropSound.play();
        // countUse++;
        // textField.setText("Μένουν ακόμα: " + (getCheckList()-countUse));
        // Alex.flagForRemovedItem = false;
        // Alex.removeFromInv(true);
        // break;
        // case 3: 
        // buildSound.play();
        // getWorld().removeObject(textField);
        // Alex.flagForRemovedItem = false;
        // Alex.removeFromInv(true);
        // isActive = false;
        // endOfUse = true;
        // setImage(bH);
        // setBuildHouse(true);                          
        // break;
        // }
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
