package Controller.Helper;

import Model.Usuario;
import View.Login;

public class LoginHelper implements IHelper {

	private final Login view;

	public LoginHelper(Login view) {
		this.view = view;
	}

	@Override
	public Usuario obterModelo() {
		String nome = view.getCampologin().getText();
		String senha = view.getCamposenha().getText();
		Usuario modelo = new Usuario(0, nome, senha);
		return modelo;
	}

	public void setarModelo(Usuario modelo) {
		String nome = modelo.getNome();
		String senha = modelo.getSenha();

		view.getCampologin().setText(nome);
		view.getCamposenha().setText(senha);
	}

	@Override
	public void limparTela() {
		view.getCampologin().setText("");
		view.getCamposenha().setText("");
	}
}
