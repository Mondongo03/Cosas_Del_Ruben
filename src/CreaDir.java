import java.io.File;
import java.util.Scanner;

public class CreaDir {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Elige la ruta del directorio incluyendo el directorio que quieres crear");

        String dir = input.nextLine();

        File f = new File(dir);

        if (f.exists()){
            System.out.println("No ha sigut possible crear el directori");
        }
        else {
            f.mkdirs();
            System.out.println(f);
        }
    }
}
