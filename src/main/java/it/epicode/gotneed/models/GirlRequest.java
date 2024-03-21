package it.epicode.gotneed.models;

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
    private List<Help> offerti;
    private List<Help> richiesti;


    public GirlRequest(String nome, String cognome, String username, String password, String email, String provincia, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password=password;
        this.provincia=provincia;
        this.email = email;
        this.dataNascita = dataNascita;
        this.offerti=new ArrayList<>();
        this.richiesti=new ArrayList<>();

    }

    public GirlRequest() {
    }
}

