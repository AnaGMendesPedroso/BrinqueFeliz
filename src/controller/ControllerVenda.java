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
    
    //Adiciona produto na venda e retorna verdadeiro se adicionou
    public boolean adicionarProdutoVenda(int idProduto, int qtd) {
        Produto prod = produtoManager.buscaProduto(idProduto);
        return vendaManager.adicionarProdutoVenda(prod, qtd);
    }
    
    //metodo zoado
    public Produto buscarProduto(int idProduto) {
        Produto prod;
        prod = produtoManager.buscaProduto(idProduto);
        return prod;
    }
    
    
    //busca produto por nome e retorna uma lista de produtos
    public Collection<Produto> buscarProduto(String nomeProduto) {
        Collection<Produto> listProd;
        listProd = produtoManager.buscaProduto(nomeProduto);
        return listProd;
    }
    
    //Calcula valor total da venda e retorna valor
    public double calcularValorTotal() {
        double valor;
        valor = vendaManager.calcularValorTotal();
        return valor;
    }

    
    //remove produto da venda se esse produto existir
    public boolean removerProdutoVenda(int idProduto) {
        Produto prod;
        //retorna o produto que deseja retirar
        prod = produtoManager.buscaProduto(idProduto);
        //verifica se o produto existe na venda,se sim remove;
        if(vendaManager.buscaProdutoLista(prod)){
        vendaManager.removerProdutoVenda(prod);
        return true;
        
        }
        // se não retorna false
        else return false;

    }
    
    //Retorna lista de itens para 
    public Collection<ItemDeVenda> retornaLista(){
        Collection<ItemDeVenda> lista= vendaManager.retornaLista();
    return lista;
       }
    
    // tratar dps com o banco de dados
    public boolean registrarPagamento(double valorVenda) {
            
        vendaManager.registraPagamento(valorVenda);
        return true;

    }
    
    // tratar depois com banco de dados
    public boolean atualizarEstoque(LinkedList<ItemDeVenda> item) {

        estoqueManager.atualizaEstoque(item);
        return true;
    }
    // gera comprovante de venda 
    public boolean gerarComprovante() throws IOException {
        vendaManager.gerarComprovante();
        return vendaManager.gerarComprovante();
    }

    public boolean finalizarVenda() {
        vendaManager.finalizarVenda();
        return true;
    }

}