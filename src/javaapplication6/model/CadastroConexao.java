/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javaapplication6.conexao.Conexao;
import javax.swing.JOptionPane;

/**
 *
 * @author flavio
 */
public class CadastroConexao {
    
    public void InserirCliente ()
    {
        Connection conn;
        String sql="INSERT INTO tb_cadastro (nome, sobrenome, idade, data_nascimento, sexo) VALUES (?, ?, ?, ?, ?)";
        conn = Conexao.getConexao();//conectando ao bd
        PreparedStatement stmt=null;
        
        try
        {
            
            stmt=conn.prepareStatement(sql);
            stmt.setString(1, Cadastro.nome);
            stmt.setString(2,Cadastro.sobrenome);
            stmt.setInt(3, Cadastro.idade);
            stmt.setDate(4, Cadastro.data_nascimento);
            stmt.setString(5, Cadastro.sexo);
            stmt.executeUpdate();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null," ERRO AO GRAVAR DADOS NO BANCO DE DADOS  " + ex);
        }
        finally
        {
            Conexao.fecharConexao(conn, stmt);
        }
    }
    
    
}
