import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

abstract public class ScrollingEnemy extends ScrollingActor
{
    protected static final int SPEED = 1;
    private static final int BOUNDARY = 40;
    protected int speedX = SPEED;
    protected int speedY = SPEED;
    int counter = 0;
    
    protected void addedToWorld(World w) {
        Level4 lvl4 = (Level4) w;
        GreenfootImage img = getImage();
        img.scale(lvl4.getTileWidth(),lvl4.getTileHeight());
        setImage(img);
    }

    public void act() {
        sense();
        reaction();
        boundedMove();
        damageAlex();
    }

    protected void sense() {
        // No smarts
    }

    protected void reaction() {
        // No reaction
    }

    protected void boundedMove() {
        setLocation(getX()+speedX, getY()+speedY);
        if( isTouching(ScrollingObstacle.class) ) {
            setLocation(getX()-speedX, getY()-speedY);
        }
    }
    
    public void damageAlex(){
        counter++;
        if (isTouching(Alex.class) && counter > 300){
            HealthBar.looseHealth(); 
            counter = 0;
        }
    }
}  

