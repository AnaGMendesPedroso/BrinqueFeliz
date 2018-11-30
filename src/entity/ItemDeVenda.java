package entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="itemvenda")
public class ItemDeVenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_sequence")
    @SequenceGenerator(name = "item_sequence", sequenceName = "item_seq", allocationSize = 1)
    private Long idItemVenda;

    @Column(nullable = false)
    private int quantidade;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    @JoinColumn(name = "idProduto")
    private Produto produto;

    public ItemDeVenda() {
    }

    public ItemDeVenda(Long idItemVenda, int quantidade, Produto produto) {
        this.idItemVenda = idItemVenda;
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public ItemDeVenda(int quantidade, Produto produto) {
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
