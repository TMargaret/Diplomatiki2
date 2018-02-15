import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 *
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceShip extends Actor
{
    GreenfootImage ss = new GreenfootImage("spaceship.png");
    GreenfootImage ss2 = new GreenfootImage("spaceship2.png");
    GreenfootSound buildSound = new GreenfootSound("build.mp3");
    GreenfootSound startEngine = new GreenfootSound("startEngine.wav");
    int i=0;
    HiddenSprite hs;
    private int hsWidth, hsHeight;
    private final int HS_OFFSET_X = 0;
    private final int HS_OFFSET_Y = 0;
    boolean isDone = false;
    boolean isEDown = false, isActive = false;
    int counter = 30;

    public SpaceShip(){
        setImage(ss);
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
        ss2.scale(ss2.getWidth()/2, ss2.getHeight()/2);
    }

    /**
     * Act - do whatever the Windmill wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        materialCreation();
        finish();
    } 
    
      protected void addedToWorld(World w)
    {
        addHiddenSprite(w);
    }

    public void addHiddenSprite(World w) {   
        hs = new HiddenSprite(this, 650 , 320, HS_OFFSET_X, HS_OFFSET_Y, true);  
        w.addObject(hs, getX(), getY()); 
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
                            actionMat();
                        }
                    }
                }
            }
        }
    }
    
    public void actionMat(){
        buildSound.play();
        setImage(ss2);
        isDone = true;
    }

    public void finish(){
        int counter = 200;
        if (isDone){
            counter--;
            startEngine.play();
            if (++i == 10){
                i = 0;
                setImage(ss2);
            }
            else if (i == 5){
                setImage(ss);               
            }
        }
    }
    
    public boolean getIsDone(){
        return isDone;
    }
    
    public void stopSound(){
        startEngine.stop();
    }

}
