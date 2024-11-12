package com.example.twp_project.views;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.twp_project.MainActivity;
import com.example.twp_project.R;

public class TravelActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        ImageButton btHome = findViewById(R.id.btHome);
        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TravelActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btPerfil = findViewById(R.id.btPerfil);
        btPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TravelActivity.this, PerfilActivity.class);
                startActivity(intent);
            }
        });
    }
}
