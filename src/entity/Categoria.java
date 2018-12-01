package entity;

import java.io.Serializable;
import java.util.Collection;

public class Categoria implements Serializable {

    private long idCategoria;



    private Collection<Produto> produto;
    

    private String nomeCategoria;
    
    private String descricao;
    
    public Categoria() {
    }

    public Categoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Categoria(long idCategoria, Collection<Produto> produto, String nomeCategoria, String descricao) {
        this.idCategoria = idCategoria;
        this.produto = produto;
        this.nomeCategoria = nomeCategoria;
        this.descricao = descricao;
    }
    

    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Collection<Produto> getProduto() {
        return produto;
    }

    public void setProduto(Collection<Produto> produto) {
        this.produto = produto;
    }

}
