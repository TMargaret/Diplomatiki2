import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ant extends ScrollingEnemy
{
    GreenfootImage spider = new GreenfootImage("ant.png");
    int img_cell =64;
    final int IMG_WIDTH = spider.getWidth()/5;
    final int IMG_HEIGHT = spider.getHeight()/5;
    private final static int SPEEDVARIATION = 3;
    private final static int SPEEDCHANGECHANCE = 20;
    int count = 0;
    int count2 = 0;

    public Ant() {
        setImage(SpriteSheet.getSprite(spider, 0,  img_cell, img_cell, img_cell*2, IMG_WIDTH, IMG_HEIGHT));
    }

    protected void reaction() {
        if(Greenfoot.getRandomNumber(1000) < SPEEDCHANGECHANCE){
            speedX = Greenfoot.getRandomNumber(SPEEDVARIATION)-1;           
        }else{
            speedX = speedX;
            if (speedX>0){
                spiderAnimation(1);
            }
            if (speedX<0){
                spiderAnimation(3);
            }
            if (speedX==0){
                setImage(SpriteSheet.getSprite(spider, 0,  img_cell, img_cell, img_cell*2, IMG_WIDTH, IMG_HEIGHT));
            }
        }
        speedY = Greenfoot.getRandomNumber(1000) < SPEEDCHANGECHANCE ?
            Greenfoot.getRandomNumber(SPEEDVARIATION)-1 : speedY; 
    }

    public void spiderAnimation(int y){
        for (int i=1;i<=4;i++){
            count++;
            if (count>50){
                setImage(SpriteSheet.getSprite(spider, img_cell*(i-1), img_cell*y, img_cell*i, img_cell*(y+1), IMG_WIDTH, IMG_HEIGHT));
                count = 0;
            }
        }

    }
}
