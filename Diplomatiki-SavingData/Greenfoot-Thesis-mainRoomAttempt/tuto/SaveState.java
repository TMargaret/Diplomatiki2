import java.io.*;
/**
 * Write a description of class SaveState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SaveState  
{
    public void writefile(int lvlSize)
    {
        FileWriter fw = null;
        try
        {
            fw = new FileWriter(".//save//data.txt");
            fw.write(lvlSize);
        }
        catch (Exception e){ e.printStackTrace(); }
        finally
        {
            if(fw != null)
            {
                try { fw.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
    }

    public void readfile()
    {
        String line = null;
        int value=0;
        FileReader file = null;
        try
        {
            file = new FileReader(".//save//data.txt");
            BufferedReader reader = new BufferedReader(file);
            while((line = reader.readLine()) != null)
            {
                value = Integer.parseInt(line);
            }
        }
        catch (FileNotFoundException e) {throw new RuntimeException("Error");}
        catch (IOException e) {throw new RuntimeException("Error");}
        finally
        {
            if(file != null)
                try {file.close();}
                catch (IOException e) {e.printStackTrace();}
        }
        //speed=value;
    }
}
