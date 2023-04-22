package com.example.yourbottons;

import android.os.Bundle;

import com.example.yourbottons.Adapters.BottomAdapter;
import com.example.yourbottons.Adapters.MinhasComprasAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import modelDominio.Bottons;
import modelDominio.Compras;
import modelDominio.Usuario;

public class MinhasComprasActivity extends AppCompatActivity {

    RecyclerView rvMinhasComprasRecycler;
    MinhasComprasAdapter comprasAdapter;
    TextView tvNomeBottom, tvQuantidade, tvValor;
    ArrayList<Compras> minhasCompras;
    InformacoesApp informacoesApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minhas_compras);
        rvMinhasComprasRecycler = findViewById(R.id.rvMinhasComprasRecycler);
        tvQuantidade = findViewById(R.id.tvCQuantidade);
        tvNomeBottom = findViewById(R.id.tvCNomeBottom);
        tvValor = findViewById(R.id.tvCValor);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        informacoesApp = (InformacoesApp) getApplicationContext();


        Thread threadListaCompras = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    informacoesApp.out.writeObject("MinhasCompras");
                    informacoesApp.in.readObject();
                    informacoesApp.out.writeObject(informacoesApp.getUsuarioLogado());
                    minhasCompras = (ArrayList<Compras>) informacoesApp.in.readObject();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (informacoesApp.getUsuarioLogado() != null) {
                                if (minhasCompras!=null) {
                                comprasAdapter = new MinhasComprasAdapter(minhasCompras);
                                rvMinhasComprasRecycler.setLayoutManager(new LinearLayoutManager(informacoesApp));
                                rvMinhasComprasRecycler.setItemAnimator(new DefaultItemAnimator());
                                rvMinhasComprasRecycler.setAdapter(comprasAdapter);
                                } else {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(informacoesApp, "Você ainda não possui compras!", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        threadListaCompras.start();
    }
}
