import java.io.*;

public class CharsFileReader {
    public static void main(String[] args){
        boolean finals = false;
        String letra;

        try {
            FileReader file = new FileReader("./alphabeta5465.txt");
            BufferedReader reader = new BufferedReader(file);
            FileWriter fw = new FileWriter(System.getProperty("user.dir") + File.separator + "alphabeta.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);

            while (!finals){
                letra = reader.readLine();
                if (letra == null) finals = true;
                else bw.write(letra);
                bw.newLine();
            }
            bw.close();

        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
