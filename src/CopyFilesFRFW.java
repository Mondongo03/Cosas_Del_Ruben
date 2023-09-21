import java.io.*;

public class CopyFilesFRFW {
    public static void main(String[] args) throws FileNotFoundException {
        boolean finals = false;
        String letra;

        try {
            FileReader file = new FileReader(args[0]);
            BufferedReader reader = new BufferedReader(file);
            FileWriter fw = new FileWriter(args[1]);
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
