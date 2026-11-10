package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

import Controller.AgendaController;
import Model.Cliente;
import Model.DAO.Banco;
import Model.Servico;

public class Agenda extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int LARGURA = 1200;
	private static final int ALTURA = 800;

	private final AgendaController controller;

	private JTextField idtexto;
	private JComboBox<Cliente> clienteCaixaopcao;
	private JComboBox<Servico> servicoscaixa;
	private JTextField datatexto;
	private JTextField caixahora;
	private JTextField textovalor;
	private JTextArea jTextArea1;
	private JTable caixatabela;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Agenda() {
		setTitle("Agenda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(LARGURA, ALTURA);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		criarComponentes();

		inicializarBanco();
		controller = new AgendaController(this);
		iniciar();
	}

	private void inicializarBanco() {
		if (Banco.cliente == null) {
			try {
				Banco.inicia();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	private void iniciar() {
		this.controller.atualizaTabela();
		this.controller.atualizaCliente();
		this.controller.atualizaServico();
		this.controller.atualizaValor();
	}

	private void criarComponentes() {
		JLabel jLabel1 = new JLabel();
		jLabel1.setBounds(0, 0, LARGURA, ALTURA);
		jLabel1.setIcon(ImagemUtil.escalar("/View/Imagens/fundoagendamento.jpg", LARGURA, ALTURA));
		getContentPane().add(jLabel1);

		JLabel jLabel2 = new JLabel();
		jLabel2.setBounds(100, 15, 1000, 769);
		jLabel2.setIcon(ImagemUtil.escalar("/View/Imagens/Agenda-PainelFundo.png", 1000, 769));
		getContentPane().add(jLabel2);

		Font fonteLabel = new Font("Segoe UI", Font.PLAIN, 16);
		Font fonteCampo = new Font("Segoe UI", Font.PLAIN, 15);
		Color corTexto = new Color(245, 245, 245);

		JLabel jLabel3 = new JLabel("Id");
		jLabel3.setFont(fonteLabel);
		jLabel3.setForeground(corTexto);
		jLabel3.setBounds(140, 80, 85, 25);
		getContentPane().add(jLabel3);

		idtexto = new JTextField();
		idtexto.setFont(fonteCampo);
		idtexto.setEditable(false);
		idtexto.setBounds(235, 75, 235, 32);
		getContentPane().add(idtexto);

		JLabel jLabel4 = new JLabel("Cliente");
		jLabel4.setFont(fonteLabel);
		jLabel4.setForeground(corTexto);
		jLabel4.setBounds(140, 135, 85, 25);
		getContentPane().add(jLabel4);

		clienteCaixaopcao = new JComboBox<Cliente>();
		clienteCaixaopcao.setFont(fonteCampo);
		clienteCaixaopcao.setBounds(235, 130, 235, 32);
		getContentPane().add(clienteCaixaopcao);

		JLabel jLabel5 = new JLabel("Serviço");
		jLabel5.setFont(fonteLabel);
		jLabel5.setForeground(corTexto);
		jLabel5.setBounds(140, 190, 85, 25);
		getContentPane().add(jLabel5);

		servicoscaixa = new JComboBox<Servico>();
		servicoscaixa.setFont(fonteCampo);
		servicoscaixa.setBounds(235, 185, 235, 32);
		servicoscaixa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				controller.atualizaValor();
			}
		});
		getContentPane().add(servicoscaixa);

		JLabel jLabel6 = new JLabel("Data");
		jLabel6.setFont(fonteLabel);
		jLabel6.setForeground(corTexto);
		jLabel6.setBounds(140, 245, 85, 25);
		getContentPane().add(jLabel6);

		datatexto = new JTextField();
		datatexto.setFont(fonteCampo);
		datatexto.setToolTipText("dd/MM/yyyy");
		datatexto.setBounds(235, 240, 235, 32);
		getContentPane().add(datatexto);

		JLabel jLabel7 = new JLabel("Hora");
		jLabel7.setFont(fonteLabel);
		jLabel7.setForeground(corTexto);
		jLabel7.setBounds(140, 300, 85, 25);
		getContentPane().add(jLabel7);

		caixahora = new JTextField();
		caixahora.setFont(fonteCampo);
		caixahora.setToolTipText("HH:mm");
		caixahora.setBounds(235, 295, 235, 32);
		getContentPane().add(caixahora);

		JLabel jLabel8 = new JLabel("Valor");
		jLabel8.setFont(fonteLabel);
		jLabel8.setForeground(corTexto);
		jLabel8.setBounds(140, 355, 85, 25);
		getContentPane().add(jLabel8);

		textovalor = new JTextField();
		textovalor.setFont(fonteCampo);
		textovalor.setToolTipText("R$");
		textovalor.setEditable(false);
		textovalor.setBounds(235, 350, 235, 32);
		getContentPane().add(textovalor);

		JToggleButton botaoagendar = new JToggleButton("Agendar");
		botaoagendar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botaoagendar.setBounds(235, 410, 235, 42);
		botaoagendar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				controller.agendar();
			}
		});
		getContentPane().add(botaoagendar);

		JLabel jLabel9 = new JLabel("Observação");
		jLabel9.setFont(fonteLabel);
		jLabel9.setForeground(corTexto);
		jLabel9.setBounds(140, 455, 120, 25);
		getContentPane().add(jLabel9);

		jTextArea1 = new JTextArea();
		jTextArea1.setFont(fonteCampo);
		jTextArea1.setLineWrap(true);
		jTextArea1.setWrapStyleWord(true);
		JScrollPane jScrollPane1 = new JScrollPane(jTextArea1);
		jScrollPane1.setBounds(140, 480, 330, 155);
		getContentPane().add(jScrollPane1);

		String[] colunas = { "Id", "Cliente", "Serviço", "Valor", "Data", "Hora", "Observação" };
		caixatabela = new JTable(new DefaultTableModel(new Object[0][0], colunas));
		caixatabela.setFont(fonteCampo);
		caixatabela.setRowHeight(24);
		caixatabela.setFillsViewportHeight(true);
		caixatabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
		caixatabela.getColumnModel().getColumn(0).setPreferredWidth(35);
		caixatabela.getColumnModel().getColumn(1).setPreferredWidth(100);
		caixatabela.getColumnModel().getColumn(2).setPreferredWidth(115);
		caixatabela.getColumnModel().getColumn(3).setPreferredWidth(60);
		caixatabela.getColumnModel().getColumn(4).setPreferredWidth(95);
		caixatabela.getColumnModel().getColumn(5).setPreferredWidth(60);
		caixatabela.getColumnModel().getColumn(6).setPreferredWidth(130);

		JScrollPane jScrollPane2 = new JScrollPane(caixatabela);
		jScrollPane2.setBounds(500, 75, 580, 560);
		getContentPane().add(jScrollPane2);

		getContentPane().setComponentZOrder(jLabel1, getContentPane().getComponentCount() - 1);
		getContentPane().setComponentZOrder(jLabel2, getContentPane().getComponentCount() - 2);
	}

	public JTable getCaixatabela() {
		return caixatabela;
	}

	public void setCaixatabela(JTable caixatabela) {
		this.caixatabela = caixatabela;
	}

	public JComboBox<Cliente> getClienteCaixaopcao() {
		return clienteCaixaopcao;
	}

	public void setClienteCaixaopcao(JComboBox<Cliente> clienteCaixaopcao) {
		this.clienteCaixaopcao = clienteCaixaopcao;
	}

	public JComboBox<Servico> getServicoscaixa() {
		return servicoscaixa;
	}

	public void setServicoscaixa(JComboBox<Servico> servicoscaixa) {
		this.servicoscaixa = servicoscaixa;
	}

	public JTextField getTextovalor() {
		return textovalor;
	}

	public void setTextovalor(JTextField textovalor) {
		this.textovalor = textovalor;
	}

	public JTextField getDatatexto() {
		return datatexto;
	}

	public void setDatatexto(JTextField datatexto) {
		this.datatexto = datatexto;
	}

	public JTextField getCaixahora() {
		return caixahora;
	}

	public void setCaixahora(JTextField caixahora) {
		this.caixahora = caixahora;
	}

	public JTextField getIdtexto() {
		return idtexto;
	}

	public void setIdtexto(JTextField idtexto) {
		this.idtexto = idtexto;
	}

	public JTextArea getjTextArea1() {
		return jTextArea1;
	}

	public void setjTextArea1(JTextArea jTextArea1) {
		this.jTextArea1 = jTextArea1;
	}
}
