package it.epicode.gotneed.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import it.epicode.gotneed.exceptions.UnAuthorizedException;
import it.epicode.gotneed.models.Girl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;
import java.util.Date;

@Component //eseguita direttamente da Spring, creazione del token
@PropertySource("application.properties")
public class JwtTools {
    @Value("${spring.jwt.secret}")
    private String secret;
    @Value("${spring.jwt.expirationMs}")
    private String expirationMs;

    public String createToken(Girl girl) {//token creato con: utente, data emissione, data scadenza, firma=criptaggio, metodo compact
        return Jwts.builder().subject(girl.getUsername()).issuedAt(new Date(System.currentTimeMillis())).expiration(new Date(System.currentTimeMillis() + Long.parseLong(expirationMs))).signWith(Keys.hmacShaKeyFor(secret.getBytes())).compact();

    }

    public void validateToken(String token) {//verifica della validità del token attraverso la chiave segreta che ricripta verificando che l'hash prodotto sia uguale all'hash del token
        try {
            Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).build().parse(token);

        } catch (Exception e) {
            throw new UnAuthorizedException(e.getMessage());
        }
    }
    public String extractUsernameFromToken (String token) {//estrae l'utente estraendo il Payload, cioè il body, che contiene tutte le info sull'utente, consentendoci di "riconoscerlo" e dargli i permessi; parse= decodifica
            return Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).build().parseSignedClaims(token).getPayload().getSubject();
    }
    }