package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="pagamento")
public class Pagamento implements Serializable {

    @Id@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pagamento_sequence")
    @SequenceGenerator(name = "pagemento_sequence", sequenceName = "pagamento_seq", allocationSize = 1)
      private long idPagamento;

    @Column(nullable = false)
    private double valor;
    
    @Column(nullable = false)
    private String tipoPagamento;

    @OneToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    
    @OneToOne
    @JoinColumn(name = "idVenda")
    private Venda venda;

    public Pagamento() {
    }

    public Pagamento(Long idPagamento, double valor, String tipoPagamento, Cliente cliente, Venda venda) {
        this.idPagamento = idPagamento;
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
        this.cliente = cliente;
        this.venda = venda;
    }

    public Long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    

}
