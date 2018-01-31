import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;

/**
 * The frame for inventory
 * 
 * @author erdelf
 * @version 1.0
 */
public class Inventory extends Actor
{
    private int[] item1PosX = {15, 53, 90, 128, 166, 204, 242, 15, 53, 90, 128, 166, 204, 242};
    private int[] item1PosY = {36, 36, 36, 36, 36, 36, 36, 71, 71, 71, 71, 71, 71, 71};

    private boolean created;
    private static boolean open;
    GreenfootImage moneyImg;
    GreenfootImage imgInventory = new GreenfootImage("hud.gif");
    String[] items;

    //private int version;

    public Inventory()
    {
        created = false;
        open = true;

        int x = 50;
        int y = 10;
        // // switch(version)
        // //  {
        // case 1: x = 50; y = 10; break;
        // case 2: x = 200; y = 170; break;
        // }
        //bg.drawImage(moneyImg, x,y);
        setImage(imgInventory);
        items = Alex.getItems();
        int[] itemPosX = new int[1];
        int[] itemPosY = new int[1];
        // switch(version)
        // {
        // case 1: itemPosX = item1PosX; itemPosY = item1PosY; break;
        // case 2: itemPosX = item2PosX; itemPosY = item2PosY; break;
        // }
        itemPosX = item1PosX; 
        itemPosY = item1PosY;
        for(int i = 1;  i < items.length; i++)
        {
            if(i < 15)
            {
                GreenfootImage itemImg;
                String item = items[i];
                //if item has been used is equal to null, so we don't want to draw anything
                if (item != null){

                    itemImg = new GreenfootImage(item + "icon" + ".png");
                    imgInventory.drawImage(itemImg, itemPosX[i-1], itemPosY[i-1]);
                }
            }
        }
    }

    /**
     * Act - do whatever the Inventory wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!created)
        {
            int x = 0;
            int y = 0;
            x = getX() + 127; y = getY() - 50;
            // switch(version)
            // {
            // case 1: x = getX() + 127; y = getY() - 50; break;
            // case 2: x = getX() + 120; y = getY() - 88; break;
            // }
            //getWorld().addObject(new Button(), x,y);    
            created =  true;
        }
        //drag();
        redraw();
    }

    public static void setOpen(boolean opens)
    {
        open = opens;
    }

    public static boolean getOpen()
    {
        return open;
    }

    public void redraw()
    {
        // moneyImg.clear();
        //moneyImg.drawString(Player.getMoney() + "", 0, moneyImg.getHeight()/2);
        //bg.clear();

        imgInventory.drawImage(new GreenfootImage("hud.gif"),0,0);
        // switch(version)
        // {
        // case 1: bg.drawImage(new GreenfootImage("hud_2.png"),0,0); break;
        // case 2: bg.drawImage(new GreenfootImage("2_hud_2.png"),0,0); break;
        // }
        int x = 0;
        int y = 0;
        x = 50; y = 10;
        // switch(version)
        // {
        // case 1: x = 50; y = 10; break;
        // case 2: x = 200; y = 170; break;
        // }
        //bg.drawImage(moneyImg, x,y);

        items = Alex.getItems();

        int[] itemPosX = new int[1];
        int[] itemPosY = new int[1];
        itemPosX = item1PosX; itemPosY = item1PosY;
        // switch(version)
        // {
        // case 1: itemPosX = item1PosX; itemPosY = item1PosY; break;
        // case 2: itemPosX = item2PosX; itemPosY = item2PosY; break;
        // }

        int max = 14;
        // switch(version)
        // {
        // case 1: max = 14; break;
        // case 2: max = 12; break;
        // }
        for(int i = 1;  i < items.length; i++)
        {
            if(i < max+1)
            {
                GreenfootImage itemImg;
                String item = items[i];
                if (item != null){

                    itemImg = new GreenfootImage(item + "icon" + ".png");
                    imgInventory.drawImage(itemImg, itemPosX[i-1], itemPosY[i-1]);
                }
                // int mouseX = Greenfoot.getMouseInfo().getX();

                // int mouseY = Greenfoot.getMouseInfo().getY();
                // if(mouseX < (getX() - getImage().getWidth()/2) + (itemPosX[i-1] + itemImg.getWidth())&& 
                // mouseX > (getX() - getImage().getWidth()/2) + itemPosX[i-1]&&
                // mouseY < (getY() - getImage().getHeight()/2 ) + (itemPosY[i-1] + itemImg.getHeight())&& 
                // mouseY > (getY() - getImage().getHeight()/2) + itemPosY[i-1])
                // {
                // System.out.println("yes");
                // }
                // else {
                // System.out.println("no");
                // }

            }
        }
    }
}