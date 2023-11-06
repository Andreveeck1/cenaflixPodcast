/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Lenovo
 */
public class Podcast {
    private int id;
    private String produtor;
    private String nomeEpisodio;
    private String duracao;
    private String urlRepositorio;

    public Podcast(String produtor, String nomeEpisodio, String duracao, String urlRepositorio) {
        this.produtor = produtor;
        this.nomeEpisodio = nomeEpisodio;
        this.duracao = duracao;
        this.urlRepositorio = urlRepositorio;
    }

    public Podcast(int id, String produtor, String nomeEpisodio, String duracao, String urlRepositorio) {
        this.id = id;
        this.produtor = produtor;
        this.nomeEpisodio = nomeEpisodio;
        this.duracao = duracao;
        this.urlRepositorio = urlRepositorio;
    }

    public Podcast(String produtor) {
        this.produtor = produtor;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdutor() {
        return produtor;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

    public String getNomeEpisodio() {
        return nomeEpisodio;
    }

    public void setNomeEpisodio(String nomeEpisodio) {
        this.nomeEpisodio = nomeEpisodio;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getUrlRepositorio() {
        return urlRepositorio;
    }

    public void setUrlRepositorio(String urlRepositorio) {
        this.urlRepositorio = urlRepositorio;
    }
    
    
    
}
