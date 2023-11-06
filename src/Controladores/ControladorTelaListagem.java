/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import DAO.PodcastDAO;
import DAO.UsuarioDAO;
import Modelos.Podcast;
import Modelos.Usuario;
import Visoes.TelaCadastrar;
import Visoes.TelaListagem;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class ControladorTelaListagem {
    
    private final TelaListagem visao;
    
    public ControladorTelaListagem(TelaListagem visao) {
        this.visao = visao;
    }
    
    public void irTelaCadastrar() {
        TelaCadastrar telaCadastrar = new TelaCadastrar();
        telaCadastrar.setVisible(true);
        visao.dispose();
    }
    
    public DefaultTableModel criaModeloTabela(ArrayList<Podcast> podcasts) {

        //cria a matriz com os dados
        Object[][] df = new Object[podcasts.size()][5];

        //preenche a matriz
        for (int i = 0; i < podcasts.size(); i++) {
            Podcast podcast = podcasts.get(i);
            df[i][0] = podcast.getId();
            df[i][1] = podcast.getProdutor();
            df[i][2] = podcast.getNomeEpisodio();
            df[i][3] = podcast.getDuracao();
            df[i][4] = podcast.getUrlRepositorio();
            
        }

        //cria o modelo da tabela com os dados
        String[] colunaNomes = {"id", "produtor", "nome episodio", "duração", "url do repositório"};
        DefaultTableModel modeloTabela = new DefaultTableModel(df, colunaNomes);
        
        return modeloTabela;
        
    }
    
    public void exibeModeloNaTabelaDaVisao() {
        
        Connection conexao = null;
        PodcastDAO podcastDAO = new PodcastDAO((com.sun.jdi.connect.spi.Connection) conexao);
        ArrayList<Podcast> podcasts = podcastDAO.listaTodosPodcasts();
        DefaultTableModel modeloTabela = this.criaModeloTabela(podcasts);
        visao.getjTableListagem().setModel(modeloTabela);
        
    }
    
    public DefaultTableModel criaModeloTabelaPesquisa(ArrayList<Podcast> podcasts) {
        //cria a matriz com os dados
        Object[][] df = new Object[podcasts.size()][5];
        //preenche a matriz
        for (int i = 0; i < podcasts.size(); i++) {
            Podcast podcast = podcasts.get(i);
            df[i][0] = podcast.getId();
            df[i][1] = podcast.getProdutor();
            df[i][2] = podcast.getNomeEpisodio();
            df[i][3] = podcast.getDuracao();
            df[i][4] = podcast.getUrlRepositorio();
            
        }

        //cria o modelo da tabela com os dados
        String[] colunaNomes = {"id", "produtor", "nome episodio", "duração", "url do repositório"};
        DefaultTableModel modeloTabela = new DefaultTableModel(df, colunaNomes);
        
        return modeloTabela;
        
    }
    
    public void exibeModeloTabelaPesquisa() {
        String nomeProdutor = visao.getjTextFieldPesquisa().getText();
        Podcast podcast = new Podcast(nomeProdutor);
        Connection conexao = null;
        PodcastDAO podcastDAO = new PodcastDAO((com.sun.jdi.connect.spi.Connection) conexao);
        ArrayList<Podcast> podcasts = podcastDAO.pesquisaPorNomeProdutor(podcast);
        DefaultTableModel modeloTabela = this.criaModeloTabelaPesquisa(podcasts);
        visao.getjTableListagem().setModel(modeloTabela);
        
    }
    
    public void sumirBotaoCadastrar(){
        Usuario usuario = visao.getUsuario();
        Connection conexao = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO((com.sun.jdi.connect.spi.Connection) conexao);
        
        String controle = usuarioDAO.buscarPermissao(usuario);
        
        if(controle.equals("usuario")){
            visao.getjButtonCadastrar().setVisible(false);
        }
    }
    
    public void mostrarMensagemBoasVindas(){
        
          Usuario usuario = visao.getUsuario();
        Connection conexao = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO((com.sun.jdi.connect.spi.Connection) conexao);
        
        String permissao = usuarioDAO.buscarPermissao(usuario);
        
        JOptionPane.showMessageDialog(null, "Bem vindo usuario " + usuario.getLogin()+" sua permissão é de "+ permissao+"!");
        
        
    }
    
}
