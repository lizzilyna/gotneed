package it.epicode.gotneed.services;

import it.epicode.gotneed.models.Girl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GirlService {
    private List<Girl>girls=new ArrayList<>();
    public List<Girl>getAllGirls(){
        return girls;
    }

    public Girl getGirlById(int id){
        return girls.stream().filter(girl -> girl.getId()==id).findAny().
                orElseThrow(()->new NoSuchElementException("Girl not found"));
    }

    public Girl saveGirl (Girl girl){
        girls.add(girl);
        return girl;
    }

    public Girl updateGirl (int id, Girl girl) throws NoSuchElementException{
        Girl g=getGirlById(id);
        g.setNome(girl.getNome());
        g.setCognome(girl.getCognome());
        g.setUsername(girl.getUsername());
        g.setEmail(girl.getEmail());
        g.setDataNascita(girl.getDataNascita());

        return g;
    }

    public void deleteGirl (int id) throws NoSuchElementException { //non String perché il messaggio arriverebbe al controller che non se ne fa niente
        Girl g = getGirlById(id);
        girls.remove(g);
    }


}
