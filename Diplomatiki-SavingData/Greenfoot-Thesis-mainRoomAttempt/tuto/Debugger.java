/**
 * Write a description of class Debugger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Debugger  
{
    String playersCode = null;
    String message = null;

    /**
     * Constructor for objects of class Debugger
     */
    public Debugger()
    {
    }

    public Debugger(String playersCode){
        this.playersCode = playersCode; 

    }
    
    public String checkSpelling(String playersCode){
        this.playersCode = playersCode;
        if (!playersCode.contains(";")){
            message = "Το ερωτηματικό μπαίνει απαραίτητα στο\nτέλος κάθε γραμμής κώδικα.\n";
        }
        if (!playersCode.contains("()")){
            message += "Οι παρενθέσεις συνοδεύουν πάντα το\nόνομα της μεθόδου.\n";
        }
        return message;
    }

}
