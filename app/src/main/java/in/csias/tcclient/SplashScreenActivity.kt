package `in`.csias.tcclient

import `in`.csias.tcclient.allcountryotp.MainOtpActivity
import `in`.csias.tcclient.otp.NumberActivity
import android.Manifest
import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceManager

class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_DISPLAY_LENGTH = 2000
    private val REQUEST_ENABLE_BT = 3
    private val PERMISSION_COARSE_LOCATION = 2
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (sharedPreferences.contains(MainFragment.KEY_LOGIN)) {
            if (sharedPreferences.getBoolean(MainFragment.KEY_LOGIN, false)) {
                checkLocationPermission()
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Location Permission Needed")
                    .setMessage("Qmodi Tracking Android App collects\n" +
                            "location data to enable tracking yours\n" +
                            "several loads and calculate distance\n" +
                            "travelled when app is working or even when\n" +
                            "the app is closed or not in use.\n" +
                            "\n" +
                            "This data will be uploaded to qmodi.com\n" +
                            "where you can view and/or delete your\n" +
                            "location(Loads) tavelled history.\n" +
                            "\n" +
                            "Qmodi Tracking Android App collects location data to enable\n" +
                            "1. Estimate/Actual Time Needed for each load trips\n" +
                            "2. Distance traveled (Actual vs as on load map) estimate vs actual\n" +
                            "3. Marking and Notifying on entry and exit of each Geo fence (Stops) in the load trips\n" +
                            "even when the app is closed or not in use.\n" +
                            "\n" +
                            "Qmodi Tracking Android App collects location data to enable\n" +
                            "1. Estimate/Actual Time Needed for each load trips\n" +
                            "2. Distance traveled (Actual vs as on load map) estimate vs actual\n" +
                            "3. Marking and Notifying on entry and exit of each Geo fence (Stops) in the load trips\n" +
                            "even when the app is closed or not in use and it is also used to support advertising.")
                    .setPositiveButton(
                        "Proceed"
                    ) { _, _ ->
                        val mainIntent = Intent(this, MainOtpActivity::class.java)
                        startActivity(mainIntent)
                        finish()
                    }
                    .create()
                    .show()

            }
        } else {
            AlertDialog.Builder(this)
                .setTitle("Location Permission Needed")
                .setMessage("Qmodi Tracking Android App collects\n" +
                        "location data to enable tracking yours\n" +
                        "several loads and calculate distance\n" +
                        "travelled when app is working or even when\n" +
                        "the app is closed or not in use.\n" +
                        "\n" +
                        "This data will be uploaded to qmodi.com\n" +
                        "where you can view and/or delete your\n" +
                        "location(Loads) tavelled history.\n" +
                        "\n" +
                        "Qmodi Tracking Android App collects location data to enable\n" +
                        "1. Estimate/Actual Time Needed for each load trips\n" +
                        "2. Distance traveled (Actual vs as on load map) estimate vs actual\n" +
                        "3. Marking and Notifying on entry and exit of each Geo fence (Stops) in the load trips\n" +
                        "even when the app is closed or not in use.\n" +
                        "\n" +
                        "Qmodi Tracking Android App collects location data to enable\n" +
                        "1. Estimate/Actual Time Needed for each load trips\n" +
                        "2. Distance traveled (Actual vs as on load map) estimate vs actual\n" +
                        "3. Marking and Notifying on entry and exit of each Geo fence (Stops) in the load trips\n" +
                        "even when the app is closed or not in use and it is also used to support advertising.")
                .setPositiveButton(
                    "Proceed"
                ) { _, _ ->
                    val mainIntent = Intent(this, MainOtpActivity::class.java)
                    startActivity(mainIntent)
                    finish()
                }
                .create()
                .show()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_ENABLE_BT) {
            if (resultCode == RESULT_OK) {
                checkLocationPermission()
            } else {
                finish()
            }
        }
    }


    private fun checkLocationPermission() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            ) {
                AlertDialog.Builder(this)
                    .setTitle("Location Permission Needed")
                    .setMessage("Qmodi Tracking Android App collects\n" +
                            "location data to enable tracking yours\n" +
                            "several loads and calculate distance\n" +
                            "travelled when app is working or even when\n" +
                            "the app is closed or not in use.\n" +
                            "\n" +
                            "This data will be uploaded to qmodi.com\n" +
                            "where you can view and/or delete your\n" +
                            "location(Loads) tavelled history.\n" +
                            "\n" +
                            "Qmodi Tracking Android App collects location data to enable\n" +
                            "1. Estimate/Actual Time Needed for each load trips\n" +
                            "2. Distance traveled (Actual vs as on load map) estimate vs actual\n" +
                            "3. Marking and Notifying on entry and exit of each Geo fence (Stops) in the load trips\n" +
                            "even when the app is closed or not in use.\n" +
                            "\n" +
                            "Qmodi Tracking Android App collects location data to enable\n" +
                            "1. Estimate/Actual Time Needed for each load trips\n" +
                            "2. Distance traveled (Actual vs as on load map) estimate vs actual\n" +
                            "3. Marking and Notifying on entry and exit of each Geo fence (Stops) in the load trips\n" +
                            "even when the app is closed or not in use and it is also used to support advertising.")
                    .setPositiveButton(
                        "Proceed"
                    ) { _, _ ->
                        //Prompt the user once explanation has been shown
                        requestLocationPermission()
                    }
                    .create()
                    .show()
            } else {
                // No explanation needed, we can request the permission.
                AlertDialog.Builder(this)
                    .setTitle("Location Permission Needed")
                    .setMessage("Qmodi Tracking Android App collects\n" +
                            "location data to enable tracking yours\n" +
                            "several loads and calculate distance\n" +
                            "travelled when app is working or even when\n" +
                            "the app is closed or not in use.\n" +
                            "\n" +
                            "This data will be uploaded to qmodi.com\n" +
                            "where you can view and/or delete your\n" +
                            "location(Loads) tavelled history.\n" +
                            "\n" +
                            "Qmodi Tracking Android App collects location data to enable\n" +
                            "1. Estimate/Actual Time Needed for each load trips\n" +
                            "2. Distance traveled (Actual vs as on load map) estimate vs actual\n" +
                            "3. Marking and Notifying on entry and exit of each Geo fence (Stops) in the load trips\n" +
                            "even when the app is closed or not in use.\n" +
                            "\n" +
                            "Qmodi Tracking Android App collects location data to enable\n" +
                            "1. Estimate/Actual Time Needed for each load trips\n" +
                            "2. Distance traveled (Actual vs as on load map) estimate vs actual\n" +
                            "3. Marking and Notifying on entry and exit of each Geo fence (Stops) in the load trips\n" +
                            "even when the app is closed or not in use and it is also used to support advertising.")
                    .setPositiveButton(
                        "Proceed"
                    ) { _, _ ->
                        //Prompt the user once explanation has been shown
                        requestLocationPermission()
                    }
                    .create()
                    .show()
            }
        } else {
            Handler().postDelayed({
                finish()
                val mainIntent = Intent(this, MainActivity::class.java)
                startActivity(mainIntent)
                finish()
            }, SPLASH_DISPLAY_LENGTH.toLong())
        }
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
            ),
            MY_PERMISSIONS_REQUEST_LOCATION
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_LOCATION -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {                        // Now check background location
                        Handler().postDelayed({
                            finish()
                            val mainIntent = Intent(this, MainActivity::class.java)
                            startActivity(mainIntent)
                            finish()
                        }, SPLASH_DISPLAY_LENGTH.toLong())
                    }

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show()

                    // Check if we are in a state where the user has denied the permission and
                    // selected Don't ask again
                    if (!ActivityCompat.shouldShowRequestPermissionRationale(
                            this,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        )
                    ) {
                        startActivity(
                            Intent(
                                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                Uri.fromParts("package", this.packageName, null),
                            ),
                        )
                    }
                }
                return
            }
        }
    }

    companion object {
        private const val MY_PERMISSIONS_REQUEST_LOCATION = 99
        private const val MY_PERMISSIONS_REQUEST_BACKGROUND_LOCATION = 66
    }
}