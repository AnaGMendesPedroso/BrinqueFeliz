package elementos;

import java.util.Date;

import java.util.Collection;

public class Funcionario {

	private boolean tipoPermissao;

	private Date dataContratacao;

	private String tipo;

	private int matricula;

	private int senha;

	private int cpf;

	private String nome;

	private int telefone;

	private String email;

	private Collection<Cliente> cliente;

	private Collection<Venda> venda;

	private Estoque estoque;

	private Collection<Funcionario> funcionario;

	private Funcionario funcionario;

	private Collection<Endereco> endereco;

	public boolean autentificarUsuario(int matricula, int senha) {
		return false;
	}

	public boolean verificarPermissao(int tipoPermissao) {
		return false;
	}

	public void setEmail(String email) {

	}

	public String getEmail() {
		return null;
	}

	public void setTelefone(int telefone) {

	}

	public int getTelefone() {
		return 0;
	}

	public void setNome(String nome) {

	}

	public String getNome() {
		return null;
	}

	public int getCpf() {
		return 0;
	}

	public int getSenha() {
		return 0;
	}

	public int getMatricula() {
		return 0;
	}

	public void setDataContratacao(Date dataContratacao) {

	}

	public Date getDataContratacao() {
		return null;
	}

	public boolean isTipoPermissao() {
		return false;
	}

}
