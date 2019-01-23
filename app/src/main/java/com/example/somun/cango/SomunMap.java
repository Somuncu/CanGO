package com.example.somun.cango;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SomunMap extends FragmentActivity implements OnMapReadyCallback {

    private static final int LOCATION_REQUEST = 500;
    ArrayList<LatLng> listPoints;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_somun_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        listPoints = new ArrayList<>();

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST);
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                //Reset marker when already
               if (listPoints.size() == 2) {
                    listPoints.clear();
                    mMap.clear();
                }
                listPoints.add(latLng);
                //Create Marker
             MarkerOptions markerOptions = new MarkerOptions();
             markerOptions.position(latLng);
                if (listPoints.size() == 1) {
                   //add first marker to the map
                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN ));
              }else {
                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED ));
                }
                mMap.addMarker(markerOptions);

                if (listPoints.size() == 2) {
               String url = getRequestUrl(listPoints.get(0),listPoints.get(1));

                }


            }
        });

        //Add a marker in İzmir and move the camera
        LatLng izmir = new LatLng(38.472123,  27.217561);
        mMap.addMarker(new MarkerOptions().position(izmir).title("Marker in İzmir"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(izmir,13F));
    }

    private String getRequestUrl(LatLng origin, LatLng dest) {
        String str_org = "origin" + origin.latitude + "," + origin.longitude;
        String str_dest = "destination" + dest.latitude + "," + dest.longitude;
        String sensor = "sensor = false";
        String mode = "mode = driving";
        String param =str_org + "&" + str_dest + "&" + sensor + "&" + mode;
        String output = "json";
        String url = "https://maps.googleapis.com/maps/directions/" + output + "?" + param;
        return url;


    }




    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case LOCATION_REQUEST:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mMap.setMyLocationEnabled(true);
                }
                break;
        }
    }


}
