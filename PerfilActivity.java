package com.example.yourbottons;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import modelDominio.Usuario;

public class PerfilActivity extends AppCompatActivity {

    InformacoesApp informacoesApp;
    Usuario usuario;
    String msgRecebida;

    EditText etPerfilNome, etPerfilEmail, etPerfilSenha, etPerfilLogin;
    TextView etPerfilCPF;
    Button bPerfilSalvar, bPerfilCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etPerfilNome = findViewById(R.id.etPerfilNome);
        etPerfilCPF = findViewById(R.id.tvPerfilCPF);
        etPerfilSenha = findViewById(R.id.etPerfilSenha);
        etPerfilEmail = findViewById(R.id.etPerfilEmail);
        etPerfilLogin = findViewById(R.id.etPerfilLogin);

        bPerfilSalvar = findViewById(R.id.bPerfilSalvar);
        bPerfilCancelar = findViewById(R.id.bPerfilCancelar);

        informacoesApp = (InformacoesApp) getApplicationContext();

        etPerfilNome.setText(informacoesApp.getUsuarioLogado().getNomeusuario());
        etPerfilLogin.setText(informacoesApp.getUsuarioLogado().getLogin());
        etPerfilEmail.setText(informacoesApp.getUsuarioLogado().getEmail());
        etPerfilSenha.setText("");
        etPerfilCPF.setText(informacoesApp.getUsuarioLogado().getCpf());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bPerfilSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etPerfilNome.getText().toString().equals("")) {
                    if (!etPerfilLogin.getText().toString().equals("")){
                      if (!etPerfilEmail.getText().toString().equals("")) {
                                //obtendo as infos da tela
                                    int cod = informacoesApp.getUsuarioLogado().getCodUsuario();
                                    String nome = etPerfilNome.getText().toString();
                                    String login = etPerfilLogin.getText().toString();
                                    String email = etPerfilEmail.getText().toString();
                                    String senha = etPerfilSenha.getText().toString();
                                    String cpf = informacoesApp.getUsuarioLogado().getCpf();
                                    int tipo = 0;

                            // passando informações pro usuário

                                    usuario = new Usuario(cod, nome, login, senha, email, cpf, tipo);

                                    Thread threadZ = new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                informacoesApp.out.writeObject("alterarUsuario");
                                                msgRecebida = (String) informacoesApp.in.readObject();
                                                if (msgRecebida.equals("ok")) {
                                                    informacoesApp.out.writeObject(usuario);
                                                    msgRecebida = (String) informacoesApp.in.readObject();
                                                    if (msgRecebida.equals("ok")) {
                                                        if (usuario != null) {
                                                            runOnUiThread(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    Toast.makeText(informacoesApp, "Usuário alterado com sucesso!", Toast.LENGTH_SHORT).show();
                                                                }
                                                            });
                                                        } else {
                                                            runOnUiThread(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    Toast.makeText(informacoesApp, "ATENÇÃO!\nNão foi possível alterar o usuário", Toast.LENGTH_SHORT).show();
                                                                    limpaCampos();
                                                                }
                                                            });
                                                        }
                                                    } else {
                                                        runOnUiThread(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                Toast.makeText(informacoesApp, "Erro ao tentar alterar usuário.", Toast.LENGTH_SHORT).show();
                                                            }
                                                        });
                                                    }
                                                }
                                            }catch (
                                                    IOException e) {
                                                e.printStackTrace();
                                            } catch (
                                                    ClassNotFoundException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    });
                                    threadZ.start();
                      } else {
                                etPerfilEmail.setError("Erro!\nInforme um email!");
                                etPerfilEmail.requestFocus();
                            }

                        } else {
                            etPerfilLogin.setError("Erro!\nInforme um login!");
                            etPerfilLogin.requestFocus();
                        }

                    } else {
                        etPerfilNome.setError("Erro!\nInforme um nome!");
                        etPerfilNome.requestFocus();
                    }

                }

        });


        bPerfilCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpaCampos();
            }
        });


    }
    public void limpaCampos() {
        etPerfilNome.setText("");
        etPerfilEmail.setText("");
        etPerfilCPF.setText("");
        etPerfilSenha.setText("");
    }

}
