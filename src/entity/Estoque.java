package entity;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name="estoque")
public class Estoque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estoque_sequence")
    @SequenceGenerator(name = "estoque_sequence", sequenceName = "estoque_seq", allocationSize = 1)
    private long idEstoque;
    
    @Column(nullable = false)
    private int quantidade;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    @JoinColumn(name="idCategoria")
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
