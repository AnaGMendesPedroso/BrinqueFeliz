package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;

@Entity
@Table(name = "venda")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_sequence")
    @SequenceGenerator(name = "venda_sequence", sequenceName = "venda_seq", allocationSize = 1)
    private long idVenda;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    @JoinColumn(name = "idProduto")
    private Produto produto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemvenda")
    @JoinColumn(name = "idItemVenda")
    private Collection<ItemDeVenda> itemDeVenda;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
    @JoinColumn(name = "matricula")
    private Funcionario funcionario;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pagamento")
    @JoinColumn(name = "idPagamento")
    private Pagamento pagamento;

    public Venda() {
    }

    public Venda(long idVenda, double valor, Date data, Produto produto, Collection<ItemDeVenda> itemDeVenda, Cliente cliente, Funcionario funcionario, Pagamento pagamento) {
        this.idVenda = idVenda;
        this.valor = valor;
        this.data = data;
        this.produto = produto;
        this.itemDeVenda = itemDeVenda;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.pagamento = pagamento;
    }

    public Venda(long idVenda, Date data, Cliente cliente, Funcionario funcionario) {
        this.idVenda = idVenda;
        this.data = data;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    
    
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

    public long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(long idVenda) {
        this.idVenda = idVenda;
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

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    
}
