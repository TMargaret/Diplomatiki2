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
    public HiddenSprite hs;
    public int hsWidth = 0; 
    public int hsHeight = 70;
    private final int HS_OFFSET_X = 0;
    private final int HS_OFFSET_Y = 0;

    public boolean isEDown = false, isActive = false, tryAgainOrLeave = false;
    boolean wrongCommand = false;
    boolean thisLvl = false;
    TextField textField;
    int counter = 30;
    int version = 0;
    String my_text = "";
    TextPanel textPanel;
    static boolean addToInv = false;
    protected static ArrayList<Material> materialList = new ArrayList<Material>();
    InvBar invBar = new InvBar();
    Debugger db;
    GreenfootSound pickupSound = new GreenfootSound("pickUp.wav");

    public Material(){
        hsWidth = getImage().getWidth() + getImage().getWidth()/2;
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

    public void addHiddenSprite(World w) {   
        hs = new HiddenSprite(this, hsWidth , hsHeight/2, HS_OFFSET_X, HS_OFFSET_Y, true);  
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
        if (getWorld() instanceof Level_02){
            version = 3;
        }
    }

    public void materialCreation(){
        if( hs.getWorld() != null ) {   
            List<Actor> things = hs.getHitBoxIntersections();    
            if( things.size() > 1 ) {      

                Actor a = null;
                // int infront = 0;      // TODO Show list of intersecting objects. Pick the one to interact with 1,2,3,4...1
                for(int i=0; i < things.size(); i++ ) { 
                    a = things.get(i);
                    if(a instanceof HiddenSprite)  {     
                        continue;
                    }
                    if( a instanceof Alex) {
                        counter--;
                        if (Greenfoot.isKeyDown("e") && !isEDown){
                            isEDown = true;
                            counter = 20;
                        }
                        if (counter<0 && isEDown && !thisLvl)
                        {
                           extraAction();
                        }
                        if (counter<0 && !isActive && isEDown && thisLvl){
                            isActive = true;
                            textFieldCreation();
                        }
                        if (Greenfoot.mouseClicked(textField) && isEDown && thisLvl){
                            textField.setText("");
                        }
                        if (thisLvl && Greenfoot.isKeyDown("escape") && isEDown ){
                            getWorld().removeObject(textField); 
                            isActive = false;
                            isEDown = false;
                        }   

                        if (thisLvl && Greenfoot.isKeyDown("enter") && isEDown){
                            isEDown = false;
                            counter = 30;
                            db = new Debugger(textField.getText(), this.checkMaterial());
                            if (db.checkSpelling())
                            {
                                actionSpelling();
                                actionMat();
                            }
                            else {
                                checkHealthBar();
                                if (HealthBar.getHealth()>0){
                                    textPanel= new TextPanel("wrongKey", db.feedback());
                                    getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
                                    tryAgainOrLeave = true;
                                    isEDown = false;
                                }
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
    
    public void extraAction(){
        thisLvl = true;
    }

    public void actionSpelling(){
        getWorld().removeObject(textField);      
        isActive = false;
        addToInv = true;
        isEDown = false;
    }

    public void actionMat(){
        getWorld().removeObject(this);      
        materialList.add(this);
        pickupSound.play();
    }

    public void textFieldCreation(){
        textField = new TextField(700, 45,getTextFieldMessage());
        getWorld().addObject(textField, textField.getImage().getWidth()/2, getWorld().getHeight() - textField.getImage().getHeight()/2);
    }

    public String getTextFieldMessage(){
        String textMsg = "Κάλεσε την αντίστοιχη μέθοδο και πάτα enter";
        return textMsg;
    }

    public void checkHealthBar(){
        getWorld().removeObject(textField);
        if (!wrongCommand){
            wrongCommand = true;
            HealthBar.looseHealth();
        }
    }

    public String getMaterial(){
        String material = "";
        return material;
    }

    public String checkMaterial(){
        String materialAnswer = " ";
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
