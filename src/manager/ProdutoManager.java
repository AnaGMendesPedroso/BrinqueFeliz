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
        Produto p = null;

        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM brinquefelizschema.produto WHERE codigobarras = '" + codigobarras + "'";
            System.out.println(sql);
            ResultSet resultado = statement.executeQuery(sql);
            // converter resultado para Produto aqui e onde precisar
            while (resultado.next()) {
                int cod = resultado.getInt("codigobarras");
                System.out.println(cod);
                int cat = resultado.getInt("idcategoria");
                System.out.println(cat);

                String nome = resultado.getString("nomeproduto");
                System.out.println(nome);

                double preco = resultado.getDouble("preco");
                System.out.println(preco);

                int qtd = resultado.getInt("qtdestoque");
                System.out.println(qtd);

                p = new Produto(cod, cat, nome, preco, qtd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
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
