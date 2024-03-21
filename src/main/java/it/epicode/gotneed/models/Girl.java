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

    @Column(unique = true)
    private String username;
    private String password;
    private String email;
    private String provincia;
    private LocalDate dataNascita;
    private String avatar;

    @OneToMany(mappedBy = "offeredBy", cascade = CascadeType.ALL)
    private List<Help> offerti = new ArrayList<>();

    @OneToMany(mappedBy = "requestedBy", cascade = CascadeType.ALL)
    private List<Help> richiesti = new ArrayList<>();


    public Girl(String nome, String cognome, String username, String password, String email, String provincia, LocalDate dataNascita)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password=password;
        this.email = email;
        this.provincia= provincia;
        this.dataNascita = dataNascita;
        this.offerti = new ArrayList<>();
        this.richiesti = new ArrayList<>();
        this.avatar = "https://ui-avatars.com/api/?name="+nome+"+"+cognome;
    }

    public Girl() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Help> getOfferti() {
        return offerti;
    }

    public void setOfferti(List<Help> offerti) {
        this.offerti = offerti;
    }

    public List<Help> getRichiesti() {
        return richiesti;
    }

    public void setRichiesti(List<Help> richiesti) {
        this.richiesti = richiesti;
    }
}
