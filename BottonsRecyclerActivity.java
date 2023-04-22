package com.example.yourbottons;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.example.yourbottons.Adapters.BottomAdapter;

import java.io.IOException;
import java.util.ArrayList;

import modelDominio.Bottons;

public class BottonsRecyclerActivity extends AppCompatActivity {
    RecyclerView rvBottonsRecycler;
    BottomAdapter bottomAdapter;

    ArrayList<Bottons> listaBottons;
    InformacoesApp informacoesApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottons_recycler);
        rvBottonsRecycler = findViewById(R.id.rvBottonsRecycler);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    informacoesApp.out.writeObject("BottonsLista");
                    informacoesApp.in.readObject();
                    listaBottons = (ArrayList<Bottons>) informacoesApp.in.readObject();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            bottomAdapter = new BottomAdapter(listaBottons, trataCliqueItem);
                            rvBottonsRecycler.setLayoutManager(new LinearLayoutManager(informacoesApp));
                            rvBottonsRecycler.setItemAnimator(new DefaultItemAnimator());
                            rvBottonsRecycler.setAdapter(bottomAdapter);
                        }
                    });

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                } catch (ClassNotFoundException classe) {
                    classe.printStackTrace();
                }
            }
        });
        threadC.start();
    }

    BottomAdapter.BottomOnClickListener trataCliqueItem = new BottomAdapter.BottomOnClickListener() {
        @Override
        public void onClickBottons(View view, int position) {
            Bottons meuBottom = listaBottons.get(position);

            Intent it = new Intent(BottonsRecyclerActivity.this, BottomExpandidoActivity.class);
            it.putExtra("bottom", meuBottom);
            startActivity(it);
        }
    };
}
