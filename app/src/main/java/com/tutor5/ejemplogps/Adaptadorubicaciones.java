package com.tutor5.ejemplogps;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptadorubicaciones extends RecyclerView.Adapter<Adaptadorubicaciones.MyViewHolder>{

    private List<Ubicacion> listaDeUbicaciones;

    public void setListaDeUbicaciones(List<Ubicacion> listaDeUbicaciones) {
        this.listaDeUbicaciones = listaDeUbicaciones;
    }

    public Adaptadorubicaciones(List<Ubicacion> ubicaciones) {
        this.listaDeUbicaciones = ubicaciones;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View filaProducto = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ubicacion, viewGroup, false);
        return new MyViewHolder(filaProducto);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Ubicacion ubicacion = listaDeUbicaciones.get(i);


        String latitud = ubicacion.getLatitud();
        String longitud = ubicacion.getLongitud();


        myViewHolder.latitud.setText(latitud);
        myViewHolder.longitud.setText(longitud);

    }

    @Override
    public int getItemCount() {
        return listaDeUbicaciones.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView latitud,longitud;

        MyViewHolder(View itemView) {
            super(itemView);
            this.latitud = itemView.findViewById(R.id.tvlatitud);
            this.longitud = itemView.findViewById(R.id.tvlongitud);

        }
    }

}
