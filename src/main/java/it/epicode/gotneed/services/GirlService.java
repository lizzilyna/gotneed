package it.epicode.gotneed.services;

import it.epicode.gotneed.exceptions.NotFoundException;
import it.epicode.gotneed.models.Girl;
import it.epicode.gotneed.models.GirlRequest;
import it.epicode.gotneed.models.Help;
import it.epicode.gotneed.models.HelpType;
import it.epicode.gotneed.repositories.GirlRepository;
import it.epicode.gotneed.repositories.HelpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private HelpRepository helpRepository;

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public Page<Girl> getAllGirls(Pageable pageable){
        return girlRepository.findAll(pageable);
    }

    public Girl getGirlById(int id){
        return girlRepository.findById(id).orElseThrow(()->new NotFoundException("Girl con id="+id+" non trovata"));
    }

    public List<String> findUsernamesByTypeAndProvincia(HelpType type, String provincia) {
        // Recupera tutti gli aiuti di un certo tipo.
        List<Help> helps = helpRepository.findByType(type);
        List<String> usernames = helps.stream()
                .filter(help ->  {
                    // Controllo che sia offeredBy.provincia che requestedBy.provincia non siano null prima del confronto
                    boolean isOfferedByProvinciaMatch = help.getOfferedBy() != null && help.getOfferedBy().getProvincia() != null && help.getOfferedBy().getProvincia().equals(provincia);
                    boolean isRequestedByProvinciaMatch = help.getRequestedBy() != null && help.getRequestedBy().getProvincia() != null && help.getRequestedBy().getProvincia().equals(provincia);
                    return isOfferedByProvinciaMatch || isRequestedByProvinciaMatch;
                })  .map(help -> {
                    if (help.getOfferedBy() != null && help.getOfferedBy().getProvincia().equals(provincia)) {
                        return help.getOfferedBy().getUsername();
                    } else if (help.getRequestedBy() != null && help.getRequestedBy().getProvincia().equals(provincia)) {
                        return help.getRequestedBy().getUsername();
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return usernames;}


        public Girl saveGirl (GirlRequest girlRequest){
        Girl girl=new Girl(
                girlRequest.getNome(),
                girlRequest.getCognome(),
                girlRequest.getUsername(),
                girlRequest.getPassword(),
                girlRequest.getEmail(),
                girlRequest.getProvincia(),
                girlRequest.getDataNascita());

        if (girlRequest.getHelpOffertiIds() != null) {
            List<Help> offerti = girlRequest.getHelpOffertiIds().stream()
                    .map(helpId -> helpRepository.findById(helpId).orElse(null))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            girl.setOfferti(offerti);
        }

        if (girlRequest.getHelpRichiestiIds() != null) {
            List<Help> richiesti = girlRequest.getHelpRichiestiIds().stream()
                    .map(helpId -> helpRepository.findById(helpId).orElse(null))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            girl.setRichiesti(richiesti);

        }
        //girl.setOfferti(girlRequest.getOfferti());
        //girl.setRichiesti(girlRequest.getRichiesti());

            sendMail(girl.getEmail());

        return girlRepository.save(girl);
    }

    private void sendMail(String email){
        SimpleMailMessage message= new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Registrazione GotNeed");
        message.setText("Registrazione avvenuta con successo");
        javaMailSender.send(message);

    }


    public Girl getGirlByUsername (String username) {
    return  girlRepository.findByUsername(username).orElseThrow(()->new NotFoundException("Girl con username="+username+" non trovata"));
    }



    public Girl updateGirl (int id, GirlRequest girlRequest) throws NotFoundException{
        Girl g=getGirlById(id);


        return girlRepository.save(g);
    }



    public void deleteGirl (int id) throws NotFoundException { //non String perché il messaggio arriverebbe al controller che non se ne fa niente
        Girl g = getGirlById(id);
        girlRepository.delete(g);
    }


}
