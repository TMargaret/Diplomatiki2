import greenfoot.*; 
import java.util.List; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.util.ArrayList;

/**
 * Alex is the main character of the game
 * 
 * @author (Margaret) 
 * @9/5/2017
 */
public class Alex extends SpriteSheet implements ButtonResponder{

    private boolean canMove = true, isMoving = false;
    boolean flagForImage = false, bothDirections = false;
    String getKeyBoth = "", getKey = "";
    int img_cell = 32;
    int img = 0;
    int delay = 0;
    GreenfootImage alex = new GreenfootImage("alex.png");
    final int IMG_WIDTH = alex.getWidth()/6;
    final int IMG_HEIGHT = alex.getHeight()/4;
    static boolean flagForRemovedItem = false;
    private static final int BOUNDARY = 40;
    List<Bubble> bbl;

    HealthLogo healthLogo;
    HealthBar healthBar;
    InvBar invBar;
    Inventory inv;
    HintBar hintBar;
    ExitBar exitBar;
    HintRules hintRules;
    boolean invIsOpen = false, hintIsOpen = false;
    boolean lostMessage;
    Button inventoryBtn, hintBtn, exitBtn;
    private static String[] items;
    public double time;
    static int alexHealth = 6;
    Level_1 level1;
    boolean isAdded = false;

    ArrayList<Material> materialList;
    Material myMaterial;
    static ArrayList<Material>  inventoryList = new ArrayList<Material>();
    TextPanel theEnd;

