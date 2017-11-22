package com.landsoft.startservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnStartService, btnStopService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnStartService = findViewById(R.id.btn_start_sevice);
        btnStopService = findViewById(R.id.btn_stop_sevice);

        btnStartService.setOnClickListener(this);
        btnStopService.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this,UnBoundService.class);
        switch (view.getId()){
            case R.id.btn_start_sevice:
                startService(intent);
                break;
            case R.id.btn_stop_sevice:
                stopService(intent);
                break;
        }
    }
}
