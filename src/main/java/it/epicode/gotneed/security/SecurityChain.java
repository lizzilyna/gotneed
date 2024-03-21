package it.epicode.gotneed.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration //tipo particolare di component eseguito in automatico da Spring
@EnableWebSecurity (debug = true)
public class SecurityChain {
    @Autowired
    private JwtTools jwtTools;
    @Autowired
    private JwtFilter jwtFilter;
    @Bean //è richiamato da Spring in automatico a ogni richiesta http, prima del controller; nel metodo applico a http dei filtri
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.csrf(AbstractHttpConfigurer::disable);
    httpSecurity.cors(AbstractHttpConfigurer::disable);
    httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    httpSecurity.authorizeHttpRequests(request->request.requestMatchers("/auth/**").permitAll());
    httpSecurity.authorizeHttpRequests(request->request.requestMatchers("/girls/**").permitAll());
    httpSecurity.authorizeHttpRequests(request->request.requestMatchers("/**").denyAll());
    return  httpSecurity.build();
    }

}
