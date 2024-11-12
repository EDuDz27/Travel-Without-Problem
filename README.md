# App-Travel-without-Problem

## Dependencies

  Adicione a linha as dependencias, no final do arquivo "build.gradle.kts (Module:app)":
    
    implementation ("com.github.denzcoskun:ImageSlideshow:0.1.2")
    
  ![image](https://github.com/nickolasferraz/App-Travel-without-Problem/assets/145012805/282f04b3-936c-4ff1-bfac-a8a119af2de9)

## Repositories

  Adicione o bloco aos repositorios, no arquivo "settings.gradle.kts":

        maven {
            url = uri("https://jitpack.io")
        }

  ![image](https://github.com/nickolasferraz/App-Travel-without-Problem/assets/145012805/994a7d64-c005-4ca5-8a8b-1ff6cb709f6a)

## Manifesto

  E por ultimo, em "app/manifests/AndroidManifest.xml" adicione a permissão de usuario logo no inicio:

        <uses-permission android:name="android.permission.INTERNET" />

  ![image](https://github.com/nickolasferraz/App-Travel-without-Problem/assets/145012805/ec5f9112-e0d7-435a-9988-65b403dae8f7)
