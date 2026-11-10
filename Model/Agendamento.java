package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Agendamento {

	private int id;
	private Cliente cliente;
	private Servico servico;
	private float valor;
	private Date data;
	private String hora;
	private String observacao;

	public Agendamento(int id, Cliente cliente, Servico servico, float valor, String data, String hora,
			String observacao) {
		this.id = id;
		this.cliente = cliente;
		this.servico = servico;
		this.valor = valor;
		this.data = Pessoa.converterData(data);
		this.hora = hora;
		this.observacao = observacao;
	}

	public Agendamento(int id, Cliente cliente, Servico servico, float valor, String dataHora) {
		this.id = id;
		this.cliente = cliente;
		this.servico = servico;
		this.valor = valor;
		this.data = Pessoa.converterData(dataHora);
		this.hora = extrairHora(dataHora);
	}

	private String extrairHora(String dataHora) {
		if (dataHora == null || !dataHora.contains(" ")) {
			return null;
		}
		return dataHora.substring(dataHora.indexOf(' ') + 1);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public String getDataFormatada() {
		if (data == null) {
			return "";
		}
		return new SimpleDateFormat("dd/MM/yyyy").format(data);
	}

	public String getHoraFormatada() {
		return hora == null ? "" : hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "Agendamento [id=" + id + ", cliente=" + cliente + ", servico=" + servico + ", valor=" + valor
				+ ", data=" + data + ", hora=" + hora + ", observacao=" + observacao + "]";
	}
}
