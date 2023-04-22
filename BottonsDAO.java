/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Kauany
 *
 *
 */
import factory.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelDominio.Bottons;

public class BottonsDAO {

    private Connection conexao;

    public BottonsDAO() {
        this.conexao = Conector.getConnection();
    }

    public int inserir(Bottons bt) {
        PreparedStatement stmt = null;

        try {
            try {
                //colocamos o autocommit para false pq nós vamos controlar as transações
                conexao.setAutoCommit(false);

                String sql = "insert into bottom (nome, valor, descricao, datalancamento, quantidadeestoque, imagem) VALUES (?, ?, ?, ?, ?, ?)";

                stmt = conexao.prepareStatement(sql);
                //trocar os paramentros
                stmt.setString(1, bt.getNome());
                stmt.setFloat(2, bt.getValor());
                stmt.setString(3, bt.getDescricao());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                stmt.setString(4, sdf.format(bt.getDatalancamento()));
                stmt.setInt(5, bt.getQuantEstoque());
                stmt.setBytes(6, bt.getImagem());

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

    public int alterar(Bottons bt) {
        PreparedStatement stmt = null;

        try {
            try {
                //colocamos o autocommit para false pq nós vamos controlar as transações
                conexao.setAutoCommit(false);

                String sql = "update bottom set nome=?, valor = ?, descricao=?,  quantidadeestoque=?,"
                        + " datalancamento=?, imagem=?"
                        + " where codbottom = ?";

                stmt = conexao.prepareStatement(sql);

                //trocar os paramentros               
                stmt.setString(1, bt.getNome());
                stmt.setFloat(2, bt.getValor());
                stmt.setString(3, bt.getDescricao());
                stmt.setInt(4, bt.getQuantEstoque());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                stmt.setString(5, sdf.format(bt.getDatalancamento()));
                stmt.setBytes(6, bt.getImagem());
                stmt.setInt(7, bt.getCodBottom());


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

    public int excluir(Bottons bt) {
        PreparedStatement stmt = null;

        try {
            try {
                //colocamos o autocommit para false pq nós vamos controlar as transações
                conexao.setAutoCommit(false);

                String sql = "delete from bottom where codbottom = (?)";
                stmt = conexao.prepareStatement(sql);
                //trocar os paramentros
                stmt.setInt(1, bt.getCodBottom());

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

    public ArrayList<Bottons> getListaBottons() {

        Statement stmt = null;
        ArrayList<Bottons> listaBottons = new ArrayList<>();
        try {
            stmt = conexao.createStatement();

            ResultSet res = stmt.executeQuery("select * from bottom");

            while (res.next()) {

                Bottons bottonS;
                bottonS = new Bottons(res.getInt("codbottom"),
                        res.getString("nome"), res.getFloat("valor"),
                        res.getString("descricao"), res.getInt("quantidadeestoque"),
                        res.getDate("datalancamento"), res.getBytes("imagem"));

                //add na lista 
                listaBottons.add(bottonS);

            }
            res.close();
            stmt.close();
            conexao.close();
            return listaBottons;

        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }

    }

    public ArrayList<Bottons> getBottonsListaNome(String nome) {

        Statement stmt = null;
        ArrayList<Bottons> listaNomeBottons = new ArrayList<>();
        try {
            stmt = conexao.createStatement();
            
            ResultSet res = stmt.executeQuery("select * from bottom where nome like '%" + nome + "%'");

            //percorrendo o resultado
            while (res.next()) {

                Bottons BottonS = new Bottons(res.getInt("codbottom"),
                        res.getString("nome"), res.getFloat("valor"),
                        res.getString("descricao"), res.getInt("quantidadeestoque"),
                        res.getDate("datalancamento"), res.getBytes("imagem"));

                //add na lista auxiliar
                listaNomeBottons.add(BottonS);

            }
            res.close();
            stmt.close();
            conexao.close();
            return listaNomeBottons;

        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }
    }
    
      public int removerEstoque(Bottons bt) {
        PreparedStatement stmt = null;

        try {
            try {
                //colocamos o autocommit para false pq nós vamos controlar as transações
                conexao.setAutoCommit(false);

                String sql = "update bottom set quantidadeestoque = ? where codbottom = (?)";
                stmt = conexao.prepareStatement(sql);
                //trocar os paramentros
                stmt.setInt(1, bt.getQuantEstoque());
                stmt.setInt(2, bt.getCodBottom());

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
