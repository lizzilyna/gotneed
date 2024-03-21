package it.epicode.gotneed.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;
@Data
@Entity
public class Help {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    private HelpType type;
    private String cover = "https://picsum.photos/200/300";

    @ManyToOne
    //@JsonIgnore in caso vada in frattale girl/help/girl
    @JoinColumn(name = "offered_by")
    private Girl offeredBy;

    @ManyToOne
    @JoinColumn(name = "requested_by")
    private Girl requestedBy;

    public Help() {
    }

    public Help(HelpType type, Girl offeredBy, Girl requestedBy) {

        this.type = type;
        this.offeredBy = offeredBy;
        this.requestedBy = requestedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HelpType getType() {
        return type;
    }

    public void setType(HelpType type) {
        this.type = type;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Girl getOfferedBy() {
        return offeredBy;
    }

    public void setOfferedBy(Girl offeredBy) {
        this.offeredBy = offeredBy;
    }

    public Girl getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(Girl requestedBy) {
        this.requestedBy = requestedBy;
    }
}
