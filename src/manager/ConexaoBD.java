/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author anapedroso
 */
public abstract class ConexaoBD {
    private final String database = "jdbc:postgresql://localhost:5432/brinquefeliz";
    private final String user = "root";
    private final String password = "root";
    
     protected Connection conn;

    public ConexaoBD() {
        try {

            conn = DriverManager.getConnection(database + ";user="
                    + user + ";password=" + password);

            System.out.println("Conectado!");

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro na conexão. " + ex);
        }
    }
}
