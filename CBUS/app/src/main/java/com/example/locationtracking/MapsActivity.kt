package com.example.locationtracking

import android.annotation.SuppressLint
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    val permissions = arrayOf(
        android.Manifest.permission.ACCESS_FINE_LOCATION,
        android.Manifest.permission.ACCESS_COARSE_LOCATION
    )
    val PERM_FLAG = 99

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        if (isPermitted()) {
            startProcess()
        } else {
            ActivityCompat.requestPermissions(this, permissions, PERM_FLAG)
        }
    }




fun isPermitted(): Boolean {
    for (perm in permissions) {
        if (ContextCompat.checkSelfPermission(this, perm) != PERMISSION_GRANTED) {
            return false
        }
    }
    return true
}

fun startProcess() {
    val mapFragment = supportFragmentManager
        .findFragmentById(R.id.map) as SupportMapFragment

    mapFragment.getMapAsync(this)
    //onMapReady 리턴
}

/**
 * Manipulates the map once available.
 * This callback is triggered when the map is ready to be used.
 * This is where we can add markers or lines, add listeners or move the camera. In this case,
 * we just add a marker near Sydney, Australia.
 * If Google Play services is not installed on the device, the user will be prompted to install
 * it inside the SupportMapFragment. This method will only be triggered once the user has
 * installed Google Play services and returned to the app.
 */
override fun onMapReady(googleMap: GoogleMap) {
    mMap = googleMap
    fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
    // 마지막으로 확인된 위치정보 리턴
    setUpdateLocationListener()
}

// 내 위치를 가져오는 코드

lateinit var fusedLocationClient: FusedLocationProviderClient
lateinit var locationCallback: LocationCallback


@SuppressLint("MissingPermission")
fun setUpdateLocationListener() {
    var locationRequest = LocationRequest.create()
    locationRequest.run {
        priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        interval = 1000 //1초에 한번씩
    }

    locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult?) {
            locationResult?.let {
                for ((i, location) in it.locations.withIndex()) {
                    Log.d("로케이션", "$i ${location.latitude}, ${location.longitude}")
                    setLastLocation(location)

                }
            }
        }
    }

    fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper())
    // 로케이션 요청 함수 호출
}

private fun setLastLocation(location: Location) {
    val descriptor = getDescriptorFromDrawable(R.drawable.busmarker2)
    val myLocation = LatLng(location.latitude, location.longitude)

    val marker = MarkerOptions()
        .position(myLocation)
        .title("여기 있습니다.")
        .icon(descriptor)

    val cameraOption = CameraPosition.Builder()
        .target(myLocation)
        .zoom(17.0f)
        .build()
    val camera = CameraUpdateFactory.newCameraPosition(cameraOption)

    val m: Marker = mMap.addMarker(marker)

    m.setPosition(myLocation)

    mMap.moveCamera(camera)
}


@SuppressLint("MissingSuperCall")
override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
) {
    when (requestCode) {
        PERM_FLAG -> {
            var check = false
            for (grant in grantResults) {
                if (grant != PERMISSION_GRANTED) {
                    check = false
                    break
                }
            }

            if (check) {
                startProcess()
            } else {
                Toast.makeText(this, "권한을 승인해야지만 앱을 사용할 수 있습니다.", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }
}

fun getDescriptorFromDrawable(drawableId: Int): BitmapDescriptor {
    //마커 아이콘 만들기
    var bitmapDrawable: BitmapDrawable
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        bitmapDrawable = getDrawable(drawableId) as BitmapDrawable
    } else {
        bitmapDrawable = resources.getDrawable(drawableId) as BitmapDrawable
    }
    //마커 크기 변환
    val scaledBitmap = Bitmap.createScaledBitmap(bitmapDrawable.bitmap, 150, 150, false)
    return BitmapDescriptorFactory.fromBitmap(scaledBitmap)

}
}