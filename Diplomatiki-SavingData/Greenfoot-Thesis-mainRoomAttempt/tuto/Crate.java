import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

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
    boolean isActive = false;
    int endGame = -1;
    private HiddenSprite hs;
    private int hsWidth = 150; 
    private int hsHeight = 290;
    private final int HS_OFFSET_X = 0;
    private final int HS_OFFSET_Y = 0;
    TextField t1,t2,t3,t4,t5,t6;
    private ArrayList<String> rightAnswer = new ArrayList<String>(){
            {
                add("main");
                add("new");
                add("Material");
                add("wood");
                add("unloadCargo");
                add("brick");
            }
        };
    private Button btnOK;

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
                        if (Greenfoot.isKeyDown("e") && !isEDown && !isActive){
                            Greenfoot.getKey().replaceAll("e", "");
                            isEDown = true;       
                            isActive = true;
                            tp = new TextPanel("crate",800,480);
                            getWorld().addObject(tp, getWorld().getWidth()/2, getWorld().getHeight()/2);
                            addEditor();
                        }

                        if (Greenfoot.mouseClicked(btnOK)){                          
                            if (evaluate().compareTo("111111")==0){
                                removeSome();
                                setEnd(1);
                            }
                            else {
                                removeSome();
                                setEnd(0);
                            }
                        }
                    }
                }
            }
        }
    }

    public void addEditor(){
        t1 = new TextField(70,30);
        getWorld().addObject(t1,320,137);        
        t2 = new TextField(60,30);
        getWorld().addObject(t2,510,195);
        t3 = new TextField(115,30);
        getWorld().addObject(t3,717,195);
        t4 = new TextField(115,30);
        getWorld().addObject(t4,390,255);
        t5 = new TextField(110,30);
        getWorld().addObject(t5,188,313);
        t6 = new TextField(110,30);
        getWorld().addObject(t6,380,373);
        btnOK = new Button("OK");
        getWorld().addObject(btnOK, 500, 470);
    }

    public String evaluate(){
        String eval = "";
        ArrayList<String> gt = new ArrayList<String>();
        gt.add(t1.getText());
        gt.add(t2.getText());
        gt.add(t3.getText());
        gt.add(t4.getText());
        gt.add(t5.getText());
        gt.add(t6.getText());      
        for(int i=0;i<gt.size();i++){
            String temp = gt.get(i).replaceAll("\\s+","");
            if (temp.equals(rightAnswer.get(i))){
                eval +=1;
            }
            else eval+=0;
        }
        return eval;
    }

    public boolean getActive(){
        return isActive;
    }

    public void setEnd(int end){
        endGame = end;
    }

    public int getEnd(){
        return endGame;
    }

    public void removeSome(){
        getWorld().removeObject(tp);
        getWorld().removeObject(btnOK);
        if (getWorld().getObjects(TextField.class) != null){
            getWorld().removeObjects(getWorld().getObjects(TextField.class));
        }
    }

}
