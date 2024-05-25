package com.mycompany.connectdatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDatabase {

    public static Connection conexao;
    public JDBCConnection jdbc;
    
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World!");
        
        JDBCConnection jdbc = new JDBCConnection();
        conexao = jdbc.getConnection();
        
        //AddJogo(5, "Resident Evil");
        //DeleteJogo(5);
        //UpdateJogo(4, "Call of Duty");
        ListItens();
    }
    
    public static void ListItens() throws SQLException {
        
        Statement stm = conexao.createStatement();
        ResultSet rec = stm.executeQuery("SELECT *FROM jogos");
        
        while(rec.next()) {
            System.out.println(rec.getString("CodigoDoJogo") + " - " + rec.getString("NomeDoJogo"));           
        }   
    }
    
    public static void AddJogo(int Id, String nome) throws SQLException{
        
        Statement stm = conexao.createStatement();
        
        String cmd = "INSERT jogos (CodigoDoJogo, NomeDoJogo) VALUES (" + Id + " , '" + nome + "')";
        stm.execute(cmd);
        System.out.println("Registro Adicionado com Sucesso");
    }
    
    public static void DeleteJogo(int id) throws SQLException {
        
        Statement stm = conexao.createStatement();
        String cmd = "DELETE FROM jogos WHERE CodigoDoJogo = " + id;
        stm.execute(cmd);
        System.out.println("Registro Deletado com Sucesso");
    }
    
    public static void UpdateJogo(int id, String novo_nome) throws SQLException {
        
        Statement stm = conexao.createStatement();
        
        String cmd = "UPDATE jogos SET NomeDoJogo = '" + novo_nome + "' WHERE CodigoDoJogo = " + id;
        
        stm.execute(cmd);
        System.out.println("Registro Alterado com Sucesso");
        
    }
    
    
    
    
}
