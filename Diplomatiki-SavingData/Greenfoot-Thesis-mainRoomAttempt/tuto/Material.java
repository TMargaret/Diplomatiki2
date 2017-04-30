import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Material here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Material extends Actor
{
    private HiddenSprite hs;
    private int hsWidth, hsHeight = 40;
    private final int HS_OFFSET_X = 10;
    private final int HS_OFFSET_Y = 5;

    boolean isEDown = false, isActive = false, tryAgainOrLeave = false;
    boolean wrongCommand = false;
    TextField textField;
    int counter = 30;
    String my_text = "";
    TextPanel textPanel;
    boolean addToInv = false;

    public Material(){
    }
    /**
     * Act - do whatever the Material wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        materialCreation();
    }    

    protected void addedToWorld(World w)
    {
        addHiddenSprite();
    }

    protected void addHiddenSprite() {   
        hs = new HiddenSprite(this, getImage().getWidth() + getImage().getWidth()/2 , hsHeight, HS_OFFSET_X, HS_OFFSET_Y, true);  
        getWorld().addObject(hs, getX(), getY()); 
    }

    public void materialCreation(){
        if( hs.getWorld() != null ) {   
            List<Actor> things = hs.getHitBoxIntersections();    
            if( things.size() > 1 ) {      
                int infront = 0;      
                for(int i=0; i < things.size(); i++ ) {       
                    Actor a = things.get(i);        
                    if(a instanceof HiddenSprite)        
                        continue;        
                    if( a instanceof Alex) {
                        counter--;
                        if (Greenfoot.isKeyDown("e") & !isEDown){
                            isEDown = true;
                        }
                        if (counter<0 && !isActive && isEDown){
                            isActive = true;
                            textFieldCreation();
                        }
                        if (Greenfoot.mouseClicked(textField) && isEDown){
                            textField.setText("");
                        }
                        if (Greenfoot.isKeyDown("enter") && isEDown){
                            counter = 30;
                            my_text = textField.getText();

                            if (my_text.contains(checkMaterial()))
                            {
                                getWorld().removeObject(textField);
                                getWorld().removeObject(this);
                                isActive = false;
                                addToInv = true;
                                break;
                            }
                            else {
                                checkHealthBar();
                                getWorld().removeObject(textField);
                                textPanel= new TextPanel("wrongKey");
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
                    wrongCommand = false;
                }
            }
        }

    }

    public void textFieldCreation(){
        textField = new TextField(700, 45, "Δημιούργησε ένα αντικείμενο " + setMaterial() + " και πάτα enter");
        getWorld().addObject(textField, textField.getImage().getWidth()/2, getWorld().getHeight() - textField.getImage().getHeight()/2);
    }

    public void checkHealthBar(){
        mainHouseRoom mainHouseRoom = (mainHouseRoom)getWorld();
        HealthBar healthBar = mainHouseRoom.getHealthBar();
        getWorld().removeObject(textField);
        if (!wrongCommand){
            wrongCommand = true;
            healthBar.looseHealth();
        }
    }

    public String setMaterial(){
        String material = "";
        return material;

    }

    public String checkMaterial(){
        String materialAnswer = "";
        return materialAnswer;

    }

    public boolean getActive(){
        return isActive;
    }

    public boolean getAddToInv(){
        return addToInv;
    }

    public void setAddToInv(){
        addToInv = false;
    }
}
