import java.io.FileInputStream;
import java.io.FileOutputStream;

public class AsciifyImage {
    public static void main(String args[]) {
        String inputFN = args[0];
        FileInputStream inImage;
        FileOutputStream outImage;      //grayscale image
        try {
            inImage = new FileInputStream(inputFN);
        } catch (Exception e) {
            System.out.println("\nInput invalid. Check filename or check if file exists.");
        }
        
    }
}
