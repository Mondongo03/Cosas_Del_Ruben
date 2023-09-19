import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class NumsToFile1 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("./Num11001200.txt");
        PrintWriter pwInput = new PrintWriter(file);

        for (int i = 1100; i < 1201; i++) {
            pwInput.println(i);
        }
        pwInput.close();
    }
}
