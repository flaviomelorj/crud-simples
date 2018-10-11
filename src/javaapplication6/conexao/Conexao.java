/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6.conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author flavio
 */
public class Conexao {
    
    public static final String DRIVER="com.mysql.jdbc.Driver";
    public static final String URL="jdbc:mysql://bancodados.mysql.uhserver.com/bancodados";
    public static final String USUARIO="flaviomelorj";
    public static final String SENHA="nicole@1998";
    
    
    public static Connection getConexao ()
    {
        
        
        try
        {
            Class.forName(DRIVER);
            return (Connection) DriverManager.getConnection(URL, USUARIO, SENHA);
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            throw new RuntimeException("NÃO CONECTOU COM O BD " + ex);
        }
        
    }
    
    public static void fecharConexao (Connection conn)
    {
        if ( conn != null)
        {
            try 
            {
                conn.close();
            }
            catch (SQLException ex)
            {
                throw new RuntimeException ("não fechou o banco de dados " + ex);
            }
        }
    }
 
    public static void fecharConexao (Connection conn,PreparedStatement stmt)
    {
        if (stmt != null)
        {
            try 
            {
                stmt.close();
            }
            catch (SQLException ex)
            {
                throw new RuntimeException ("não fechou o banco de dados " + ex);
            }
        }
        
        fecharConexao(conn);
    }
    
    public static void fecharConexao (Connection conn,PreparedStatement stmt,ResultSet rs)
    {
        if ( rs != null)
        {
            try
            {
                rs.close();
            }
            catch (SQLException ex)
            {
                throw new RuntimeException ("não fechou o banco de dados " + ex);
            }
        }
        
        fecharConexao (conn,stmt);
    }
    
}
