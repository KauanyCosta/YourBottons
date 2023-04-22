package com.example.yourbottons;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import modelDominio.Usuario;

public class CadastroActivity extends AppCompatActivity {
    EditText etCadastroNome, etCadastroEmail, etCadastroSenha, etCadastroLogin, etCadastroCPF;
    Button bCadastroCadastrar, bCadastroCancelar;
    InformacoesApp informacoesApp;

    Usuario usuario;
    String msgRecebida = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etCadastroNome = findViewById(R.id.etCadastroNome);
        etCadastroEmail = findViewById(R.id.etCadastroEmail);
        etCadastroSenha = findViewById(R.id.etCadastroSenha);
        etCadastroLogin = findViewById(R.id.etCadastroLogin);
        etCadastroCPF = findViewById(R.id.etCadastroCPF);

        bCadastroCadastrar = findViewById(R.id.bCadastroCadastrar);
        bCadastroCancelar = findViewById(R.id.bCadastroCancelar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        informacoesApp = (InformacoesApp) getApplicationContext();

        bCadastroCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verificando campos
                if (!etCadastroNome.getText().toString().equals("")) {
                    if (!etCadastroLogin.getText().toString().equals("")) {
                        if (!etCadastroEmail.getText().toString().equals("")) {
                            if (!etCadastroSenha.getText().toString().equals("")) {
                                if (!etCadastroCPF.getText().toString().equals("")) {

                                    //obtendo as infos da tela
                                    String nome = etCadastroNome.getText().toString();
                                    String login = etCadastroLogin.getText().toString();
                                    String email = etCadastroEmail.getText().toString();
                                    String senha = etCadastroSenha.getText().toString();
                                    String cpf = etCadastroCPF.getText().toString();
                                    int tipo = 0;

                                    // passando informações pro usuário
                                    usuario = new Usuario(nome, login, senha, email, cpf, tipo);

                                    Thread thread2 = new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                informacoesApp.out.writeObject("AdicionarUsuario");
                                                msgRecebida = (String) informacoesApp.in.readObject();
                                                informacoesApp.out.writeObject(usuario);
                                                msgRecebida = (String) informacoesApp.in.readObject();
                                                if (msgRecebida.equals("ok")) {
                                                    if (usuario != null) {
                                                        runOnUiThread(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                Toast.makeText(informacoesApp, "Usuário criado com sucesso.", Toast.LENGTH_SHORT).show();
                                                            }
                                                        });
                                                        limpaCampos();

                                                    } else {
                                                        runOnUiThread(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                Toast.makeText(informacoesApp, "ATENÇÃO!\nNão foi possível cadastrar novo usuário", Toast.LENGTH_SHORT).show();
                                                                limpaCampos();
                                                            }
                                                        });
                                                    }
                                                } else {
                                                    runOnUiThread(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            Toast.makeText(informacoesApp, "Erro ao tentar cadastrar usuário.", Toast.LENGTH_SHORT).show();
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
                                    thread2.start();
                                } else {
                                    etCadastroCPF.setError("Erri\nInforme um CPF.");
                                    etCadastroCPF.requestFocus();
                                }
                            } else {
                                etCadastroSenha.setError("Erro!\nInforme uma senha");
                                etCadastroSenha.requestFocus();
                            }

                        } else {
                            etCadastroEmail.setError("Erro\nInforme um email válido!");
                            etCadastroEmail.requestFocus();
                        }

                    } else {
                        etCadastroLogin.setError("Erro!\nInforme um login.");
                        etCadastroLogin.requestFocus();
                    }

                } else {
                    etCadastroNome.setError("Erro!\nInforme o seu nome.");
                    etCadastroNome.requestFocus();
                }
            }
        });
        bCadastroCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpaCampos();
            }
        });
    }

    public void limpaCampos() {
        etCadastroNome.setText("");
        etCadastroLogin.setText("");
        etCadastroEmail.setText("");
        etCadastroCPF.setText("");
        etCadastroSenha.setText("");
    }
}
