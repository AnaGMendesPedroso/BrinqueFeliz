package entity;

import java.util.Collection;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    @Id
    private int codigoBarras;

    @Column(nullable = false)
    private String nomeProduto;

    @Column
    private String descricao;

    @Column(nullable = false)
    private double preco;

    @Column(nullable = false)
    private int qtdEstoque;

    @OneToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    @OneToMany
    @JoinColumn(name = "idEmpresa")
    private Collection<Empresa> empresa;

    public Produto() {
    }

    public Produto(int codigoBarras, String nomeProduto, String descricao, double preco, int qtdEstoque, Categoria categoria, Collection<Empresa> empresa) {
        this.codigoBarras = codigoBarras;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.categoria = categoria;
        this.empresa = empresa;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Collection<Empresa> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Collection<Empresa> empresa) {
        this.empresa = empresa;
    }

    
}
