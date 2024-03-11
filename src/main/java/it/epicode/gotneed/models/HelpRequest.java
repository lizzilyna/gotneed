package it.epicode.gotneed.models;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class HelpRequest {
    @Autowired

    private String nome;
    private int idOfferedBy;
    private int idRequestedBy;
}
