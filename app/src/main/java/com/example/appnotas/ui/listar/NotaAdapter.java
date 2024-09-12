package com.example.appnotas.ui.listar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnotas.R;
import com.example.appnotas.modelos.Nota;

import java.util.ArrayList;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolderNota> {

    private ArrayList<Nota> notas;
    private LayoutInflater li;

    public NotaAdapter(ArrayList<Nota> notas, LayoutInflater li){
        this.notas = notas;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolderNota onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.tarjeta, parent, false);
        return new ViewHolderNota(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderNota holder, int position) {
        Nota nota = notas.get(position);
        holder.tvTitulo.setText(nota.getTitulo());
        holder.tvContenido.setText(nota.getContenido());
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    public class ViewHolderNota extends RecyclerView.ViewHolder {
        TextView tvTitulo, tvContenido;

        public ViewHolderNota(@NonNull View itemView) {
            super(itemView);

            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvContenido = itemView.findViewById(R.id.tvContenido);
        }
    }

}
