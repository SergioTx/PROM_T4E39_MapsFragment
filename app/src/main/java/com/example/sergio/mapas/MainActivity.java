package com.example.sergio.mapas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        CameraUpdate move = CameraUpdateFactory.newLatLngZoom(new LatLng(42.8367129,-2.6773887),19f);
        map.animateCamera(move);

        //mostrar botones de zoom
        map.getUiSettings().setZoomControlsEnabled(true);

        //añade un marcador
        map.addMarker(new MarkerOptions().position(new LatLng(42.8367129,-2.6773887)).title("Ciudad Jardín"));
        //quita el menú que aparece al seleccionar el marcador para iniciar guiado con la app de Google maps
        map.getUiSettings().setMapToolbarEnabled(false);
    }
}
