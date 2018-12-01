package entity;

import java.io.Serializable;
import java.util.Collection;


public class Estoque implements Serializable {

    private long idEstoque;
    

    private int quantidade;

    private Collection<Categoria> categoria;

    public Estoque() {
    }

    public Estoque(int quantidade, Collection<Categoria> categoria) {
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public Estoque(long idEstoque, int quantidade, Collection<Categoria> categoria) {
        this.idEstoque = idEstoque;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public long getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(long idEstoque) {
        this.idEstoque = idEstoque;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Collection<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(Collection<Categoria> categoria) {
        this.categoria = categoria;
    }
}
