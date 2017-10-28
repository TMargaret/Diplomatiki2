import greenfoot.*;
import java.util.List;
public class Snake extends ScrollingEnemy {
    GreenfootImage snake = new GreenfootImage("snake.png");
    int img_cell =80;
    final int IMG_WIDTH = snake.getWidth()/10;
    final int IMG_HEIGHT = snake.getHeight()/5;
    private static final int PATHLENGTH = 200;
    private static final int INRANGE = 100;
    private int pathCounter = PATHLENGTH;
    private boolean pathing = false;
    private int rememberSpeedX = 0;
    private List<Alex> lse;
    
    public Snake() {
        speedX = rememberSpeedX = SPEED;
        speedY = 0;
        setImage(SpriteSheet.getSprite(snake, 0,  img_cell*2, img_cell, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
    }

    protected void sense() {
        // If near, move towards enemy
        lse = getObjectsInRange(INRANGE,Alex.class);
        pathing = lse.isEmpty();
    }

    protected void reaction() {
        if( pathing ) {
            speedX = rememberSpeedX;
            speedY = 0;
            if( --pathCounter == 0 ) {
                pathCounter = PATHLENGTH;
                speedX = rememberSpeedX = -speedX;
            }
        } else {
            speedX = lse.get(0).getX() > getX() ? 1 : -1;
            speedY = lse.get(0).getY() > getY() ? 1 : -1;
        }
    }
}
