package com.example.yourbottons;

import android.app.Application;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import modelDominio.Bottons;
import modelDominio.Usuario;

public class InformacoesApp extends Application {
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;

    private Usuario usuarioLogado;
    private Bottons bottomSel;

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public Bottons getBottomSel() {
        return bottomSel;
    }

    public void setBottomSel(Bottons bottomSel) {
        this.bottomSel = bottomSel;
    }
}
