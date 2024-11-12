package com.example.twp_project.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.twp_project.R;
import com.example.twp_project.data.CriaBanco;
import com.example.twp_project.data.DadosLogin;

public class AlteraDadosActivity extends AppCompatActivity {
    CriaBanco criaBanco = new CriaBanco(this);
    String email = DadosLogin.getInstance().getLogin();

    EditText alterarEmail, alterarSenha, alterarNome, alterarCelular;
    Button btAplicar;
    ImageButton btVoltar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        alterarNome = findViewById(R.id.alterarNome);
        alterarCelular = findViewById(R.id.alterarCelular);
        alterarEmail = findViewById(R.id.alterarEmail);
        alterarSenha = findViewById(R.id.alterarSenha);

        btVoltar = findViewById(R.id.btVoltar);

        btAplicar = findViewById(R.id.btAplicar);
        btAplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String novoNome, novoEmail, novoCelular, novoSenha;
                novoNome = alterarNome.getText().toString();
                novoEmail = alterarEmail.getText().toString();
                novoCelular = alterarCelular.getText().toString();
                novoSenha = alterarSenha.getText().toString();

                if (criaBanco.verificaEmail(novoEmail)){
                    Toast.makeText(AlteraDadosActivity.this, "Email ja registrado, nao pode ser alterado", Toast.LENGTH_LONG).show();
                    return;
                }

                criaBanco.atualizarDadosUsuario(email, novoNome, novoCelular, novoEmail, novoSenha);
                Intent intent = new Intent(AlteraDadosActivity.this, PerfilActivity.class);
                startActivity(intent);
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlteraDadosActivity.this, PerfilActivity.class);
                startActivity(intent);
            }
        });

    }
}
