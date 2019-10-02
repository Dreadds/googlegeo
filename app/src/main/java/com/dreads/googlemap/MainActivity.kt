package com.dreads.googlemap

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.widget.SearchView
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.io.IOException

class MainActivity : FragmentActivity(), OnMapReadyCallback  {
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
    }

    lateinit var map: GoogleMap
    lateinit var mapFragment: SupportMapFragment
    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchView = findViewById(R.id.sv_location)
        mapFragment = this.supportFragmentManager
            .findFragmentById(R.id.google_map) as SupportMapFragment

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                val location = searchView.query.toString()
                var addresseList: List<Address>? = null

                if (location != null || location != "") {
                    val geocoder = Geocoder(this@MainActivity)
                    try {
                        addresseList = geocoder.getFromLocationName(location, 1)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                    val address = addresseList!![0]
                    val latLng = LatLng(address.latitude, address.longitude)
                    map.addMarker(MarkerOptions().position(latLng).title(location))
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10F))
                }
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                return false
            }
        })

        mapFragment.getMapAsync(this)

    }
}



