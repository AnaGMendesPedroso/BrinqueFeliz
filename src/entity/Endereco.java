package entity;

import java.io.Serializable;

public class Endereco implements Serializable {


    private long idEndereco;


    private String estado;

    private String cidade;


    private String rua;


    private String bairro;

    private int numero;


    private int cep;

    public Endereco() {
    }

    public Endereco(String estado, String cidade, String rua, String bairro, int numero, int cep) {
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
    }

    public long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    
}
