package com.example.yourbottons;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import modelDominio.Bottons;
import modelDominio.Compras;

public class BottomExpandidoActivity extends AppCompatActivity {
    ImageView ivBottomEImagem;
    Button bBottomExpandidoComprar;
    TextView tvBottomETitulo, tvBottomEValor, tvBottomEDescricao;
    EditText etQuantidade;
    Bottons bottom;
    Compras compra;
    InformacoesApp informacoesApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botton_expandido);

        setContentView(R.layout.activity_botton_expandido);
        ivBottomEImagem = findViewById(R.id.ivBottomEImagem);
 //       bBottomEComprar = findViewById(R.id.bBottomEComprar);
        bBottomExpandidoComprar = findViewById(R.id.bBottomExpandidoComprar);
        tvBottomEDescricao = findViewById(R.id.tvBottomEDescricao);
        tvBottomETitulo = findViewById(R.id.tvBottomETitulo);
        tvBottomEValor = findViewById(R.id.tvBottomEValor);
        etQuantidade = findViewById(R.id.etQuantidade);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        informacoesApp = (InformacoesApp) getApplicationContext();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent it = getIntent();
        if (it != null && it.hasExtra("bottom")) {
            //recebendo os dados
            bottom = (Bottons) it.getSerializableExtra("bottom");

            //mandando pra tela as infos
            tvBottomETitulo.setText(bottom.getNome());
            tvBottomEValor.setText(bottom.getPrecoString());
            tvBottomEDescricao.setText(bottom.getDescricao());
            Bitmap bmp = ByteArrayToBitmap(bottom.getImagem());
            ivBottomEImagem.setImageBitmap(bmp);
        }

        bBottomExpandidoComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int quantidaderequisitada = Integer.valueOf(etQuantidade.getText().toString());
                int quantrestante = bottom.getQuantEstoque();

                int quantfinal = quantrestante - quantidaderequisitada;

                    if (quantrestante>0 ) {
                        if (quantfinal>=0){
                            if (!etQuantidade.getText().toString().equals("") ){

                                int quantidade = Integer.valueOf(etQuantidade.getText().toString());
                                float valor = bottom.getValor();
                                int codusuario = informacoesApp.getUsuarioLogado().getCodUsuario();
                                float valorfinal = valor*quantidade;


                                compra = new Compras(valorfinal, quantidade, bottom, codusuario);

                                Thread threadComprar = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        String msg;
                                        try {
                                            informacoesApp.out.writeObject("EfetuarCompra");
                                            msg = (String) informacoesApp.in.readObject();
                                            if (msg.equals("ok")) {
                                                informacoesApp.out.writeObject(compra);
                                                msg = (String) informacoesApp.in.readObject();
                                                if (msg.equals("ok")){
                                                    runOnUiThread(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            Toast.makeText(informacoesApp, "Compra feita com sucesso! Muito obrigada!", Toast.LENGTH_SHORT).show();
                                                            compra.atualizaEstoque();
                                                            limpaCampos();
                                                        }
                                                    });
                                                } else {
                                                    runOnUiThread(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            Toast.makeText(informacoesApp, "ATENÇÃO!\nNão foi possível efetuar a compra!", Toast.LENGTH_SHORT).show();
                                                            limpaCampos();
                                                        }
                                                    });
                                                }
                                            }
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        } catch (ClassNotFoundException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }); threadComprar.start();
                        } else {
                            Toast.makeText(informacoesApp, "Informe um valor válido!", Toast.LENGTH_SHORT).show();

                        }

                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Toast.makeText(informacoesApp, "Infelizmente não possuímos estoque desse bottom por enquanto!" +
                                        "\nA quantidade restante é de: " +bottom.getQuantEstoque(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(informacoesApp, "Informe um valor válido!", Toast.LENGTH_SHORT).show();

                        }
                    });
                }

                }
            });

    }
    public void limpaCampos(){
        etQuantidade.setText("");
    }

    public Bitmap ByteArrayToBitmap(byte[] byteArray) {
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byteArray);
        Bitmap bitmap = BitmapFactory.decodeStream(arrayInputStream);
        return bitmap;
    }
}