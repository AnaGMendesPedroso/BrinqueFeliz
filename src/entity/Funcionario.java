package entity;

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

    private Collection<Endereco> endereco;

    public boolean autentificarUsuario(int matricula, int senha) {
        return false;
    }

    public boolean verificarPermissao(int tipoPermissao) {
        return false;
    }

    public boolean isTipoPermissao() {
        return false;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(Collection<Cliente> cliente) {
        this.cliente = cliente;
    }

    public Collection<Venda> getVenda() {
        return venda;
    }

    public void setVenda(Collection<Venda> venda) {
        this.venda = venda;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Collection<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Collection<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }

    public Collection<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(Collection<Endereco> endereco) {
        this.endereco = endereco;
    }

}
