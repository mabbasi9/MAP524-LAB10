package com.example.student.myfirstmap;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                mMap.getUiSettings().setZoomControlsEnabled(true);
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        /*mMap.addMarker(new MarkerOptions().position(new LatLng(45, -79)).title("Ottawa"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(46, 71)).title("Quebec"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(43, 79)).title("Toronto"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(45, 73)).title("Montreal"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(51, 114)).title("Calgary"));*/


        mMap.addMarker(new MarkerOptions().position(new LatLng(45.4214, -75.6919)).title("Ottawa"));

       // Enable MyLocation Layer of Google Map
        mMap.setMyLocationEnabled(true);

        LatLng coordinate = new LatLng(45.4214, -75.6919);
        CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(coordinate, 20);
        mMap.animateCamera(yourLocation);


        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(coordinate)      // Sets the center of the map to Mountain View
                .zoom(18)                   // Sets the zoom
                .bearing(0)                // Sets the orientation of the camera to east
                .tilt(25)                   // Sets the tilt of the camera to 25 degrees
                .build();                   // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
