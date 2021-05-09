package com.example.gismobile;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

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

        // Add a marker in Sydney and move the camera
        LatLng rumah = new LatLng(-0.933176, 119.866752);
        LatLng kmeranti = new LatLng(-0.9334928823991187, 119.86606769300451);
        LatLng pole2 = new LatLng(-0.933858760860325, 119.86763457641895);
        LatLng slevis = new LatLng(-0.9338155577589403, 119.86657757558999);
        LatLng fmkoleksi = new LatLng(-0.9334868298365103, 119.86664659494868);

        int tinggi = 100;
        int lebar = 100;

        BitmapDrawable bitmapRumah=(BitmapDrawable) getResources().getDrawable(R.drawable.home);
        BitmapDrawable bitmapKmeranti=(BitmapDrawable) getResources().getDrawable(R.drawable.kios);
        BitmapDrawable bitmapPole2=(BitmapDrawable) getResources().getDrawable(R.drawable.kios);
        BitmapDrawable bitmapSlevis=(BitmapDrawable) getResources().getDrawable(R.drawable.kios);
        BitmapDrawable bitmapFMKoleksi=(BitmapDrawable) getResources().getDrawable(R.drawable.kios);

        Bitmap r=bitmapRumah.getBitmap();
        Bitmap km=bitmapKmeranti.getBitmap();
        Bitmap po=bitmapPole2.getBitmap();
        Bitmap sl=bitmapSlevis.getBitmap();
        Bitmap fmk=bitmapFMKoleksi.getBitmap();

        Bitmap markerRumah=Bitmap.createScaledBitmap(r, lebar, tinggi, false);
        Bitmap markerPole2=Bitmap.createScaledBitmap(po, lebar, tinggi, false);
        Bitmap markerKmeranti=Bitmap.createScaledBitmap(km, lebar, tinggi, false);
        Bitmap markerSlevis=Bitmap.createScaledBitmap(sl, lebar, tinggi, false);
        Bitmap markerFMKoleksi=Bitmap.createScaledBitmap(fmk, lebar, tinggi, false);

        mMap.addMarker(new MarkerOptions().position(rumah).title("Rumah")
                .snippet("Ini Adalah Rumah Saya")
                .icon(BitmapDescriptorFactory.fromBitmap(markerRumah)));
        mMap.addMarker(new MarkerOptions().position(pole2).title("Pusat Oleh-Oleh Kripik Fiqra")
                .snippet("Ini Adalah Pusat Oleh-Oleh Kripik Fiqra")
                .icon(BitmapDescriptorFactory.fromBitmap(markerPole2)));
        mMap.addMarker(new MarkerOptions().position(kmeranti).title("Kios Meranti")
                .snippet("Ini Adalah Kios Meranti")
                .icon(BitmapDescriptorFactory.fromBitmap(markerKmeranti)));
        mMap.addMarker(new MarkerOptions().position(slevis).title("Surahman Levi's")
                .snippet("Ini Adalah Surahman Levi's")
                .icon(BitmapDescriptorFactory.fromBitmap(markerSlevis)));
        mMap.addMarker(new MarkerOptions().position(fmkoleksi).title("FM Koleksi")
                .snippet("Ini Adalah FM Koleksi")
                .icon(BitmapDescriptorFactory.fromBitmap(markerFMKoleksi)));

        mMap.addPolyline(new PolylineOptions().add(
                rumah,
                new LatLng(-0.933176, 119.866752),
                new LatLng(-0.933205, 119.866796),
                new LatLng(-0.933294, 119.866729),
                new LatLng(-0.933096, 119.866457),
                new LatLng(-0.933358, 119.866250),
                new LatLng(-0.933551, 119.866128),
                new LatLng(-0.933507, 119.866062),
                kmeranti
                )   .width (15)
                    .color(Color.MAGENTA)
                );

        mMap.addPolyline(new PolylineOptions().add(
                rumah,
                new LatLng(-0.933176, 119.866752),
                new LatLng(-0.933205, 119.866796),
                new LatLng(-0.933294, 119.866729),
                new LatLng(-0.933567, 119.866511),
                new LatLng(-0.933756, 119.866757),
                new LatLng(-0.933872, 119.866664),
                slevis
                )   .width (15)
                        .color(Color.GRAY)
        );
        mMap.addPolyline(new PolylineOptions().add(
                rumah,
                new LatLng(-0.933176, 119.866752),
                new LatLng(-0.933205, 119.866796),
                new LatLng(-0.933294, 119.866729),
                new LatLng( -0.933448, 119.866605),
                fmkoleksi
                )   .width (15)
                        .color(Color.BLACK)
        );
        mMap.addPolyline(new PolylineOptions().add(
                rumah,
                new LatLng(-0.933176, 119.866752),
                new LatLng(-0.933205, 119.866796),
                new LatLng(-0.933294, 119.866729),
                new LatLng(-0.933567, 119.866511),
                new LatLng(-0.933756, 119.866757),
                new LatLng(-0.933516, 119.866938),
                new LatLng(-0.933950, 119.867472),
                pole2
                )   .width (15)
                        .color(Color.BLUE)
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rumah,14.5f));
    }  }

