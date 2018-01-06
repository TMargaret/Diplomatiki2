import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pic4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pic4 extends QuizPic
{
    int fontSize = 18;
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
        " τα μέλη μιας\nυπάρχουσας κλάσης και τα εμπλουτίζει με νέες ή\nτροποποιημένες δυνατότητες.";
    }

    @Override
    public String quiz2(){
        return "public class Animal { "
        +"}\n"
        +"public class Mammal extends Animal { "
        +"}\n"
        +"public class Reptile extends Animal { "
        +"}\n"
        +"public class Dog extends Mammal { "
        +"}\n\n"
        +"Τι ισχύει από τα παρακάτω;";
    }

    @Override
    public String quiz3(){
        return "class Animal {\n"
        +"   public void move() {\n"
        +"       System.out.println(\"Animals can move\");\n"
        +"       }\n"
        +"   }\n"
        +"class Dragon extends Animal {\n"
        +"   public void move() {\n"
        +"       System.out.println(\"Dragons can fly\");\n"
        +"       }\n"
        +"   }\n"
        +"Τι ισχύει από τα παρακάτω;";
    }

    public String quiz4(){
        return "public class Animal { "
        +"}\n"
        +"public class Mammal extends Animal { "
        +"}\n"
        +"public class Dog extends Mammal {\n"
        +"  public static void main(String args[]) {\n"
        +"      Animal a = new Animal();\n"
        +"      Mammal m = new Mammal();\n"
        +"      Dog d = new Dog();\n"
        +"      System.out.println(m instanceof Animal);\n"
        +"      System.out.println(d instanceof Animal);"
        +"  }\n"
        +"}\n"
        +"Τι θα τυπωθεί;";
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
        String text4 = "\nΗ κλάση Dog είναι υποκλάση της Mammal,\nόπου η Mammal είναι υποκλάση της Animal."
            +"\nΆρα η Dog κληρονομεί και από την Animal.";
        getAnswer(order,text1, text2, text3, text4);
    }

    @Override
    public void getAnswer3(){
        String order = "0010";
        String text1 = "";            
        String text2 = "";
        String text3 = "Η εφαρμογή του παραδείγματος.\n"
            +"public class TestDog {\n"
            +"    public static void main(String args[]) {\n"
            +"        Animal b = new Dragon();\n"
            +"        b.move();\n"
            +"    }\n"
            +"}\n"
            +"Output:\n"
            +"Dragons can fly";
        String text4 = "Η εφαρμογή του παραδείγματος.\n"
            +"public class TestDog {\n"
            +"    public static void main(String args[]) {\n"
            +"        Animal b = new Dragon();\n"
            +"        b.move();\n"
            +"    }\n"
            +"}\n"
            +"Output:\n"
            +"Dragons can fly";
        getAnswer(order,text1, text2, text3, text4);
    }

    @Override
    public void getAnswer4(){
        String order = "0001";
        String text1 = "";            
        String text2 = "";
        String text3 = "https://stackoverflow.com/questions/7313559\n/what-is-the-instanceof-operator-used-for-\nin-java";
        String text4 = "";
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
        getWorld().removeObject(btn1);
        getWorld().removeObject(btn2);
        btn3.setTitle("Η μέθοδος move() της κλάσης Dragon\nπαρακάμπτει τη move() της Animal");
        btn4.setTitle("Η μέθοδος move() της κλάσης Dragon\nδεν παρακάμπτει τη move() της Animal");
    }

    @Override
    public void answerBtn4(){
        getWorld().removeObject(btn1);
        getWorld().removeObject(btn2);
        btn3.setTitle("true\nfalse");
        btn4.setTitle("true\ntrue");
    }
}