    /**
     * Constructor
     */
    public Alex(){
        setImage(getSprite(alex, img_cell*3,  img_cell*2, img_cell*4, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
        items = new String[1];

    }

    /**
     * Method addedToWorld
     *
     * @param world A parameter
     */
    protected void addedToWorld(World world){

        //check if objects already added
        if (!isAdded){
            isAdded = true;
            healthBar = new HealthBar(alexHealth);

            healthLogo = new HealthLogo();

            invBar = new InvBar();
            inventoryBtn = new Button(invBar.getImage().getWidth(), invBar.getImage().getHeight());
            inventoryBtn.setResponder(this);

            exitBar = new ExitBar();
            exitBtn = new Button(exitBar.getImage().getWidth(), exitBar.getImage().getHeight());
            exitBtn.setResponder(this);

            hintBar = new HintBar();
            hintBtn = new Button(hintBar.getImage().getWidth(), hintBar.getImage().getHeight());
            hintBtn.setResponder(this);

        }
        getWorld().addObject(healthBar, healthBar.getImage().getWidth(), healthBar.getImage().getHeight());
        getWorld().addObject(healthLogo,21,19);
        getWorld().addObject(invBar,947,18);

        getWorld().addObject(inventoryBtn, 947, 18);

        getWorld().addObject(exitBar,984,18);
        getWorld().addObject(exitBtn, 984, 18);
        getWorld().addObject(hintBar, 910, 18);
        getWorld().addObject(hintBtn, 910, 18);

    }

    /**
     * Act - do whatever the Alex wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        move(5); 
        gameOver();
        addToInventory();
        checkWorld();
    }

    public void checkWorld(){
        if (getWorld() instanceof Level_1){
            level1 = (Level_1) getWorld();
            materialList = level1.getMaterialList();
        }
        if (getWorld() instanceof mainHouseRoom){
            mainHouseRoom mainHouseRoom = (mainHouseRoom)getWorld();
            materialList = mainHouseRoom.getMaterialList();
        }
        if (getWorld() instanceof Level_0){
            Level_0 level0 = (Level_0)getWorld();
            materialList = level0.getMaterialList();
        }
        if (getWorld() instanceof Level_02){
            Level_02 level02 = (Level_02)getWorld();
            materialList = level02.getMaterialList();
        }
        if (getWorld() instanceof mainHutRoom){
            mainHutRoom mainHutRoom = (mainHutRoom)getWorld();
            materialList = mainHutRoom.getMaterialList();
        }
    }

    /**
     * Setter method - sets the move state of Alex
     */
    public void setCanMove(boolean moveStatus){
        canMove = moveStatus;
    }

    /**
     * Move method - gives movement to Alex
     */
    public void move(int moveAmt){

        // determine direction by keypress checking
        if (!canMove){
            return;
        }

        int dx = 0, dy = 0;
        //checking which button(s) is/are pressed
        if (Greenfoot.isKeyDown("down") && Greenfoot.isKeyDown("right")) {
            getKeyBoth = "downRight";
            animation();
        }
        if (Greenfoot.isKeyDown("down") && Greenfoot.isKeyDown("left")) {
            getKeyBoth = "downLeft";
            animation();
        }
        if (Greenfoot.isKeyDown("up") && Greenfoot.isKeyDown("right")) {
            getKeyBoth = "upRight";
            animation();
        }
        if (Greenfoot.isKeyDown("up") && Greenfoot.isKeyDown("left")) {
            getKeyBoth = "upLeft";
            animation();
        }
        if (Greenfoot.isKeyDown("right")) {
            dx = 4;
            getKey = "right";
            animation();

        }
        if (Greenfoot.isKeyDown("left")) {
            dx = -4;
            getKey = "left";
            animation();
        }
        if (Greenfoot.isKeyDown("down")) {
            dy = 4;
            getKey = "down";
            animation();
        }
        if (Greenfoot.isKeyDown("up")) {
            dy = -4;
            getKey = "up";
            animation();
        }
        // //initializes the getKey variables
        // initGetKey();

        //check for wall on each step of move in both vertical and horizontal directions
        // for (int i = 0; i < moveAmt; i++)
        // {
        setLocation(getX() + dx, getY()+dy);
        if ((getOneIntersectingObject(Wall.class) != null) ||
        (getOneIntersectingObject(Wall3.class) != null) ||
        (getOneIntersectingObject(WallBlock.class) != null)||
        (getOneIntersectingObject(SignBlock.class) != null)||
        (getOneIntersectingObject(Rose.class) != null)||
        (getOneIntersectingObject(Crate.class) != null) ||  
        (getOneIntersectingObject(Barrel.class) != null) ||  
        (getOneIntersectingObject(Grass.class) != null) ||  
        (getOneIntersectingObject(Material.class) != null) ||
        (getOneIntersectingObject(Unicorn.class) != null) ||
        (getOneIntersectingObject(Locals.class) !=null) ||
        (getX() < getImage().getWidth()/2) ||
        (getX() > getWorld().getWidth() - getImage().getWidth()/2)){ 
            setLocation(getX() - dx, getY());
        }
        if (getWorld() instanceof Level4){
            if((getX() > (getWorld().getWidth()/6)*5) && (getKey == "right" || getKeyBoth=="upRight" || getKeyBoth=="downRight")) {
                ((Level4)getWorld()).shiftWorld(-dx/2);
                setLocation(getX() - dx, getY());
                bbl = getWorld().getObjects(Bubble.class);
                if (bbl !=null){
                    for(Bubble bbls: bbl){
                    getWorld().removeObject(bbls);
                }
                }
            } if( (getX() < (getWorld().getWidth()/2)) &&(getKey == "left" || getKeyBoth=="upLeft" || getKeyBoth=="downLeft")) {
                ((Level4)getWorld()).shiftWorld(-dx/2);
                setLocation(getX()-dx, getY());
             }
        }
        

        // setLocation(getX(), getY() + dy);
        if ((getOneIntersectingObject(Wall.class) != null)||
        (getOneIntersectingObject(WallBlock.class) != null)||
        (getOneIntersectingObject(Wall3.class) != null) ||
        (getOneIntersectingObject(Crate.class) != null) ||  
        (getOneIntersectingObject(Barrel.class) != null) || 
        (getOneIntersectingObject(SignBlock.class) != null)||
        (getOneIntersectingObject(Wall2.class) != null) 
        || (getOneIntersectingObject(Grass.class) != null)  
        || (getOneIntersectingObject(Material.class) != null)
        || (getOneIntersectingObject(Unicorn.class) != null)
        || (getOneIntersectingObject(Locals.class) !=null) ||
        (getY() < getImage().getHeight()/2) ||
        (getY() > getWorld().getHeight() - getImage().getHeight()/2)){
            setLocation(getX(), getY() - dy);
    }
        //initializes the getKey variables
        initGetKey();
    }

    /**
     * Gives animation to Alex - 8 different cases, 16 different images
     */
    public void animation(){
        delay--;

        if (getKeyBoth == "downRight"){  
            if (delay<0 && !flagForImage){
                setImage(getSprite(alex, img_cell*3,  img_cell*2, img_cell*4, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
                delay = 20;
                flagForImage = true;
            }
            if (delay < 0 && flagForImage){
                setImage(getSprite(alex, img_cell*4,  img_cell*2, img_cell*5, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
                flagForImage = false;
                delay = 20;
            }
        }
        if (getKeyBoth == "downLeft"){  
            if (delay<0 && !flagForImage){
                setImage(getSprite(alex, img_cell*3,  img, img_cell*4, img_cell, IMG_WIDTH, IMG_HEIGHT));
                delay = 20;
                flagForImage = true;
            }
            if (delay < 0 && flagForImage){
                setImage(getSprite(alex, img_cell*4,  img, img_cell*5, img_cell, IMG_WIDTH, IMG_HEIGHT));
                flagForImage = false;
                delay = 20;
            }
        }
        if (getKeyBoth == "upRight"){  
            if (delay<0 && !flagForImage){
                setImage(getSprite(alex, img_cell*3,  img_cell*3, img_cell*4, img_cell*4, IMG_WIDTH, IMG_HEIGHT));
                delay = 20;
                flagForImage = true;
            }
            if (delay < 0 && flagForImage){
                setImage(getSprite(alex, img_cell*4,  img_cell*3, img_cell*5, img_cell*4, IMG_WIDTH, IMG_HEIGHT));
                flagForImage = false;
                delay = 20;
            }
        }
        if (getKeyBoth == "upLeft"){  
            if (delay<0 && !flagForImage){
                setImage(getSprite(alex, img_cell*3,  img_cell, img_cell*4, img_cell*2, IMG_WIDTH, IMG_HEIGHT));
                delay = 20;
                flagForImage = true;
            }
            if (delay < 0 && flagForImage){
                setImage(getSprite(alex, img_cell*4,  img_cell, img_cell*5, img_cell*2, IMG_WIDTH, IMG_HEIGHT));
                flagForImage = false;
                delay = 20;
            }
        }
        if (getKey == "right"){
            if (delay<0 && !flagForImage){
                setImage(getSprite(alex, img,  img_cell*2, img_cell, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
                delay = 10;
                flagForImage = true;
            }
            if (delay < 0 && flagForImage){
                setImage(getSprite(alex, img_cell,  img_cell*2, img_cell*2, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
                flagForImage = false;
                delay = 10;
            }
        }
        if (getKey == "left"){   
            if (delay<0 && !flagForImage){
                setImage(getSprite(alex, img,  img_cell, img_cell, img_cell*2, IMG_WIDTH, IMG_HEIGHT));
                delay = 10;
                flagForImage = true;
            }
            if (delay < 0 && flagForImage){
                setImage(getSprite(alex, img_cell,  img_cell, img_cell*2, img_cell*2, IMG_WIDTH, IMG_HEIGHT));
                flagForImage = false;
                delay = 10;
            }
        }
        if (getKey == "up"){   
            if (delay<0 && !flagForImage){
                setImage(getSprite(alex, img,  img_cell*3, img_cell, img_cell*4, IMG_WIDTH, IMG_HEIGHT));
                delay = 10;
                flagForImage = true;
            }
            if (delay < 0 && flagForImage){
                setImage(getSprite(alex, img_cell,  img_cell*3, img_cell*2, img_cell*4, IMG_WIDTH, IMG_HEIGHT));
                flagForImage = false;
                delay = 10;
            }
        }
        if (getKey == "down"){   
            if (delay<0 && !flagForImage){
                setImage(getSprite(alex, img,  img, img_cell, img_cell, IMG_WIDTH, IMG_HEIGHT));
                delay = 10;
                flagForImage = true;
            }
            if (delay < 0 && flagForImage){
                setImage(getSprite(alex, img_cell,  img, img_cell*2, img_cell, IMG_WIDTH, IMG_HEIGHT));
                flagForImage = false;
                delay = 10;
            }
        }

    }

    /**
     * Return true if we can see an object of class 'clss' right where we are. 
     * False if there is no such object here.
     */
    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }

    /**
     * Initializes the getKey and getKeyBoth String variables
     */
    public void initGetKey(){
        getKey = "";
        getKeyBoth = "";
    }

    /**
     * Method gameOver, Checks the healthbar and terminates the game if no health is left
     *
     */
    public void gameOver(){
        if (healthBar.getHealth() <= 0 && !lostMessage){
            lostMessage = true;
            theEnd = new TextPanel("youLost");
            getWorld().addObject(theEnd, getWorld().getWidth()/2, getWorld().getHeight()/2);
        }
        if (Greenfoot.isKeyDown("space") && lostMessage){
            Greenfoot.setWorld(new LevelsScreen());
            canMove = true;
        }
    }

    /**
     * Method buttonClicked. Checks if a button is clicked.
     * if so, then the appropriate dialogue opens.
     *
     * @param button A parameter
     */
    public void buttonClicked(Button button)
    {   
        //opens the hint dialogue
        if (Greenfoot.mouseClicked(hintBtn) && !hintIsOpen){
            hintRules = new HintRules();
            getWorld().addObject(hintRules, hintBar.getX() - (hintRules.getImage().getWidth()/2), 
                hintBar.getY() + (hintBar.getImage().getHeight()/3) + (hintRules.getImage().getHeight()/2));
            hintIsOpen = true;
        }
        //closes the hint dialogue
        else if (Greenfoot.mouseClicked(hintBtn) && hintIsOpen)
        {
            getWorld().removeObject(hintRules);
            hintIsOpen = false;
        }
        //opens the inventory
        if (Greenfoot.mouseClicked(inventoryBtn) && !invIsOpen)
        {
            inv = new Inventory();
            getWorld().addObject(inv, invBar.getX() - (inv.getImage().getWidth()/2), 
                invBar.getY() + (invBar.getImage().getHeight()/3) + (inv.getImage().getHeight()/2));
            invIsOpen = true;
        }
        //closes the inventory
        else if (Greenfoot.mouseClicked(inventoryBtn) && invIsOpen)
        {
            getWorld().removeObject(inv);
            invIsOpen = false;
        }
        //exitButton
        if (Greenfoot.mouseClicked(exitBtn))
        {
            Greenfoot.setWorld(new LevelsScreen());
            Level_0.level0Sound.stop();
            Level_1.lvl.stop();
            Level_02.lvlSound.stop();
            Level_022.suspenseSound.stop();
        }

    }

    public void addToInventory(){

        if (materialList != null){
            if(System.currentTimeMillis() > time + 500){
                for (Material myMat : materialList){
                    if(myMat.getAddToInv())
                    {
                        invBar.specialEffect();
                        addItem(myMat.getMaterial());
                        myMat.setAddToInv();
                        myMaterial = myMat; 
                        time = System.currentTimeMillis();
                        //this list holds the items in total
                        inventoryList.add(myMat);
                    }
                }
            }
            materialList.remove(myMaterial);
        }       
    }

    /**
     * Method getMaterialList
     *
     * @return The return value
     */
    public ArrayList getMaterialList(){
        return inventoryList;
    }

    public static void removeFromInv(boolean flag){
        Material m = null;
        for (Material material : inventoryList)
        {
            if(flag && !flagForRemovedItem){
                removeItem(material.getMaterial());
                m = material;
                flagForRemovedItem = true;
            }
        }
        inventoryList.remove(m);
    }

    public static String[] getItems()
    {
        return items;
    }

    public static void changeItems(String[] newItems)
    {
        items = newItems;
    }

    public static void addItem(String newItem)  
    {  
        int x = items.length;  
        String[] temp = new String[x];  
        for (int i = 0; i < x; i++) 
            temp[i] = items[i];  
        items = new String[x + 1];  
        for (int i = 0; i < x; i++) {
            items[i] = temp[i]; 
        }  
        items[x] = newItem;  
    }

    /**
     * Method removeItem from inventory. We just replace the item with null
     *
     * @param newItem A parameter
     */
    public static void removeItem(String newItem)  
    {  
        int x = items.length;  
        for (int i = 0; i < x; i++) {
            if (items[i] != null){
                if (items[i].equals(newItem))
                {
                    items[i] = null;
                    break;
                }
            }
        }
    }

    public void setIsAdded(boolean isAdded){
        this.isAdded = isAdded;
    }

}
