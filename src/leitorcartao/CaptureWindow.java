package leitorcartao;

/**
 *
 * @author Paulo
 */
import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;
import java.awt.*;

public class CaptureWindow {

    public static CaptureWindow windowReader;

    public CaptureWindow() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        if (!gd.isWindowTranslucencySupported(TRANSLUCENT)) {
            System.err.println("Translucency is not supported");
            System.exit(0);
        }
        TransparentFrame tw = new TransparentFrame();
        // Defina a janela para 55% opaco (45% translúcida).
        tw.setOpacity(0.55f);
        // Mostra as janelas
        tw.setVisible(true);
    }

    // o ponto de entrada principal

    public static void main(String[] args) {
        // chamando as janelas de captura
        windowReader = new CaptureWindow();
    }
}
