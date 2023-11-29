/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TesteModelo;

import Modelos.Podcast;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lenovo
 */
public class TesteModelosJUnitTest {

    public TesteModelosJUnitTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testeModelo() {

        int id = 1;
        String produtor = "andre";
        String nomeEpisodio = "a vida e a morte";
        String duracao = "50min";
        String url = "https://avidaeamorte.jps";

        Podcast podcast = new Podcast(id, produtor, nomeEpisodio, duracao, url);

        // Agora  verificar os valores do objeto Podcast
        assertEquals(id, podcast.getId());
        assertEquals(produtor, podcast.getProdutor());
        assertEquals(nomeEpisodio, podcast.getNomeEpisodio());
        assertEquals(duracao, podcast.getDuracao());
        assertEquals(url, podcast.getUrlRepositorio());
    }

}
