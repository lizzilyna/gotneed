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

    private Girl offeredBy;
    private Girl requestedBy;

    public HelpRequest(HelpType type, Girl offeredBy, Girl requestedBy) {
        this.type=type;
        this.offeredBy = offeredBy;
        this.requestedBy = requestedBy;



    }


}
