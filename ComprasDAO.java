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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelDominio.Bottons;
import modelDominio.Compras;
import modelDominio.Usuario;

/**
 *
 * @author Kauany
 */
public class ComprasDAO {

    private Connection conexao;

    public ComprasDAO() {
        this.conexao = Conector.getConnection();
    }

    public ArrayList<Compras> getListaCompras() {

        Statement stmt = null;
        ArrayList<Compras> listaCompras = new ArrayList<>();
        try {
            stmt = conexao.createStatement();

            ResultSet res = stmt.executeQuery("select c.codcompra, c.valorcompras, c.quantidade, c.codusuario, "
                    + "c.codbottom, b.nome from compras c left join bottom b on (c.codbottom = b.codbottom)");

            while (res.next()) {

                Bottons bottons = new Bottons(res.getInt("codbottom"), res.getString("nome"));
                Compras compraS = new Compras(res.getInt("codcompra"), res.getFloat("valorcompras"),
                        res.getInt("quantidade"), bottons, res.getInt("codusuario"));

                //add na lista 
                listaCompras.add(compraS);
                System.out.println(listaCompras);

            }
            res.close();
            stmt.close();
            conexao.close();
            return listaCompras;

        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }

    }

    public int EfetuarCompra(Compras cp) {
        PreparedStatement stmt = null;
        System.out.println("EfetuarCompra");
        try {
            try {
                //colocamos o autocommit para false pq nós vamos controlar as transações
                conexao.setAutoCommit(false);

                String sql = "insert into compras (valorcompras, codbottom, codusuario, quantidade) VALUES (?, ?, ?, ?)";

                stmt = conexao.prepareStatement(sql);
                
                //trocar os paramentros
                stmt.setFloat(1, cp.getValorcompra());
                stmt.setInt(2, cp.getBottons().getCodBottom());
                stmt.setInt(3, cp.getCodUsuario());
                stmt.setFloat(4, cp.getQuantidade());

                //executar o scrpit 
                stmt.execute();  //efetivar a transação

                String sql2 = "update bottom set quantidadeestoque = quantidadeestoque-? where codbottom = ?";

                stmt = conexao.prepareStatement(sql2);

                stmt.setInt(1, cp.getQuantidade());
                stmt.setInt(2, cp.getBottons().getCodBottom());
                int quantrestante = cp.getBottons().getQuantEstoque() - cp.getQuantidade();
                
                if (quantrestante >= 0) {
                    stmt.execute(); 
                } else {
                    //cancela a transação se deu erro
                    conexao.rollback();
                }
                //stmt.execute();
                
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


    public ArrayList getMinhasCompras(Usuario usuario) {
        ArrayList<Compras> minhasCompras = new ArrayList<>();

        // essa variável prepara o SQL para ser executado
        PreparedStatement stmt = null;

        try {
            String sql = "select * from compras join usuario on (usuario.codusuario = compras.codusuario)"
                    + " inner join bottom on (bottom.codbottom = compras.codbottom)"
                    + " where compras.codusuario = ?";

            // preparando o script para ser executado
            stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, usuario.getCodUsuario());

            // executar o script SQL
            ResultSet res = stmt.executeQuery();

            // acessando o resultado 
            while (res.next()) {
                Bottons bottons = new Bottons(res.getInt("codbottom"), res.getString("nome"));
                Compras compraS = new Compras(res.getInt("codcompra"), res.getFloat("valorcompras"), res.getInt("quantidade"),
                        bottons, res.getInt("codusuario"));
                minhasCompras.add(compraS);

                System.out.println(minhasCompras);

            }

            // fechando o script e a conexão com o banco
            res.close();
            stmt.close();
            conexao.close();
            // retornando a reuniao selecionado
            return minhasCompras;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
