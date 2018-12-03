package entity;

import java.util.Collection;
import java.io.Serializable;

public class Produto implements Serializable {


    private int codigoBarras;

 
    private String nomeProduto;

    private String descricao;

    private double preco;

    private int qtdEstoque;
    
    private int idCategoria;
    
    public Produto() {
    }

    public Produto(int cod, int cat, String nome, double preco, int qtd) {
        this.codigoBarras = cod;
        this.nomeProduto = nome;
        this.preco = preco;
        this.qtdEstoque = qtd;
        this.idCategoria = cat;
    }

    public int getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(int codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }  
}
