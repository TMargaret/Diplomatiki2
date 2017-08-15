import greenfoot.*;

/**
 * Write a description of class Bridge here.
 * @author (your name) @version (a version number or a date)
 */
public class Bridge extends Material
{
    String myAnswer;
    int count = 0;

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

    @Override
    public void extraAction(){
        // if (checkMatList()< 2 && !msgActive){
        // msgActive = true;
        // counter = 150;
        // textPanel = new TextPanel("houseMsgL0");
        // getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
        // }
        // if (counter<0){ 
        // counter = 20;
        // getWorld().removeObject(textPanel);
        // isEDown = false;
        // }
        System.out.println(checkMatList());
        if (checkMatList()== 2){
            System.out.println("hm");
        }

    }
    public int checkMatList(){
        if (super.materialList != null){
            for (Material mat: super.materialList){
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
