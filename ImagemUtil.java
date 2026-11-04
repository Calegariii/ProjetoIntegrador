package View;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

final class ImagemUtil {

	private ImagemUtil() {
	}

	static ImageIcon carregar(String caminho) {
		URL url = ImagemUtil.class.getResource(caminho);
		if (url == null) {
			System.err.println("Imagem nao encontrada: " + caminho);
			return null;
		}
		return new ImageIcon(url);
	}

	static ImageIcon escalar(String caminho, int largura, int altura) {
		ImageIcon original = carregar(caminho);
		if (original == null) {
			return null;
		}
		Image imagem = original.getImage().getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
		return new ImageIcon(imagem);
	}
}
