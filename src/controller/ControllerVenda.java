package controller;

import entity.Cliente;
import entity.Funcionario;
import entity.ItemDeVenda;
import entity.Produto;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import manager.EstoqueManager;
import manager.PessoaManager;
import manager.ProdutoManager;
import manager.VendaManager;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gabrielkans
 */
public class ControllerVenda {

    EstoqueManager estoqueManager = new EstoqueManager();
    PessoaManager pessoaManager = new PessoaManager();
    ProdutoManager produtoManager = new ProdutoManager();
    VendaManager vendaManager = new VendaManager();
    //inicia venda 
    public void iniciarVenda(int idCliente, int idFuncionario) {
        Funcionario func = pessoaManager.buscaFuncionario(idFuncionario);
        if(idCliente!=0){
        Cliente cli = pessoaManager.buscaCliente(idCliente);
        vendaManager.iniciarVenda(cli, func);
        }
        else vendaManager.iniciarVenda(func);
    }
    
    public boolean adicionarProdutoVenda(int idProduto, int qtd) {
        Produto prod = produtoManager.buscaProduto(idProduto);
        vendaManager.adicionarProdutoVenda(prod, qtd);
        return true;
    }

    public Produto buscarProduto(int idProduto) {
        Produto prod;
        prod = produtoManager.buscaProduto(idProduto);
        return prod;
    }

    public LinkedList<Produto> buscarProduto(String nomeProduto) {
        LinkedList<Produto> listProd;
        listProd = produtoManager.buscaProduto(nomeProduto);
        return listProd;
    }

    public double calcularValorTotal() {
        double valor;
        valor = vendaManager.calcularValorTotal();
        return valor;
    }

    public boolean removerProdutoVenda(int idProduto) {
        Produto prod;
        prod = produtoManager.buscaProduto(idProduto);
        vendaManager.removerProdutoVenda(prod);
        return true;

    }

    public boolean registrarPagamento(double valorVenda) {
        vendaManager.registraPagamento(valorVenda);
        return true;

    }

    public boolean atualizarEstoque(LinkedList<ItemDeVenda> item) {

        estoqueManager.atualizaEstoque(item);
        return true;
    }

    public boolean gerarComprovante() throws IOException {
        vendaManager.gerarComprovante();
        return true;
    }

    public boolean finalizarVenda() {
        vendaManager.finalizarVenda();
        return true;
    }

    public Collection<ItemDeVenda> retornaLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
