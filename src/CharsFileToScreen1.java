import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CharsFileToScreen1 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("./alphabeta.txt");
        Scanner input = new Scanner(file);
        String letra;
        String letraMayus;
        char num;
        for (int i = 97; i < 123; i++) {
            letra = input.nextLine();
            num = letra.charAt(0);
            num = (char) (num-32);
            letraMayus = String.valueOf((char)num);
            System.out.println(letra + " "+ letraMayus);
        };
    }
}
