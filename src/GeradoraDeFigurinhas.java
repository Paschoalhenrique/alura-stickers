import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
	
	private static final File InputStream = null;

	public void cria(InputStream inputStream, String nomeArquivo) throws Exception{
		
	//leituda de imagem
		// InputStream inputStream = 
        //             new FileInputStream(new File("entrada/filme-maior.jpg"));
        // InputStream inputStream = 
        //                 new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")
        //                 .openStream();
	BufferedImage imagemOriginal = ImageIO.read(InputStream);
	
	//criar nova imagem em memoria com tranparecencia e com tamanho novo
	int largura = imagemOriginal.getHeight();
	int altura = imagemOriginal.getHeight();
	int novaAltura = altura + 200;
	BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
	
	
	
	//copiar a imagem pra novo imagem (em memoria)
	Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);
	
	//configurar a fonte
    var fonte = new Font(Font.SANS_SERIF, Font.BOLD,64);
    graphics.setColor(Color.YELLOW);
    graphics.setFont(fonte);
    	
	//escrever uma frase na nova imagem
    graphics.drawString("TOPEZERA", 100, novaAltura - 100);
    
    //escrever a nova imagem em um arquivo
    ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    
    
	}
}
