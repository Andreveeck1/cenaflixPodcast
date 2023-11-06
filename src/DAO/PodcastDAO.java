/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controladores.ControladorTelaListagem;
import Modelos.Podcast;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class PodcastDAO {
    
    private Connection connection;
    
    public PodcastDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void inserirPodcastNoBanco(Podcast podcast) {
        
        try {
            java.sql.Connection conn = new ConexaoBancoDados().getConnection();
            
            String sql = "insert into podcast(produtor,nomeEpisodio,duracao,urlRepositorio)values(?,?,?,?);";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, podcast.getProdutor());
            ps.setString(2, podcast.getNomeEpisodio());
            ps.setString(3, podcast.getDuracao());
            ps.setString(4, podcast.getUrlRepositorio());
            
            ps.execute();
            ps.close();
            conn.close();
            
            JOptionPane.showMessageDialog(null, "Podcast salvo com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(PodcastDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "FALHA NO SQL!");
        }
        
    }
    
    public boolean podcastExiste(Podcast podcast) {
        boolean resultado = true;
        try {
            java.sql.Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            conn = new ConexaoBancoDados().getConnection();
            String sql = "SELECT * FROM podcast WHERE produtor = ? AND nomeEpisodio = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, podcast.getProdutor());
            ps.setString(2, podcast.getNomeEpisodio());
            rs = ps.executeQuery();
            resultado = rs.next();
            ps.close();
            rs.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(PodcastDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
        
    }
    
    public ArrayList<Podcast> listaTodosPodcasts() {
        
        ArrayList<Podcast> podcasts = new ArrayList<>();
        try {
            
            java.sql.Connection conn = (java.sql.Connection) new ConexaoBancoDados().getConnection();
            String sql = "select * from podcast;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                // Extrair informações do ResultSet e criar objetos ProdutoApp
                int id = rs.getInt("id");
                String produtor = rs.getString("produtor");
                String nomeEpisodio = rs.getString("nomeEpisodio");
                String duracao = rs.getString("duracao");
                String urlRepositorio = rs.getString("urlRepositorio");
                
                Podcast podcast = new Podcast(id, produtor, nomeEpisodio, duracao, urlRepositorio);
                podcasts.add(podcast);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorTelaListagem.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Falha no sql!");
        }
        return podcasts;
    }
    
    public ArrayList<Podcast> pesquisaPorNomeProdutor(Podcast podcastPesquisa) {
        
        ArrayList<Podcast> podcastsNomeProdutor = new ArrayList<>();
        try {
            
            java.sql.Connection conn = (java.sql.Connection) new ConexaoBancoDados().getConnection();
            String sql = "select * from podcast where produtor = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
              ps.setString(1, podcastPesquisa.getProdutor());
            ps.execute();
            ResultSet rs = ps.getResultSet();
             while (rs.next()) {
                // Extrair informações do ResultSet e criar objetos ProdutoApp
                int id = rs.getInt("id");
                String produtor = rs.getString("produtor");
                String nomeEpisodio = rs.getString("nomeEpisodio");
                String duracao = rs.getString("duracao");
                String urlRepositorio = rs.getString("urlRepositorio");
                
                Podcast podcast = new Podcast(id, produtor, nomeEpisodio, duracao, urlRepositorio);
                podcastsNomeProdutor.add(podcast);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PodcastDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return podcastsNomeProdutor;
    }
    
}
