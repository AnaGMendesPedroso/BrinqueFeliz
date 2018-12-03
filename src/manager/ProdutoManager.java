/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Categoria;
import entity.Cliente;
import entity.Produto;
import java.sql.ResultSet;
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
       Produto prod=new Produto();
       
       try {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM brinquefelizschema.produto WHERE codigobarras = '" + codigobarras + "'";
            System.out.println(sql);
            ResultSet resultado =  statement.executeQuery(sql);
            while (resultado.next()) {
            	int id=resultado.getInt(1);
                int idc=resultado.getInt(2);
                String nome=resultado.getString(3);
                String descricao=resultado.getString(4);
                double preco=resultado.getDouble(5);
                
                int qtd=resultado.getInt(6);
                System.out.println(id+" "+nome);
                
                prod= new Produto(id,nome,descricao,preco,qtd);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaManager.class.getName()).log(Level.SEVERE, null, ex);
        }

       
       return prod;
    }
    public LinkedList<Produto> buscaProduto(String nomeProduto) {
        LinkedList<Produto> listaProd=new LinkedList<Produto>();
             
       try {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM brinquefelizschema.produto WHERE nomeproduto LIKE '%" + nomeProduto + "%'";
            System.out.println(sql);
            ResultSet resultado =  statement.executeQuery(sql);
            while (resultado.next()) {
            	int id=resultado.getInt(1);
                int idc=resultado.getInt(2);
                String nome=resultado.getString(3);
                String descricao=resultado.getString(4);
                double preco=resultado.getDouble(5);
                
                int qtd=resultado.getInt(6);
                System.out.println(id+" "+nome);
             Produto   prod= new Produto(id,nome,descricao,preco,qtd);
             listaProd.add(prod);   
            }
            
             
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaManager.class.getName()).log(Level.SEVERE, null, ex);
        }
       return listaProd;
    }

}
