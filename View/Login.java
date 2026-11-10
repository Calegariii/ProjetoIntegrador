package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.LoginController;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int LARGURA = 1200;
	private static final int ALTURA = 800;

	private JTextField textUsuario;
	private JPasswordField textSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(LARGURA, ALTURA);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		JLabel jLabelFundo = new JLabel();
		jLabelFundo.setBounds(0, 0, LARGURA, ALTURA);
		ImageIcon fundo = ImagemUtil.escalar("/View/Imagens/logo1.jpg", LARGURA, ALTURA);
		if (fundo != null) {
			jLabelFundo.setIcon(fundo);
		} else {
			jLabelFundo.setOpaque(true);
			jLabelFundo.setBackground(new Color(245, 245, 245));
		}
		getContentPane().add(jLabelFundo);

		JLabel jLabel2 = new JLabel();
		jLabel2.setBounds(315, 150, 570, 500);
		jLabel2.setIcon(ImagemUtil.escalar("/View/Imagens/painel-login.png", 570, 500));
		getContentPane().add(jLabel2);

		JLabel jLabel3 = new JLabel("Login", JLabel.CENTER);
		jLabel3.setFont(new Font("Segoe UI", Font.BOLD, 32));
		jLabel3.setForeground(new Color(45, 45, 45));
		jLabel3.setBounds(465, 235, 270, 45);
		getContentPane().add(jLabel3);

		JLabel jLabel4 = new JLabel("Usuario");
		jLabel4.setFont(new Font("Segoe UI", Font.BOLD, 18));
		jLabel4.setForeground(new Color(45, 45, 45));
		jLabel4.setBounds(395, 330, 100, 25);
		getContentPane().add(jLabel4);

		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textUsuario.setBounds(505, 325, 270, 32);
		getContentPane().add(textUsuario);

		JLabel jLabel5 = new JLabel("Senha");
		jLabel5.setFont(new Font("Segoe UI", Font.BOLD, 18));
		jLabel5.setForeground(new Color(45, 45, 45));
		jLabel5.setBounds(395, 390, 100, 25);
		getContentPane().add(jLabel5);

		textSenha = new JPasswordField();
		textSenha.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textSenha.setBounds(505, 385, 270, 32);
		getContentPane().add(textSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnEntrar.setBounds(505, 445, 270, 42);
		btnEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				try {
					LoginController controller = new LoginController(Login.this);
					controller.entrarNoSistema();
				} catch (ParseException ex) {
					exibeMensagem("Erro ao converter data: " + ex.getMessage());
				}
			}
		});
		getContentPane().add(btnEntrar);

		getContentPane().setComponentZOrder(jLabelFundo, getContentPane().getComponentCount() - 1);
		getContentPane().setComponentZOrder(jLabel2, getContentPane().getComponentCount() - 2);
	}

	public JTextField getCampologin() {
		return textUsuario;
	}

	public void setCampologin(JTextField campologin) {
		this.textUsuario = campologin;
	}

	public JPasswordField getCamposenha() {
		return textSenha;
	}

	public void setCamposenha(JPasswordField camposenha) {
		this.textSenha = camposenha;
	}

	public void exibeMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}
}
