/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import model.BottonsDAO;
import model.ComprasDAO;
import model.SugestaoDAO;
import model.UsuarioDAO;
import modelDominio.Bottons;
import modelDominio.Compras;
import modelDominio.Sugestao;
import modelDominio.Usuario;

/**
 *
 * @author Kauany
 */
public class TrataClienteController extends Thread {

    private ObjectInputStream in;
    private ObjectOutputStream out;
    private int idUnico;
    private Socket cliente;

    public TrataClienteController(ObjectInputStream in, ObjectOutputStream out, int idUnico, Socket cliente) {
        this.in = in;
        this.out = out;
        this.idUnico = idUnico;
        this.cliente = cliente;
    }

    @Override
    public void run() {
        String comando;
        System.out.println("Esperando comandos do cliente " + idUnico);

        try {
            comando = (String) in.readObject();
            while (!comando.equalsIgnoreCase("fim")) {
                System.out.println("Cliente" + idUnico + " enviou comando " + comando);
                //aqui dentro iremos receber os comandos do cliente

                if (comando.equalsIgnoreCase("UsuarioEfetuarLogin")) {
                    out.writeObject("ok");
                    //aguardando receber o objeto  Usuario com os dados do login e a senha
                    Usuario usr = (Usuario) in.readObject();
                    UsuarioDAO usrDAO = new UsuarioDAO();
                    Usuario usrSelecionado = usrDAO.efetuarLogin(usr);
                    System.out.println(usrSelecionado);
                    out.writeObject(usrSelecionado);

                } else if (comando.equalsIgnoreCase("AdicionarUsuario")) {
                    out.writeObject("ok");
                    Usuario usr = (Usuario) in.readObject();
                    //criar o usuarioDAO  e chamar o metodo inserir
                    UsuarioDAO usrDAO = new UsuarioDAO();
                    int result = usrDAO.AdicionarUsuario(usr);
                    if (result == -1) {
                        out.writeObject("ok");
                    } else {
                        out.writeObject("nok");
                    }
                } else if (comando.equalsIgnoreCase("alterarUsuario")) {
                    out.writeObject("ok");
                    Usuario usr = (Usuario) in.readObject();
                    //chamar o metodo de alterar do usuariodao
                    UsuarioDAO usrdao = new UsuarioDAO();
                    int result = usrdao.alterarUsuario(usr);
                    if (result == -1) {
                        out.writeObject("ok");
                    } else {
                        out.writeObject("nok");
                    }
                } else if (comando.equalsIgnoreCase("excluirUsuario")) {
                    out.writeObject("ok");
                    Usuario usr = (Usuario) in.readObject();
                    //chamar o metodo de alterar do bottonsdao
                    UsuarioDAO usrdao = new UsuarioDAO();
                    int result = usrdao.excluirUsuario(usr);
                    if (result == -1) {
                        out.writeObject("ok");
                    } else {
                        out.writeObject("nok");
                    }
                } 
                 else if (comando.equalsIgnoreCase("NegarSugestao")) {
                    out.writeObject("ok");
                    Sugestao sugestao = (Sugestao) in.readObject();
                    //chamar o metodo de alterar do bottonsdao
                    SugestaoDAO sgtdao = new SugestaoDAO();
                    int result = sgtdao.NegarSugestao(sugestao);
                    if (result == -1) {
                        out.writeObject("ok");
                    } else {
                        out.writeObject("nok");
                    }
                } 
                 else if (comando.equalsIgnoreCase("ListaUsuarios")) {
                    out.writeObject("ok");
                    //chamar o metodo de alterar do marcadao
                    String nome = (String) in.readObject();
                    UsuarioDAO usrdao = new UsuarioDAO();
                    ArrayList<Usuario> listaUsuarios = usrdao.getListaUsuarios(nome);
                    out.writeObject(listaUsuarios);

                } else if (comando.equalsIgnoreCase("BottomInserir")) {
                    out.writeObject("ok");
                    Bottons bt = (Bottons) in.readObject();
                    //criar o marca DAO  e chamar o metodo inserir
                    BottonsDAO btdao = new BottonsDAO();
                    int result = btdao.inserir(bt);
                    if (result == -1) {
                        out.writeObject("ok");
                    } else {
                        out.writeObject("nok");
                    }

                } else if (comando.equalsIgnoreCase("BottomAlterar")) {
                    out.writeObject("ok");
                    Bottons bt = (Bottons) in.readObject();
                    //chamar o metodo de alterar do bottonsdao
                    BottonsDAO btdao = new BottonsDAO();
                    int result = btdao.alterar(bt);
                    if (result == -1) {
                        out.writeObject("ok");
                    } else {
                        out.writeObject("nok");
                    }

                } else if (comando.equalsIgnoreCase("AceitarSugestao")) {
                    out.writeObject("ok");
                    Sugestao sug = (Sugestao) in.readObject();
                    SugestaoDAO sgdao = new SugestaoDAO();
                    int result = sgdao.SugestaoAceita(sug);
                    if (result == 1) {
                        out.writeObject("ok");
                     } else {
                        out.writeObject("nok");
                    }
                }
                
                else if (comando.equalsIgnoreCase("BottomExcluir")) {
                    out.writeObject("ok");
                    Bottons bt = (Bottons) in.readObject();
                    //chamar o metodo de alterar do bottonsdao
                    BottonsDAO btdao = new BottonsDAO();
                    int result = btdao.excluir(bt);
                    if (result == -1) {
                        out.writeObject("ok");
                    } else {
                        out.writeObject("nok");
                    }

                } else if (comando.equalsIgnoreCase("RemoverBottom")) {
                    out.writeObject("ok");
                    Bottons bt = (Bottons) in.readObject();
                    //chamar o metodo de alterar do bottonsdao
                    BottonsDAO btdao = new BottonsDAO();
                    int result = btdao.removerEstoque(bt);
                    if (result == -1) {
                        out.writeObject("ok");
                    } else {
                        out.writeObject("nok");
                    }

                } 
                else if (comando.equalsIgnoreCase("BottonsLista")) {
                    out.writeObject("ok");
                    //chamar o metodo de alterar do bottonsdao
                    BottonsDAO btdao = new BottonsDAO();
                    ArrayList<Bottons> listaBottons = btdao.getListaBottons();
                    out.writeObject(listaBottons);

                } else if (comando.equalsIgnoreCase("MinhasCompras")) {
                    out.writeObject("ok");
                    Usuario usuario = (Usuario) in.readObject();
                    ComprasDAO cpdao = new ComprasDAO();
                    ArrayList<Compras> minhasCompras = cpdao.getMinhasCompras(usuario);
                    out.writeObject(minhasCompras);
                } 
                else if (comando.equalsIgnoreCase("ListaSugestao")) {
                    out.writeObject("ok");
                    //chamar o metodo de alterar do bottonsdao
                    SugestaoDAO sgtdao = new SugestaoDAO();
                    ArrayList<Sugestao> listaSugestao = sgtdao.getListaSugestao();
                    out.writeObject(listaSugestao);

                } else if (comando.equalsIgnoreCase("EnviarSugestao")) {
                    out.writeObject("ok");
                    Sugestao sugestao = (Sugestao) in.readObject();
                    //criar o sugestao DAO  e chamar o metodo inserir
                    SugestaoDAO sgtdao = new SugestaoDAO();
                    int result = sgtdao.EnviarSugestao(sugestao);
                    if (result == -1) {
                        out.writeObject("ok");
                    } else {
                        out.writeObject("nok");
                    }
                } else if (comando.equalsIgnoreCase("BottonsListaNome")) {
                    out.writeObject("ok");
                    //chamar o metodo de alterar do marcadao
                    String nome = (String) in.readObject();
                    BottonsDAO btdao = new BottonsDAO();
                    ArrayList<Bottons> listaNomeBottons = btdao.getBottonsListaNome(nome);
                    out.writeObject(listaNomeBottons);

                } else if (comando.equalsIgnoreCase("RemoverEstoque")) {
                    out.writeObject("ok");
                    Bottons bt = (Bottons) in.readObject();
                    //criar o marca DAO  e chamar o metodo remover
                    BottonsDAO btdao = new BottonsDAO();
                    int result = btdao.removerEstoque(bt);
                    if (result == -1) {
                        out.writeObject("ok");
                    } else {
                        out.writeObject("nok");
                    }
                } else if (comando.equalsIgnoreCase("ComprasLista")) {
                    out.writeObject("ok");
                    //chamar o metodo de alterar do bottonsdao
                    ComprasDAO cpdao = new ComprasDAO();
                    ArrayList<Compras> listaCompras = cpdao.getListaCompras();
                    out.writeObject(listaCompras);
                } else if (comando.equalsIgnoreCase("EfetuarCompra")) {
                    out.writeObject("ok");
                    Compras cp = (Compras) in.readObject();
                    //criar o compra DAO  e chamar o metodo inserir
                    ComprasDAO cpdao = new ComprasDAO();
                    System.out.println(cp);
                    int result = cpdao.EfetuarCompra(cp);
                    if (result == -1) {
                        out.writeObject("ok");
                    } else {
                        out.writeObject("nok");
                    }
                }
                //lendo proximo comando
                comando = (String) in.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //fechando as conexões
        try {
            System.out.println("Cliente " + idUnico + " fechou o programa");
            in.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
