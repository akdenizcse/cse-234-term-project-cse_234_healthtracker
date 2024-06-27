package com.example.healthtracker.Screens

import android.app.Activity
import android.content.ContentProvider
import android.content.Context
import android.location.Location
import android.os.Looper
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.NavHostController
import com.example.healthtracker.MainActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState


@Composable
fun ExerciseScreen(navHostController: NavHostController){

    val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult?) {
            locationResult ?: return
            for (location in locationResult.locations) {
                // Handle location updates
                val latitude = location.latitude
                val longitude = location.longitude
                // Use latitude and longitude as needed
            }
        }
    }


    Box(modifier = Modifier.fillMaxSize()){
        val antalya = LatLng(36.884804, 30.704044)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(antalya, 15f)
        }

        GoogleMap(
            modifier = Modifier.fillMaxSize(),

        )
    }
}
