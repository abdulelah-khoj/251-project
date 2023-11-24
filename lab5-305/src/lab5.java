import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class lab5 {

    public static void main(String[] args) throws IOException {
        BufferedReader Reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a filename or directory path: ");
        String UserInput = Reader.readLine();

        File fileOrDirectory = new File(UserInput);

        MetaData(fileOrDirectory);
    }

    private static void MetaData(File fileOrDirectory) throws IOException {

        if (fileOrDirectory.isDirectory()) {
            
            System.out.println("\n" + "Start new thread");
            System.out.println("Metadata for: " + fileOrDirectory.getAbsolutePath() + "\n");
            Thread1 Th = new Thread1(fileOrDirectory.getAbsolutePath());
            Th.start();
            System.out.println(Th.toString());
            
            try {
                Th.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(lab5.class.getName()).log(Level.SEVERE, null, ex);
            }
            File[] files = fileOrDirectory.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {

                    File file = files[i];
                    MetaData(file);
             
                }
            } else 
            {
                System.out.println("File or directory not exist");
            }
        }
    }
}
