import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pic4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pic4 extends QuizPic
{
    int fontSize = 20;
    /**
     * Act - do whatever the Pic4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        drawText();
        lostGame();
    }
    
    public int getFont(){
        return fontSize;
    }

    @Override
    public String quiz1(){
        return "1.Η κληρονομικότητα είναι μια μορφή\nεπαναχρησιμοποίησης"+
        " λογισμικού κατά την\nοποία δημιουργείται μια νέα κλάση.\n2.Η νέα κλάση απορροφά"+
        " τα μέλη μιας υπάρχουσας\nκλάσης και τα εμπλουτίζει με νέες ή\nτροποποιημένες δυνατότητες.";
    }

    @Override
    public String quiz2(){
        return "public class Animal { "
        +"}\n"
        +"public class Mammal extends Animal { "
        +"}\n\n"
        +"public class Reptile extends Animal { "
        +"}\n\n"
        +"public class Dog extends Mammal { "
        +"}\n";
    }

    @Override
    public String quiz3(){
        return "Με τη γραμμή κώδικα:\n"
        +"Alex.pickUp(new Dragon());\n"
        +"Τι από τα παρακάτω θα συμβεί;";
    }

    public String quiz4(){
        return "Με τη γραμμή κώδικα:\n"
        +"Clay clay = new Clay();"
        +"\nΤι από τα παρακάτω θα συμβεί;";
    }

    @Override
    public void getAnswer1(){
        String order = "0001";
        String text1 = "Η πρόταση 1 είναι αληθής, αλλά όχι μόνο..";            
        String text2 = "Η πρόταση 2 είναι αληθής, αλλά όχι μόνο..";
        String text3 = "Μήπως να έκανες μια επανάληψη στη\nθεωρία;";
        String text4 = "Well done!";
        getAnswer(order,text1, text2, text3, text4);
    }

    @Override
    public void getAnswer2(){
        String order = "0001";
        String text1 = "Το ανάποδο θα έλεγε κανείς!";            
        String text2 = "Το ανάποδο θα έλεγε κανείς!";
        String text3 = "Μήπως να έκανες μια επανάληψη στη\nθεωρία;";
        String text4 = "Ακριβώς!\nΗ κλάση Dog είναι υποκλάση της Mammal,\nόπου η Mammal είναι υποκλάση της Animal."
        +"Άρα η Dog κληρονομεί και από την Animal.\nΔεύτερος βαθμός κληρονομικότητας!";
        getAnswer(order,text1, text2, text3, text4);
    }

    @Override
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

    @Override
    public void getAnswer4(){
        String order = "0100";
        String text1 = "Δεν υπάρχει συντακτικό λάθος.";            
        String text2 = "\nH clay είναι μια μεταβλητή τύπου Clay στην\nοποία"
            +" εκχωρούμε το στιγμιότυπο του πηλού."
            +"\nΣτην εκχώρηση τιμής η διαδικασία"
            +"\nγίνεται από δεξιά προς τα αριστέρα!";
        String text3 = "Η διαφορά είναι λεπτή αλλά σημαντική."
            +"\nΣτην εκχώρηση τιμής η διαδικασία"
            +"\nγίνεται από δεξιά προς τα αριστέρα!";
        String text4 = "Όχι, είναι τελείως λάθος αυτό.";
        getAnswer(order,text1, text2, text3, text4);
    }

    @Override
    public void answerBtn1(){
        btn1.setTitle("Συμφωνώ με την πρόταση 1");
        btn2.setTitle("Συμφωνώ με την πρόταση 2");
        btn3.setTitle("Δε συμφωνώ");
        btn4.setTitle("Συμφωνώ και με τις 2 προτάσεις");
    }

    @Override
    public void answerBtn2(){
        btn1.setTitle("H Animal είναι η υποκλάση της Mammal κλάσης.");
        btn2.setTitle("Η Animal είναι η υποκλάση της Reptile κλάσης.");
        btn3.setTitle("Οι Mammal και Reptile είναι υπερκλάσεις της Animal.");
        btn4.setTitle("Η Dog είναι η υποκλάση των Mammal και Animal.");
    }

    @Override
    public void answerBtn3(){
        btn1.setTitle("Δημιουργείται ένα νέο στιγμιότυπο δράκου.");
        btn2.setTitle("Τίποτα, υπάρχει συντακτικό λάθος.");
        btn3.setTitle("Δημιουργείται μια καινούρια μέθοδος του δράκου.");
        btn4.setTitle("Μαζεύουμε ένα καινούριο στιγμιότυπο δράκου.");
    }

    @Override
    public void answerBtn4(){
        btn1.setTitle("Τίποτα, υπάρχει συντακτικό λάθος.");
        btn2.setTitle("Ένα νέο στιγμιότυπο του πηλού\nεκχωρείται στη μεταβλητή clay.");
        btn3.setTitle("Η μεταβλητή clay ισούται με\nτη δημιουργία νέου πηλού.");
        btn4.setTitle("O Alex δημιουργεί και μαζεύει έναν πηλό.");
    }
}
