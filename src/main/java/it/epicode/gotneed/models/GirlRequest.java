package it.epicode.gotneed.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class GirlRequest {
    private String nome;
    private String cognome;
    private String username;
    private String email;
    private String provincia;
    private LocalDate dataNascita;
    private List<Help> offerti;
    private List<Help> richiesti;

    public GirlRequest(String nome, String cognome, String username, String email, String provincia, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.provincia=provincia;
        this.email = email;
        this.dataNascita = dataNascita;
        this.offerti=new ArrayList<>();
        this.richiesti=new ArrayList<>();
    }
}

