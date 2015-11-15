package leitorcartao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author Paulo
 */
public class GeradorImagem {

    public static final String localImagem = "imagens";

    public GeradorImagem() {
        File f = new File(localImagem);
        if (!f.exists()) {
            f.mkdir();
        }
    }

    public void gerarImagem(Cartao cartao) throws FileNotFoundException, IOException {
        BufferedImage image = new BufferedImage(500, 250, BufferedImage.TYPE_INT_ARGB);
        Graphics2D canvas = image.createGraphics();
        canvas.setColor(Color.LIGHT_GRAY);
        canvas.fillRect(0, 0, 500, 250);
        canvas.setColor(Color.DARK_GRAY);
        canvas.drawRect(10, 10, 480, 230);
        canvas.setColor(Color.BLACK);
        canvas.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 32));
        canvas.drawString(cartao.getNome(), 30, 50);
        canvas.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        canvas.drawString("Empresa: " + cartao.getEmpresa(), 30, 90);
        canvas.drawString("Função: " + cartao.getFuncao(), 30, 130);
        canvas.drawString("Endereço: " + cartao.getEndereco(), 30, 170);
        canvas.drawString("Telefone: " + cartao.getTelefone(), 30, 210);
        try (OutputStream out = new FileOutputStream(new File(localImagem + File.separator + cartao.getNome() + ".png"))) {
            ImageIO.write(image, "PNG", out);
        }
    }
}
