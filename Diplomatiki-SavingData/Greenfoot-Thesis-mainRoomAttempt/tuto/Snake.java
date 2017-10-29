import greenfoot.*;
import java.util.List;
public class Snake extends ScrollingEnemy {
    GreenfootImage snake = new GreenfootImage("snake.png");
    GreenfootImage snake2 = new GreenfootImage("snake2.png");
    int img_cell =80;
    final int IMG_WIDTH = snake.getWidth()/16;
    final int IMG_HEIGHT = snake.getHeight()/5;
    private static final int PATHLENGTH = 160;
    private static final int INRANGE = 160;
    private int pathCounter = PATHLENGTH;
    private boolean pathing = false;
    private int rememberSpeedX = 0;
    private List<Alex> lse;
    int count = 0;
    int count2 = 0;

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
            if(rememberSpeedX>0) {
                setImage(SpriteSheet.getSprite(snake, 0,  img_cell*2, img_cell, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
            }
            else {
                setImage(SpriteSheet.getSprite(snake2, 0,  img_cell*2, img_cell, img_cell*3, IMG_WIDTH, IMG_HEIGHT));
            }

            if( --pathCounter == 0 ) {
                pathCounter = PATHLENGTH;
                speedX = rememberSpeedX = -speedX; 

            }
        } else {
            // speedX = lse.get(0).getX() > getX() ? 1 : -1;    
            if (lse.get(0).getX() > getX()){
                speedX = 3;
                snakeAnimation();
            }
            else {
                speedX = -3;
                snakeAnimation2();
            }
            speedY = lse.get(0).getY() > getY() ? 2 : -2;
        }
    }

    public void snakeAnimation(){
        for (int i=1;i<=10;i++){
            count++;
            if (count>80){
                setImage(SpriteSheet.getSprite(snake, img_cell*(i-1), img_cell*3, img_cell*i, img_cell*4, IMG_WIDTH, IMG_HEIGHT));
                count = 0;
            }
        }

    }

    public void snakeAnimation2(){
        for (int i=1;i<=10;i++){
            count2++;
            if (count2>80){
                setImage(SpriteSheet.getSprite(snake2, img_cell*(i-1), img_cell*3, img_cell*i, img_cell*4, IMG_WIDTH, IMG_HEIGHT));
                count2 = 0;
            }
        }
    }
}
