/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelDominio.Bottons;
import modelDominio.Compras;
import modelDominio.Sugestao;
import modelDominio.Usuario;

/**
 *
 * @author Kauany
 */
public class ConexaoController {

    private ObjectOutputStream out;
    private ObjectInputStream in;
    private int idUnico;
    //atributo que armazena o usuaio logado no sistema
    public Usuario usuario;

    public ConexaoController(ObjectOutputStream out, ObjectInputStream in, int idUnico) {
        this.out = out;
        this.in = in;
        this.idUnico = idUnico;
    }

    //***************** USUARIO ****************
    public Usuario efetuarLogin(Usuario usr) {
        String msg;
        try {
            out.writeObject("UsuarioEfetuarLogin");
            msg = (String) in.readObject();//lendo o ok
            out.writeObject(usr);
            Usuario usrSelecionado = (Usuario) in.readObject();
            return usrSelecionado;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean adicionarUsuario(Usuario usr) {
        String msg;
        try {
            out.writeObject("AdicionarUsuario");
            msg = (String) in.readObject();//lendo o ok
            out.writeObject(usr);
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<Usuario> listaUsuarios(String nome) {
        String msg;
        try {
            out.writeObject("ListaUsuarios");
            msg = (String) in.readObject();
            out.writeObject(nome);
            ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) in.readObject();
            return listaUsuarios;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public boolean excluirUsuario(Usuario usr){
        String msg;
        try {
            out.writeObject("excluirUsuario");
            msg = (String) in.readObject();
            out.writeObject(usr);
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean alterarUsuario(Usuario usr){
        String msg;
        try {          
            out.writeObject("alterarUsuario");
            msg = (String) in.readObject();
            out.writeObject(usr);
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }
    public boolean EnviarSugestao(Sugestao sugestao){
        String msg;
        try {          
            out.writeObject("EnviarSugestao");
            msg = (String) in.readObject();
            out.writeObject(sugestao);
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }
    
    
    public boolean AceitarSugestao(Sugestao sugestao){
        String msg;
        try {          
            out.writeObject("AceitarSugestao");
            msg = (String) in.readObject();
            out.writeObject(sugestao);
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }
    
    public boolean NegarSugestao(Sugestao sugestao){
        String msg;
        try {          
            out.writeObject("NegarSugestao");
            msg = (String) in.readObject();
            out.writeObject(sugestao);
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

    public boolean bottomInserir(Bottons bt) {
        String msg;
        try {
            out.writeObject("BottomInserir");
            msg = (String) in.readObject();//lendo o ok
            out.writeObject(bt);// enviando a bike para o servidor
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean EfetuarCompra(Compras cp) {
        String msg;
        try {
            out.writeObject("EfetuarCompra");
            msg = (String) in.readObject();//lendo o ok
            out.writeObject(cp);// enviando a bike para o servidor
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean bottomAlterar(Bottons bt) {
        String msg;
        try {
            out.writeObject("BottomAlterar");
            msg = (String) in.readObject();
            out.writeObject(bt);
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean bottomExcluir(Bottons bt) {
        String msg;
        try {
            out.writeObject("BottomExcluir");
            msg = (String) in.readObject();
            out.writeObject(bt);
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean removerBottom(Bottons bt) {
        String msg;
        try {
            out.writeObject("RemoverBottom");
            msg = (String) in.readObject();
            out.writeObject(bt);
            msg = (String) in.readObject();
            if (msg.equals("ok")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Bottons> listaBottons() {
        String msg;
        try {
            out.writeObject("BottonsLista");
            msg = (String) in.readObject();
            ArrayList<Bottons> listaBottons = (ArrayList<Bottons>) in.readObject();
            System.out.println(listaBottons);
            return listaBottons;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Sugestao> listaSugestao() {
        String msg;
        try {
            out.writeObject("ListaSugestao");
            msg = (String) in.readObject();
            ArrayList<Sugestao> listaSugestao = (ArrayList<Sugestao>) in.readObject();
            System.out.println(listaSugestao);
            return listaSugestao;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Bottons> bottonsListaNome(String nome) {
        String msg;
        try {
            out.writeObject("BottonsListaNome");
            msg = (String) in.readObject();
            out.writeObject(nome);
            ArrayList<Bottons> listaBottons = (ArrayList<Bottons>) in.readObject();
            return listaBottons;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Bottons> minhasCompras(int codusuario) {
        String msg;
        try {
            out.writeObject("MinhasCompras");
            msg = (String) in.readObject();
            out.writeObject(codusuario);
            ArrayList<Compras> minhasCompras = (ArrayList<Compras>) in.readObject();
            return minhasCompras(codusuario);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public ArrayList<Compras> listaCompras() {
        String msg;
        try {
            out.writeObject("ComprasLista");
            msg = (String) in.readObject();
            ArrayList<Compras> listaCompras = (ArrayList<Compras>) in.readObject();
            return listaCompras;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
