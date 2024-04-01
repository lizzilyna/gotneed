package it.epicode.gotneed.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class GirlRequest {

    @NotBlank(message = "campo obbligatorio")
    private String nome;

    @NotBlank (message = "campo obbligatorio")
    private String cognome;

    @NotBlank (message = "campo obbligatorio")
    private String username;

    @NotBlank (message = "campo obbligatorio")
    private String password;


    private String email;
    private String provincia;
    private LocalDate dataNascita;
    private List<Integer> helpOffertiIds;
    private List<Integer> helpRichiestiIds;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Integer> getHelpOffertiIds() {
        return helpOffertiIds;
    }

    public void setHelpOffertiIds(List<Integer> helpOffertiIds) {
        this.helpOffertiIds = helpOffertiIds;
    }

    public List<Integer> getHelpRichiestiIds() {
        return helpRichiestiIds;
    }

    public void setHelpRichiestiIds(List<Integer> helpRichiestiIds) {
        this.helpRichiestiIds = helpRichiestiIds;
    }

    public GirlRequest(String nome, String cognome, String username, String password, String email, String provincia, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password=password;
        this.provincia=provincia;
        this.email = email;
        this.dataNascita = dataNascita;
        this.helpOffertiIds=new ArrayList<>();
        this.helpRichiestiIds=new ArrayList<>();

    }

    public GirlRequest() {
    }
}

