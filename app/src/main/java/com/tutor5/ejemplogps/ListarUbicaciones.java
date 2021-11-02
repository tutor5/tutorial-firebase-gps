package com.tutor5.ejemplogps;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ListarUbicaciones extends AppCompatActivity {

    ArrayList<Ubicacion> ubicaciones = new ArrayList<>();

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("ubicaciones");
    private List<Ubicacion> listaDeUbicaciones;
    private RecyclerView recyclerView;
    private Adaptadorubicaciones adaptadorubicaciones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_ubicaciones);
        recyclerView = findViewById(R.id.rvubicaciones);
        myRef.addChildEventListener(childEventListener);

        listaDeUbicaciones = new ArrayList<>();
        adaptadorubicaciones = new Adaptadorubicaciones(listaDeUbicaciones);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adaptadorubicaciones);


    }

    public void refrescarubicaciones() {

        if (adaptadorubicaciones == null) return;
        listaDeUbicaciones = ubicaciones;
        //Log.d("prueba ubicacion", String.valueOf(ubicaciones));
        adaptadorubicaciones.setListaDeUbicaciones(listaDeUbicaciones);
        adaptadorubicaciones.notifyDataSetChanged();
    }

    public void mostrarubicaciones(Ubicacion ubicacion) {
        //Log.d("prueba ubicacion 2", String.valueOf(ubicacion));
        ubicaciones.add(ubicacion);
        refrescarubicaciones();
    }


    ChildEventListener childEventListener = new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {

            // A new comment has been added, add it to the displayed list
            Ubicacion ubicacion = dataSnapshot.getValue(Ubicacion.class);
            // ..
            if (ubicacion != null) mostrarubicaciones(ubicacion);

            // ...
        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {


            Ubicacion ubicacion = dataSnapshot.getValue(Ubicacion.class);
            // ..
            if (ubicacion != null) mostrarubicaciones(ubicacion);


        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

            // A comment has changed, use the key to determine if we are displaying this
            // comment and if so remove it.
            String commentKey = dataSnapshot.getKey();

            // ...
        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {

            // A comment has changed position, use the key to determine if we are
            // displaying this comment and if so move it.
            Ubicacion ubicacion = dataSnapshot.getValue(Ubicacion.class);
            // ..
            if (ubicacion != null) mostrarubicaciones(ubicacion);

            // ...
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
        }


    };



}
