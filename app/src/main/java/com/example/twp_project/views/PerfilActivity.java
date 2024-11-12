package com.example.twp_project.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.twp_project.MainActivity;
import com.example.twp_project.R;
import com.example.twp_project.data.CriaBanco;
import com.example.twp_project.data.DadosLogin;

import java.util.Objects;

public class PerfilActivity extends AppCompatActivity {
    CriaBanco criaBanco;

    TextView txtNome, txtCelular, txtEmail;
    String email, nome, celular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        criaBanco = new CriaBanco(this);
        SQLiteDatabase myDB = criaBanco.getReadableDatabase();

        email = DadosLogin.getInstance().getLogin();
        if (Objects.equals(email, "") || email == null){
            Intent intent = new Intent(PerfilActivity.this, LoginActivity.class);
            startActivity(intent);

        } else {
            Cursor cursor = myDB.rawQuery("SELECT * FROM users WHERE email = ?", new String[]{email});
            if (cursor != null && cursor.moveToFirst()) {
                nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
                celular = cursor.getString(cursor.getColumnIndexOrThrow("celular"));
            }

            txtNome = findViewById(R.id.txtNomePerfil);
            txtCelular = findViewById(R.id.txtCelularPerfil);
            txtEmail = findViewById(R.id.txtEmailPerfil);

            txtNome.setText(nome);
            txtCelular.setText(celular);
            txtEmail.setText(email);

        }

        ImageButton btOptions = findViewById(R.id.btOptions);
        btOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(PerfilActivity.this, btOptions);
                popup.getMenuInflater().inflate(R.menu.manu_flutuante, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        final int itemId = item.getItemId();
                        if (itemId == R.id.action_option){
                            return true;
                        } else if (itemId == R.id.itemLogout) {
                            DadosLogin.getInstance().setLogin(null);
                            Intent intent = new Intent(PerfilActivity.this, LoginActivity.class);
                            startActivity(intent);
                            return true;
                        } else {
                            return false;
                        }
                    }

                });
                popup.show();
            }
        });


        ImageButton btHome = findViewById(R.id.btHome);
        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btTravel = findViewById(R.id.btTravel);
        btTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilActivity.this, TravelActivity.class);
                startActivity(intent);
            }
        });

        Button btEdit = findViewById(R.id.btEdit);
        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilActivity.this, AlteraDadosActivity.class);
                startActivity(intent);
            }
        });


    }
}