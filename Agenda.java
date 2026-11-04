package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

public class Agenda extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int LARGURA = 1200;
	private static final int ALTURA = 800;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(LARGURA, ALTURA);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

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

		JLabel jLabel3 = new JLabel("Nome");
		jLabel3.setFont(fonteLabel);
		jLabel3.setForeground(corTexto);
		jLabel3.setBounds(140, 80, 85, 25);
		getContentPane().add(jLabel3);

		JTextField jTextField1 = new JTextField();
		jTextField1.setFont(fonteCampo);
		jTextField1.setBounds(235, 75, 235, 32);
		getContentPane().add(jTextField1);

		JLabel jLabel4 = new JLabel("Cliente");
		jLabel4.setFont(fonteLabel);
		jLabel4.setForeground(corTexto);
		jLabel4.setBounds(140, 135, 85, 25);
		getContentPane().add(jLabel4);

		JComboBox<String> jComboBox1 = new JComboBox<String>(new String[] { "Alan", "Pedro", "Giovane" });
		jComboBox1.setFont(fonteCampo);
		jComboBox1.setBounds(235, 130, 235, 32);
		getContentPane().add(jComboBox1);

		JLabel jLabel5 = new JLabel("Serviço");
		jLabel5.setFont(fonteLabel);
		jLabel5.setForeground(corTexto);
		jLabel5.setBounds(140, 190, 85, 25);
		getContentPane().add(jLabel5);

		JComboBox<String> jComboBox2 = new JComboBox<String>(new String[] { "Corte", "Barba", "Corte + Barba" });
		jComboBox2.setFont(fonteCampo);
		jComboBox2.setBounds(235, 185, 235, 32);
		getContentPane().add(jComboBox2);

		JLabel jLabel6 = new JLabel("Data");
		jLabel6.setFont(fonteLabel);
		jLabel6.setForeground(corTexto);
		jLabel6.setBounds(140, 245, 85, 25);
		getContentPane().add(jLabel6);

		JTextField jTextField2 = new JTextField();
		jTextField2.setFont(fonteCampo);
		jTextField2.setToolTipText("dd/MM/yyyy");
		jTextField2.setBounds(235, 240, 235, 32);
		getContentPane().add(jTextField2);

		JLabel jLabel7 = new JLabel("Hora");
		jLabel7.setFont(fonteLabel);
		jLabel7.setForeground(corTexto);
		jLabel7.setBounds(140, 300, 85, 25);
		getContentPane().add(jLabel7);

		JTextField jTextField3 = new JTextField();
		jTextField3.setFont(fonteCampo);
		jTextField3.setToolTipText("HH:mm");
		jTextField3.setBounds(235, 295, 235, 32);
		getContentPane().add(jTextField3);

		JLabel jLabel8 = new JLabel("Valor");
		jLabel8.setFont(fonteLabel);
		jLabel8.setForeground(corTexto);
		jLabel8.setBounds(140, 355, 85, 25);
		getContentPane().add(jLabel8);

		JTextField jTextField4 = new JTextField();
		jTextField4.setFont(fonteCampo);
		jTextField4.setToolTipText("R$");
		jTextField4.setBounds(235, 350, 235, 32);
		getContentPane().add(jTextField4);

		JToggleButton jToggleButton1 = new JToggleButton("Agendar");
		jToggleButton1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		jToggleButton1.setBounds(235, 410, 235, 42);
		getContentPane().add(jToggleButton1);

		JTextArea jTextArea1 = new JTextArea();
		jTextArea1.setFont(fonteCampo);
		jTextArea1.setLineWrap(true);
		jTextArea1.setWrapStyleWord(true);
		JScrollPane jScrollPane1 = new JScrollPane(jTextArea1);
		jScrollPane1.setBounds(140, 475, 330, 160);
		getContentPane().add(jScrollPane1);

		String[] colunas = { "id", "Cliente", "Serviço", "Valor", "Data", "Hora", "Observação" };
		Object[][] dados = {
				{ "1", "Alan", "Corte", "10", "16/03/2024", "08:00", "Pode ser" },
				{ "2", "Abgail", "Barba", "20", "16/03/2024", "08:00", "" },
				{ "3", "Pedro", "Barba", "20", "16/03/2024", "08:00", "" },
				{ "4", "Teste", "Barba + Corte", "30", "16/03/2024", "08:00", "" } };

		JTable jTable1 = new JTable(new DefaultTableModel(dados, colunas));
		jTable1.setFont(fonteCampo);
		jTable1.setRowHeight(24);
		jTable1.setFillsViewportHeight(true);
		jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
		jTable1.getColumnModel().getColumn(0).setPreferredWidth(35);
		jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
		jTable1.getColumnModel().getColumn(2).setPreferredWidth(115);
		jTable1.getColumnModel().getColumn(3).setPreferredWidth(60);
		jTable1.getColumnModel().getColumn(4).setPreferredWidth(95);
		jTable1.getColumnModel().getColumn(5).setPreferredWidth(60);
		jTable1.getColumnModel().getColumn(6).setPreferredWidth(130);

		JScrollPane jScrollPane2 = new JScrollPane(jTable1);
		jScrollPane2.setBounds(500, 75, 580, 560);
		getContentPane().add(jScrollPane2);

		getContentPane().setComponentZOrder(jLabel1, getContentPane().getComponentCount() - 1);
		getContentPane().setComponentZOrder(jLabel2, getContentPane().getComponentCount() - 2);
	}
}
