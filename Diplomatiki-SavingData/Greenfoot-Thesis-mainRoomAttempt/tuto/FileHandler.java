import java.io.*;
import java.util.ArrayList;

public class FileHandler
{
    private Object obj;
    private static final String TextFILE = "master.txt";
    private static final String BinaryFILE = "bmaster.ser";

    //public FileHandler(SongsDB db)
    public FileHandler(Object myWorld)
    {
        obj = myWorld;
    }

    // public void writeToTextFile() throws IOException
    // {
        // File outFile = new File(TextFILE);
        // FileWriter writer = new FileWriter(outFile, true);

        // writer.write(aSong.getSong());
        // writer.write('\n');

        // writer.close();
    // }

    // public void readFromTextFile() throws FileNotFoundException, IOException
    // {
    // File inFile = new File(TextFILE);
    // if ( inFile.exists() )
    // {
    // FileReader freader = new FileReader(inFile);
    // BufferedReader reader = new BufferedReader(freader);
    // String line;
    // line = reader.readLine();
    // while (line != null)
    // {
    // System.out.println(line);
    // line = reader. readLine();
    // }
    // System.out.println();
    // reader.close();
    // }
    // }   

    // public void addEntriesFromTextFile(String filename) throws IOException
    // {
    // File bFile = new File(filename);
    // FileReader inFile = new FileReader(bFile);
    // BufferedReader reader = new BufferedReader(inFile);
    // String name;
    // name = reader.readLine();
    // while ( name != null )
    // {
    // String title = reader.readLine();
    // int duration = Integer.parseInt(reader.readLine());
    // reader.readLine();
    // System.out.println(name + " " + title + " " + duration);
    // songs.addSong(new Song(name, title, duration));
    // name = reader.readLine();
    // }
    // reader.close();
    // }

    public void writeToBinaryFile() throws IOException
    {
        System.out.println("1");
        File destination = new File("./bin/test.txt");
        System.out.println("2");
        FileOutputStream fouts = new FileOutputStream(destination);
        System.out.println("3");
        ObjectOutputStream os = new ObjectOutputStream(fouts);
        System.out.println(obj);
        os.writeObject(obj);
        System.out.println("5");
        os.close();
    }

    // public SongsDB readFromBinaryFile() throws IOException, ClassNotFoundException
    // {
    // File source = new File(BinaryFILE);
    // if ( source.exists() )
    // {
    // FileInputStream fins = new FileInputStream(source);
    // ObjectInputStream is = new ObjectInputStream(fins);
    // SongsDB db = (SongsDB) is.readObject();
    // is.close();
    // return db;
    // }
    // else
    // return null;
    // }       

}