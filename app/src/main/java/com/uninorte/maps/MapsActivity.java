package com.uninorte.maps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private CameraUpdate mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in barranquilla and move the camera
        LatLng baq = new LatLng(10.9642,-74.797);
        mMap.addMarker(new MarkerOptions().position(baq).title("Barranquilla"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(baq));

    }



    private void setUpMap(){
        mMap.addMarker(new MarkerOptions().position(new LatLng(10.9642, -74.797)).title("Barranquilla"));//.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_comida)).snippet("Plaza comidas BV");
        mCamera = CameraUpdateFactory.newLatLngZoom(new LatLng(10.9642, -74.797), 16);
        mMap.animateCamera(mCamera);

    }

}
