import java.io.File;
import java.util.Scanner;

public class MostraInfoDir {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("");

        for (int i = 0; i < args.length; i++) {
            System.out.print(i + " ");
            System.out.println(args[i]);

            File f = new File(args[i]);
            File[] files = f.listFiles();

            System.out.print(files[i]+" ");
        }
    }
}
