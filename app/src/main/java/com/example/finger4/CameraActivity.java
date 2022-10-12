package com.example.finger4;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.opencv.android.OpenCVLoader;

public class CameraActivity extends AppCompatActivity {

    private final PermissionsDelegate permissionsDelegate = new PermissionsDelegate(this);

    private static final String TAG = "TCameraActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        init();
    }
    private void init() {
        if (OpenCVLoader.initDebug()) {
            Log.d(TAG, "Open CV LOADED");
        } else {
            Log.d(TAG, "Open CV FAILED");
        }

        boolean hasPermission = permissionsDelegate.hasPermissions();
        if (!hasPermission) {
            permissionsDelegate.requestPermissions();
        }
    }
}

