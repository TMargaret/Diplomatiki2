import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
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
    private final int HS_OFFSET_X = 0;
    private final int HS_OFFSET_Y = 0;

    boolean isEDown = false, isActive = false, tryAgainOrLeave = false;
    boolean wrongCommand = false;
    TextField textField;
    int counter = 30;
    int version = 0;
    String my_text = "";
    TextPanel textPanel;
    static boolean addToInv = false;
    ArrayList<Material> materialList = new ArrayList<Material>();

    public Material(){
    }

    /**
     * Act - do whatever the Material wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkWorld();
        materialCreation();
    }    

    protected void addedToWorld(World w)
    {
        addHiddenSprite(w);
    }

    protected void addHiddenSprite(World w) {   
        hs = new HiddenSprite(this, getImage().getWidth() + getImage().getWidth()/2 , hsHeight, HS_OFFSET_X, HS_OFFSET_Y, true);  
        w.addObject(hs, getX(), getY()); 
    }

    public void checkWorld(){
        if (getWorld() instanceof Level_0){
            version = 0;
        }
        if (getWorld() instanceof Level_1){
            version = 1;
        }
        if (getWorld() instanceof mainHouseRoom){
            version = 2;
        }
        System.out.println(version);
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
                            counter = 20;
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
                                materialList.add(this);
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
        switch(version){
            case 0:
            textField = new TextField(700, 45,"Κάλεσε την αντίστοιχη μέθοδο και πάτα enter");
            getWorld().addObject(textField, textField.getImage().getWidth()/2, getWorld().getHeight() - textField.getImage().getHeight()/2);
            break;
            case 1:
            case 2:
            textField = new TextField(700, 45,"Δημιούργησε ένα αντικείμενο " + getMaterial() + " και πάτα enter");
            getWorld().addObject(textField, textField.getImage().getWidth()/2, getWorld().getHeight() - textField.getImage().getHeight()/2);
            break;
        }
        // if (getWorld() instanceof Level_0 ){
        // textField = new TextField(700, 45,"Κάλεσε την αντίστοιχη μέθοδο και πάτα enter");
        // getWorld().addObject(textField, textField.getImage().getWidth()/2, getWorld().getHeight() - textField.getImage().getHeight()/2);
        // }
        // if (getWorld() instanceof Level_1 || getWorld() instanceof mainHouseRoom ){
        // textField = new TextField(700, 45,"Δημιούργησε ένα αντικείμενο " + getMaterial() + " και πάτα enter");
        // getWorld().addObject(textField, textField.getImage().getWidth()/2, getWorld().getHeight() - textField.getImage().getHeight()/2);
        // }

    }

    public void checkHealthBar(){
        switch(version){
            case 0:
            Level_0 lvl0 = (Level_0)getWorld();
            getWorld().removeObject(textField);
            if (!wrongCommand){
                wrongCommand = true;
                HealthBar.looseHealth();
            }
            break;
            case 1:
            Level_1 level1 = (Level_1) getWorld();
            getWorld().removeObject(textField);
            if (!wrongCommand){
                wrongCommand = true;
                HealthBar.looseHealth();
            }
            break;
            case 2: 
            mainHouseRoom mainHouseRoom = (mainHouseRoom)getWorld();
            getWorld().removeObject(textField);
            if (!wrongCommand){
                wrongCommand = true;
                HealthBar.looseHealth();
            }
           break;
        }
    }

    public String getMaterial(){
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

    public static boolean getAddToInv(){
        return addToInv;
    }

    public static void setAddToInv(){
        addToInv = false;
    }

}
