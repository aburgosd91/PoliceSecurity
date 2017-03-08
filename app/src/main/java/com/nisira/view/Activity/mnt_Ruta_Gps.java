package com.nisira.view.Activity;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;

import android.support.v4.content.ContextCompat;
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
    private static final int LOCATION_REQUEST_CODE = 1;
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
        getMapAsync(this);
        return root;

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        GoogleMap mMap = googleMap;
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Mostrar diálogo explicativo
            } else {
                // Solicitar permiso
                ActivityCompat.requestPermissions(
                        getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        LOCATION_REQUEST_CODE);
            }
        }
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.getUiSettings().setScrollGesturesEnabled(true);
        mMap.getUiSettings().setIndoorLevelPickerEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);
        LatLng cali = new LatLng(0,0);
        googleMap.addMarker(new MarkerOptions()
                .position(cali)
                .title("Police Security"));

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        // Marcadores
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)));

        Location location = mMap.getMyLocation();
        if(location!=null) {
            LatLng cali = new LatLng(location.getLatitude(), location.getLongitude());
            googleMap.addMarker(new MarkerOptions()
                    .position(cali)
                    .title("Police Security"));

        CameraPosition cameraPosition = CameraPosition.builder()
                .target(cali)
                .zoom(100)
                .build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            CameraPosition cameraPosition = CameraPosition.builder()
                    .target(cali)
                    .zoom(10)
                    .build();
            googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }


        mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                /*
                LatLng cali = new LatLng(location.getLatitude(), location.getLongitude());
                googleMap.addMarker(new MarkerOptions()
                        .position(cali)
                        .title("Police Security"));

                CameraPosition cameraPosition = CameraPosition.builder()
                        .target(cali)
                        .zoom(10)
                        .build();
                googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                */
            }
        });

    }
}
