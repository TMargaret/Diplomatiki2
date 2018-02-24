import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Brick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Brick extends Material
{
    String myAnswer = "";
    int num = 0;
    /**
     * Brick Constructor
     *
     */
    public Brick() 
    {
        myAnswer = "Alex.pickUp();";
    }
    
    public Brick(int num) 
    {
        this.num = num;
        switch(num){
            case 1:
            myAnswer = "Alex.pickUp(brick);";
            break;
            case 2:
            myAnswer = "Alex.pickUp(brick1);";
            break;
            case 3:
            myAnswer = "Alex.pickUp(brick2);";
            break;
        }
        //myAnswer = "Alex.pickUp(brick);";
    }

    /**
     * Act - do whatever the Clay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        materialCreation();
    } 

    /**
     * Method getMaterial
     *
     * @return The material value, for the info message that appears in inputField
     */
    public String getMaterial(){
        String material = "Brick";
        return material;
    }

    /**
     * Method checkMaterial
     *
     * @return The correct answer value to be check
     */
    public String checkMaterial(){      
        return myAnswer;

    } 
    
        public void textFieldCreation(){
            textField = new TextField(700, 45,"Κάλεσε την αντίστοιχη μέθοδο και πάτα enter");
            getWorld().addObject(textField, textField.getImage().getWidth()/2, getWorld().getHeight() - textField.getImage().getHeight()/2);
        }
}
