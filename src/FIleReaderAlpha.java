import java.io.BufferedReader;
import java.io.FileReader;

public class FileReaderAlpha {
    public static void main(String[] args){
        boolean finals = false;
        String letra;
        try {
            FileReader file = new FileReader("./alphabeta5465.txt");
            BufferedReader reader = new BufferedReader(file);

            while (!finals){
                letra = reader.readLine();
                if (letra == null) finals = true;
                else System.out.print(letra.toUpperCase()+" ");

            }
        }catch (Exception e){
            System.out.println("Error");
        }

    }
}
