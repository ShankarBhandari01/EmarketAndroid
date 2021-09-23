package com.example.emarketapplication.UserInterface

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.emarketapplication.R
import com.example.emarketapplication.databinding.ActivityMapsBinding
import com.example.emarketapplication.modal.LatitudeLogitude
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private var lstLatitudeLogitude=ArrayList<LatitudeLogitude>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        lstLatitudeLogitude.add(LatitudeLogitude(27.706895, 85.340863, "Fam Store"))
        lstLatitudeLogitude.add(LatitudeLogitude(27.6980133, 85.3199651, "Koilash Fam"))

        for(location in lstLatitudeLogitude){
            mMap.addMarker(
                MarkerOptions().position(LatLng(location.latitude,location.logitude))
                    .title(location.markerName)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
            )
        }
        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(LatLng(27.7061355,85.3294626),12F), 3000,null
        )
        mMap.uiSettings.isZoomControlsEnabled=true
        mMap.uiSettings.isScrollGesturesEnabledDuringRotateOrZoom=true
        mMap.uiSettings.isMyLocationButtonEnabled=true
        mMap.uiSettings.isCompassEnabled= true

    }
}