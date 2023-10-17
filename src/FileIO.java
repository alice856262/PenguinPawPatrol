/**
 * The FileIO class provides methods for reading and writing data to files.
 *
 * @author Pei-Jiun Chuang
 * @version ver1.0.0
 */

import java.util.Scanner;
import java.io.*;

public class FileIO
{
    /**
     * Default constructor for the FileIO class.
     */
    public FileIO()
    {

    }

    /**
     * Read comma-separated integers from a file and return them as an array.
     *
     * @param filePath    The path to the input file.
     * @return            An array containing the integers read from the file.
     */
    public int[] readFile(String filePath)
    {
        int[] numberAnimal = new int[4];
        try
        {
            FileReader reader = new FileReader(filePath);
            Scanner fileInput = new Scanner(reader);

            String[] inputAnimal = fileInput.nextLine().split(",");
            numberAnimal[0] = Integer.parseInt(inputAnimal[0]);
            numberAnimal[1] = Integer.parseInt(inputAnimal[1]);
            numberAnimal[2] = Integer.parseInt(inputAnimal[2]);
            numberAnimal[3] = Integer.parseInt(inputAnimal[3].trim());

            reader.close();
        }
        catch (Exception e)
        {
            System.out.println("Error in reading from the file! Exiting...");
        }
        return numberAnimal;
    }

    /**
     * Write an array of strings to a file, with one string per line.
     *
     * @param filePath         The path to the output file.
     * @param writeItemList    An array of strings to be written to the file.
     */
    public void writeFile(String filePath, String[] writeItemList)
    {
        try
        {
            FileWriter writer = new FileWriter(filePath);
            for (int i = 0; i < writeItemList.length; i++)
            {
                writer.write(writeItemList[i] + "\n");
            }
            writer.close();
        }
        catch (Exception e)
        {
            System.out.println("Error in writing to the file! Exiting...");
        }
    }
}
