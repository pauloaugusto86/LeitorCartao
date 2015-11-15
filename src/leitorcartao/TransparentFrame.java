package leitorcartao;

import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Paulo
 */
public class TransparentFrame extends JFrame implements MouseMotionListener, ActionListener {

    public TransparentFrame() {
        addMouseMotionListener(this);
        setUndecorated(true);
        setLayout(new GridBagLayout());
        setSize(500, 250);
        setLocation(200, 200);

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                print();
            }

        });
        // Startingthe thread that will read yhe screen
        //ThreadReadData t = new ThreadReadData();
        //t.windowReference = this;
        //t.start();
    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        // Positioning with the mouse
        this.setLocation(e.getLocationOnScreen().x - this.getSize().width / 2, e.getLocationOnScreen().y - this.getSize().height / 2);
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
    }

    private void print() {
        Robot robot;
        try {
            robot = new Robot();

            BufferedImage screenShot = robot.createScreenCapture(new Rectangle(this.getLocationOnScreen().x, this.getLocationOnScreen().y, this.getSize().width, this.getSize().height));
            // save you screen shot with its label
            ImageIO.write(screenShot, "png", new File("imagens" + File.separator + "imagem01.png"));
            // Call the tesseract.exe OCR
            //caminho executavel/caminho da imagem/caminho arquivo de saida
            //Process process = new ProcessBuilder("C:\\OCR\\Tesseract-OCR\\tesseract.exe", "C:\\OCR\\Tesseract-OCR\\eurotext.tif", "C:\\OCR\\Tesseract-OCR\\out").start();
            Process process = new ProcessBuilder("Tesseract-OCR" + File.separator + "tesseract.exe", "imagens+" + File.separator + "imagem01.png", "ima").start();
            //Process process = new ProcessBuilder("Tesseract-OCR" + File.separator + "tesseract.exe", f.getAbsolutePath(), f.getName()).start();
            //ler o arquivo e saida
            //Read the data from the output file
            //String everything = this.readFile("C:\\OCR\\Tesseract-OCR\\out.txt");
            //System.out.println("OCR" + everything);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
