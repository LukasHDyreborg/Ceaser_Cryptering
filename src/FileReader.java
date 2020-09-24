import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class FileReader {

    public static void read(ArrayList<String> list) {
        try {
            // we use the BufferReader to read the file.
            BufferedReader buff = new BufferedReader(new java.io.FileReader("src/Input"));

            // this while loop is used to read all lines and add them to a ArrayList.
            String line = buff.readLine();
            while (line != null) {
                list.add(line);
                line = buff.readLine();
            }
        } catch (IOException e) {
            System.out.println("You got an Input/Output exception!");
        }
    }

    public static void print(ArrayList<String> list) {
        try {
            PrintStream output = new PrintStream(new File("src/Output"));
            for (String line : list) {
                //if (line.equals(null)) {
                //    output.println("");
                //} else {
                    output.println(line);
                //}
            }
        } catch (IOException e) {
            System.out.println("You got an Input/Output exception!");
        }
    }
}
