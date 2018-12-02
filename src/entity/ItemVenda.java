package entity;

import java.io.Serializable;

public class ItemVenda implements Serializable {

    private Long idItemVenda;


    private int quantidade;

    private Produto produto;

    public ItemVenda() {
    }

    public ItemVenda(int quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public Long getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(Long idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
