package com.example.yourbottons;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import modelDominio.Sugestao;
import modelDominio.Usuario;

public class SugestaoActivity extends AppCompatActivity {
    EditText etSugestaoTexto;
    Button bSugestaoEnviar;
    Usuario usuario;
    InformacoesApp informacoesApp;
    Sugestao sugestao;
    String msgRecebida = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugestao);
        etSugestaoTexto = findViewById(R.id.etSugestaoTexto);
        bSugestaoEnviar = findViewById(R.id.bSugestaoEnviar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        informacoesApp = (InformacoesApp) getApplicationContext();

        bSugestaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!etSugestaoTexto.getText().toString().equals("")) {
                    int codusuario = informacoesApp.getUsuarioLogado().getCodUsuario();
                    String descricao = etSugestaoTexto.getText().toString();
                    usuario = new Usuario(codusuario);
                    sugestao = new Sugestao(descricao, usuario);

                    //obtendo as infos da tel
                    Thread threadF = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                informacoesApp.out.writeObject("EnviarSugestao");
                                msgRecebida = (String) informacoesApp.in.readObject();
                                informacoesApp.out.writeObject(sugestao);
                                msgRecebida = (String) informacoesApp.in.readObject();
                                if (msgRecebida.equals("ok")) {
                                    if (sugestao!=null){
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(informacoesApp, "Sugestão enviada com sucesso!\nMuito obrigada!", Toast.LENGTH_LONG).show();
                                                limpaCampos();
                                            }
                                        });
                                    } else {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(informacoesApp, "ATENÇÃO!\nNão foi possível enviar uma sugestão!", Toast.LENGTH_SHORT).show();
                                                limpaCampos();
                                            }
                                        });
                                    }
                                }
                            } catch (
                                    IOException e) {
                                e.printStackTrace();
                            } catch (
                                    ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    threadF.start();

                } else {
                    etSugestaoTexto.setError("Erro!\nEscreva uma sugestão primeiro.");
                    etSugestaoTexto.requestFocus();
                }
            }
        });
    }

    public void limpaCampos() {
        etSugestaoTexto.setText("");
    }
}
