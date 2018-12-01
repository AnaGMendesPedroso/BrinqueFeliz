/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;
import entity.Categoria;
import entity.Produto;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author anapedroso
 */
public class ProdutoManager {

    public Produto buscaProduto(int idProduto) {
       
       /*
       implementar codigo
       buscar produto por id no banco
       se produto existir retorna produto
       se não retorna null
       */
       //prod recebe produto buscado
       Produto prod=null;
       return prod;
    }
   

    public Collection<Produto> buscaProduto(String nomeProduto) {
       
        /*
       implementar codigo
       buscar produto por nome no banco
       se produto existir retorna lista de produto com o msm nome
       se não retorna null
       */       
        
       //listaProd recebe lista de produtos buscado
        Collection<Produto> listaProd =null;
        
       return listaProd;
    }

}
