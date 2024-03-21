package it.epicode.gotneed.controllers;

import it.epicode.gotneed.exceptions.BadRequestException;
import it.epicode.gotneed.exceptions.LoginFaultException;
import it.epicode.gotneed.models.Girl;
import it.epicode.gotneed.models.GirlRequest;
import it.epicode.gotneed.models.LoginRequest;
import it.epicode.gotneed.security.JwtTools;
import it.epicode.gotneed.services.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private GirlService girlService;
    @Autowired
    private JwtTools jwtTools;

    @PostMapping("/auth/register")
    public Girl register(@RequestBody @Validated GirlRequest girlRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }
        return girlService.saveGirl(girlRequest);
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody @Validated LoginRequest loginRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }

        Girl girl = girlService.getGirlByUsername(loginRequest.getUsername());
        if (girl.getPassword().equals(loginRequest.getPassword())) {
           return jwtTools.createToken(girl);

        } else {
            throw new LoginFaultException("username/password errate");
        }
    }
}
