package it.epicode.gotneed.controllers;

import it.epicode.gotneed.models.Help;
import it.epicode.gotneed.models.HelpRequest;
import it.epicode.gotneed.services.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/helps")
public class HelpController {
    @Autowired
    private HelpService helpService;

    @GetMapping
    public Page<Help> getAllHelps(Pageable pageable){
        return helpService.getAllHelps(pageable);
    }

    @GetMapping("/requested")
    public Page<Help> getRequestedHelpByProvincia(@RequestParam String provincia, Pageable pageable) {
        return helpService.getRequestedHelpByProvincia(provincia, pageable);

    }
    @GetMapping("/offered")
    public Page<Help> getOfferedHelpByProvincia(@RequestParam String provincia, Pageable pageable) {
        return helpService.getOfferedHelpByProvincia(provincia, pageable);
    }

    @GetMapping ("/{id}")
    public Help getById(@PathVariable int id) {
        return helpService.getHelpById(id);
    }

    @PostMapping
    public Help saveHelp (@RequestBody HelpRequest helpRequest) {
        return helpService.saveHelp(helpRequest);

    }

    @PutMapping("/{id}")
    public Help updateHelp(@PathVariable int id, @RequestBody HelpRequest helpRequest){
        return helpService.updateHelp(id, helpRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteHelp(@PathVariable int id) {
        helpService.deleteHelp(id);
    }
}
