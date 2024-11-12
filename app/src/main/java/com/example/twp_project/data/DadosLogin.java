package com.example.twp_project.data;

public class DadosLogin {
    private static DadosLogin instance;
    private String login;

    private DadosLogin() { }

    public static DadosLogin getInstance() {
        if (instance == null) {
            instance = new DadosLogin();
        }
        return instance;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}

