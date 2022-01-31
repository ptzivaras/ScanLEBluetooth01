package com.example.scanlebluetooth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int BLUETOOTH_SCAN_CODE = 102;
    Button button0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // o panagiotis leei apo katw na grafw kwdika.
        button0 = findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {
                    //checkPermission("BLUETOOTH_SCAN", 101);
                    checkPermission("ACCESS_FINE_LOCATION", 102);
                    //checkPermission("BLUETOOTH", 103);
                }else {
                    Toast.makeText(MainActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
                }

                //String[] SCAN_PERMISSION = { "BLUETOOTH_SCAN" };
                //requestPermissions(new String[]{Manifest.permission.BLUETOOTH_SCAN}, BLUETOOTH_SCAN_CODE);
            }
        });
    }

    public void checkPermission(String permission, int requestCode) {
        // Checking if permission is not granted
        Toast.makeText(MainActivity.this, "Lets see", Toast.LENGTH_SHORT).show();
        ActivityCompat.requestPermissions(MainActivity.this, new String[] { permission }, requestCode);
    }

    // This function is called when user accept or decline the permission.
    // Request Code is used to check which permission called this function.
    // This request code is provided when user is prompt for permission.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if( requestCode == 101 ) {
            // Checking whether user granted the permission or not.
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Showing the toast message
                Toast.makeText(MainActivity.this, "Bluetooth Permission Granted", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(MainActivity.this, "Bluetooth Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}