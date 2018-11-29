package entity;

import entity.Cliente;
import entity.Funcionario;
import entity.ItemDeVenda;
import entity.Pagamento;
import entity.Produto;
import java.util.Date;
import java.util.Collection;

public class Venda {

    private double valor;
    private Date data;
    private Produto produto;
    private Collection<ItemDeVenda> itemDeVenda;
    private Cliente cliente;
    private Funcionario funcionario;
    private Pagamento pagamento;

    public void gerarRecibo() {

    }

    public void removerProdutoVenda() {

    }

    public void registrarProdutoVenda() {

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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Collection<ItemDeVenda> getItemDeVenda() {
        return itemDeVenda;
    }

    public void setItemDeVenda(Collection<ItemDeVenda> itemDeVenda) {
        this.itemDeVenda = itemDeVenda;
    }


    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
