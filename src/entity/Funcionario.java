package entity;

import java.io.Serializable;
import java.util.Date;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

    @Id
    private int matricula;

    @Column(nullable = false)
    private boolean ehAdministrador;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataContratacao;
    
    @Column(nullable = false)
    private String senha;
    
    @Column(nullable = false)
    private String cpf;
    
    @Column(nullable = false)
    private String nome;
    
    @Column
    private int telefone;
    
    @Column
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "endereco")
    @JoinColumn(name="idEndereco")
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
