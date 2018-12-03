/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Cliente;
import entity.Funcionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anapedroso
 */
public class PessoaManager extends ConexaoBD {

    public PessoaManager() {
        super();
    }

    public Cliente buscaCliente(int idCliente) {
        Cliente cli = null;

        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM brinquefelizschema.cliente WHERE idcliente = '" + idCliente + "'";
            System.out.println(sql);
            cli = (Cliente) statement.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cli;
    }

    public Funcionario buscaFuncionario(int matricula) {
        Funcionario func = null;
        
         try {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM brinquefelizschema.funcionario WHERE matricula = '" + matricula + "'";
            System.out.println(sql);
            func = (Funcionario) statement.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return func;
    }
    
    public boolean validarUsuario(int matricula) {
        Funcionario user;
        List<Funcionario> lista = new ArrayList();
        boolean teste;
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT *  FROM brinquefelizschema.funcionario WHERE matricula = '"
                    + matricula + "'";
            System.out.println(sql);

            ResultSet resultado = statement.executeQuery(sql);
            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String ehADM = resultado.getString("ehadministrador");
                user = new Funcionario(nome, matricula, ehADM);
                lista.add(user);
            }
            if (lista.isEmpty()) {
                throw new IllegalArgumentException("Usuario não cadastrado");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao validar: " + ex);
            return teste = false;
        } catch (IllegalArgumentException e) {
            System.out.println("Não existe esse usuário no BD");
            return teste = false;
        }
        return teste = true;
    }
}
