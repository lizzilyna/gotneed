package it.epicode.gotneed.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GirlRequest {
    private String nome;
    private String cognome;
    private String username;
    private String email;
    private LocalDate dataNascita;

    public GirlRequest(String nome, String cognome, String username, String email, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.email = email;
        this.dataNascita = dataNascita;
    }
}

