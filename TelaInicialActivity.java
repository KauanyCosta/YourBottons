package com.example.yourbottons;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import modelDominio.Usuario;

public class TelaInicialActivity extends AppCompatActivity {
    Button bTelaInicialBottons, bTelaInicialPerfil, bPerfilCompras, bPerfilSugestao;
    TextView tvTelaInicialSaudacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        bPerfilSugestao = findViewById(R.id.bPerfilSugestao);
        bPerfilCompras = findViewById(R.id.bPerfilCompras);
        bTelaInicialBottons = findViewById(R.id.bTelaInicialBottons);
        bTelaInicialPerfil = findViewById(R.id.bTelaInicialPerfil);
        tvTelaInicialSaudacao = findViewById(R.id.tvTelaInicialSaudacao);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

      Intent it = getIntent();
        if (it != null && it.hasExtra("usuario")) {
            //recebendo os dados
            Usuario usuario = (Usuario) it.getSerializableExtra("usuario");

            //mandando pra tela as infos
            tvTelaInicialSaudacao.setText("Olá, " + usuario.getNomeusuario()+"!\n\nSeja muito bem vindo(a)!");
        }
        bTelaInicialBottons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(TelaInicialActivity.this, BottonsRecyclerActivity.class);
                startActivity(it);
            }
        });

        bTelaInicialPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(TelaInicialActivity.this, PerfilActivity.class);
                startActivity(it);
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bPerfilSugestao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(TelaInicialActivity.this, SugestaoActivity.class);
                startActivity(it);

            }
        });

        bPerfilCompras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(TelaInicialActivity.this, MinhasComprasActivity.class);
                startActivity(it);
            }
        });


    }


}
