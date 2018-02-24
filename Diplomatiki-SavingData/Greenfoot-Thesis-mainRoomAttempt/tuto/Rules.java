import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rules here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rules extends World implements ButtonResponder
{
    Label lbl, rules;
    Button menuBtn;

    /**
     * Constructor for objects of class Rules.
     * 
     */
    public Rules()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        prepare();
    }

    public void prepare(){
        lbl = new Label("Back", 50);
        lbl.setFillColor(Color.WHITE);
        addObject(lbl, 70, 30);

        menuBtn = new Button(lbl.getImage().getWidth(), lbl.getImage().getHeight());
        addObject(menuBtn, 70, 30);
        menuBtn.setResponder(this);

        rules = new Label(myRules(),28);
        rules.setFillColor(Color.WHITE);
        addObject(rules, 500, 300);
        
        Button btn = new Button("ΚΟΥΜΠΙ");
        addObject(btn, 334, 410);
    }   

    public void buttonClicked(Button button){
        if (Greenfoot.mouseClicked(menuBtn)){
            Greenfoot.setWorld(new LevelsScreen());
        }
    }

    public String myRules(){
        return "Το όνομά σου είναι Alex.\nΘα σου χρειαστεί για να καλείς μεθόδους\nπχ Alex.pickUp();"+
        "\n\nwasd : Πλοήγηση του Alex"+
        "\n\ne: Αλληλεπίδραση με αντικείμενα"+
        "\n\nescape: έξοδος από δραστηριότητες"+
        "\n\nenter: επαλήθευση κώδικα στον επεξεργαστή, κλείσιμο μηνυμάτων"+
        "\n\nspace: κλείσιμο μηνυμάτων ήττας"+
        "\n\nκλικ με το ποντίκι"+
        "\n\n<-   ->   πλοήγηση με τα βελάκια αριστερά-δεξιά"+
        "\n\nμε κλικ στον editor, σβήνει μονομιάς το κείμενο"+
        "\n\nΣτον πλανήτη Practicus θα βρεις διασκεδαστικές διαφάνειες για τη γλώσσα Java!";
    }
}
