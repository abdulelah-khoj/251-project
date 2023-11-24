import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Thread1 extends Thread {
    private String filePath;
    private File fileOrDirectory;
    private File[] files;
    private File file;
    
    public Thread1(String filePath) {
        this.filePath = filePath;
        fileOrDirectory = new File(filePath);
    }
    public Thread1() {
    }
    
    public File getFileOrDirectory() {
        return fileOrDirectory;
    }

    public void setFileOrDirectory(File fileOrDirectory) {
        this.fileOrDirectory = fileOrDirectory;
    }
    @Override
    public void run() {
        files = fileOrDirectory.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                file = files[i];
          
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss\n");
                    String formattedDate = sdf.format(new Date(file.lastModified()));
                    System.out.print("Metadata for " + file.getAbsolutePath() + "\n");
                    System.out.print("Directory " + file.isDirectory() + "\n");
                    System.out.print("Readable: " + file.canRead() + " \n");
                    System.out.print("Writeable: " + file.canWrite() + "\n");
                    System.out.print("Executable: " + file.canExecute() + "\n");
                    System.out.println("Last Modified: " + formattedDate);
            }
        }
    }
}
