package br.com.yaw.jdk7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Exemplo: a nova API de JDBC (4.1) foi modificada para suportar AutoCloseable, reduzindo o código try-finally.
 *
 * Utilizo o driver do MySQL.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
public class NovoJDBC {
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {}
    }
    
    public static void main(String[] args) throws SQLException {
        String query = "select nome, cpf from aluno"; //Ajuste a consulta SQL (Table: Aluno [nome, cpf])
        
        //Coloque a url jdbc correta
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
             

              while (rs.next()) {
                  String nome = rs.getString("nome");
                  String cpf = rs.getString("cpf");
                  
                  System.out.printf("Nome:%s\t Cpf:%s %n", nome, cpf);
              }
         }
    }
    
}
