import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Crate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crate extends Actor
{
    boolean isEDown = false;
    TextPanel tp;
    public HiddenSprite hs;
    public int hsWidth = 150; 
    public int hsHeight = 290;
    private final int HS_OFFSET_X = 0;
    private final int HS_OFFSET_Y = 0;

    public Crate(){
        GreenfootImage img = getImage();  
        img.scale(img.getWidth()/10, img.getHeight()/10);
    }

    public Crate(String img){
        GreenfootImage myImg = new GreenfootImage("opencrate.png");  
        setImage(myImg);
        //myImg.scale(myImg.getWidth()/2, myImg.getHeight()/2);
    }

    protected void addedToWorld(World w)
    {
        addHiddenSprite(w);
    }

    public void addHiddenSprite(World w) {   
        hs = new HiddenSprite(this, hsWidth , hsHeight/2, HS_OFFSET_X, HS_OFFSET_Y, true);  
        w.addObject(hs, getX(), getY()); 
    }

    /**
     * Act - do whatever the Crate wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getWorld().getClass().getName()=="Level5"){
            actionBox();
        }
    }  

    public void actionBox(){
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
                        if (Greenfoot.isKeyDown("e") && !isEDown){
                            isEDown = true;
                            Greenfoot.getKey().replaceAll("e", "");
                            tp = new TextPanel("crate",800,480);
                            getWorld().addObject(tp, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            addEditor();

                        }
                    }
                }
            }
        }
    }
    
    public void addEditor(){
        TextField t = new TextField(70,30);
        getWorld().addObject(t,320,137);        
        TextField t2 = new TextField(60,30);
        getWorld().addObject(t2,510,195);
        TextField t3 = new TextField(115,30);
        getWorld().addObject(t3,717,195);
        TextField t4 = new TextField(115,30);
        getWorld().addObject(t4,390,255);
        TextField t5 = new TextField(110,30);
        getWorld().addObject(t5,188,313);
        TextField t6 = new TextField(110,30);
        getWorld().addObject(t6,380,373);
    }
}
