/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.TrataClienteController;
import factory.Conector;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;

/**
 *
 * @author Kauany
 */
public class Principal {
     public static void main(String[] args) {
        Connection con;
        con = Conector.getConnection();

        try {
            ServerSocket servidor = new ServerSocket(12346);
            System.out.println("Servidor Inicializado. Aguardando conexões...");
            ConectaServidor cs = new ConectaServidor(servidor);
            //iniciando a thread
            cs.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ConectaServidor extends Thread {

    private ServerSocket servidor;
    private int idUnico;

    public ConectaServidor(ServerSocket servidor) {
        this.servidor = servidor;
        idUnico = 0;
    }

    @Override
    public void run() {

        try {
            while (true) {
                //aceitando conexão do cliente
                Socket cliente = servidor.accept();
                System.out.println("Um novo cliente conectou!");

                //objeto que recebe coisas do cliente = entrada
                ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());

                //objeto que envia coisas = saida
                ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());

                idUnico++; //incrementando o id do cliente

                //thread q escuta os comandos do cliente
                System.out.println("Iniciando uma nova thread para o cliente " +idUnico);
                TrataClienteController tcc = new TrataClienteController(in, out, idUnico, cliente);
                tcc.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
