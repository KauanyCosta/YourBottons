/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

/**
 *
 * @author Kauany
 */

import java.sql.*;

public class Conector {    private static Connection conexao;

    public static Connection getConnection() {

        try {
            String url = "jdbc:mysql://localhost:3306/";
            String banco = "yourbottons";
            String usuario = "root";
            String senha = "";

            conexao = DriverManager.getConnection(url + banco, usuario, senha);
            System.out.println("\n Conectado com sucesso no banco!  " +banco);
            return conexao;
        } catch (Exception e) {
            //o printstacktrace imprime toda pilha do erro que aconteceu
            e.printStackTrace();
            return null;
            
        }
        
        
    }

    
}
