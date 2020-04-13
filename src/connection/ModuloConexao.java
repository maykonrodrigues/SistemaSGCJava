/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Maykon Rodrigues
 */
public class ModuloConexao {
        // a linha abaixo "chama" o driver
        private static final String DRIVER = "com.mysql.jdbc.Driver";
        // Armazenando informações referente ao banco
        private static final String URL = "jdbc:mysql://localhost:3306/dbsgcjava?verifyServerCertificate=false&useSSL=true";
        private static final String USER = "root";
        private static final String PASSWORD = "181406";

// Estabelecendo a conexão com o banco
//método responsavel por estabelecer a conexão com o banco
    public static Connection conector() {
        java.sql.Connection conexao = null;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado ao banco de dados com sucesso!");
            return conexao;
        } catch (Exception e) {
            System.out.println("Mensagem de erro de conexão com o banco de dados: "+e);
            return null;
        }
    }
    
    public static void fecharConexao(Connection con) {
        try {
            if (con != null) {
                con.close();
                System.out.println("'Connection' finalizado!");
            }
        } catch (Exception e) {
            System.out.println("Connection já foi fechada! "+e);
        }
    }

    public static void fecharConexao(Connection con, PreparedStatement stmt) {
        fecharConexao(con);
        try {
            if (stmt != null) {
                stmt.close();
                System.out.println("'PreparedStatement' finalizado!");
            }
        } catch (Exception e) {
            System.out.println("PreparedStatement já foi fechado! "+e);
        }
    }

    public static void fecharConexao(Connection con, PreparedStatement stmt, ResultSet rs) {
        fecharConexao(con, stmt);
        try {
            if (rs != null) {
                rs.close();
                System.out.println("'ResultSet' finalizado!");
            }
        } catch (Exception e) {
            System.out.println("ResultSet já foi fechado! "+e);
        }
    }
}
