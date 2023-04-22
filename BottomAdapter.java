package com.example.yourbottons.Adapters;

import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yourbottons.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import modelDominio.Bottons;
import modelDominio.Compras;

public class BottomAdapter extends RecyclerView.Adapter<BottomAdapter.MyViewHolder> {

    private List<Bottons> listaBottons;
    private BottomOnClickListener bottomOnClickListener;

    public BottomAdapter(List<Bottons> listaBottons, BottomOnClickListener bottomOnClickListener) {
        this.listaBottons = listaBottons;
        this.bottomOnClickListener = bottomOnClickListener;
    }

    @Override
    public BottomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BottomAdapter.MyViewHolder holder, final int position) {
        Bottons meuBottom = listaBottons.get(position);
        holder.tvNomeBottom.setText(meuBottom.getNome());
        holder.tvValor.setText(meuBottom.getPrecoString());
        if (meuBottom.getImagem()!=null){
            Bitmap bmp = ByteArrayToBitmap(meuBottom.getImagem());
            holder.ivImagemBottom.setImageBitmap(bmp);
        }

        /* CUIDADO: .setText() precisa sempre de String. Se for outro tipo de dado, deve ser feita a conversão com o String.valueOf() */

        // clique no item do cliente
        if (bottomOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bottomOnClickListener.onClickBottons(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaBottons.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNomeBottom, tvValor;
        ImageView ivImagemBottom;
//        ImageButton bComprar;
//        Button bDescricao;

        // declarar aqui os elementos que estão no itemListRow (não esquecer de fazer o findViewbyId

        public MyViewHolder(View itemView) {
            super(itemView);

            tvNomeBottom = (TextView) itemView.findViewById(R.id.tvNomeBottom);
            tvValor = (TextView) itemView.findViewById(R.id.tvValor);
            ivImagemBottom = (ImageView) itemView.findViewById(R.id.ivImagemBottom);

        }
    }


    public Bitmap ByteArrayToBitmap(byte[] byteArray) {
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byteArray);
        Bitmap bitmap = BitmapFactory.decodeStream(arrayInputStream);
        return bitmap;
    }

    public interface BottomOnClickListener {
        public void onClickBottons(View view, int position);
    }
}
