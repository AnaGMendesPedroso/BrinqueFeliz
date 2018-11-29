package entity;

import java.util.Collection;

public class Produto {

    private int codigoBarras;

    private String nomeProduto;

    private String descricao;

    private int preco;

    private int qtdEstoque;

    private Venda venda;

    private Estoque estoque;

    private Categoria categoria;

    private Collection<Empresa> empresa;

    private Collection<ItemDeVenda> itemDeVenda;

    public Produto buscarProduto(int idProduto) {
        return null;
    }

    public boolean alterarProduto(int idProduto) {
        return false;
    }

    public boolean excluirProduto(int idProduto) {
        return false;
    }

    public void cadastrarProduto(int codBarras, String nomeProduto, int idCategoria, int qtdEstoque, int idFabricante, int idFornecedor, int precoVenda, String descricao) {

    }

    public Produto buscarProduto(String nomeProduto) {
        return null;
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

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
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

    public Collection<ItemDeVenda> getItemDeVenda() {
        return itemDeVenda;
    }

    public void setItemDeVenda(Collection<ItemDeVenda> itemDeVenda) {
        this.itemDeVenda = itemDeVenda;
    }

}
