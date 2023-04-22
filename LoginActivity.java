package com.example.yourbottons;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import modelDominio.Usuario;

public class LoginActivity extends AppCompatActivity {
    EditText etLoginLogin, etLoginSenha;
    Button bLoginEntrar, bLoginCancelar;
    InformacoesApp informacoesApp;

    Usuario usuario;
    String msgRecebida = "" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginLogin = findViewById(R.id.etLoginLogin);
        etLoginSenha = findViewById(R.id.etLoginSenha);

        bLoginEntrar = findViewById(R.id.bLoginEntrar);
        bLoginCancelar = findViewById(R.id.bLoginCancelar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    informacoesApp.socket = new Socket("192.168.2.107", 12346);
                    informacoesApp.out = new ObjectOutputStream(informacoesApp.socket.getOutputStream());
                    informacoesApp.in = new ObjectInputStream(informacoesApp.socket.getInputStream());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(informacoesApp, "Conexão efetuada com sucesso!", Toast.LENGTH_SHORT).show();
                        }
                    });

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        });
        thread.start();

        bLoginEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verificando os campos
                if (!etLoginLogin.getText().toString().equals("")) {
                    if (!etLoginSenha.getText().toString().equals("")) {

                        //obtendo as infos da tela
                        String login = etLoginLogin.getText().toString();
                        String senha = etLoginSenha.getText().toString();

                        usuario = new Usuario(login, senha);

                        Thread thread1 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    informacoesApp.out.writeObject("UsuarioEfetuarLogin");
                                    msgRecebida = (String) informacoesApp.in.readObject();
                                    if (msgRecebida.equals("ok")) {
                                        informacoesApp.out.writeObject(usuario);
                                        usuario = (Usuario) informacoesApp.in.readObject();
                                        if (usuario != null) {

                                            //System.out.println("usuario logado");
                                            informacoesApp.setUsuarioLogado(usuario);

                                            Intent it = new Intent(LoginActivity.this, TelaInicialActivity.class);
                                            it.putExtra("usuario", usuario);
                                            startActivity(it);

                                        } else {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Toast.makeText(informacoesApp, "ATENÇÃO!\nUsuário ou senha não conferem.", Toast.LENGTH_SHORT).show();
                                                    limpaCampos();
                                                }
                                            });
                                        }
                                    } else {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(informacoesApp, "ERRO ao tentar se autenticar.", Toast.LENGTH_SHORT).show();
                                            }
                                        });
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
                        thread1.start();

                    } else {
                        etLoginSenha.setError("Erro!\nInforme a senha.");
                        etLoginSenha.requestFocus();
                    }
                } else {
                    etLoginLogin.setError("Erro!\nInforme o login.");
                    etLoginLogin.requestFocus();
                }
            }
        });

        bLoginCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpaCampos();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void limpaCampos() {
        etLoginLogin.setText("");
        etLoginSenha.setText("");
    }
}

