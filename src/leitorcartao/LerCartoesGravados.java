package leitorcartao;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Paulo
 */
public class LerCartoesGravados {

    public void lerCartoes() throws IOException {
        // Ler a pasta imagens
        File pasta = new File(GeradorImagem.localImagem);
        // Para cada arquivo de imagem na pasta gerar um txt
        for (File f : pasta.listFiles()) {
            Process process = new ProcessBuilder("Tesseract-OCR" + File.separator + "tesseract.exe", f.getAbsolutePath(), f.getName()).start();
        }
    }
}
