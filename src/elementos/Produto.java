package elementos;

import java.util.String;
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

	public void setCodigoBarras(int codigoBarras) {

	}

	public int getCodigoBarras() {
		return 0;
	}

	public void setNomeProduto(String nomeProduto) {

	}

	public String getNomeProduto() {
		return null;
	}

	public void setDescricao(String descricao) {

	}

	public String getDescricao() {
		return null;
	}

	public void setPreco(int preco) {

	}

	public int getPreco() {
		return 0;
	}

	public void setQtdEstoque(int qtdEstoque) {

	}

	public int getQtdEstoque() {
		return 0;
	}

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

}
