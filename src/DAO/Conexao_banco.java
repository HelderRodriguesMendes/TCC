/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author helde_000
 */
public class Conexao_banco {
     public static Connection conector() { // Connection é um conjunto de funcionalidades do pacote sql
        java.sql.Connection Conexao = null; // variavel Conexao é para armazenar os dados que vem do banco
        String driver = "com.mysql.jdbc.Driver"; //variavel responsavel por chamar o driver 

        //Armazerna informações do banco:
        String url = "jdbc:mysql://localhost:3306/TCC"; // caminho onde esta o banco: jdbc:mysql:// é padrão do sql. localhost:3306/projetoFC: LOCALHOST esta indicando que o banco esta instalado nesta maquina, 3306 é a porta padrao do mysql q encaminha pro banco
        String user = "root";
        String password = "";
        
        try {
            Class.forName(driver); // executa o drive de conexao
            Conexao = DriverManager.getConnection(url, user, password); // armazena passando por parametro, as informações de conexao            
            return Conexao;
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados." + "\n" + e);
            System.out.println(e);
            return null;
        }
    }
}
