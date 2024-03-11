package it.epicode.gotneed.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;
@Data
@Entity
public class Help {



    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String cover = "https://picsum.photos/200/300";

    @ManyToOne
    @JoinColumn(name = "offered_by")
    private Girl offeredBy;

    @ManyToOne
    @JoinColumn(name = "requested_by")
    private Girl requestedBy;

    public Help(String nome) {
        this.nome = nome;
    }
}
