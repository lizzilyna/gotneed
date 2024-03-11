package it.epicode.gotneed.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@Entity
public class Girl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String cognome;
    private String username;
    private String email;
    private LocalDate dataNascita;
    private String avatar;

    @OneToMany(mappedBy = "offeredBy", cascade = CascadeType.ALL)
    private List<Help> offerti = new ArrayList<>();

    @OneToMany(mappedBy = "requestedBy", cascade = CascadeType.ALL)
    private List<Help> richiesti = new ArrayList<>();


    public Girl(String nome, String cognome, String username, String email, LocalDate dataNascita)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.email = email;
        this.dataNascita = dataNascita;
        this.avatar = "https://ui-avatars.com/api/?name="+nome+"+"+cognome;
    }



}
