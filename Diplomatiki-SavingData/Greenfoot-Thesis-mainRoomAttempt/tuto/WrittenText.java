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

    String debuggerMsg = "Έχασες ενέργεια!\n\nΠροσπάθησε ξανά ή μίλα πάλι μαζί μου\nγια βοήθεια.";
    /**
     * Act - do whatever the WrittenText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public WrittenText(){
    }  

    public String exit(){
        return "Έξοδος;";
    }
    //level1
    public String welcomeMsgL0(){
        return "Καλώς ήρθες στον πλανήτη μου Methodius!\n\nΕίμαι ο πλανητάρχης Methodis και μπορώ \nνα σε "+
        "βοηθήσω να φύγεις αρκεί να κάνεις \nκάτι για μένα.";
    }

    public String taskText1L0(){
        return "Το χωριό μου δέχτηκε επίθεση από το φοβερό\nεχθρό DragonDrop.\n\nΚατέστρεψε όλα τα σπίτια μας και"+ 
        " μας πήρε\nόλες τις προμήθειες."
        +"\n\nΒοήθησέ με να φτιάξω το σπίτι μου, ώστε να\nεπιστρέψουν οι Μεθοδιανοί πίσω.";
    }

    public String taskText2L0(){
        return "Αρχικά, πρέπει να μαζέψεις πρώτες ύλες"
        +" και\nέπειτα να τις χρησιμοποιήσεις."
        +"\nΓια να το πετύχεις αυτό, πρέπει να αποκτήσεις"
        +"\nδύο νέες δυνάμεις:"
        +"\nuse();"
        +"\npickUp();"
        +"\nΗ διαδικασία, αυτή, είναι η κλήση μεθόδων\n(methods).";
    }

    public String taskText3L0(){
        return "Ας δούμε πρώτα πως μοιάζει η μέθοδος use:\n\npublic void use(){}"
        +"\n\nΑυτή είναι η επικεφαλίδα της μεθόδου, η\nοποία περιλαμβάνει όλες τις απαραίτητες\nπληροφορίες για την ενεργοποίησή της και\nονομάζεται υπογραφή (signature) της μεθόδου.";
    }

    public String taskText4L0(){
        return "Μια μέθοδος μπορεί να χρησιμοποιηθεί για να\nαλλάξουμε την κατάσταση "
        +"ενός αντικειμένου\nή να προσπελάσουμε κάποιες από τις\nπληροφορίες που περικλείει το αντικείμενο."
        +"\nAς δούμε τι μπορεί να περιλαμβάνει το 'σώμα'\nτης μεθόδου use:"
        +"\npublic void use(){   discard = wood;   }";
    }

    public String taskText5L0(){
        return "Ωστόσο για να εκτελεστεί μια μέθοδος, πρέπει\nνα την καλέσω με το όνομά της."
        +"\nπ.χ   use();"
        +"\nΟι παρενθέσεις συνοδεύουν πάντα το όνομα\nτης μεθόδου."
        +"\nΤο ερωτηματικό μπαίνει απαραίτητα στο τέλος\nκάθε γραμμής κώδικα!";
    }

    public String taskText6L0(){
        return "Οι δυνάμεις σου ανήκουν. Για να λειτουργήσουν\nσωστά"
        +" χρειάζονται και το όνομά σου:\nπ.χ Alex.pickUp();"
        +"\nΤα ΚΕΦΑΛΑΙΑ και τα πεζά γράμματα, έχουν\nσημασία!"
        +" Οι λάθος απαντήσεις θα σου κοστίσουν\nενέργεια."
        +" Φυλάξου από τη βροχή μετεωριτών\nπου πλησιάζει!";
    }

    public String toFixHouse(){
        return "Χρειάζομαι 2 ξύλα και 2 τούβλα για να φτιάξω το\nσπίτι του Methodius.";
    }

    public String allMaterial(){
        return "Έχω όλα τα υλικά.\nΤώρα θα πρέπει να τα χρησιμοποιήσω.";
    }

    public String wellDone(){
        return "Τα κατάφερες!\n\nΟι Μεθοδιανοί σου είναι ευγνώμονες.\nΤώρα μπορείς να αποχωρήσεις"
        +" από τον\nMethodis.\n\nLive long and prosper!";
    }

    public String youLost(){
        return "Έχασες όλη σου την ενέργεια!\nΞαναπροσπάθησε!";
    }

    //level3
    public String welcomeMsgL02(){
        return "Καλώς ήρθες στον πλανήτη μου Objectus!\n\nΕίμαι ο πλανητάρχης Objectis και μπορώ \nνα σε "+
        "βοηθήσω να φύγεις αρκεί να κάνεις \nκάτι για μένα.";
    }

    public String taskText1L02(){
        return "Το χωριό μου δέχτηκε επίθεση από το\nφοβερό εχθρό DragonDrop.\n\nΚατέστρεψε τη μοναδική γέφυρα"+ 
        "\nπου οδηγεί στο σπίτι μου.";
    }

    public String taskText2L02(){
        return "Βοήθησέ με να φτιάξω τη γέφυρα,ώστε\nνα μπορέσω να επιστρέψω σπίτι μου."+
        "\n\nΣε αντάλλαγμα θα σου δώσω νέες\nδυνάμεις.";
    }

    public String taskText3L02(){
        return "Για να φτιάξεις τη γέφυρα χρειάζεσαι\nΠηλό και Ξύλο.\n"
        +"Προκειμένου να λάβεις αυτές τις πρώτες\nύλες, θα πρέπει να τις δημιουργήσεις."
        +"\nΗ διαδικασία, αυτή, μοιάζει πολύ με τη\nδημιουργία αντικειμένων (objects)\nστον"
        +" κόσμο των προγραμματιστών.";
    }

    public String taskText4L02(){
        return "Κάθε πινακίδα απεικονίζει μια πρώτη ύλη,\nή αλλιώς, μια κλάση."
        +" Για παράδειγμα:\nη κλάση Ξύλο, η κλάση Πηλός."
        +"\nΧρησιμοποιώντας την εντολή new Wood();\nμπορείς να δημιουργήσεις αντικείμενα της\nκλάσης αυτής. ";
    }

    public String taskText5L02(){
        return "new όνομα_κλάσης();\n-Με το \"new\" καλείται μια ειδική λειτουργία\nκλάσης, που έχει το ίδιο όνομα με αυτή και\nονομάζεται κατασκευαστής."
        +"\n-Οι παρενθέσεις συνοδεύουν πάντα το\nόνομα της κλάσης.\n-Το ερωτηματικό μπαίνει απαραίτητα στο\nτέλος κάθε γραμμής κώδικα!";
    }

    public String taskText6L02(){
        return "Μια ακόμα νέα δύναμη είναι η useAll();\nΓια να λειτουργήσει σωστά"
        +" χρειάζεται\nτο όνομά σου.\nΧρησιμοποίησέ την σοφά!"
        +"\n\nΤέλος, πρόσεξε τις πεταλούδες που πετούν.\nΔεν είναι τόσο άκακες όσο φαίνονται..";
    }

    public String wellDonelvl2(){
        return "Τα κατάφερες! \nΜπορείς να επισκεφθείς το σπίτι μου\nπριν φύγεις.";
    }

    //level3
    public String brokenHut(){

        return "Η καλύβα αυτή φαίνεται ετοιμόρροπη.\nΚαλύτερα να τη φτιάξω πριν μπω.\n\nΧρειάζομαι ξύλο και άχυρο.";
    }

    public String brokenWell(){

        return "Το πηγάδι είναι κατεστραμμένο..\nΧρειάζομαι δύο τούβλα..";
    }

    public String enteringRoom(){
        return "Είσοδος...";
    }

    public String exitRoom(){
        return "Έξοδος...";
    }

    public String welcomeMsg(){
        return "Καλώς ήρθες στον πλανήτη μου Parametrus!\n\nΕίμαι ο πλανητάρχης Parametris και μπορώ \nνα σε "+
        "βοηθήσω να φύγεις αρκεί να κάνεις \nκάτι για μένα.";
    }

    public String taskText1(){
        return "Το χωριό μου δέχτηκε επίθεση από το\nφοβερό εχθρό DragonDrop.\n"
        +"Το πηγάδι και η αποθήκη με τα τρόφιμα\nκαταστράφηκαν, για να τα φτιάξεις, θα\nχρειαστείς Τούβλα, Ξύλο και Άχυρο."
        +"\nEυτυχώς ο φούρνος που φτιάχνει"
        +" τα τούβλα\nλειτουργεί ακόμα, όμως δε θυμάμαι που\nέβαλα το κλειδί για την πόρτα.";
    } 

    public String taskText2(){
        return "Προκειμένου να μαζέψεις τα υλικά, θα\nπρέπει να αποκτήσεις νέα δύναμη."
        +" Η νέα\nδύναμη σου επιτρέπει να μαζέψεις ή να\nχρησιμοποιήσεις μια συγκεκριμένη πρώτη\nύλη. "
        +"Για παράδειγμα:\nAlex.pickUp(wood);"
        +"\nH λέξη μέσα στην παρένθεση ονομάζεται\nπαράμετρος στον κόσμο των προγραμματιστών.";

    }

    public String taskText3(){
        return "Χρησιμοποιούμε παραμέτρους (parameters)\nγια την παροχή των επιπλέον πληροφοριών."
        +"\nΜε άλλα λόγια χρησιμεύει όταν θέλουμε να\nστείλουμε συγκεκριμένες τιμές σε μια\nμέθοδο."     
        +" Κάθε παράμετρος μιας μεθόδου έχει:\n-ένα συγκεκριμένο τύπο δεδομένων, που\nκαθορίζει"
        +" τι είδους τιμές μπορεί να πάρει\nη παράμετρος\n-ένα αντιπροσωπευτικό όνομα (name).";
    }

    public String taskText4(){
        return "Ας δούμε πως αλλάζει η υπογραφή της\nμεθόδου use:\n\npublic void use(Data_type material){ }"
        +"\n\nTo Data_type μπορεί να είναι integer,\nString ακόμα και κάποιο object."
        +"\nΤο material είναι το όνομα της παραμέτρου.";
    }

    public String taskText5(){
        return "Η λειτουργία της μεθόδου εξαρτάται\nαπό το τι περιέχει το σώμα της. Π.χ:"
        +"\npublic void use(Object material){\n   delete(material);   \n}"
        +"\nΚαλώντας την παραπάνω μέθοδο ως εξής:"
        +"\nuse(straw);\n"
        +"Στην ουσία προκαλούμε τη διαγραφή του\nαντικειμένου straw.";
    }

    public String taskText6(){
        return "Τέλος, μια μέθοδος μπορεί να πάρει όσες\nπαραμέτρους χρειαζόμαστε:"
        +"\nH υπογραφή της μεθόδου use θα ήταν:\npublic void use(Object wood, Object straw)\n{}\n"
        +"\nκαι αντίστοιχα η κλήση της θα ήταν:\nAlex.use(wood,straw);";
    }

    public String taskText7(){
        return "Είσαι έτοιμος για την αποστολή σου.\n\n"
        +"Ο φούρνος που φτιάχνει τούβλα ευτυχώς\nλειτουργεί."
        +"\nΚαλή τύχη.";
    }

    public String lockedDoor(){
        return "Είναι κλειδωμένη...\n\nΆραγε μπορώ να την ανοίξω...;";
    }

    public String wellDone2(){
        return "Τα κατάφερες!\n\nΤώρα μπορείς να αποχωρήσεις"
        +" από τον\nParametrus.\n\nLive long and prosper!";
    }

    //dragon
    public String dragon0(){
        return "Είμαι ο φοβερός DragonDrop και ήρθε η\nώρα να με αντιμετωπίσεις.";
    }

    public String dragon1(){
        return "Βλέπω το φόβο και την αδυναμία\nστα μάτια σου."
        +"\n\nΣε προκαλώ να μου δείξεις τις δυνάμεις\nσου σε μια αναμέτρηση γνώσεων.";
    }

    public String dragon2(){
        return "Είσαι έτοιμος;";
    }

    public String dragon3(){
        return "Εμείς οι δύο δεν έχουμε τελειώσει...\n";
    }

    //level4
    public String repeatOrLeave(){
        return "Δεν έχεις μαζέψει τα σωστά ανταλλακτικά.\n\nΘέλεις να αρχίσεις ξανά;";
    }

    public String notEnough(){
        return "Δεν έχεις μαζέψει όλα τα ανταλλακτικά.\n\nΣυνέχισε την αναζήτηση...";
    }

    public String wellDone4(){
        return "Τα κατάφερες!\n\nLive long and prosper!";
    }

    //level5
    public String boat(){
        return
        "public class Boat {\n"+
        "  public static void main(String args[]) {\n"+
        "     ArrayList<String> cargo = new ArrayList<String>();\n"+
        "     cargo.add(\"wood\");\n"+
        "     cargo.add(\"clay\");\n"+
        "     cargo.add(\"brick\");\n"+
        "     cargo.set(2,\"wood\");\n"+
        "     cargo.add(\"straw\");\n"+
        "     cargo.remove(1);\n"+
        "     cargo.add(\"brick\");\n"+
        "     cargo.remove(0);\n"+
        "     System.out.println(cargo.size());\n"+
        "    }\n"+
        " }\n\nΤι θα τυπωθεί;";
    }

    public String moveOrStudy(){
        return "Πίεσε\n\n1 για να ελέγξεις το φορτίο"+
        "\n\n2 για να περάσεις απένταντι";
    }

    public String crate(){
        return
        "public class Box {\n\n"+
        "  public static void  --------- (String args[]) {\n\n"+
        "     ArrayList<Material> unloadCargo =  -------  ArrayList<   ---------------    >();\n\n"+
        "     unloadCargo.add( \"   ---------------  \" );\n\n"+
        "     --------------  .add(\"straw\");\n\n"+
        "     unloadCargo.add(\"   --------------  \");\n\n";
    }
    
    public String youLostLvl5(){
        return "Η λύση δεν ήταν σωστή.\n\nΞαναπροσπάθησε!";
    }
}
