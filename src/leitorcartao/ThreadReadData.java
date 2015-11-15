package leitorcartao;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.imageio.ImageIO;

/**
 *
 * @author Paulo
 */
public class ThreadReadData extends Thread {

    public TransparentFrame windowReference;

    @Override
    public void run() {
        try {
            if (this.windowReference.isShowing()) {
                // Capturing the screen with the RObot cass
                Robot robot;
                try {
                    robot = new Robot();

                    BufferedImage screenShot = robot.createScreenCapture(new Rectangle(windowReference.getLocationOnScreen().x, windowReference.getLocationOnScreen().y, windowReference.getSize().width, windowReference.getSize().height));
                    // save you screen shot with its label
                    ImageIO.write(screenShot, "png", new File("imagens+" + File.separator + "imagem01.png"));
                    //caminho executavel/caminho da imagem/caminho arquivo de saida
                    
                    Process process = new ProcessBuilder("Tesseract-OCR" + File.separator + "tesseract.exe", "imagens+" + File.separator + "imagem01.png", "imagem").start();
                    //ler o arquivo e saida
                    //Read the data from the output file
                    //String everything = this.readFile("C:\\OCR\\Tesseract-OCR\\out.txt");
                    //System.out.println("OCR" + everything);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readFile(String f) {
        String everyString = "";
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(f));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everyString = sb.toString();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return everyString;
    }

}
