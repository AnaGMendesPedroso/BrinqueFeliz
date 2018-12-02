/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.ItemVenda;
import entity.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anapedroso
 */
public class EstoqueManager extends ConexaoBD {

    

    public EstoqueManager() {
        super();
    }

    public void atualizaEstoque(LinkedList<ItemVenda> item) {
      int qtdProdutosVendidos = 0;
   
        for (ItemVenda a : item) {
            Produto aux = a.getProduto();
            qtdProdutosVendidos = a.getQuantidade();
 
            try {
                Statement statement = conn.createStatement();
            String sql1 = "SELECT  qtdestoque FROM brinquefelizschema.produto WHERE codigobarras = '" 
                    + aux.getCodigoBarras() +"'";
            System.out.println(sql1);          
            
            ResultSet resultado = statement.executeQuery(sql1);
           int qtdFinal = resultado.getInt("qtdestoque") - qtdProdutosVendidos;
           
           String sql2 = "UPDATE  brinquefelizschema.produto SET  qtdestoque ='"+qtdFinal+"' WHERE codigobarras = '"+aux.getCodigoBarras()+"'";
           System.out.println(sql2);          
           
           String sql3 = "UPDATE  brinquefelizschema.estoque SET quantidade = '"+qtdFinal+"'";
        } catch (SQLException ex) {
              Logger.getLogger(EstoqueManager.class.getName()).log(Level.SEVERE, null, ex);
          }
        
            System.out.println("Estoque do produto " +aux.getNomeProduto()+" atualizado ");
        }

    }

}
