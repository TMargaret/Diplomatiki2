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
    String question = "Ερώτηση";
    int questNum = 1;

    public QuizPic(){

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
            break;
            case 2:
            text = quiz2();
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
}

