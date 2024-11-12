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

import com.example.twp_project.MainActivity;
import com.example.twp_project.R;
import com.example.twp_project.data.CriaBanco;

public class RegistroActivity extends AppCompatActivity {
    EditText txtNome, txtCpf, txtIdade, txtCelular;
    EditText txtEmail, txtSenha;
    Button btProximo, btLogin, btCadastrar;
    ImageButton btVoltar;
    CriaBanco criaBanco;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_dados);
        txtNome = findViewById(R.id.nomeCadastro);
        txtCpf = findViewById(R.id.cpfCadastro);
        txtIdade = findViewById(R.id.idadeCadastro);
        txtCelular = findViewById(R.id.celularCadastro);

        btVoltar = findViewById(R.id.btVoltar);
        btLogin = findViewById(R.id.btLogin);
        btProximo = findViewById(R.id.btProximaPagina);
        criaBanco = new CriaBanco(this);

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btHome = findViewById(R.id.btHome);
        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btTravel = findViewById(R.id.btTravel);
        btTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistroActivity.this, TravelActivity.class);
                startActivity(intent);
            }
        });

        btProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome, cpf, idade, celular;
                nome = txtNome.getText().toString();
                cpf = txtCpf.getText().toString();
                idade = txtIdade.getText().toString();
                celular = txtCelular.getText().toString();

                if (nome.equals("") || cpf.equals("")){
                    Toast.makeText(RegistroActivity.this, "Porfavor preencha todos os campos obrigatorios", Toast.LENGTH_LONG).show();
                } else {
                    setContentView(R.layout.activity_cadastro_login);
                    txtEmail = findViewById(R.id.emailCadastro);
                    txtSenha = findViewById(R.id.senhaCadastro);

                    btVoltar = findViewById(R.id.btVoltar);
                    btLogin = findViewById(R.id.btLogin);
                    btCadastrar = findViewById(R.id.btCadastrar);

                    btVoltar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(RegistroActivity.this, RegistroActivity.class);
                            startActivity(intent);
                        }
                    });

                    ImageButton btHome = findViewById(R.id.btHome);
                    btHome.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });

                    ImageButton btTravel = findViewById(R.id.btTravel);
                    btTravel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(RegistroActivity.this, TravelActivity.class);
                            startActivity(intent);
                        }
                    });

                    btLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    });

                    btCadastrar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String email, senha;
                            email = txtEmail.getText().toString();
                            senha = txtSenha.getText().toString();
                            if (email.equals("") || senha.equals("")){
                                Toast.makeText(RegistroActivity.this, "Porfavor Preencha todos os campos", Toast.LENGTH_LONG).show();
                            } else {
                                if (criaBanco.verificaUsuario(cpf)){
                                    Toast.makeText(RegistroActivity.this, "Esse usuario ja existe", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                boolean registroSucedido = criaBanco.inserirDados(nome, cpf, idade, celular, email, senha);
                                if (registroSucedido){
                                    Toast.makeText(RegistroActivity.this, "Usuario Registrado com Sucesso", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(RegistroActivity.this, "Registro de usuario Falhou!", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    });
                }
            }
        });
    }
}
