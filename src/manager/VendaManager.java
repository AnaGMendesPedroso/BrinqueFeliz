/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Cliente;
import entity.Funcionario;
import entity.Venda;
import entity.Pagamento;
import entity.ItemDeVenda;
import entity.Produto;
import java.util.LinkedList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author anapedroso
 */
public class VendaManager {

    private Venda ven;

    public VendaManager() {
    }
    //cria um objeto Venda
    public void iniciarVenda(Cliente cli, Funcionario fun) {

        ven = new Venda(cli, fun);

    }
    public void iniciarVenda(Funcionario func) {
      ven = new Venda(func);
     }

    public void adicionarProdutoVenda(Produto prod, int qtd) {
        ItemDeVenda novo = new ItemDeVenda(qtd, prod);
        ven.adicionarProdutoVenda(novo);

    }

    public double calcularValorTotal() {
        double preco = 0;

        Collection<ItemDeVenda> listaItem;
        listaItem = ven.getItemDeVenda();
        for (ItemDeVenda a : listaItem) {
            preco += a.getQuantidade() * a.getProduto().getPreco();
        }
        return preco;
    }

    public void removerProdutoVenda(Produto prod) {
        Collection<ItemDeVenda> novaLista;
        novaLista = ven.getItemDeVenda();
        novaLista.remove(prod);
        ven.setItemDeVenda(novaLista);
    }

    public void registraPagamento(double valorVenda) {
        ven.setValor(valorVenda);
        Cliente cli = ven.getCliente();//funcionario
        Pagamento pag = new Pagamento(valorVenda, "Dinheiro", cli, ven);
        /*
        inserir pagamento no banco de dados???
         */
    }

    public void gerarComprovante() throws IOException {

        FileWriter arq = new FileWriter("d:\\Comprovante-de-Venda.txt");
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.printf("--------------BRINQUE FELIZ S.A.--------------%n");
        String nomeCliente = ven.getCliente().getNome();
        gravarArq.printf("%nNome Cliente:");
        gravarArq.printf("%d%n", nomeCliente);
        String nomeFuncionario = ven.getFuncionario().getNome();
        gravarArq.printf("%nNome Funcionario:");
        gravarArq.printf("%d%n", nomeFuncionario);
        Collection<ItemDeVenda> lista = ven.getItemDeVenda();

        gravarArq.printf(" Qtd ||  Nome Produto  ||    id     || Preço Unitario%n");
        for (ItemDeVenda a : lista) {
            String nome = a.getProduto().getNomeProduto();
            int id = a.getProduto().getCodigoBarras();
            int qtd = a.getQuantidade();
            double precoUnitario = a.getProduto().getPreco();
            double precoParcial = precoUnitario * qtd;
            gravarArq.printf("  %d    %d     %d    %d%n", qtd, nome, id, precoUnitario);
            gravarArq.printf("  %d  *  %d   =           %d    %n", qtd, precoUnitario, precoParcial);
        }
        gravarArq.printf("%n-----------------------------------------------%n");
        gravarArq.printf("Forma de Pagamento-------------------------%d%n", ven.getPagamento().getTipoPagamento());
        gravarArq.printf("Total-------------------------%d%n", ven.getValor());

        arq.close();
    }

    public void finalizarVenda() {
        
        /*
        inserir venda no banco de dados
         */

    }

   

}
