package com.example.twp_project.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Objects;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String BANCO_NOME = "banco_usuario.db";

    private static final int VERSAO = 1;

    public CriaBanco(Context context){
        super(context, BANCO_NOME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE users (cpf TEXT primary key, nome TEXT, idade TEXT, celular TEXT, email TEXT, senha TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
    }

    public boolean inserirDados(String nome, String cpf, String idade, String celular, String email, String senha){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", nome);
        contentValues.put("cpf", cpf);
        contentValues.put("idade", idade);
        contentValues.put("celular", celular);
        contentValues.put("email", email);
        contentValues.put("senha", senha);
        long result = myDB.insert("users", null, contentValues);
        if(result == -1) return false;
        else return true;
    }

    public boolean verificaUsuario(String cpf){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT * FROM users WHERE cpf = ?", new String[]{cpf});
        if (cursor.getCount() > 0)
            return true;
        else return false;
    }

    public boolean validaUsuario(String email, String senha){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT * FROM users WHERE email = ? AND senha = ?", new String[]{email, senha});
        if (cursor.getCount() > 0)
            return true;
        else return false;
    }

    public boolean atualizarDadosUsuario(String email, String novoNome, String novoCelular, String novoEmail, String novoSenha) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        if (!novoNome.equals("")){
            contentValues.put("nome", novoNome);

        } else if (!novoCelular.equals("")){
            contentValues.put("celular", novoCelular);

        } else if (!novoEmail.equals("")){
            contentValues.put("email", novoEmail);
            DadosLogin.getInstance().setLogin(novoEmail);

        } else if (!novoSenha.equals("")){
            contentValues.put("senha", novoSenha);

        } else return false;

        int resultado = myDB.update("users", contentValues, "email = ?", new String[]{email});
        if (resultado > 0){
            return true;
        } else return  false;
    }

    public boolean verificaEmail(String email){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT * FROM users WHERE email = ?", new String[]{email});
        if (cursor.getCount() > 0)
            return true;
        else return false;
    }


}
