package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AgendaController {

	private final Agenda view;
	private final AgendaHelper helper;

	public AgendaController(Agenda view) {
		this.view = view;
		this.helper = new AgendaHelper(view);
	}

	public void atualizaTabela() {
		// Buscar lista com agendamentos do banco de dados
		AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
		ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
		// Exibir esta lista na View
		helper.preencherTabela(agendamentos);
	}

	public void atualizaCliente() {
		// Buscar clientes do banco de dados
		ClienteDAO clienteDAO = new ClienteDAO();
		ArrayList<Cliente> clientes = clienteDAO.selectAll();
		// Exibir clientes no combobox de cliente
		helper.preencherCliente(clientes);
	}

	public void atualizaServico() {
		// Buscar servicos do banco de dados
		ServicoDAO servicoDAO = new ServicoDAO();
		ArrayList<Servico> servicos = servicoDAO.selectAll();
		// Exibir servicos no combobox de servico
		helper.preencherServico(servicos);
	}

	public void atualizaValor() {
		Servico servico = helper.obterServico();
		if (servico != null) {
			helper.setarValor(servico.getValor());
		}
	}

	public void agendar() {
		// Buscar objeto Agendamento da tela
		Agendamento agendamento = helper.obterModelo();
		if (agendamento == null) {
			JOptionPane.showMessageDialog(view, "Selecione um cliente e um servico.");
			return;
		}
		// Salvar objeto no banco de dados
		new AgendamentoDAO().insert(agendamento);
		// Atualizar a tabela e limpar a tela
		atualizaTabela();
		helper.limparTela();
	}
}
