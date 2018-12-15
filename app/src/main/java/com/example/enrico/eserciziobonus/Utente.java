package com.example.enrico.eserciziobonus;


import java.io.Serializable;

public class Utente implements Serializable {

    //attributi che rappresentano un utente
    private String nome;
    private String username;
    private String password;

    //costruttore di Utente
    public Utente (String nome, String username, String password){
        this.nome = nome;
        this.username = username;
        this.password = password;
    }

    /*
      Metodi e funzioni che modificano un oggetto di tipo Utente
      Alcuni di essi non sono usati, ma sono stati scritti per completezza
    */
    public void setName (String nome){
        this.nome = nome;
    }

    public String getNome (){
        return nome;
    }

    public void setUsername (String username){
        this.username = username;
    }

    public String getUsername (){
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
