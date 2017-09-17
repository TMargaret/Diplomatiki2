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
    GreenfootImage myImage = getImage();
    String question = "Ερώτηση";
    String correctAnswer = "1234";
    String givenAnswer = null;
    int questNum = 1;
    Button btn1 = new Button();
    Button btn2 = new Button();
    Button btn3 = new Button();
    Button btn4 = new Button();

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
        getImage().setFont(new Font("Lucida Sans Unicode", 28));
        getImage().drawString(question + questNum, getImage().getWidth()/3, 60);
        getImage().drawString(text, 30, 100);        
    }
    
    public void getAnswer(){
        if (Greenfoot.mouseClicked(btn1)){
            givenAnswer += 1;
            setBackground().
        }
        if (Greenfoot.mouseClicked(btn2)){
            givenAnswer += 2;
        }
        if (Greenfoot.mouseClicked(btn3)){
            givenAnswer += 3;
        }
        if (Greenfoot.mouseClicked(btn4)){
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
        return "Με τη γραμμή κώδικα:\n"
        +"new Dragon();\n"
        +"Τι από τα παρακάτω θα συμβεί;"
        +"";
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

