package it.epicode.gotneed.controllers;

import it.epicode.gotneed.exceptions.BadRequestException;
import it.epicode.gotneed.models.Girl;
import it.epicode.gotneed.models.GirlRequest;
import it.epicode.gotneed.models.HelpType;
import it.epicode.gotneed.security.JwtTools;
import it.epicode.gotneed.services.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class GirlController {
    @Autowired
    private GirlService girlService;

    @Autowired
    private JwtTools jwtTools;

    @Autowired

    @GetMapping("/girls")
    public Page<Girl> getAll(Pageable pageable)
    {
        return girlService.getAllGirls(pageable);
    }

    @GetMapping("/girls/{id}")
    public Girl getGirlById(@PathVariable int id) {
      return girlService.getGirlById(id);

    }

    @GetMapping("girls/usernames")
    public ResponseEntity<List<String>> getHelpUsernames(
            @RequestParam HelpType type,
            @RequestParam String provincia) {
        List<String> usernames = girlService.findUsernamesByTypeAndProvincia(type, provincia);
        if (usernames.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usernames);

}

    @PostMapping("/girls")
    public Girl saveGirl(@RequestBody @Validated GirlRequest girlRequest, BindingResult bindingResult) {//il parametro d'ingresso è estratto dal body
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }
                    return girlService.saveGirl(girlRequest);
        }

    @PutMapping("/girls/{id}")
    public Girl updateGirl(@PathVariable int id, @RequestBody @Validated GirlRequest girlRequest, BindingResult bindingResult) {//il parametro d'ingresso è estratto dal body
            if (bindingResult.hasErrors()){
                throw new BadRequestException(bindingResult.getAllErrors().toString());
            }
        return girlService.updateGirl(id, girlRequest);

    }

    @DeleteMapping("/girls/{id}")
    public void deleteGirl(@PathVariable int id){
       girlService.deleteGirl(id);
    }
}
