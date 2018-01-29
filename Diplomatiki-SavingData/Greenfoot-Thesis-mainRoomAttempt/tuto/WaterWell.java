import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WaterWell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaterWell extends Actor
{

    int counter = 10;
    boolean isEDown = false;
    boolean isActive = false, displayMessage = false;
    private TextPanel textPanel;
    boolean endOfUse = false;
    boolean tryAgainOrLeave = false;
    boolean wrongCommand = false;
    boolean buildHouse = false;
    TextField textField;
    Debugger db;
    GreenfootSound dropSound = new GreenfootSound("drop.wav");
    GreenfootSound buildSound = new GreenfootSound("build.mp3");
    GreenfootImage bH = new GreenfootImage("well2.png");
    int countMat = 0;
    int countUse = 0;
    GreenfootImage img = getImage();

    public WaterWell(){
        img.scale(img.getWidth()/4, img.getHeight()/4);
        bH.scale(bH.getWidth()/4, bH.getHeight()/4);
    }

    /**
     * Act - do whatever the WaterWell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        canSeeAlex();
    } 

    public boolean getActive(){
        return isActive;
    }

    public void canSeeAlex(){
        if (isTouching(Alex.class))
        {
            counter--;
            if (Greenfoot.isKeyDown("e")){               
                isEDown = true;
            }
            if (getCheckList() < 2){
                if (isEDown && !isActive && !displayMessage){
                    textPanel = new TextPanel("BrokenWellMessage");
                    getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
                    isActive = true;
                    displayMessage = true;
                }
                if (Greenfoot.isKeyDown("enter")){
                    counter = 10;
                    getWorld().removeObject(textPanel);
                    isActive = false;
                    isEDown = false;
                    displayMessage = false;
                }
            }
            if (getCheckList() == 2 && !endOfUse){
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
                    //db = new Debugger(textField.getText(),"1");
                    db = new Debugger(textField.getText(),"Alex.use(brick,brick);");
                    if (db.checkSpelling())
                    {
                        Alex.removeFromInv(true);
                        Alex.removeFromInv(true);
                        buildSound.play();
                        getWorld().removeObject(textField);
                        isActive = false;
                        endOfUse = true;
                        setImage(bH);
                        setBuildHouse(true);                          

                    } 
                    else {
                        checkHealthBar();
                        getWorld().removeObject(textField);
                        if (HealthBar.getHealth()>0){                                 
                            textPanel= new TextPanel("wrongKey", db.feedback());
                            getWorld().addObject(textPanel, getWorld().getWidth()/2, getWorld().getHeight()/2);
                        }
                        tryAgainOrLeave = true;
                        isEDown = false;
                    }
                }

                if (Greenfoot.isKeyDown("enter") && counter < 0 && tryAgainOrLeave){
                    counter = 40;
                    isEDown = false;
                    isActive = false;
                    tryAgainOrLeave = false;
                    wrongCommand = false;
                    getWorld().removeObject(textPanel);
                }
            }
        }
    }

    public void textFieldCreation(){
        Greenfoot.getKey().replaceAll("e", "");
        textField = new TextField(700, 45,"Χρησιμοποίησε τα υλικά μαζί..");
        getWorld().addObject(textField, textField.getImage().getWidth()/2, getWorld().getHeight() - textField.getImage().getHeight()/2);
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

    public void checkHealthBar(){
        Level3 lvl3 = (Level3)getWorld();
        getWorld().removeObject(textField);
        if (!wrongCommand){
            wrongCommand = true;
            HealthBar.looseHealth();
        }
    }
}
