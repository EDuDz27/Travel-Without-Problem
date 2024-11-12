package com.example.twp_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.twp_project.data.CriaBanco;
import com.example.twp_project.data.Noticia;
import com.example.twp_project.views.DetalhesActivity;
import com.example.twp_project.views.PerfilActivity;
import com.example.twp_project.views.RegistroActivity;
import com.example.twp_project.views.TravelActivity;
import com.google.android.material.imageview.ShapeableImageView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CriaBanco criaBanco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        criaBanco = new CriaBanco(this);

        // Slider Imagens
        // Criar lista de imagens
        ArrayList<SlideModel> imageList = new ArrayList<>();

        // Adicione imagens a lista
        imageList.add(new SlideModel("https://bit.ly/2YoJ77H", "A população de animais diminuiu 58% em 42 anos.", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://bit.ly/2BteuF2", "Elefantes e tigres podem entrar em extinção.", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://bit.ly/3fLJf72", "E as pessoas fazem isso.", ScaleTypes.CENTER_CROP));

        // Encontrar ImageSlider no layout
        ImageSlider imageSlider = findViewById(R.id.image_slider);

        // Definir lista de imagens no ImageSlider
        imageSlider.setImageList(imageList);

        // Botões de redirecionamento
        ImageButton btPerfil = findViewById(R.id.btPerfil);
        ImageButton btTravel = findViewById(R.id.btTravel);
        ImageButton btMenu = findViewById(R.id.btMenu);

        // Definir OnClickListener para os botões
        btPerfil.setOnClickListener(this);
        btTravel.setOnClickListener(this);
        btMenu.setOnClickListener(this);

        LinearLayout ContaninerNoticias = findViewById(R.id.news_container);
        adicionarNoticias(ContaninerNoticias);
    }

    private void adicionarNoticias(LinearLayout container){
        ArrayList<Noticia> listasNoticias = new ArrayList<>();

        listasNoticias.add(new Noticia(
                "Lunin cogita deixar o Real Madrid após ficar no banco durante final da Champions League, diz jornal",
                "Goleiro do Real Madrid, o ucraniano Lunin ficou extremamente incomodado por não ter entrado em campo na decisão da Champions League e inclusive cogita deixar o clube, segundo publicou o jornal espanhol Sport nesta quinta-feira (6)",
                "https://encrypted-tbn2.gstatic.com/licensed-image?q=tbn:ANd9GcQ0kxKW3O_SEAv9YmkxHZ0YSp0FPIn39vz1LyLMRbXBnUskJQiEfjpRyVCc8VqxxW8FEdVHaoNTvkQtp28")
        );

        listasNoticias.add(new Noticia(
                "A história do avião que foi deixado no alagamento do aeroporto Salgado Filho",
                "Um avião da Azul está no meio da inundação que forçou o fechamento do Aeroporto Salgado Filho, em Porto Alegre. A aeronave, modelo Cessna C208EX Caravan, com capacidade para transportar até 14 passageiros, está parcialmente embaixo d´água, ao lado de um hangar junto a outros jatinhos em uma área para aviação executiva.",
                "https://s2.glbimg.com/qCLROoWIwYj1-wWlmMGJKxHpyMk=/s.glbimg.com/jo/g1/f/original/2015/10/27/52c4071b232dbc033694baed6bcfd156.jpg")
        );

        listasNoticias.add(new Noticia(
                "Amazônia registra maior número de queimadas em uma década, alerta INPE",
                "O Instituto Nacional de Pesquisas Espaciais (INPE) divulgou que a Amazônia registrou o maior número de queimadas dos últimos dez anos. Especialistas alertam para os impactos ambientais e climáticos.",
                "https://images02.brasildefato.com.br/e1c4dd6795f370cb7af4b12f9fd001a3.jpeg")
        );

        listasNoticias.add(new Noticia(
                "Tecnologia 5G revoluciona setor de telecomunicações no Brasil",
                "A chegada do 5G ao Brasil está transformando o setor de telecomunicações, oferecendo maior velocidade de conexão e novas oportunidades para inovação e desenvolvimento econômico.",
                "https://www.redebrasilatual.com.br/wp-content/uploads/2021/02/5g-brasil.jpg")
        );

        listasNoticias.add(new Noticia(
                "Pandemia aumentou desigualdade social no Brasil, aponta estudo",
                "Um estudo recente revela que a pandemia de COVID-19 agravou a desigualdade social no Brasil, com impactos profundos na economia e no bem-estar das populações mais vulneráveis.",
                "https://s2-valor.glbimg.com/wbRknKThKlTWdLSbPHbM4PkCatw=/21x0:620x350/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_63b422c2caee4269b8b34177e8876b93/internal_photos/bs/2020/A/O/qD4ROuSw6lIDYZRs8Luw/imoveis.jpg")
        );

        listasNoticias.add(new Noticia(
                "Descoberta nova espécie de dinossauro no interior de São Paulo",
                "Paleontólogos descobriram uma nova espécie de dinossauro em escavações no interior de São Paulo. A descoberta é considerada um marco importante para a ciência e o conhecimento sobre a era dos dinossauros no Brasil.",
                "https://imagens.ebc.com.br/-DmvGUvZ51IZHYFI_VU6woJw7N4=/1170x700/smart/https://agenciabrasil.ebc.com.br/sites/default/files/thumbnails/image/kurupi-itaata.jpg?itok=SBer2pfO")
        );

        listasNoticias.add(new Noticia(
                "Campanha de vacinação contra gripe é lançada em todo o país",
                "O Ministério da Saúde lançou a campanha nacional de vacinação contra a gripe, com o objetivo de imunizar milhões de brasileiros e prevenir surtos da doença durante o inverno.",
                "https://cnm.org.br/storage/noticias/2023/Imagens/Sa%C3%BAde/image.jpg")
        );

        listasNoticias.add(new Noticia(
                "Projeto de lei propõe redução da carga tributária para pequenas empresas",
                "Um novo projeto de lei que visa reduzir a carga tributária para pequenas empresas está em tramitação no Congresso. A medida busca fomentar o crescimento econômico e a geração de empregos.",
                "https://ogimg.infoglobo.com.br/in/17552584-a82-16a/FT1086A/ranking-paises.jpg")
        );

        listasNoticias.add(new Noticia(
                "Estudo revela impacto positivo do home office na produtividade",
                "Uma pesquisa recente aponta que o home office tem um impacto positivo na produtividade dos trabalhadores. O estudo destaca que a flexibilidade e a ausência de deslocamentos contribuem para esse resultado.",
                "https://cdn.oantagonista.com/uploads/2022/03/teletrabalho.jpg")
        );

        listasNoticias.add(new Noticia(
                "Festival de cinema exibe filmes de diretores estreantes em São Paulo",
                "O tradicional festival de cinema de São Paulo este ano destaca a obra de diretores estreantes, oferecendo uma plataforma para novos talentos e promovendo a diversidade no setor cinematográfico.",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCXnZTkI9ohf5CQXl7c0i_H_M0K5Ti2fexmg&s")
        );

        for (Noticia noticia : listasNoticias){
            View noticiaView = getLayoutInflater().inflate(R.layout.noticia_item, container, false);

            ShapeableImageView imagemView = noticiaView.findViewById(R.id.noticia_imagem);
            TextView tituloView = noticiaView.findViewById(R.id.noticia_titulo);
            TextView descricaoView = noticiaView.findViewById(R.id.noticia_descricao);

            Glide.with(this).load(noticia.getImagemUrl()).into(imagemView);
            tituloView.setText(noticia.getTitulo());
            descricaoView.setText(noticia.getDescricao());

            container.addView(noticiaView);
        }
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btPerfil) {
            Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
            startActivity(intent);
        }

        if(v.getId()== R.id.btTravel){
            Intent DetailsTravel=new Intent(this, TravelActivity.class);
            startActivity(DetailsTravel);
        }

    }
}