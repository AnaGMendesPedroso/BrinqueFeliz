/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Categoria;
import entity.Estoque;
import entity.ItemDeVenda;
import entity.Produto;
import java.util.LinkedList;

/**
 *
 * @author anapedroso
 */
public class EstoqueManager {

    

    public EstoqueManager() {
    }

    public void atualizaEstoque(LinkedList<ItemDeVenda> item) {
        //para cada item na lista de itens vendidos...
        for (ItemDeVenda a : item) {
            //pega o produto do item,...
            Produto aux = a.getProduto();
            //pega a quantidade vendida do item,...
            int qtd = a.getQuantidade();
            
            //busca o produto no estoque(Banco de dados)
            /*
            
            implementar codigo:
            buscar produto estoque
            alterar quantidade de produto no estoque:
            quantidade atual menos quantidade vendida;
            
            */
            

        }

    }

}
