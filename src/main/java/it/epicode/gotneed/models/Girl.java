package it.epicode.gotneed.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.Random;

@Data
public class Girl {
    private int id;
    private String nome;
    private String cognome;
    private String username;
    private String email;
    private LocalDate dataNascita;
    private String avatar;

    public Girl(String nome, String cognome, String username, String email, LocalDate dataNascita)
    {
        this.id = new Random().nextInt(1, Integer.MAX_VALUE);
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.email = email;
        this.dataNascita = dataNascita;
        this.avatar = "https://ui-avatars.com/api/?name="+nome+"+"+cognome;
    }


}
