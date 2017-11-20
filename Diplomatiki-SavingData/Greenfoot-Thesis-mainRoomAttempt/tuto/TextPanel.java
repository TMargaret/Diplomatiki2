import greenfoot.*;
import java.io.*;

//κλάση του τελικού πίνακα ScoreBoard ο οποίος χρησιμοποιείται είτε σε περίπτωση νίκης, είτε ήττας
//author M Kölling
//modifications Trifou Margaret
//BrokenHutMessage, RoomEntranceText, welcomeMsg, taskText1-6,lockedDoor, warningForDoor

public class TextPanel extends Actor implements Serializable
{
    public static final float FONT_SIZE = 24.0f;
    public static final int WIDTH = 540;
    public static final int HEIGHT = 330;
    // public static final int TOTAL_ANSWERS = 6;
    private String status = null;
    private WrittenText text;
    private int counter = 1;
    private int count_slide = 0;
    String debugMsg = null;
    //private int iScore, lives, wrong_answers = 0;

    private GreenfootImage image;

    public TextPanel(String status)
    {
        this.status = status;
        text = new WrittenText();
        //this.iScore = iScore;
        //wrong_answers = TOTAL_ANSWERS - iScore;

    }

    public TextPanel(String status, String debugMsg)
    {
        this.status = status;
        this.debugMsg = debugMsg;
        text = new WrittenText();
    }

    public void act()
    {

    }

    protected void addedToWorld(World w){
        if (w instanceof Level_0 || w instanceof Level_02){
            makeTextL0();
        }
        if (w instanceof Level_02){
            makeTextL1();
        }
        if (w instanceof Level_1 || w instanceof mainHouseRoom || w instanceof mainHutRoom){
            makeTextL2();
        }
        if (w instanceof Level_022){
            makeTextL22();
        }
        if (w instanceof Level4){
            makeTextL4();
        }
    }

    private void makeTextL0(){

        if (status == "welcomeMsgL0") {
            String mytext = text.welcomeMsgL0();
            count_slide = 1;
            makeImage(mytext, "alien");
        }
        if (status == "taskText1L0") {
            String mytext = text.taskText1L0();
            count_slide = 2;
            makeImage(mytext, "alien");
        }
        if (status == "taskText2L0") {
            String mytext = text.taskText2L0();
            count_slide = 3;
            makeImage(mytext, "alien");
        }
        if (status == "taskText3L0") {
            String mytext = text.taskText3L0();
            count_slide = 4;
            makeImage(mytext, "alien");
        }
        if (status == "taskText4L0") {
            String mytext = text.taskText4L0();
            count_slide = 5;
            makeImage(mytext, "alien");
        }
        if (status == "taskText5L0") {
            String mytext = text.taskText5L0();
            count_slide = 6;
            makeImage(mytext, "alien");
        }
        if (status == "taskText6L0") {
            String mytext = text.taskText6L0();
            count_slide = 7;
            makeImage(mytext, "alien");
        }
        //debugger message
        if (status == "wrongKey"){
            makeImage(debugMsg, "alien");
        }
        if (status == "houseMsgL0"){
            String mytext = text.toFixHouse();
            makeImage(mytext);
        }
        if (status == "allMaterial"){
            String mytext = text.allMaterial();
            makeImage(mytext);
        }
        if (status == "wellDone"){
            String mytext = text.wellDone();
            makeImage(mytext, "alien");
        }
        if (status == "youLost"){
            String mytext = text.youLost();
            makeImage(mytext, "alien");
        }

    }

