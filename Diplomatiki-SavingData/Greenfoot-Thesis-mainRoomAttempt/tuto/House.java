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
    boolean isEDown = false;
    boolean isActive = false, displayMessage = false;
    boolean wrongCommand = false;
    private TextPanel textPanel;
    Level_0 lvl_0 = (Level_0)getWorld();
    TextField textField;

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

    public void canSeeAlex(){
        if (getOneIntersectingObject(Alex.class) != null)
        {
            counter--;
            if (Greenfoot.isKeyDown("e")){
                isEDown = true;
            }
            if (isEDown && !isActive && isEDownTwice ==0){

                textPanel = new TextPanel("houseMsgL0");
                getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
                isActive = true;
                isEDownTwice++;
                

            }
            if (Greenfoot.isKeyDown("enter")){
                counter = 20;
                getWorld().removeObject(textPanel);
                isActive = false;
                isEDown = false;
                displayMessage = true;

            }
            if (counter < 0 && isEDown && isEDownTwice>0 && displayMessage && lvl_0.checkMatList()==4) {
                isActive = true;
                textFieldCreation();
            }
       
            if (Greenfoot.mouseClicked(textField) && isEDown){
                textField.setText("");
            }

        }
    }

    public void textFieldCreation(){
        textField = new TextField(700, 45,"Κάλεσε την αντίστοιχη μέθοδο και πάτα enter");
        getWorld().addObject(textField, textField.getImage().getWidth()/2, getWorld().getHeight() - textField.getImage().getHeight()/2);
    }

    public void checkHealthBar(){
        Level_0 lvl0 = (Level_0)getWorld();
        getWorld().removeObject(textField);
        if (!wrongCommand){
            wrongCommand = true;
            HealthBar.looseHealth();
        }
    }

}
