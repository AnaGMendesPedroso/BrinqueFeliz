/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;
import entity.Categoria;
import entity.Cliente;
import entity.Produto;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anapedroso
 */
public class ProdutoManager extends ConexaoBD {

    public ProdutoManager() {
        super();
    }
    
    

    public Produto buscaProduto(int codigobarras) {
       Produto prod=null;
       
       try {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM brinquefelizschema.produto WHERE codigobarras = '" + codigobarras + "'";
            System.out.println(sql);
            prod = (Produto) statement.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaManager.class.getName()).log(Level.SEVERE, null, ex);
        }

       
       return prod;
    }
   

    public Collection<Produto> buscaProduto(String nomeProduto) {
        Collection<Produto> listaProd = null;
             
       try {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM brinquefelizschema.produto WHERE nomeproduto LIKE '% '" + nomeProduto + "'%";
            System.out.println(sql);
             listaProd.add((Produto) statement.executeQuery(sql));
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaManager.class.getName()).log(Level.SEVERE, null, ex);
        }
       return listaProd;
    }

}