    public void makeTextL1(){
        if (status == "welcomeMsgL02") {
            String mytext = text.welcomeMsgL02();
            count_slide = 1;
            makeImage(mytext, "alien");
        }
        if (status == "taskText1L02") {
            String mytext = text.taskText1L02();
            count_slide = 2;
            makeImage(mytext, "alien");
        }
        if (status == "taskText2L02") {
            String mytext = text.taskText2L02();
            count_slide = 3;
            makeImage(mytext, "alien");
        }
        if (status == "taskText3L02") {
            String mytext = text.taskText3L02();
            count_slide = 4;
            makeImage(mytext, "alien");
        }
        if (status == "taskText4L02") {
            String mytext = text.taskText4L02();
            count_slide = 5;
            makeImage(mytext, "alien");
        }
        if (status == "taskText5L02") {
            String mytext = text.taskText5L02();
            count_slide = 6;
            makeImage(mytext, "alien");
        }
        if (status == "taskText6L02") {
            String mytext = text.taskText6L02();
            count_slide = 7;
            makeImage(mytext, "alien");
        }
        //debugger message
        if (status == "wrongKey"){
            makeImage(debugMsg, "alien");
        }
        if (status == "youLost"){
            String mytext = text.youLost();
            makeImage(mytext, "alien");
        }
        // if (status == "houseMsgL0"){
        // String mytext = text.toFixHouse();
        // makeImage(mytext);
        // }
        if (status == "enteringRoom") {
            String mytext = text.enteringRoom();
            makeImage(mytext);
        }
        if (status == "wellDonelvl2"){
            String mytext = text.wellDonelvl2();
            makeImage(mytext, "alien");
        }

    }

    private void makeTextL2(){
        if (status == "BrokenHutMessage") {
            String mytext = text.brokenHut();
            makeImage(mytext);
        }
        if (status == "BrokenWellMessage") {
            String mytext = text.brokenWell();
            makeImage(mytext);
        }
        if (status == "enteringRoom") {
            String mytext = text.enteringRoom();
            makeImage(mytext);
        }
        if (status == "exitRoom") {
            String mytext = text.exitRoom();
            makeImage(mytext);
        }
        if (status == "welcomeMsg") {
            String mytext = text.welcomeMsg();
            count_slide = 1;
            makeImage(mytext, "elder");
        }
        if (status == "taskText1") {
            String mytext = text.taskText1();
            count_slide = 2;
            makeImage(mytext, "elder");
        }
        if (status == "taskText2") {
            String mytext = text.taskText2();
            count_slide = 3;
            makeImage(mytext, "elder");
        }
        if (status == "taskText3") {
            String mytext = text.taskText3();
            count_slide = 4;
            makeImage(mytext, "elder");
        }
        if (status == "taskText4") {
            String mytext = text.taskText4();
            count_slide = 5;
            makeImage(mytext, "elder");
        }
        if (status == "taskText5") {
            String mytext = text.taskText5();
            count_slide = 6;
            makeImage(mytext, "elder");
        }
        if (status == "taskText6") {
            String mytext = text.taskText6();
            count_slide = 7;
            makeImage(mytext, "elder");
        }
        if (status == "lockedDoor") {
            String mytext = text.lockedDoor();
            makeImage(mytext);
        }
        if (status == "wellDone2"){
            String mytext = text.wellDone2();
            makeImage(mytext, "elder");
        }
        //method for debug messages
        if (status == "wrongKey"){
            makeImage(debugMsg, "elder");
        }
        if (status == "youLost"){
            String mytext = text.youLost();
            makeImage(mytext, "elder");
        }
    }

    private void makeTextL22(){
        if (status == "dragon0"){
            String mytext = text.dragon0();
            makeImage(mytext, "dragon");
        }
        if (status == "dragon1"){
            String mytext = text.dragon1();
            makeImage(mytext, "dragon");
        }
        if (status == "dragon2"){
            String mytext = text.dragon2();
            makeImage(mytext, "dragon");
        }
        if (status == "dragon3"){
            String mytext = text.dragon3();
            makeImage(mytext, "dragon");
        }
        if (status == "youLost"){
            String mytext = text.youLost();
            makeImage(mytext, "dragon");
        }
    }
    
        private void makeTextL4(){
        if (status == "youLost"){
            String mytext = text.youLost();
            makeImage(mytext, "dragon");
        }
    }

