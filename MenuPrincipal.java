package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controller.MenuPrincipalController;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int LARGURA = 1200;
	private static final int ALTURA = 800;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuPrincipal() {
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(LARGURA, ALTURA);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		JLabel jLabel1 = new JLabel();
		jLabel1.setBounds(0, 0, LARGURA, ALTURA);
		jLabel1.setIcon(ImagemUtil.escalar("/View/Imagens/fundomenu1.jpg", LARGURA, ALTURA));
		getContentPane().add(jLabel1);

		JMenuBar jMenuBar1 = new JMenuBar();
		JMenu jMenuCadastro = new JMenu("Cadastro");
		jMenuCadastro.setFont(new Font("Segoe UI", Font.PLAIN, 16));

		JMenuItem jMenuItem1 = new JMenuItem("Cliente");
		jMenuItem1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		ImageIcon iconeCliente = ImagemUtil.carregar("/View/Imagens/Icones/cliente-icon.png");
		jMenuItem1.setIcon(iconeCliente);

		JMenuItem jMenuItem2 = new JMenuItem("Serviço");
		jMenuItem2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		ImageIcon iconeServico = ImagemUtil.carregar("/View/Imagens/Icones/tesoura32-icon.png");
		jMenuItem2.setIcon(iconeServico);

		jMenuCadastro.add(jMenuItem1);
		jMenuCadastro.add(jMenuItem2);
		jMenuBar1.add(jMenuCadastro);

		JMenu jMenuAgenda = new JMenu("Agenda");
		jMenuAgenda.setFont(new Font("Segoe UI", Font.PLAIN, 16));

		JMenuItem jMenuItemAgenda = new JMenuItem("Abrir Agenda");
		jMenuItemAgenda.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		ImageIcon iconeAgenda = ImagemUtil.carregar("/View/Imagens/Icones/agenda32-icon.png");
		jMenuItemAgenda.setIcon(iconeAgenda);
		jMenuItemAgenda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				MenuPrincipalController controller = new MenuPrincipalController(MenuPrincipal.this);
				controller.navegarParaAgenda();
			}
		});

		jMenuAgenda.add(jMenuItemAgenda);
		jMenuBar1.add(jMenuAgenda);
		setJMenuBar(jMenuBar1);
	}
}
