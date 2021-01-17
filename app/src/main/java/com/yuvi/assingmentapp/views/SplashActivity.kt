package com.yuvi.assingmentapp.views

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.*
import com.yuvi.assingmentapp.R
import com.yuvi.assingmentapp.constants.DataConstants

class SplashActivity : AppCompatActivity() {

    val DELAY: Long = 7000

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    lateinit var loacationRequest: LocationRequest

    lateinit var locationCallback: LocationCallback

    lateinit var location: Location

    val REQUEST_CODE = 1000

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode)
        {
            REQUEST_CODE->{
                if (grantResults.size > 0)
                {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                        Toast.makeText(this@SplashActivity,"Permission Granted" , Toast.LENGTH_SHORT).show()
                    else
                        Toast.makeText(this@SplashActivity,"Permission Denied" , Toast.LENGTH_SHORT).show()

                }
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)


        //*****************check location permission********************************
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,android.Manifest.permission
                .ACCESS_FINE_LOCATION))
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION
            ),REQUEST_CODE)
        else
        {
            buildLocationRequest()
            buildLocationCallback()

            //Create FusedProviderClient
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

            if(ActivityCompat.checkSelfPermission(this@SplashActivity,android.Manifest.permission
                    .ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED   &&   ActivityCompat
                    .checkSelfPermission(this@SplashActivity,android.Manifest.permission
                        .ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED )
            {
                ActivityCompat.requestPermissions(this@SplashActivity, arrayOf(android.Manifest.permission
                    .ACCESS_FINE_LOCATION),REQUEST_CODE)
            }
            fusedLocationProviderClient.requestLocationUpdates(loacationRequest,locationCallback, Looper.myLooper())
        }



        val handler = Handler()
        val runnable = Runnable {


            //window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

            //val animDrawable = splash_layout.background as AnimationDrawable

            //animDrawable.setEnterFadeDuration(10)
            //animDrawable.setExitFadeDuration(2000)
            //animDrawable.start()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        handler.postDelayed(runnable, DELAY)


    }

    private fun buildLocationCallback() {

        locationCallback = object : LocationCallback() {

            override fun onLocationResult(p0: LocationResult?) {
                location = p0!!.locations.get(p0!!.locations.size - 1) //Get last Location
                Log.e("lattitude", location.latitude.toString() + "  " + location.longitude.toString())

                DataConstants.lat = location.latitude.toString()
                DataConstants.longti = location.longitude.toString()


            }
        }
    }

    @SuppressLint("RestrictedApi")
    private fun buildLocationRequest() {

        loacationRequest = LocationRequest()
        loacationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        loacationRequest.interval = 5000
        loacationRequest.fastestInterval=3000
        loacationRequest.smallestDisplacement = 10f
    }

    override fun onResume() {
        super.onResume()


        buildLocationRequest()
        buildLocationCallback()

        //Create FusedProviderClient
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        if(ActivityCompat.checkSelfPermission(this@SplashActivity,android.Manifest.permission
                .ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED   &&   ActivityCompat
                .checkSelfPermission(this@SplashActivity,android.Manifest.permission
                    .ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED )
        {
            ActivityCompat.requestPermissions(this@SplashActivity, arrayOf(android.Manifest.permission
                .ACCESS_FINE_LOCATION),REQUEST_CODE)
        }
        fusedLocationProviderClient.requestLocationUpdates(loacationRequest,locationCallback, Looper.myLooper())

    }
}
