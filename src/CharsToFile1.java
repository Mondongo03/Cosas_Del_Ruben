import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CharsToFile1 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("./alphabeta.txt");
        PrintWriter pwInput = new PrintWriter(file);
        char letra;

        for (int i = 97; i < 123; i++) {
            letra = (char) i;

            pwInput.println(letra);
        }
        pwInput.close();
    }
}

