package it.epicode.gotneed.controllers;

import it.epicode.gotneed.models.Help;
import it.epicode.gotneed.models.HelpRequest;
import it.epicode.gotneed.models.HelpType;
import it.epicode.gotneed.security.JwtTools;
import it.epicode.gotneed.services.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class HelpController {
    @Autowired
    private HelpService helpService;

    @Autowired
    private JwtTools jwtTools;

    @GetMapping("/helps")
    public Page<Help> getAllHelps(Pageable pageable){
        return helpService.getAllHelps(pageable);
    }

    @GetMapping("/helps/requested")
    public Page<Help> getRequestedHelpByProvincia(@RequestParam String provincia, Pageable pageable) {
        return helpService.getRequestedHelpByProvincia(provincia, pageable);

    }
    @GetMapping("/helps/offered")
    public Page<Help> getOfferedHelpByProvincia(@RequestParam String provincia, Pageable pageable) {
        return helpService.getOfferedHelpByProvincia(provincia, pageable);
    }

    @GetMapping ("/helps/{id}")
    public Help getById(@PathVariable int id) {
        return helpService.getHelpById(id);
    }

    @GetMapping("/helps/types")
    public ResponseEntity<HelpType[]> getHelpTypes() {
        return ResponseEntity.ok(HelpType.values());
    }

    @PostMapping
    public Help saveHelp (@RequestBody HelpRequest helpRequest) {
        return helpService.saveHelp(helpRequest);

    }

    @PutMapping("/helps/{id}")
    public Help updateHelp(@PathVariable int id, @RequestBody HelpRequest helpRequest){
        return helpService.updateHelp(id, helpRequest);
    }

    @DeleteMapping("helps/{id}")
    public void deleteHelp(@PathVariable int id) {
        helpService.deleteHelp(id);
    }
}
