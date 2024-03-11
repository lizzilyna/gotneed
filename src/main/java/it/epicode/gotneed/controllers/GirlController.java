package it.epicode.gotneed.controllers;

import it.epicode.gotneed.models.Girl;
import it.epicode.gotneed.services.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class GirlController {
    @Autowired
    private GirlService girlService;

    @GetMapping("/girls")
    public List<Girl> getAll() {
        return girlService.getAllGirls();
    }

    @GetMapping("/girls/{id}")
    public ResponseEntity<Girl> getGirlById(@PathVariable int id) {//responseEntity wrappa la girl
        try {
            Girl girl = girlService.getGirlById(id);
            return new ResponseEntity<Girl>(girl, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Girl>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/girls")
    public Girl saveGirl(@RequestBody Girl girl) {//il parametro d'ingresso è estratto dal body
        return girlService.saveGirl(girl);
    }

    @PutMapping("/girls/{id}")
    public ResponseEntity<Girl> updateGirl(@PathVariable int id, @RequestBody Girl girl) {
        try {
            Girl g = girlService.updateGirl(id, girl);
            return new ResponseEntity<Girl>(HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Girl>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/girls/{id}")
    public ResponseEntity<String> deleteGirl(@PathVariable int id){
        try {
              girlService.deleteGirl(id);
              return new ResponseEntity<String>("Girl con id="+id+" cancellata", HttpStatus.OK);
          }
          catch (NoSuchElementException e){
              return new ResponseEntity<String>("Girl con id="+id+" non trovata", HttpStatus.NOT_FOUND);
    }
}
}