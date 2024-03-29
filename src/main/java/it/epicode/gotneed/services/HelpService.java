package it.epicode.gotneed.services;

import it.epicode.gotneed.exceptions.NotFoundException;
import it.epicode.gotneed.models.Girl;
import it.epicode.gotneed.models.Help;
import it.epicode.gotneed.models.HelpRequest;
import it.epicode.gotneed.models.HelpType;
import it.epicode.gotneed.repositories.HelpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    public Page <Help> getOfferedHelpByProvincia(@RequestParam String provincia, Pageable pageable) throws NotFoundException{
        return helpRepository.findByOfferedByProvincia(provincia, pageable);
    }
    public Page <Help> getRequestedHelpByProvincia(@RequestParam String provincia, Pageable pageable) throws NotFoundException{
        return helpRepository.findByRequestedByProvincia(provincia, pageable);
    }

    public Page<Help> getOfferedHelpByProvinciaAndType(String provincia, HelpType type, Pageable pageable) {
        return helpRepository.findByOfferedByProvinciaAndType(provincia, type, pageable);
    }

    public Page<Help> getRequestedHelpByProvinciaAndType(String provincia, HelpType type, Pageable pageable) {
        return helpRepository.findByRequestedByProvinciaAndType(provincia, type, pageable);
    }

    public Help saveHelp (HelpRequest helpRequest)throws NotFoundException{
                Girl offeredBy=girlService.getGirlById(helpRequest.getOfferedById());
                Girl requestedBy=null;
        if (helpRequest.getRequestedById()!= null) {
                    requestedBy= girlService.getGirlById(helpRequest.getRequestedById());
                }
                Help help= new Help();
                help.setType(helpRequest.getType());
                help.setOfferedBy(offeredBy);
                help.setRequestedBy(requestedBy);
                return helpRepository.save(help);

            }

    public Help updateHelp (int id, HelpRequest helpRequest)throws NotFoundException{
                Help help =getHelpById(id);
                if (helpRequest.getType()!=null) help.setType(helpRequest.getType());
                if (helpRequest.getOfferedById() !=null){
                    Girl offeredBy=girlService.getGirlById(helpRequest.getOfferedById());
                    help.setOfferedBy(offeredBy);
                }
                if (helpRequest.getRequestedById()!=null){
                    Girl requestedBy=girlService.getGirlById(helpRequest.getRequestedById());
                    help.setRequestedBy(requestedBy);
                }

                return helpRepository.save(help);
            }

            public void deleteHelp (int id)throws NotFoundException{
                Help help=getHelpById (id);
                helpRepository.delete(help);
            }
        }
