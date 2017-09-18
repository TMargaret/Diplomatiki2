import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class butterfly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class QuizPic extends Actor
{
    GreenfootImage myImage = new GreenfootImage("quiz.png");
    String question = "Ερώτηση";
    String correctAnswer = "1234";
    String givenAnswer = null;
    int questNum = 1;
    Button btn1 = new Button();
    Button btn2 = new Button();
    Button btn3 = new Button();
    Button btn4 = new Button();
    boolean isOn = false;

    public QuizPic(){

    }

    protected void addedToWorld(World w)
    {
        getWorld().addObject(btn1, getImage().getWidth() - btn1.getImage().getWidth()-btn1.getImage().getWidth()/2, getImage().getHeight()- (btn1.getImage().getHeight()*3));
        getWorld().addObject(btn2, getImage().getWidth() - btn2.getImage().getWidth()-btn2.getImage().getWidth()/2, getImage().getHeight()- btn1.getImage().getHeight()*2);
        getWorld().addObject(btn3, getImage().getWidth() - btn3.getImage().getWidth()-btn3.getImage().getWidth()/2 , getImage().getHeight()- btn1.getImage().getHeight());
        getWorld().addObject(btn4, getImage().getWidth() - btn4.getImage().getWidth()-btn4.getImage().getWidth()/2, getImage().getHeight());
    }

    /**
     * Act - do whatever the butterfly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        drawText();
    }

    public void drawText(){

        String text = "";
        switch (questNum){
            case 1:
            text = quiz1();
            answerBtn1();
            getAnswer();          
            break;
            case 2:
            text = quiz2();
            answerBtn2();
            getAnswer();
            break;
            case 3:
            text = quiz3();
            break;
            case 4:
            text = quiz4();
            break;
            case 5:
            text = quiz5();
            break;
        }
        if (!isOn){
            isOn = true; 
            getImage().setFont(new Font("Lucida Sans Unicode", 28));
            getImage().drawString(question + questNum, getImage().getWidth()/3, 40);
            getImage().drawString(text, 30, 80);
        }
    }

    public void getAnswer(){
        if (Greenfoot.mouseClicked(btn1)){
            givenAnswer += 1;
            setImage(new GreenfootImage(myImage));
           // isOn = false;
            //questNum++;
        }
        else if (Greenfoot.mouseClicked(btn2)){
            // givenAnswer += 2;
            // setImage(new GreenfootImage(myImage));
            // isOn = false;
            // questNum++;
        }
        else if(Greenfoot.mouseClicked(btn3)){
            givenAnswer += 3;
        }
        else if (Greenfoot.mouseClicked(btn4)){
            givenAnswer += 4;
        }

    }
    public String quiz1(){
        return "Με τη γραμμή κώδικα:\n"
        +"new Dragon();\n"
        +"Τι από τα παρακάτω θα συμβεί;"
        +"";
    }

    public String quiz2(){
        return "Ποια γραμμή έχει λάθος;\n"
        +"Alex.pickup();\n"
        +"Alex.pickUp();\n"
        +"Alex.pickup()\n"
        +"Alex.PickUp();";
    }

    public String quiz3(){
        return "Με τη γραμμή κώδικα:\n"
        +"new Dragon();\n"
        +"Τι από τα παρακάτω θα συμβεί;"
        +"";
    }

    public String quiz4(){
        return "Με τη γραμμή κώδικα:\n"
        +"new Dragon();\n"
        +"Τι από τα παρακάτω θα συμβεί;"
        +"";
    }

    public String quiz5(){
        return "Με τη γραμμή κώδικα:\n"
        +"new Dragon();\n"
        +"Τι από τα παρακάτω θα συμβεί;"
        +"";
    }

    public void answerBtn1(){
        btn1.setTitle("Τίποτα");
        btn2.setTitle("Τίποτα");
        btn3.setTitle("Τίποτα");
        btn4.setTitle("Τίποτα");
    }

    public void answerBtn2(){
        btn1.setTitle("Τίποτα");
        btn2.setTitle("Τίποτα");
        btn3.setTitle("Τίποτα");
        btn4.setTitle("Τίποτα");
    }

    public void answerBtn3(){
        btn1.setTitle("Τίποτα");
        btn2.setTitle("Τίποτα");
        btn3.setTitle("Τίποτα");
        btn4.setTitle("Τίποτα");
    }

    public void answerBtn4(){
        btn1.setTitle("Τίποτα");
        btn2.setTitle("Τίποτα");
        btn3.setTitle("Τίποτα");
        btn4.setTitle("Τίποτα");
    }

    public void answerBtn5(){
        btn1.setTitle("Τίποτα");
        btn2.setTitle("Τίποτα");
        btn3.setTitle("Τίποτα");
        btn4.setTitle("Τίποτα");
    }

    
}

