 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class ConexaoBancoDados {
    	
    public Connection getConnection() throws SQLException {
    String url = "jdbc:mysql://localhost:3306/cenaflixPodcast";
    String user = "root";
    String password = "250580";
    Connection conn = DriverManager.getConnection(url, user, password);
    return conn;
    }
}
