
package com.mycompany.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public Connection conexao;
    public String driver = "com.mysql.cj.jdbc.Driver";
    public String server = "localhost";
    public String port = "3306";
    public String database = "games";
    public String usuario = "root";
    public String senha = "1234";
    public String caminho = "jdbc:mysql://" + server + ":" + port + "/" + database;

    
    public Connection getConnection() throws SQLException {
        
        System.setProperty("jdbc.Drivers", driver);
        conexao = DriverManager.getConnection(caminho, usuario, senha); 
        System.out.println("Conectado com o Banco de Dados");
        return conexao;
        
    }
    
    
    
    
    
}
