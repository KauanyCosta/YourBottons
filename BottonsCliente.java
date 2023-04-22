/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ConexaoController;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Kauany
 */
public class BottonsCliente {
     public static ConexaoController ccont;

    public static void main(String[] args) {

        Socket socket;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        int idUnico = 0;

        try {
            socket = new Socket("127.0.0.1", 12346);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }

        //criando o controller geral e a tela principal 
        ccont = new ConexaoController(out, in, idUnico);
        FormLogin frmLog = new FormLogin();
        frmLog.setVisible(true);
    }
}
