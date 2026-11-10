package View;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Model.Usuario;

public class Main {

	public static void main(String[] args) {
		String nome = "Rodrigo";
		System.out.println(nome);

		Servico servico = new Servico(1, "barba", 30);

		System.out.println(servico.getDescricao());
		System.out.println(servico.getValor());

		Cliente cliente = new Cliente(1, "Jorge", 'M', "30/01/1995", "30212126", "jorge@email.com", "5142487",
				"Rua tesla 95", "93300012");
		System.out.println(cliente.getNome());

		Usuario usuario = new Usuario(1, "barbeiro", "senha");
		System.out.println(usuario);

		Agendamento agendamento = new Agendamento(1, cliente, servico, 30, "25/03/2024 11:20");
		System.out.println(agendamento.getCliente().getNome());
		System.out.println(agendamento.getData());
		System.out.println(agendamento.getHora());
	}
}
