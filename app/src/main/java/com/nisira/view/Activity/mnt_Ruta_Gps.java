package com.nisira.view.Activity;


import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;


import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nisira.gcalderon.policesecurity.R;
import com.thoughtworks.xstream.converters.basic.StringConverter;


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
    boolean flag_location;
    SupportMapFragment fragment1;

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
        fragment1=this;
        getMapAsync(this);

        return root;

    }
    private LocationManager gpsListener;
    private LocationManager mlocManager;
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //codigo a modificado
        GoogleMap mMap = googleMap;
        mlocManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        if (mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){

            //--fin codigo

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

            /*LatLng cali = new LatLng(0, 0);
            googleMap.addMarker(new MarkerOptions()
                    .position(cali)
                    .title("Police Security"));*/

            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap.setMyLocationEnabled(true);
            // Marcadores
            //mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)));

            Location location = mMap.getMyLocation();
            flag_location = true;
            if (location != null) {
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
                mMap.getUiSettings().setMapToolbarEnabled(true);
                mMap.getUiSettings().setScrollGesturesEnabled(true);
                mMap.getUiSettings().setIndoorLevelPickerEnabled(true);
                mMap.getUiSettings().setZoomControlsEnabled(true);
                mMap.getUiSettings().setRotateGesturesEnabled(true);
                LatLng cali = new LatLng(location.getLatitude(), location.getLongitude());
                googleMap.addMarker(new MarkerOptions()
                        .position(cali)
                        .title("Posicion Actual P.S."));

                CameraPosition cameraPosition = CameraPosition.builder()
                        .target(cali)
                        .zoom(10)
                        .build();

                googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                cameraPosition = CameraPosition.builder()
                        .target(cali)
                        .zoom(10)
                        .build();
                googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
            mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
                @Override
                public void onMyLocationChange(Location location){

                    if (flag_location) {
                        LatLng cali = new LatLng(location.getLatitude(), location.getLongitude());
                    /*
                    BitmapDrawable icon = (BitmapDrawable)getResources().getDrawable(R.drawable.icon_police_black);
                    Bitmap b=icon.getBitmap();
                    Bitmap smallMarker = Bitmap.createScaledBitmap(b, 80, 80, false);*/
                        googleMap.addMarker(new MarkerOptions()
                                .position(cali)
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_police_small))
                                .title("Police Security"));

                        CameraPosition cameraPosition = CameraPosition.builder()
                                .target(cali)
                                .zoom(15)
                                .build();
                        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                        flag_location = false;
                    }
                }
            });
        }else{
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder( getActivity());
            alertDialogBuilder  .setMessage("GPS desactivado en el dispositivo, Desea activarlo?")
                    .setCancelable(false)
                    .setPositiveButton("Activar GPS", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id){
                            Intent callGPSSettingIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            getActivity().startActivity(callGPSSettingIntent);
                            SupportMapFragment currentFragment = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.main_content);
                            if(currentFragment instanceof mnt_Ruta_Gps){
                                System.out.println("gps intent");
                                getFragmentManager().popBackStack();
                            }
                        }
                    });
            alertDialogBuilder.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id){
                    dialog.cancel();
                }
            });
            AlertDialog alert = alertDialogBuilder.create();
            alert.show();
        }
    }
}