    private void makeImage(String title)
    //δημιουργείται η εικόνα του ScoreBoard
    {
        image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(new Color(0,255,200, 128));
        image.fillRect(0, 0, image.getWidth(),image.getHeight());
        image.setColor(new Color(200, 130, 120, 128));
        image.fillRect(5, 5, image.getWidth()- 10, image.getHeight()-10);
        Font font = image.getFont();
        font = font.deriveFont(22.0f);
        image.setFont(font);
        image.setColor(Color.YELLOW);
        image.drawString(title, 5, 30);
        //image.drawString(prefix, 60, 150);
        //ανάλογα με την περίπτωση εμφανίζεται το κατάλληλο μήνυμα
        if ((status == "BrokenHutMessage") || (status == "RoomEntranceText" || (status == "BrokenWellMessage"))
        || (status == "welcomeMsg")) image.drawString("Πάτα ENTER", 30, 290);
        if (status == "lockedDoor" || status=="houseMsgL0") image.drawString("Πάτα ENTER", 30, 290);
        if (status == "allMaterial")  image.drawString("Πάτα ENTER", 30, 290);
        // if (status == "start2") image.drawString("Πάτα ENTER", 200, 280);
        // if (status == "start_quiz") image.drawString("Πάτα ENTER", 200, 280);
        // if (status == "start_quiz2") image.drawString("Πάτα ENTER για να ξεκινήσεις", 60, 280);
        setImage(image);

    }

    private void makeImage(String title, String icon)
    //δημιουργείται η εικόνα του ScoreBoard
    {     
        //level 0
        if (icon == "alien"){
            image = new GreenfootImage(WIDTH, HEIGHT);
            image.setColor(new Color(200,0,1, 100));
            image.fillRect(0, 0, image.getWidth(),image.getHeight());
            image.setColor(new Color(50, 200, 100, 180));
            image.fillRect(5, 5, image.getWidth()- 10, image.getHeight()-10);
            image.setFont(new Font("Lucida Sans Unicode", 20));
            image.setColor(Color.WHITE);
            if (status == "welcomeMsgL0" || status == "taskText1L0" || status == "taskText2L0"
            || status == "taskText3L0" || status == "taskText4L0" || status == "taskText5L0"
            || status == "taskText6L0" )
            {
                image.drawString("Πάτα ENTER", 30, 290);
                image.drawString(count_slide+"/7", 450, 290);
            }
            if (status == "wrongKey" || status=="wellDone") image.drawString("Πάτα ENTER", 30, 290);
            if (status == "welcomeMsgL02" || status == "taskText1L02" || status == "taskText2L02"
            || status == "taskText3L02" || status == "taskText4L02" || status == "taskText5L02"
            || status == "taskText6L02" )
            {
                image.drawString("Πάτα ENTER", 30, 290);
                image.drawString(count_slide+"/7", 450, 290);
            }
            if (status == "wrongKey" || status=="wellDone" || status=="wellDonelvl2") image.drawString("Πάτα ENTER", 30, 290);
            if (status=="youLost") image.drawString("Πάτα SPACE", 30, 290);

        }
        //level 1
        if (icon == "elder"){
            image = new GreenfootImage(WIDTH, HEIGHT);
            image.setColor(new Color(130,24,24, 255));
            image.fillRect(0, 0, image.getWidth(),image.getHeight());
            image.setColor(new Color(200, 163, 92, 100));
            image.fillRect(5, 5, image.getWidth()- 10, image.getHeight()-10);
            image.setFont(new Font("Monospaced", 20));
            image.setColor(Color.WHITE);          

            if (status == "welcomeMsg" || status == "taskText1" || status == "taskText2" || 
            status == "taskText3" || status == "taskText4" || status == "taskText5" || status == "taskText6"){
                image.drawString("Πάτα ENTER", 30, 290);
                image.drawString(count_slide+"/7", 450, 290);
            }
            if ((status == "wrongKey") || (status == "wellDone2") ) image.drawString("Πάτα ENTER", 30, 290);
            if (status=="youLost") image.drawString("Πάτα SPACE", 30, 290);
        }

        if (icon == "dragon"){
            image = new GreenfootImage(WIDTH, HEIGHT);
            image.setColor(new Color(50,50,50, 255));
            image.fillRect(0, 0, image.getWidth(),image.getHeight());
            image.setColor(new Color(200, 163, 92, 100));
            image.fillRect(5, 5, image.getWidth()- 10, image.getHeight()-10);
            image.setFont(new Font("Serif", 29));
            image.setColor(Color.LIGHT_GRAY);          

            if (status == "dragon0" || status == "dragon1" || status == "dragon2" || status=="dragon3") image.drawString("Πάτα ENTER", 30, 290);
            if (status=="youLost") image.drawString("Πάτα SPACE", 30, 290);
        }
        image.drawString(title, 30, 50);
        setImage(image);

    }
}