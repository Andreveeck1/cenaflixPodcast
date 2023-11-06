/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import DAO.PodcastDAO;
import Modelos.Podcast;
import Modelos.Usuario;
import Visoes.TelaCadastrar;
import Visoes.TelaListagem;
import com.sun.jdi.connect.spi.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class ControladorTelaCadastrar {

    private final TelaCadastrar visao;
    private Usuario usuario;

    public ControladorTelaCadastrar(TelaCadastrar visao) {
        this.visao = visao;
    }

    public Podcast construirPodcast() {
        Podcast podcast = null;

        String produtor = visao.getjTextFieldProdutor().getText();
        String nomeEpisodio = visao.getjTextFieldNomeEpisodio().getText();
        String duracao = visao.getjFormattedTextFieldDuracao().getText();
        String urlRepositorio = visao.getjTextFieldUrlRepositorio().getText();

        podcast = new Podcast(produtor, nomeEpisodio, duracao, urlRepositorio);

        return podcast;

    }

    public void inserirPodcastNoBanco() {
        Podcast podcast = this.construirPodcast();
        Connection conexao = null;
        PodcastDAO podcastDAO = new PodcastDAO(conexao);
        if (!podcast.getProdutor().isEmpty() && !podcast.getNomeEpisodio().isEmpty() && !podcast.getDuracao().isEmpty() && !podcast.getUrlRepositorio().isEmpty() && !podcastDAO.podcastExiste(podcast)) {

            podcastDAO.inserirPodcastNoBanco(podcast);

        } else {
            JOptionPane.showMessageDialog(null, "Há campos em branco ou o episodio já existe!");
        }

    }

    public void irTelaListagem() {
        TelaListagem telaLiategem = new TelaListagem(usuario);
        telaLiategem.setVisible(true);
        visao.dispose();

    }
}
