import java.io.*;
import java.util.Arrays;

public class CopyDirFRFW {
    public static void main(String[] args) throws IOException {
        boolean finals = false;
        String letra;

        try {


            for (int i = 0; i < args.length; i++) {

                File f = new File(args[0]);
                File[] files = f.listFiles();
                File f2 = new File(args[1]);
                File[] files2 = f2.listFiles();

                System.out.println(files[i]);
                System.out.println("");
                System.out.println(files2[i]);

            FileReader file = new FileReader(files[i]);
            BufferedReader reader = new BufferedReader(file);
            FileWriter fw = new FileWriter(files2[i]+"/ej");
            BufferedWriter bw = new BufferedWriter(fw);

            /*System.out.println(file);
            System.out.println(reader);
            System.out.println(fw);
            System.out.println(bw);*/

                while (!finals){
                    letra = reader.readLine();
                    if (letra == null) finals = true;
                    else bw.write(letra);
                    bw.newLine();
                }
                bw.close();
            }
        }catch (Exception e){
            System.err.println("Error");
        }
    }


}