/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6.model;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javaapplication6.conexao.Conexao;
import javaapplication6.view.TelaPri;
import javax.swing.JOptionPane;

/**
 *
 * @author flavio
 */
public class LoginConexao {
    
  
   
   
    
    public void InserirUsuario ()
    {
        Connection conn;
        String sql="INSERT INTO tb_login (usuario, senha) VALUES (?, ?)";
        conn = Conexao.getConexao();//conectando ao bd
        PreparedStatement stmt=null;
        
        try
        {
            
            stmt=conn.prepareStatement(sql);
            stmt.setString(1, Login.usuario);
            stmt.setString(2,Login.senha);
            stmt.executeUpdate();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"erro ao gravar no bd " + ex);
        }
        finally
        {
            Conexao.fecharConexao(conn, stmt);
        }
        
    }
    
    public void verificarUsuario ()
    {
        Connection conn;
        String sql="SELECT * FROM tb_login";
        conn = Conexao.getConexao();//conectando ao bd
        PreparedStatement stmt=null;
        ResultSet rs=null;
        
        try
        {
            
            stmt=conn.prepareStatement(sql);
            
            rs=stmt.executeQuery();
            rs.next();
            
            String usuario1 = rs.getString("usuario");
            String senha1 = rs.getString("senha");
            
            
           // teste 
           
           if (usuario1.equals(Login.usuario) && senha1.equals(Login.senha))
           {
              TelaPri tp=new TelaPri();
              tp.setVisible(true);
           }
       
            
               }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"erro ao gravar no bd " + ex);
        }
        finally
        {
            Conexao.fecharConexao(conn, stmt);
        }
    }
    
    
}
