package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.Banco;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;
import java.text.ParseException;

public class LoginController {

	private final Login view;
	private LoginHelper helper;

	public LoginController(Login view) {
		this.view = view;
		this.helper = new LoginHelper(view);
	}

	public void entrarNoSistema() throws ParseException {
		if (Banco.usuario == null) {
			Banco.inicia();
		}

		Usuario usuario = helper.obterModelo();

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);

		if (usuarioAutenticado != null) {
			MenuPrincipal menu = new MenuPrincipal();
			menu.setVisible(true);
			this.view.dispose();
		} else {
			view.exibeMensagem("Usuario ou senha invalidos");
		}
	}
}
