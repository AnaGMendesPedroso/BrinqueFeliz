package entity;

import java.io.Serializable;
import java.util.Date;

import java.util.Collection;

public class Funcionario implements Serializable {

    
    private int matricula;

    
    private boolean ehAdministrador;

    
    private Date dataContratacao;
    
    
    private String senha;
    
    
    private String cpf;
    
    
    private String nome;
    
    
    private int telefone;
    
    
    private String email;

    private Collection<Endereco> endereco;

    public Funcionario() {
    }

    public Funcionario(int matricula, boolean ehAdministrador, Date dataContratacao, String senha, String cpf, String nome, int telefone, String email, Collection<Endereco> endereco) {
        this.matricula = matricula;
        this.ehAdministrador = ehAdministrador;
        this.dataContratacao = dataContratacao;
        this.senha = senha;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Funcionario(String nome, int matricula, String ehADM) {
        this.nome = nome;
         this.matricula = matricula;
         this.ehAdministrador = ehAdministrador;
    }

    public Funcionario(int mat, String nome, boolean adm) {
         this.nome = nome;
         this.matricula = matricula;
         this.ehAdministrador = ehAdministrador;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public boolean isEhAdministrador() {
        return ehAdministrador;
    }

    public void setEhAdministrador(boolean ehAdministrador) {
        this.ehAdministrador = ehAdministrador;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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

    public Collection<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(Collection<Endereco> endereco) {
        this.endereco = endereco;
    }
}
