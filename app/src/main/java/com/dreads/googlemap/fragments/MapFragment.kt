package com.dreads.googlemap.fragments


import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController

import com.dreads.googlemap.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.io.IOException

/**
 * A simple [Fragment] subclass.
 */
class MapFragment : Fragment(), OnMapReadyCallback {

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
    }

    lateinit var map: GoogleMap
    lateinit var mapFragment: SupportMapFragment
    lateinit var searchView: SearchView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_map, container, false)

        //searchView = view.findViewById(R.id.sv_location)
        /*mapFragment = this.supportFragmentManager
            .findFragmentById(R.id.google_map) as SupportMapFragment*/

        /*searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                val location = searchView.query.toString()
                var addresseList: List<Address>? = null

                if (location != null || location != "") {
                    val geocoder = Geocoder(context)
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
*/
        return view
    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_map)

        searchView = findViewById(R.id.sv_location)
        mapFragment = this.supportFragmentManager
            .findFragmentById(R.id.google_map) as SupportMapFragment

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                val location = searchView.query.toString()
                var addresseList: List<Address>? = null

                if (location != null || location != "") {
                    val geocoder = Geocoder(this@MapFragment)
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

    }*/
}
