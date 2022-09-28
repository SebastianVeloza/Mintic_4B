package com.example.reto4b.adaptadores;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.reto4b.R;
import com.example.reto4b.VerActivity;;
import com.example.reto4b.Entidades.LIBROS;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class listaLibrosAdapter extends RecyclerView.Adapter<listaLibrosAdapter.ContactoViewHolder> {

    ArrayList<LIBROS> listaLibros;
    ArrayList<LIBROS> listaOriginal;

    public listaLibrosAdapter(ArrayList<LIBROS> listaContactos) {
        this.listaLibros = listaContactos;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaContactos);
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_libros, null, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        holder.viewtitulo.setText(listaLibros.get(position).getTitulo());
        holder.viewSubtitulo.setText(listaLibros.get(position).getSubtitulo());
        holder.viewtitulo.setText(listaLibros.get(position).getTitulo());
        holder.viewtitulo.setText(listaLibros.get(position).getTitulo());
        holder.viewtitulo.setText(listaLibros.get(position).getTitulo());
        holder.viewtitulo.setText(listaLibros.get(position).getTitulo());
        holder.viewTelefono.setText(listaLibros.get(position).getTelefono());
        holder.viewCorreo.setText(listaLibros.get(position).getCorreo_electornico());
    }

    public void filtrado(final String txtBuscar) {
        int longitud = txtBuscar.length();
        if (longitud == 0) {
            listaLibros.clear();
            listaLibros.addAll(listaOriginal);
        } else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<LIBROS> collecion = listaLibros.stream()
                        .filter(i -> i.getTitulo().toLowerCase().contains(txtBuscar.toLowerCase()))
                        .collect(Collectors.toList());
                listaLibros.clear();
                listaLibros.addAll(collecion);
            } else {
                for (LIBROS c : listaOriginal) {
                    if (c.getTitulo().toLowerCase().contains(txtBuscar.toLowerCase())) {
                        listaLibros.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listaLibros.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {

        TextView viewtitulo, viewTelefono, viewCorreo;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            viewtitulo = itemView.findViewById(R.id.viewtitulo);
            viewTelefono = itemView.findViewById(R.id.viewTelefono);
            viewCorreo = itemView.findViewById(R.id.viewCorreo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, VerActivity.class);
                    intent.putExtra("ID", listaLibros.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }

}
