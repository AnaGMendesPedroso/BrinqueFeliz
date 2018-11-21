package elementos;

import java.util.Date;
import java.util.Collection;


public class Venda {

	private double valor;

	private Date data;

	private Produto produto;

	private ItemDeVenda itemDeVenda;

	private Collection<ItemDeVenda> itemDeVenda;

	private Pagamento pagamento;

	private Cliente cliente;

	private Funcionario funcionario;

	private Collection<Pagamento> pagamento;

	public void gerarRecibo() {

	}

	public void removerProdutoVenda() {

	}

	public void registrarProdutoVenda() {

	}

	public void setValor(double valor) {

	}

	public double getValor() {
		return 0;
	}

	public void setData(Date data) {

	}

	public Date getData() {
		return null;
	}

	public void iniciarVenda(int cpfCliente) {

	}

	public double adicionarProdutoVenda(int idProduto) {
		return 0;
	}

	public void gerarComprovante(int idVenda) {

	}

	public double calcularValorTotal(int idVenda) {
		return 0;
	}

	public String efetuarPagamento(int tipoPagamento, int quantia) {
		return null;
	}

	public String validarDados(int totalVenda, String dadosCartao) {
		return null;
	}

}
