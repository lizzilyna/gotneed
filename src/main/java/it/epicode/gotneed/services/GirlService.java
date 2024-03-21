package it.epicode.gotneed.services;

import it.epicode.gotneed.exceptions.NotFoundException;
import it.epicode.gotneed.models.Girl;
import it.epicode.gotneed.models.GirlRequest;
import it.epicode.gotneed.repositories.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;
    public Page<Girl> getAllGirls(Pageable pageable){
        return girlRepository.findAll(pageable);
    }

    public Girl getGirlById(int id){
        return girlRepository.findById(id).orElseThrow(()->new NotFoundException("Girl con id="+id+" non trovata"));
    }

    public Girl saveGirl (GirlRequest girlRequest){
        Girl girl=new Girl(girlRequest.getNome(),girlRequest.getCognome(),girlRequest.getUsername(), girlRequest.getPassword(), girlRequest.getEmail(), girlRequest.getProvincia(), girlRequest.getDataNascita());
        girl.setOfferti(girlRequest.getOfferti());
        girl.setRichiesti(girlRequest.getRichiesti());

        return girlRepository.save(girl);
    }

    public Girl getGirlByUsername (String username) {
    return  girlRepository.findByUsername(username).orElseThrow(()->new NotFoundException("Girl con username="+username+" non trovata"));
    }

    public Girl updateGirl (int id, GirlRequest girlRequest) throws NotFoundException{
        Girl g=getGirlById(id);
        g.setUsername(girlRequest.getUsername());

        return girlRepository.save(g);
    }



    public void deleteGirl (int id) throws NotFoundException { //non String perché il messaggio arriverebbe al controller che non se ne fa niente
        Girl g = getGirlById(id);
        girlRepository.delete(g);
    }


}
