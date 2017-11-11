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
    int questNum = 1;
    Button btn1 = new Button();
    Button btn2 = new Button();
    Button btn3 = new Button();
    Button btn4 = new Button();
    Button btn5 = new Button();
    Button btn6 = new Button();
    Button btn7 = new Button();
    boolean isOn = false;
    String text = null;
    static boolean endFlag = false;

    public QuizPic(){

    }

    /**
     * Act - do whatever the butterfly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        drawText();
        lostGame();
    }

    public void lostGame(){
        if (HealthBar.getHealth()<=0){
            
            getImage().clear();
            removeButton();
            
        }
    }

    public void drawText(){
        switch (questNum){
            case 1:
            text = quiz1();
            answerBtn1();
            getAnswer1();          
            break;
            case 2:
            text = quiz2();
            answerBtn2();
            getAnswer2();
            break;
            case 3:
            text = quiz3();
            answerBtn3();
            getAnswer3();
            break;
            case 4:
            text = quiz4();
            answerBtn4();
            getAnswer4();
            break;
            case 5:
            moveNextQuest();
            break;
            case 6:
            repeatOrLeave();
            addButton2();
            setBtn2();
            text = quiz1();
            finishing();
            break;
        }
        if (!isOn){
            isOn = true;           
            getImage().setFont(new Font("Lucida Sans Unicode", 28));
            getImage().drawString(question + questNum, getImage().getWidth()/3, 40);
            getImage().drawString(text, 30, 80);
            addButton4();
            text = "";
        }
    }

    public void repeatOrLeave(){
        getImage().setFont(new Font("Lucida Sans Unicode", 28));
        getImage().drawString("Τέλος ερωτήσεων", 30, 60);
        getImage().drawString(repeatLeave(), 30, 100);
    }

    public void finishing(){
        if (Greenfoot.mouseClicked(btn6)){
            questNum = 1;
            isOn = false;
            getImage().clear();
            removeButton(); 
            setImage(new GreenfootImage(myImage)); 
        }
        if (Greenfoot.mouseClicked(btn7)){         
            endFlag = true;
            removeButton();
            getWorld().removeObject(this);

        }
    }

    public void getAnswer(String order, String textBtn1, String textBtn2, String textBtn3, String textBtn4){
        if (Greenfoot.mouseClicked(btn1)){
            refreshImage();
            if (order.charAt(0) == '1'){
                correctAnswer(textBtn1); 
            }else{
                wrongAnswer(textBtn1);
                HealthBar.looseHealth();
            }
        }
        if (Greenfoot.mouseClicked(btn2)){
            refreshImage();
            if (order.codePointAt(1)== '1'){
                correctAnswer(textBtn2); 
            }else{
                wrongAnswer(textBtn2);
                HealthBar.looseHealth();
            }
        }
        if(Greenfoot.mouseClicked(btn3)){
            refreshImage();
            if (order.codePointAt(2)=='1'){
                correctAnswer(textBtn3); 
            }else{
                wrongAnswer(textBtn3);
                HealthBar.looseHealth();
            }
        }
        if (Greenfoot.mouseClicked(btn4)){
            refreshImage();
            if (order.codePointAt(3)=='1'){
                correctAnswer(textBtn4); 
            }else{
                wrongAnswer(textBtn4);
                HealthBar.looseHealth();
            }
        }
        moveNextQuest();
    }

    public void refreshImage(){
        getImage().clear();
        removeButton();
        addButton1();
        betweenAnswers();  
        setImage(new GreenfootImage(myImage));
        questNum++;
    }

    public void moveNextQuest(){
        if (Greenfoot.mouseClicked(btn5)){
            getImage().clear();
            removeButton();
            setImage(new GreenfootImage(myImage));           
            if (questNum<5){               
                isOn = false;
            }
            if (questNum == 5){
                questNum++;             
            }
        }
    }

    public String quiz1(){
        return "Με τη γραμμή κώδικα:\n"
        +"new Dragon();\n"
        +"Τι από τα παρακάτω θα συμβεί;";
    }

    public String quiz2(){
        return "Ποια γραμμή έχει λάθος;\n"
        +"Γραμμή 1:  Alex.pickup();\n"
        +"Γραμμή 2:  Alex.pickUp();\n"
        +"Γραμμή 3:  Alex.pickup()\n"
        +"Γραμμή 4:  Alex.PickUp();";
    }

    public String quiz3(){
        return "Με τη γραμμή κώδικα:\n"
        +"Alex.pickUp(new Dragon());\n"
        +"Τι από τα παρακάτω θα συμβεί;";
    }

    public String quiz4(){
        return "Με τη γραμμή κώδικα:\n"
        +"clay = new Clay();"
        +"\nΤι από τα παρακάτω θα συμβεί;";
    }

    public String repeatLeave(){
        return "Θέλεις να επαναλάβεις το quiz;";
    }

    public void getAnswer1(){
        String order = "1000";
        String text1 = "Χρησιμοποιώντας τη λέξη-κλειδί new\n"
            +"είναι ο πιο συνηθισμένος τρόπος για να\n"
            +"δημιουργήσεις ένα αντικείμενο.";            
        String text2 = "Δεν υπάρχει συντακτικό λάθος.";
        String text3 = "Η λέξη-κλειδί new χρησιμοποιείται\nγια τη δημιουργία αντικειμένων.";
        String text4 = "Η λέξη-κλειδί new χρησιμοποιείται για τη\nδημιουργία αντικειμένων.\n\n"
            +"Μπορείς να δημιουργήσεις όσα αντικείμενα\nχρειάζεσαι, τα παλιά δε σβήνονται,"
            +"παρά\nμόνο αν το θελήσεις εσύ, με ειδική εντολή.";
        getAnswer(order,text1, text2, text3, text4);
    }

    public void getAnswer2(){
        String order = "0010";
        String text1 = "Είναι καλή τακτική να χρησιμοποιείς\ncamelCase,"
            +" όμως συντακτικά δεν είναι λάθος\nαν δεν το κάνεις.";            
        String text2 = "Είναι καλή τακτική να χρησιμοποιείς\ncamelCase."
            +" Το όνομα αυτής της μεθόδου θα\nήταν η καλύτερη επιλογή.";
        String text3 = "Καλή παρατηρητικότητα!\nΗ παράλειψη του ερωτηματικού στο τέλος\nδημιουργεί"
            +" compile error το οποίο σημαίνει\nότι δε θα τρέξει το πρόγραμμα.";
        String text4 = "Είναι καλή τακτική να χρησιμοποιείς\ncamelCase,"
            +" όμως συντακτικά δεν είναι λάθος\nαν γράψεις και την πρώτη λέξη με\nκεφαλαίο γράμμα.";
        getAnswer(order,text1, text2, text3, text4);
    }

    public void getAnswer3(){
        String order = "0001";
        String text1 = "Δημιουργείται όντως ένα καινούριο\n"
            +"στιγμιότυπο δράκου, αλλά όχι μόνο.";            
        String text2 = "Δεν υπάρχει συντακτικό λάθος.";
        String text3 = "Χρησιμοποιούμε μια μέθοδο, "
            +"όμως συμβαίνει\nκαι κάτι άλλο.";
        String text4 = "Μπράβο!\nΕδώ έχουμε συνδυασμό πραγμάτων.\nΑρχικά"
            +" δημιουργούμε ένα νέο στιγμιότυπο\nδράκου και στη συνέχεια μαζέυουμε αυτό\nτο αντικείμενο.";
        getAnswer(order,text1, text2, text3, text4);
    }

    public void getAnswer4(){
        String order = "0100";
        String text1 = "Δεν υπάρχει συντακτικό λάθος.";            
        String text2 = "\nH clay είναι μια μεταβλητή στην οποία"
            +"\nεκχωρούμε το στιγμιότυπο του πηλού."
            +"\nΣτην εκχώρηση τιμής η διαδικασία"
            +"\nγίνεται από δεξιά προς τα αριστέρα!";
        String text3 = "Η διαφορά είναι λεπτή αλλά σημαντική."
            +"\nΣτην εκχώρηση τιμής η διαδικασία"
            +"\nγίνεται από δεξιά προς τα αριστέρα!";
        String text4 = "Όχι, είναι τελείως λάθος αυτό.";
        getAnswer(order,text1, text2, text3, text4);
    }

    public void answerBtn1(){
        btn1.setTitle("Δημιουργείται ένα νέο στιγμιότυπο δράκου.");
        btn2.setTitle("Τίποτα, υπάρχει συντακτικό λάθος.");
        btn3.setTitle("Δημιουργείται μια καινούρια μέθοδος του δράκου.");
        btn4.setTitle("Εάν υπήρχε δράκος, αυτός ακυρώνεται.");
    }

    public void answerBtn2(){
        btn1.setTitle("H γραμμή 1");
        btn2.setTitle("H γραμμή 2");
        btn3.setTitle("H γραμμή 3");
        btn4.setTitle("H γραμμή 4");
    }

    public void answerBtn3(){
        btn1.setTitle("Δημιουργείται ένα νέο στιγμιότυπο δράκου.");
        btn2.setTitle("Τίποτα, υπάρχει συντακτικό λάθος.");
        btn3.setTitle("Δημιουργείται μια καινούρια μέθοδος του δράκου.");
        btn4.setTitle("Μαζεύουμε ένα καινούριο στιγμιότυπο δράκου.");
    }

    public void answerBtn4(){
        btn1.setTitle("Τίποτα, υπάρχει συντακτικό λάθος.");
        btn2.setTitle("Ένα νέο στιγμιότυπο του πηλού\nεκχωρείται στη μεταβλητή clay.");
        btn3.setTitle("Η μεταβλητή clay ισούται με\nτη δημιουργία νέου πηλού.");
        btn4.setTitle("O Alex δημιουργεί και μαζεύει έναν πηλό.");
    }

    public void setBtn2(){
        btn6.setTitle("NAI");
        btn7.setTitle("OXI");
    }

    public void betweenAnswers(){
        btn5.setTitle("OK");
    }

    public void addButton4(){
        getWorld().addObject(btn1, getImage().getWidth(), getImage().getHeight()- (btn1.getImage().getHeight()*3));
        getWorld().addObject(btn2, getImage().getWidth(), getImage().getHeight()- btn1.getImage().getHeight()*2);
        getWorld().addObject(btn3, getImage().getWidth(), getImage().getHeight()- btn1.getImage().getHeight());
        getWorld().addObject(btn4, getImage().getWidth(), getImage().getHeight());
    }

    public void addButton2(){
        getWorld().addObject(btn6, getImage().getWidth(), getImage().getHeight()- (btn6.getImage().getHeight()*4));
        getWorld().addObject(btn7, getImage().getWidth(), getImage().getHeight()- (btn7.getImage().getHeight()*2));
    }

    public void addButton1(){ 
        getWorld().addObject(btn5, getImage().getWidth(), getImage().getHeight()- btn1.getImage().getHeight());
    }

    public void removeButton(){
        if (getWorld().getObjects(Button.class) != null){
            getWorld().removeObjects(getWorld().getObjects(Button.class));
        }
    }

    public void correctAnswer(String myText){
        getImage().setFont(new Font("Lucida Sans Unicode", 20));
        getImage().setColor(Color.GREEN);
        getImage().drawString("Σωστά!", 30, 80);
        getImage().setColor(Color.BLACK);
        getImage().drawString(myText, 30, 120);
    }

    public void wrongAnswer(String myText){
        getImage().setFont(new Font("Lucida Sans Unicode", 20));
        getImage().setColor(Color.RED);
        getImage().drawString("Λάθος!", 30, 80);
        getImage().setColor(Color.BLACK);
        getImage().drawString(myText, 30, 120);
    }

    public static boolean endLevel(){
        return endFlag;
    }

}
