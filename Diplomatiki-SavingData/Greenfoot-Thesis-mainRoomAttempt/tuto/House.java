import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class House here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class House extends Actor
{
    int counter = 10;
    int isEDownTwice= 0;
    int countMat = 0;
    int countUse = 0;
    boolean isEDown = false;
    boolean tryAgainOrLeave = false;
    boolean endOfUse = false;
    boolean isActive = false;
    boolean wrongCommand = false;
    boolean buildHouse = false;
    private TextPanel textPanel;
    Level_0 lvl_0;
    TextField textField;
    String my_text = "";
    GreenfootImage bH = new GreenfootImage("fixedHouse.png");
    Debugger db;

    public House(){
    }

    /**
     * Act - do whatever the House wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        canSeeAlex();
    } 

    public boolean getActive(){
        return isActive;
    }

    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }

    public void textFieldCreation(){

        textField = new TextField(700, 45,"Χρησιμοποίησε τα υλικά, ένα-ένα...");
        getWorld().addObject(textField, textField.getImage().getWidth()/2, getWorld().getHeight() - textField.getImage().getHeight()/2);
    }

    public void canSeeAlex(){
        if (getOneIntersectingObject(Alex.class) != null)
        {
            counter--;
            if (Greenfoot.isKeyDown("e")){
                isEDown = true;
            }
            if (getCheckList()< 4){
                if (isEDown && !isActive){
                    counter = 30;
                    textPanel = new TextPanel("houseMsgL0");
                    getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
                    isActive = true;
                }
                if (counter<0 && Greenfoot.isKeyDown("enter") && isActive){
                    isActive = false;
                    isEDown = false;
                    counter = 20;
                    getWorld().removeObject(textPanel);
                }
            }
            if (getCheckList() == 4 && !endOfUse){
                if (isEDown && !isActive && !endOfUse){
                    isActive = true;
                    counter = 20;
                    textFieldCreation();
                }

                if (Greenfoot.mouseClicked(textField) && isEDown){
                    textField.setText("");
                }
                if (Greenfoot.isKeyDown("escape") && isEDown){
                    getWorld().removeObject(textField); 
                    isActive = false;
                    isEDown = false;
                } 
                if (counter < 0 && Greenfoot.isKeyDown("enter") && isEDown){
                    counter = 30;
                    db = new Debugger(textField.getText(),"Alex.use();");
                    if (db.checkSpelling())
                    {
                        switch(countUse){
                            case 0: 
                            countUse++;
                            textField.setText("Μένουν ακόμα: " + (getCheckList()-countUse));
                            Alex.removeFromInv(true);
                            break;
                            case 1: 
                            countUse++;
                            textField.setText("Μένουν ακόμα: " + (getCheckList()-countUse));
                            Alex.flagForRemovedItem = false;
                            Alex.removeFromInv(true);
                            break;
                            case 2:
                            countUse++;
                            textField.setText("Μένουν ακόμα: " + (getCheckList()-countUse));
                            Alex.flagForRemovedItem = false;
                            Alex.removeFromInv(true);
                            break;
                            case 3: 
                            getWorld().removeObject(textField);
                            Alex.flagForRemovedItem = false;
                            Alex.removeFromInv(true);
                            isActive = false;
                            endOfUse = true;
                            setImage(bH);
                            setBuildHouse(true);                          
                            break;
                        } 
                    }
                    else {
                        checkHealthBar();
                        getWorld().removeObject(textField);
                        textPanel= new TextPanel("wrongKey", db.feedback());
                        getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
                        tryAgainOrLeave = true;
                        isEDown = false;
                    }
                }
                if (Greenfoot.isKeyDown("enter") && counter < 0 && tryAgainOrLeave){
                    counter = 40;
                    isEDown = false;
                    isActive = false;
                    tryAgainOrLeave = false;
                    getWorld().removeObject(textPanel);
                }
            }
        }
    }

    public void checkHealthBar(){
        Level_0 lvl0 = (Level_0)getWorld();
        getWorld().removeObject(textField);
        if (!wrongCommand){
            wrongCommand = true;
            HealthBar.looseHealth();
        }
    }

    public void setCheckList(int count_mat){
        countMat = count_mat;
    }

    public int getCheckList(){
        return countMat;
    }

    public void setBuildHouse(boolean buildH){
        buildHouse = buildH;
    }

    public boolean getBuildHouse(){
        return buildHouse;
    }

    public boolean getEndOfUse(){
        return endOfUse;
    }
}
