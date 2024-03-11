package it.epicode.gotneed.models;

import lombok.Data;

import java.util.Random;
@Data
public class Help {
    private int id = new Random().nextInt(1, Integer.MAX_VALUE);
    private String nome;
    private String cover = "https://picsum.photos/200/300";

    }
