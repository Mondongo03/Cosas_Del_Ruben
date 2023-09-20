import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TreballadorsToFile1 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("./treballadors.txt");
        PrintWriter pwInput = new PrintWriter(file);
        Scanner input = new Scanner(System.in);

        String continuar = "Y";
        String nom;
        String cognom;
        int salari;
        boolean casat;

        while (continuar.equals("Y")) {
            System.out.println("Quin es el nom del treballador?");
            nom = input.nextLine();

            System.out.println("Quin es el cognom del treballador?");
            cognom = input.nextLine();

            System.out.println("Quin es el salari del treballador?");
            salari = input.nextInt();

            System.out.println("Esta casat?");
            casat = input.nextBoolean();
            pwInput.println("("+nom+", "+cognom+", "+salari+", "+casat+")");
            input.nextLine();

            System.out.println("Vols continuar?");
            continuar = input.nextLine();

        }
        pwInput.close();
    }
}
