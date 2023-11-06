/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelos.Usuario;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class UsuarioDAO {

    private final Connection conexao;

    public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void insertUsuarioNoBanco(Usuario usuario) {
        try {
            java.sql.Connection conn = (java.sql.Connection) new ConexaoBancoDados().getConnection();
            String sql = "insert into usuario(login,senha,permissao) values(?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getPermissao());
            ps.execute();
            ps.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showInternalMessageDialog(null, "Falha no sql!");
        }
    }

    public boolean loginExiste(Usuario usuario) throws SQLException {

        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resultado = false;

        try {
            conn = new ConexaoBancoDados().getConnection();
            String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            rs = ps.executeQuery();
            resultado = rs.next();
        } finally {

            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return resultado;

    }

    public String buscarPermissao(Usuario usuario) {
        String permissao = null;
         java.sql.Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = (java.sql.Connection) new ConexaoBancoDados().getConnection();
            String sql = "SELECT permissao FROM usuario WHERE login = ? AND senha = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            rs = ps.executeQuery();

            if (rs.next()) {
                permissao = rs.getString("permissao");
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Falha na busca!");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, "Falha no sql!");
            }
        }

        return permissao;
    }

}
