/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import factory.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelDominio.Sugestao;
import modelDominio.Usuario;

/**
 *
 * @author Kauany
 */
public class SugestaoDAO {

    private Connection conexao;

    public SugestaoDAO() {
        this.conexao = Conector.getConnection();
    }

    public ArrayList<Sugestao> getListaSugestao() {

        Statement stmt = null;
        ArrayList<Sugestao> listaSugestao = new ArrayList<>();
        try {
            stmt = conexao.createStatement();

            ResultSet res = stmt.executeQuery("select s.codsugestao, s.descricaosugestao, "
                    + "s.codusuario, s.sugestaoaceita, u.nomeusuario"
                    + " from sugestao s"
                    + " left join usuario u on (s.codusuario = u.codusuario)");

            while (res.next()) {

                Usuario usuario = new Usuario(res.getInt("codusuario"),
                        res.getString("nomeusuario"));

                Sugestao sugestao = new Sugestao(res.getInt("codsugestao"),
                        res.getString("descricaosugestao"), usuario, res.getInt("sugestaoaceita"));

                //add na lista
                listaSugestao.add(sugestao);
            }
            res.close();
            stmt.close();
            conexao.close();
            return listaSugestao;

        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }

    }

    public int EnviarSugestao(Sugestao sug) {
        PreparedStatement stmt = null;

        try {
            try {
                //colocamos o autocommit para false pq nós vamos controlar as transações
                conexao.setAutoCommit(false);

                String sql = "insert into sugestao (descricaosugestao, codusuario) VALUES (?, ?)";

                stmt = conexao.prepareStatement(sql);
                //trocar os paramentros
                stmt.setString(1, sug.getDescricao());
                stmt.setInt(2, sug.getUsuario().getCodUsuario());

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

    public int SugestaoAceita(Sugestao sug) {
        PreparedStatement stmt = null;

        try {
            try {
                //colocamos o autocommit para false pq nós vamos controlar as transações
                conexao.setAutoCommit(false);

                String sql = "update sugestao set sugestaoaceita = ? where codsugestao = ?";

                stmt = conexao.prepareStatement(sql);
                //trocar os paramentros
                stmt.setInt(1, sug.getSugestao_aceita());
                stmt.setInt(2, sug.getCodsugestao());

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

    public int NegarSugestao(Sugestao sugestao) {
        PreparedStatement stmt = null;

        try {
            try {
                //colocamos o autocommit para false pq nós vamos controlar as transações
                conexao.setAutoCommit(false);

                String sql = "delete from sugestao where codsugestao = (?)";
                stmt = conexao.prepareStatement(sql);
                //trocar os paramentros
                stmt.setInt(1, sugestao.getCodsugestao());

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
