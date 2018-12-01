package entity;

import java.io.Serializable;

public class Empresa implements Serializable {

    private long idEmpresa;

    private int cnpj;

    private String nomeFantasia;

    
    private String razaoSocial;

    private boolean ehFornecedora;


    private long telefone;


    private String email;

    private Endereco endereco;

    public Empresa() {
    }

    public Empresa(int cnpj, String nomeFantasia, String razaoSocial, boolean ehFornecedora, long telefone, String email, Endereco endereco) {
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.ehFornecedora = ehFornecedora;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public boolean isEhFornecedora() {
        return ehFornecedora;
    }

    public void setEhFornecedora(boolean ehFornecedora) {
        this.ehFornecedora = ehFornecedora;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }



}
