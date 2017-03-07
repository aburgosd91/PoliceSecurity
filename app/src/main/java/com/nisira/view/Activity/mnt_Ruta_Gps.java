package com.nisira.view.Activity;


import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nisira.gcalderon.policesecurity.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mnt_Ruta_Gps#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mnt_Ruta_Gps extends SupportMapFragment implements OnMapReadyCallback {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    MapView mMapView;
    private GoogleMap googleMap;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public mnt_Ruta_Gps() {
    }

    // TODO: Rename and change types and number of parameters
    public static mnt_Ruta_Gps newInstance(String param1, String param2) {
        mnt_Ruta_Gps fragment = new mnt_Ruta_Gps();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_mnt__gps__ubicacion, container, false);
        View root = super.onCreateView(inflater, container, savedInstanceState);
        return root;

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        GoogleMap mMap = googleMap;
        LatLng cali = new LatLng(0,0);
        googleMap.addMarker(new MarkerOptions()
                .position(cali)
                .title("Police Security"));

        CameraPosition cameraPosition = CameraPosition.builder()
                .target(cali)
                .zoom(10)
                .build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {

            }
        });

    }
}
