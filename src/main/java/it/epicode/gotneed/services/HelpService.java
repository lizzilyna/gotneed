package it.epicode.gotneed.services;

import it.epicode.gotneed.exceptions.NotFoundException;
import it.epicode.gotneed.models.Girl;
import it.epicode.gotneed.models.Help;
import it.epicode.gotneed.models.HelpRequest;
import it.epicode.gotneed.repositories.HelpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HelpService {
    @Autowired
    private HelpRepository helpRepository;
    @Autowired
    private GirlService girlService;


    public Page<Help> getAllHelps(Pageable pageable){
        return helpRepository.findAll(pageable);
    }

    public Help getHelpById(int id)throws NotFoundException{
        return helpRepository.findById(id).
                orElseThrow(()->new NotFoundException("Help con id="+id+" non trovato"));
    }

    public Help saveHelp (HelpRequest helpRequest){
        Girl offeredBy=girlService.getGirlById(helpRequest.getIdOfferedBy());
        Girl requestedBy=girlService.getGirlById(helpRequest.getIdRequestedBy());
        if (offeredBy == null || requestedBy == null) {
            throw new NotFoundException("Una o entrambe le ragazze non trovate.");
        }
        Help help= new Help(helpRequest.getNome());
        help.setOfferedBy(offeredBy);
        help.setRequestedBy(requestedBy);

        return helpRepository.save(help);


    }

    public Help updateHelp (int id, HelpRequest helpRequest)throws NotFoundException{
        Help help =getHelpById(id);
        help.setNome(helpRequest.getNome());

        return help;
    }

    public void deleteHelp (int id)throws NotFoundException{
        Help help=getHelpById (id);
        helpRepository.delete(help);
    }
}
