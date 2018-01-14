import greenfoot.*;
// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    static GreenfootSound looseHealthSound = new GreenfootSound("loose.wav");
    GreenfootImage myImage;
    static int health;
    int healthBarWidth = 80;
    int healthBarHeight = 15;
    int pixelsPerHealthPoint = (int)healthBarWidth / 6;

    public HealthBar(int health){
        pixelsPerHealthPoint = (int)healthBarWidth / health;
        this.health = health;
        update();
    }

    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        update();
    }  

    public void update(){
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        myImage = getImage();
        myImage.setColor(Color.BLACK);
        myImage.drawRect(0, 0, healthBarWidth + 1, healthBarHeight + 1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1, 1, health*pixelsPerHealthPoint, healthBarHeight);       
    }

    public static void looseHealth(){
        looseHealthSound.play();
        health--;
    }

    public void setHealth(int alexHealth){
        health = alexHealth;
    }

    public static int getHealth(){
        return health;
    }
}
