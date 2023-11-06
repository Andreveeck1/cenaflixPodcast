/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import DAO.UsuarioDAO;
import Modelos.Usuario;
import Visoes.TelaListagem;
import Visoes.TelaLogin;
import com.sun.jdi.connect.spi.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class ControladorTelaLogin {

    private final TelaLogin visao;

    public ControladorTelaLogin(TelaLogin visao) {
        this.visao = visao;
    }

    public Usuario construirUsuario() {
        Usuario usuario = null;
        String login = visao.getjTextFieldLogin().getText();
        String senha = visao.getjPasswordFieldSenha1().getText();
        String permissao = visao.getjPasswordFieldPermissao().getText();

        usuario = new Usuario(login, senha, permissao);

        return usuario;

    }

    public void inserirUsuarioNobanco() {
        Usuario usuario = this.construirUsuario();
        Connection conexao = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
        try {
            if (usuario.getLogin().isEmpty() || usuario.getSenha().isEmpty() || usuario.getPermissao().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Há campos em branco!");
            } else if (!usuarioDAO.loginExiste(usuario)) {
                usuarioDAO.insertUsuarioNoBanco(usuario);
            } else {
                JOptionPane.showMessageDialog(null, "Login já existe!");
                visao.getjPasswordFieldPermissao().setVisible(false);
                visao.getjButtonCadastrar().setVisible(false);
                visao.getjLabelPermissao().setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorTelaLogin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha no sql!");
        }

    }

    public void fazerLogin() {
        String login = visao.getjTextFieldLogin().getText();
        String senha = visao.getjPasswordFieldSenha1().getText();

        Usuario usuario = new Usuario(login, senha);
        Connection conexao = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);

        try {
            if (usuario.getLogin().isEmpty() || usuario.getSenha().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Há campos em branco!");
            } else if (usuarioDAO.loginExiste(usuario)) {
                TelaListagem telaListagem = new TelaListagem(usuario);
                telaListagem.setVisible(true);
                visao.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Login inválido!");

            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorTelaLogin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha no sql!");
        }

    }

}
