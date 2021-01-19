package com.example.myappupdater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myappupdater.updater.AppUpdater;
import com.example.myappupdater.updater.net.INetCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppUpdater.getInstance().getNetManager().get("http://59.110.162.30/app_updater_version.json", new INetCallback() {
            @Override
            public void success(String response) {
                Log.d("aaa", response);
            }

            @Override
            public void failed(Throwable throwable) {
                Log.d("aaa", throwable.toString());
            }
        });
    }
}
