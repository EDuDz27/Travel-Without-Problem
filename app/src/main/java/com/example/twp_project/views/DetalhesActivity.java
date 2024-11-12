package com.example.twp_project.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.twp_project.MainActivity;
import com.example.twp_project.R;

public class DetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        ImageButton btHome = findViewById(R.id.btHome);

        btHome.setOnClickListener(new HomeButtonClickListener());
    }
    private class HomeButtonClickListener implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalhesActivity.this, MainActivity.class);
                startActivity(intent);
            }
    }

}