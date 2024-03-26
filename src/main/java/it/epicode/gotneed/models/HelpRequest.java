package it.epicode.gotneed.models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class HelpRequest {
    @Autowired

    @Enumerated(EnumType.STRING)
    private HelpType type;

    private Integer offeredById;
    private Integer requestedById;

    public HelpRequest(HelpType type, Integer offeredById, Integer requestedById) {
        this.type=type;
        this.offeredById = offeredById;
        this.requestedById = requestedById;



    }


}
