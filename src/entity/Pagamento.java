package entity;

import java.io.Serializable;


public class Pagamento implements Serializable {

      private long idPagamento;

 
    private double valor;
    
    
    private String tipoPagamento;



    private Cliente cliente;
    

    private Venda venda;

    private String data;
    public Pagamento() {
    }

    public Pagamento(double valor, String tipoPagamento, Cliente cliente, Venda venda) {
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
