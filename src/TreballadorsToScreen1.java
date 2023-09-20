import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TreballadorsToScreen1 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("./treballadors.txt");
        Scanner input = new Scanner(file);

        String nom;
        String cognom;
        String salari;
        String casat;
        int num = 1;
        while(input.hasNext()){
            System.out.println("TREBALLADOR "+num);
            nom = input.next();
            nom = nom.replace("(", "").replace(")", "").replace(",", "");
            cognom = input.next();
            cognom = cognom.replace("(", "").replace(")", "").replace(",", "");
            salari = input.next();
            salari = salari.replace("(", "").replace(")", "").replace(",", "");
            casat = input.next();
            casat = casat.replace("(", "").replace(")", "").replace(",", "");
            System.out.println(nom);
            System.out.println();
            System.out.println(cognom);
            System.out.println();
            System.out.println(salari);
            System.out.println();
            System.out.println(casat);
            System.out.println();
            num++;
        }

        }
    }

