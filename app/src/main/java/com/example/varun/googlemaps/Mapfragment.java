package com.example.varun.googlemaps;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Kirti on 27-07-2017.
 */

public class Mapfragment extends Fragment implements OnMapReadyCallback{
    GoogleMap googlemap;
    MapView mapview;
    View view;
    double latitude,longitude;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.maplayout,container,false);
        MapsInitializer.initialize(this.getActivity());
        mapview = (MapView) view.findViewById(R.id.mapview);
        mapview.onCreate(savedInstanceState);
        mapview.getMapAsync(this);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isResumed())
        {
            onResume();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mapview.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapview.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapview.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
    googlemap=googleMap;
        latitude=19.0760;
        longitude=72.8777;
        LatLng markerlocation=new LatLng(latitude,longitude);
        googlemap.addMarker(new MarkerOptions().position(markerlocation).title("Mumbai"));
        googlemap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 10));
    }
}
