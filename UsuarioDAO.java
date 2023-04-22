/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import factory.Conector;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import modelDominio.Administrador;
import modelDominio.Cliente;
import modelDominio.Comum;
import modelDominio.Usuario;

/**
 *
 * @author Kauany
 */
public class UsuarioDAO {

    private Connection conexao;

    public UsuarioDAO() {
        conexao = Conector.getConnection();
    }

    public Usuario efetuarLogin(Usuario usr) {
        PreparedStatement stmt = null;
        Usuario usrSelecionado = null;

        try {
            //passando a string de SQL que faz o SELECT
            String sql = "select * from usuario where login = ? and senha = ?";
            stmt = conexao.prepareStatement(sql);

            String senhaHash = null;
            try {
                MessageDigest md = MessageDigest.getInstance("MD5"); // MD5, SHA-1, SHA-256
                senhaHash = new String(md.digest(usr.getSenha().getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);

            } catch (Exception e) {
                e.printStackTrace();
            }

            //substituir os ? do script do SQL
            stmt.setString(1, usr.getLogin());
            stmt.setString(2, senhaHash);
            //executando o SELECT
            ResultSet res = stmt.executeQuery();
            //percorrendo o resultado do banco de dados
            if (res.next()){
                // se o usuário existe 
                if(res.getInt("tipo")== 1){//adm
                    usrSelecionado = new Administrador(res.getInt("codusuario"),
                            res.getString("nomeusuario"), res.getString("login"),
                            res.getString("senha"), res.getString("email"), res.getString("cpf"), res.getInt("tipo"));

                } else if(res.getInt("tipo")== 2){
                    usrSelecionado = new Comum(res.getInt("codusuario"),
                            res.getString("nomeusuario"), res.getString("login"),
                            res.getString("senha"), res.getString("email"), res.getString("cpf"), res.getInt("tipo"));
                    
                } else if(res.getInt("tipo")== 0){
                    usrSelecionado = new Cliente(res.getInt("codusuario"),
                            res.getString("nomeusuario"), res.getString("login"),
                            res.getString("senha"), res.getString("email"), res.getString("cpf"), res.getInt("tipo"));
                }

            }

            res.close();
            stmt.close();
            conexao.close();
            return usrSelecionado;

        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }
    }

    public ArrayList<Usuario> getListaUsuarios(String nome) {
        Statement stmt = null;
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        try {
            stmt = conexao.createStatement();

            String sql = "select * from usuario";
            if (!nome.equals("")) {
                sql = sql + " where nome like '%" + nome + "%'";
            }

            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {

                Usuario usuario = new Usuario(res.getInt("codusuario"), res.getString("nomeusuario"),
                        res.getString("login"), res.getString("senha"), res.getString("email"), res.getString("cpf"), res.getInt("tipo"));

                //add na lista 
                listaUsuario.add(usuario);
                System.out.println(listaUsuario);

            }
            res.close();
            stmt.close();
            conexao.close();
            return listaUsuario;

        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }
    }

    public int AdicionarUsuario(Usuario usr) {
        PreparedStatement stmt = null;

        try {
            try {

                conexao.setAutoCommit(false);

                //passando a string de SQL que faz o insert
                String sql = "insert into usuario (nomeusuario, login, senha, email, cpf, tipo) VALUES (?, ?, ?, ?, ?, ?)";
                stmt = conexao.prepareStatement(sql);

                String senhaHash = null;
                try {
                    MessageDigest md = MessageDigest.getInstance("MD5"); // MD5, SHA-1, SHA-256
                    senhaHash = new String(md.digest(usr.getSenha().getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                //substituir os ? do script do SQL
                stmt.setString(1, usr.getNomeusuario());
                stmt.setString(2, usr.getLogin());
                stmt.setString(3, senhaHash);
                stmt.setString(4, usr.getEmail());
                stmt.setString(5, usr.getCpf());
                stmt.setInt(6, usr.getTipo());

                stmt.execute();  //efetivar a transação
                conexao.commit(); //<- IMPORTANTE!!!!!!!!!!!!!!!!!!!!1                
                return -1;

            } catch (SQLException e) {
                try {
                    e.printStackTrace();
                    //cancela a transação se deu erro
                    conexao.rollback();
                    return e.getErrorCode();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    return ex.getErrorCode();
                }
            }

        } finally {
            //entra aqui independente se deu erro ou não
            try {
                stmt.close();
                conexao.setAutoCommit(true);
                conexao.close();

            } catch (SQLException e) {
                e.printStackTrace();
                return e.getErrorCode();
            }

        }

    }

    public int alterarUsuario(Usuario usr) {
        PreparedStatement stmt = null;

        try {
            try {

                conexao.setAutoCommit(false);
                //passando a string de SQL que faz o insert
                String sql= null;
                if (usr.getSenha().equals("")) {
                    sql = "update usuario set nomeusuario=?, login = ?, email=?, cpf=?, tipo = ?"
                        + " where codusuario = ?";
                } else {
                  sql = "update usuario set nomeusuario=?, login = ?, senha = ?, email=?, cpf=?, tipo = ?"
                        + " where codusuario = ?";
                }
        

                stmt = conexao.prepareStatement(sql);
                
                String senhaHash = null;
                try {
                    MessageDigest md = MessageDigest.getInstance("MD5"); // MD5, SHA-1, SHA-256
                    senhaHash = new String(md.digest(usr.getSenha().getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                if (usr.getSenha().equals("")) {   
                stmt.setString(1, usr.getNomeusuario());
                stmt.setString(2, usr.getLogin());
                stmt.setString(3, usr.getEmail());
                stmt.setString(4, usr.getCpf());
                stmt.setInt(5, usr.getTipo());
                stmt.setInt(6, usr.getCodUsuario());
                    
                } else{
                    
                stmt.setString(1, usr.getNomeusuario());
                stmt.setString(2, usr.getLogin());
                stmt.setString(3, senhaHash);
                stmt.setString(4, usr.getEmail());
                stmt.setString(5, usr.getCpf());
                stmt.setInt(6, usr.getTipo());
                stmt.setInt(7, usr.getCodUsuario());
                }           

                stmt.execute();  //efetivar a transação
                conexao.commit(); //<- IMPORTANTE!!!!!!!!!!!!!!!!!!!!1                
                return -1;

            } catch (SQLException e) {
                try {
                    e.printStackTrace();
                    //cancela a transação se deu erro
                    conexao.rollback();
                    return e.getErrorCode();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    return ex.getErrorCode();
                }
            }

        } finally {
            //entra aqui independente se deu erro ou não
            try {
                stmt.close();
                conexao.setAutoCommit(true);
                conexao.close();

            } catch (SQLException e) {
                e.printStackTrace();
                return e.getErrorCode();
            }

        }

    }

    public int excluirUsuario(Usuario usr) {
        PreparedStatement stmt = null;

        try {
            try {
                //colocamos o autocommit para false pq nós vamos controlar as transações
                conexao.setAutoCommit(false);

                String sql = "delete from usuario where codusuario = (?)";
                stmt = conexao.prepareStatement(sql);
                //trocar os paramentros
                stmt.setInt(1, usr.getCodUsuario());

                //executar o scrpit 
                stmt.execute();  //efetivar a transação
                conexao.commit(); //<- IMPORTANTE!!!!!!!!!!!!!!!!!!!!1
                return -1; //deu tudo certo

            } catch (SQLException e) {
                try {
                    e.printStackTrace();
                    //cancela a transação se deu erro
                    conexao.rollback();
                    return e.getErrorCode();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    return ex.getErrorCode();
                }
            }

        } finally {
            //entra aqui independente se deu erro ou não
            try {
                stmt.close();
                conexao.setAutoCommit(true);
                conexao.close();

            } catch (SQLException e) {
                e.printStackTrace();
                return e.getErrorCode();
            }
        }

    }

}
