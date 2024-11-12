package com.example.twp_project.data;

import com.bumptech.glide.Glide;

public class Noticia {
    private String titulo;
    private String descricao;
    private String imagemUrl;

    public Noticia(String titulo, String descricao, String imagemUrl) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.imagemUrl = imagemUrl;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }
}
