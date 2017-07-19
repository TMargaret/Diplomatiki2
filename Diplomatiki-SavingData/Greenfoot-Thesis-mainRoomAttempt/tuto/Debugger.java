/**
 * Write a description of class Debugger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Debugger  
{
    String playersCode = null;
    String message = "Αναφορά Σφαλμάτων\n";
    String err = "error found: ";
    String correctAnswer = null;

    /**
     * Constructor for objects of class Debugger
     */
    public Debugger()
    {
    }

    public Debugger(String playersCode){
        this.playersCode = playersCode; 

    }
    
    public Debugger(String playersCode, String correctAnswer){
        this.playersCode = playersCode; 
        this.correctAnswer = correctAnswer;

    }
    
    public boolean checkSpelling(){
        playersCode.replaceAll("\\s", "");
        return playersCode.contains(correctAnswer); 
    }
    
    public String feedback(){
        if (!playersCode.contains(";")){
            message = err + "missing ;\n";
        }
        if (!playersCode.contains("()")){
            message += err + "missing ()\n";
        }
        if (!playersCode.equals(playersCode.toLowerCase()) || !playersCode.equals(playersCode.toUpperCase())){
            message += err + "words are Case Sensitive\n";
        }
        return message;
    }

}
