import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

/**
 * Write a description of class WrittenText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WrittenText implements Serializable
{
    /**
     * Act - do whatever the WrittenText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public WrittenText(){
    }  

    //level_0
    public String welcomeMsgL0(){
        return "Καλώς ήρθες στον πλανήτη μου Methodius!\n\nΕίμαι ο πλανητάρχης Methodis και μπορώ \nνα σε "+
        "βοηθήσω να φύγεις αρκεί να κάνεις \nκάτι για μένα.";
    }

    public String taskText1L0(){
        return "Το χωριό μου δέχτηκε επίθεση από το\nφοβερό εχθρό DragonDrop.\n\nΚατέστρεψε όλα τα σπίτια μας και"+ 
        "\nμας πήρε όλες τις προμήθειες.";
    }

    public String taskText2L0(){
        return "Όλοι οι κάτοικοι έφυγαν από τον\nMethodius, όμως εγώ έμεινα πίσω\nγια να ξαναχτίσω το χωριό."
        +"\n\nΒοήθησέ με να φτιάξω το σπίτι μου,\nώστε να επιστρέψουν οι Μεθοδιανοί πίσω.";
    }

    public String taskText3L0(){
        return "Αρχικά, πρέπει να μαζέψεις πρώτες ύλες.\n"
        +"\nΣτη συνέχεια θα τις χρησιμοποιήσεις\nγια να επισκευάσεις το σπίτι μου."
        +"\nΗ διαδικασία, αυτή, μοιάζει πολύ\nμε την κλήση μεθόδων (methods)\nστον"
        +" κόσμο των προγραμματιστών.";
    }

    public String taskText4L0(){
        return "Για να μαζέψεις κάποιο αντικείμενο\nγράψε: pickUp();"
        +"\npickUp  -> το όνομα της μεθόδου."
        +"\nΟι παρενθέσεις συνοδεύουν πάντα το\nόνομα της μεθόδου."
        +"\nΤο ερωτηματικό μπαίνει απαραίτητα στο\nτέλος κάθε γραμμής κώδικα!";
    }

    public String taskText5L0(){
        return "Για να χρησιμοποιήσεις κάποιο\nαντικείμενο γράψε: use();"+
        "\n\nΠρόσεξε!\nΟι λάθος απαντήσεις θα σου κοστίσουν\nενέργεια!";
        
    }

    public String taskText6L0(){
        return "Είσαι έτοιμος για την αποστολή σου!\n\nΚαλή επιτυχία!";
    }
    
    public String toFixHouse(){
        return "Χρειάζομαι 2 ξύλα και 2 τούβλα για να φτιάξω το\nσπίτι του Methodius.";
    }

    //level_1
    public String brokenHut(){

        return "Η καλύβα αυτή φαίνεται ετοιμόρροπη.\nΚαλύτερα να τη φτιάξω πριν μπω.";
    }

    public String enteringRoom(){
        return "Είσοδος στο σπίτι...";
    }

    public String exitRoom(){
        return "Έξοδος...";
    }

    public String roomEntranceText(){
        return "Τι περίεργο σπίτι! \nΑ να κι ένα πλάσμα!\nΑς του μιλήσω, μπορεί να με βοηθήσει.";
    }

    public String welcomeMsg(){
        return "Καλώς ήρθες στον πλανήτη μου Objectus!\n\nΕίμαι ο πλανητάρχης Objectis και μπορώ \nνα σε "+
        "βοηθήσω να φύγεις αρκεί να κάνεις \nκάτι για μένα.";
    }

    public String taskText1(){
        return "Υπάρχουν δύο καλύβες έξω, οι οποίες \nχρειάζονται ανακατασκευή.\n\n"+
        "Για να τις φτιάξεις θα χρειαστείς τις\nεξής πρώτες ύλες:\nΞύλο, Πηλό και Άχυρο.";
    }

    public String taskText2(){
        return "Προκειμένου να λάβεις αυτές τις πρώτες\nύλες, θα πρέπει να τις δημιουργήσεις."
        +"\n\nΗ δημιουργία πρώτων υλών, μοιάζει πολύ\nμε τη δημιουργία αντικειμένων (objects)\nστον"
        +" κόσμο των προγραμματιστών.";
    }

    public String taskText3(){
        return "Αρχικά, ας ονομάσουμε τις πρώτες ύλες,\n\"κλάσεις\"."
        +"\n\nΓια παράδειγμα:\nη κλάση Ξύλο,\nη κλάση Πηλός,\nη κλάση Άχυρο.";
    }

    public String taskText4(){
        return "Στη συνέχεια, για να δημιουργήσεις\nκάποια πρώτη ύλη, αρκεί να \"καλέσεις\""
        +"\nτην αντίστοιχη κλάση ως εξής:\n\n π.χ\n new Wood();\n new Clay();";
    }

    public String taskText5(){
        return "new όνομα_κλάσης();\n\n-Το \"new\" υποδηλώνει τη δημιουργία του\nνέου αντικειμένου, οποιασδήποτε κλάσης."
        +"\n-Οι παρενθέσεις συνοδεύουν πάντα το\nόνομα της κλάσης.\n-Το ερωτηματικό μπαίνει απαραίτητα στο\nτέλος κάθε γραμμής κώδικα!";
    }

    public String taskText6(){
        return "Είσαι έτοιμος για την αποστολή σου.\n\nΘυμήσου!\nnew όνομα_κλάσης();\n\nΗ δημιουργία αντικειμένων θα σου\nανοίξει πολλές πόρτες... ";
    }

    public String lockedDoor(){
        return "Είναι κλειδωμένη...\n\nΆραγε μπορώ να την ανοίξω...;";
    }

    public String warningDoor(){
        return "Έκανες λάθος! Έχασες ενέργεια!\n\nΠροσπάθησε ξανά ή μίλα πάλι μαζί μου\nγια βοήθεια.";
    }

    
    
}
