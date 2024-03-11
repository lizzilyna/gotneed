package it.epicode.gotneed.services;

import it.epicode.gotneed.models.Help;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HelpService {
    private List<Help>helps=new ArrayList<>();

    public List<Help>getAllHelps(){
        return helps;
    }

    public Help getHelpById(int id){
        return helps.stream().filter(help ->help.getId()==id).findAny().
                orElseThrow(()->new NoSuchElementException("Help not found"));
    }

    public Help saveHelp (Help help){
        helps.add(help);
        return help;
    }

    public Help updateHelp (int id, Help help){
        Help h =getHelpById(id);
        h.setNome(help.getNome());

        return help;
    }

    public void deleteHelp (int id)throws NoSuchElementException{
        Help h=getHelpById (id);
        helps.remove(h);
    }
}
