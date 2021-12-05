import java.io.FileOutputStream;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class App {
    public static void main(String[] args) throws Exception {
        File outFile = new File("outputAscii.txt");
        FileOutputStream outStream = new FileOutputStream(outFile);
        if (!outFile.exists()) {
            outFile.createNewFile();
        }

        BufferedImage img = null;
        try { //TODO: Make this given by user.
            img = ImageIO.read(new File("./test_images/dog.jpg"));
        } catch (IOException e) {
            System.out.println("\nInput invalid. Check filename or check if file exists.");
        }

        int w = img.getWidth(null);
        int h = img.getHeight(null);
        //System.out.println(w);
        //System.out.println(h);
        if (w > 100) {
            double temp = ((double)h/(double)w);
            h = (int)(50*temp);
            w = 100;
        }
        
        System.out.println(w);
        System.out.println(h);
        Image toolkitImage = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        w = toolkitImage.getWidth(null);
        h = toolkitImage.getHeight(null);
        
        // w and h are of the toolkit image
        BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics graph = newImage.getGraphics();
        graph.drawImage(toolkitImage, 0, 0, null);
        graph.dispose();
        
        String outputString = "\n";
        for (int i = 0; i < h; i++) {
            String row = "";
            for (int j = 0; j < w; j++) {
                int p = newImage.getRGB(j,i);

                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                //calculate average
                int avg = (r+g+b)/3;
                p = (a<<24) | (avg<<16) | (avg<<8) | avg;
                if (avg < 50) {
                    row = row + "#";
                } else if (avg < 100) {
                    row = row + "X";
                } else if (avg < 125) {
                    row = row + "/";
                } else {
                    row = row + " ";
                }
                newImage.setRGB(j, i, p);
            }

            row = row + "\n";
            outputString = outputString + row;
            //System.out.println(row);
            
        }

        byte[] asciiInBytes = outputString.getBytes();
        outStream.write(asciiInBytes);
        outStream.flush();
        outStream.close();

         //write image
        try{
            File f = new File("Output.jpg");
            ImageIO.write(newImage, "jpg", f);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
