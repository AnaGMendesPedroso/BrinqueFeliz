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
@Table(name = "categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_sequence")
    @SequenceGenerator(name = "categoria_sequence", sequenceName = "categoria_seq", allocationSize = 1)
    @Column(name = "idcategoria", nullable = false)
    private long idCategoria;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    @JoinColumn(name="idProduto")
    private Collection<Produto> produto;
    
    @Column(nullable = false)
    private String nomeCategoria;
    
    @Column
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
