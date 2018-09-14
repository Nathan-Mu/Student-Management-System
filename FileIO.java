import java.util.ArrayList;
import java.io.*;
/**
 * A class to excute file input and output.
 * 
 * @author Dongyu Zhao
 * @version 1.0 08 Oct 2013
 */
public class FileIO
{
    private File file = new File("./Student Management Record.txt");
    /**
     * Constructor of FiloIO class
     */
    public FileIO()
    {
    }
    
    /**
     * Get the array contains each line.
     * @return An array contains each line.
     */
    public ArrayList getFileLineArray()
    {
        String line;
        ArrayList<String> fileLineArray = new ArrayList<String>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null)
            {
                fileLineArray.add(line);
            }
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
        return fileLineArray;
    }
    
    /**
     * Write the file.
     * @param lineArrayList The arraylist which only contains each line by sequence.
     */
    public void writeFile(ArrayList lineArrayList)
    {
        if (lineArrayList.size() > 0)
        {
            writeFirstLine(lineArrayList.get(1).toString());
            for (int i = 1; i < lineArrayList.size(); i++)
            {
                writeOneLineAfterFirst(lineArrayList.get(i).toString());
            }
        }
    }
      
    /**
     * Write the first line in text file.
     * @param string The string to be written.
     */
    public void writeFirstLine(String string)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(string);
            writer.close();
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
    }
    
    /**
     * Write one line after the first line in the text file.
     * @param string The string to be written.
     */
    public void writeOneLineAfterFirst(String string)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)); 
            writer.newLine();
            writer.write(string);
            writer.close();
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
    }
}
