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


    }

