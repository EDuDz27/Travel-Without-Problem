package com.example.twp_project.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.twp_project.MainActivity;
import com.example.twp_project.R;
import com.example.twp_project.data.CriaBanco;
import com.example.twp_project.data.DadosLogin;


public class LoginActivity extends AppCompatActivity {
    CriaBanco criaBanco = new CriaBanco(this);
    Button btLogin, btCadastrar;
    EditText txtEmail, txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = findViewById(R.id.emailLogin);
        txtSenha = findViewById(R.id.senhaLogin);

        btLogin = findViewById(R.id.btLogar);
        btCadastrar = findViewById(R.id.btRegistrar);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString();
                String senha = txtSenha.getText().toString();

                boolean isLogged = criaBanco.validaUsuario(email, senha);
                if (isLogged){
                    Toast.makeText(LoginActivity.this, "Login Realizado com Sucesso", Toast.LENGTH_SHORT).show();
                    DadosLogin.getInstance().setLogin(email);
                    Intent intent = new Intent(LoginActivity.this, PerfilActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Login Falhou", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageButton btVoltar = findViewById(R.id.btVoltar);
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });


    }

}
