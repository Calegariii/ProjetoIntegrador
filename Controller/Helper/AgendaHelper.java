package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class AgendaHelper implements IHelper {

	private final Agenda view;

	public AgendaHelper(Agenda view) {
		this.view = view;
	}

	public void preencherTabela(ArrayList<Agendamento> agendamentos) {
		DefaultTableModel tableModel = (DefaultTableModel) view.getCaixatabela().getModel();
		tableModel.setNumRows(0);

		for (Agendamento agendamento : agendamentos) {
			tableModel.addRow(new Object[] {
					agendamento.getId(),
					agendamento.getCliente().getNome(),
					agendamento.getServico().getDescricao(),
					agendamento.getServico().getValor(),
					agendamento.getDataFormatada(),
					agendamento.getHoraFormatada(),
					agendamento.getObservacao()
			});
		}
	}

	@SuppressWarnings("unchecked")
	public void preencherCliente(ArrayList<Cliente> clientes) {
		DefaultComboBoxModel<Cliente> comboBoxModel = (DefaultComboBoxModel<Cliente>) view.getClienteCaixaopcao()
				.getModel();
		comboBoxModel.removeAllElements();

		for (Cliente cliente : clientes) {
			comboBoxModel.addElement(cliente);
		}
	}

	@SuppressWarnings("unchecked")
	public void preencherServico(ArrayList<Servico> servicos) {
		DefaultComboBoxModel<Servico> comboBoxModel = (DefaultComboBoxModel<Servico>) view.getServicoscaixa()
				.getModel();
		comboBoxModel.removeAllElements();

		for (Servico servico : servicos) {
			comboBoxModel.addElement(servico);
		}
	}

	public Cliente obterCliente() {
		return (Cliente) view.getClienteCaixaopcao().getSelectedItem();
	}

	public Servico obterServico() {
		return (Servico) view.getServicoscaixa().getSelectedItem();
	}

	public void setarValor(float valor) {
		view.getTextovalor().setText(String.valueOf(valor));
	}

	@Override
	public Agendamento obterModelo() {
		Cliente cliente = obterCliente();
		Servico servico = obterServico();

		if (cliente == null || servico == null) {
			return null;
		}

		String data = view.getDatatexto().getText();
		String hora = view.getCaixahora().getText();
		String observacao = view.getjTextArea1().getText();

		return new Agendamento(0, cliente, servico, servico.getValor(), data, hora, observacao);
	}

	@Override
	public void limparTela() {
		view.getIdtexto().setText("");
		view.getDatatexto().setText("");
		view.getCaixahora().setText("");
		view.getjTextArea1().setText("");
	}
}
