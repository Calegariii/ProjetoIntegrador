package Model;

public class Usuario extends Pessoa {

	protected String senha;
	protected String nivelAcesso;

	public Usuario(int id, String nome, char sexo, String dataNascimento, String telefone, String email, String rg,
			String senha, String nivelAcesso) {
		super(id, nome, sexo, dataNascimento, telefone, email, rg);
		this.senha = senha;
		this.nivelAcesso = nivelAcesso;
	}

	public Usuario(int id, String nome, String senha) {
		super(id, nome);
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", senha=" + senha + ", nivelAcesso=" + nivelAcesso
				+ ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + ", telefone=" + telefone + ", email="
				+ email + ", rg=" + rg + "]";
	}
}
