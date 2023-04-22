package com.example.yourbottons.Adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yourbottons.MinhasComprasActivity;
import com.example.yourbottons.R;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import modelDominio.Bottons;
import modelDominio.Compras;

public class MinhasComprasAdapter extends  RecyclerView.Adapter<MinhasComprasAdapter.MyViewHolder>{
    private ArrayList<Compras> minhasCompras;
    private List<Bottons> listaBottons;

    public MinhasComprasAdapter(ArrayList<Compras> minhasCompras) {
        this.minhasCompras = minhasCompras;
    }

    @Override
    public MinhasComprasAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_row_compras, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MinhasComprasAdapter.MyViewHolder holder, final int position) {
        Compras compras = minhasCompras.get(position);
        holder.tvQuantidade.setText(String.valueOf(compras.getQuantidade()));
        holder.tvNomeBottom.setText(compras.getBottons().getNome());
        holder.tvValor.setText(compras.getPrecoString());
//        if (compras.getBottons().getImagem()!=null){
//            Bitmap bmp = ByteArrayToBitmap(compras.getBottons().getImagem());
//            holder.ivCImagemBottom.setImageBitmap(bmp);
//        }

        /* CUIDADO: .setText() precisa sempre de String. Se for outro tipo de dado, deve ser feita a conversão com o String.valueOf() */
    }

    @Override
    public int getItemCount() {
        return minhasCompras.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNomeBottom, tvValor, tvQuantidade;
        //ImageView ivCImagemBottom;
        // declarar aqui os elementos que estão no itemListRow


        public MyViewHolder(View itemView) {
            super(itemView);
            tvNomeBottom = itemView.findViewById(R.id.tvCNomeBottom);
            tvValor = itemView.findViewById(R.id.tvCValor);
            tvQuantidade = itemView.findViewById(R.id.tvCQuantidade);
            //ivCImagemBottom = itemView.findViewById(R.id.ivCImagemBottom);
        }
    }

        public Bitmap ByteArrayToBitmap(byte[] byteArray) {
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byteArray);
        Bitmap bitmap = BitmapFactory.decodeStream(arrayInputStream);
        return bitmap;
    }
}
