package it.epicode.gotneed.security;

import it.epicode.gotneed.exceptions.UnAuthorizedException;
import it.epicode.gotneed.models.Girl;
import it.epicode.gotneed.services.GirlService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTools jwtTools;

    @Autowired
    private GirlService girlService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
     String authorization = request.getHeader("Authorization");

     if(authorization==null||authorization.equals("")|!authorization.startsWith("Bearer")){
         throw new UnAuthorizedException("Token non presente");
     }
     String token = authorization.substring(7);//bearer+ spazio sono 7 caratteri
     jwtTools.validateToken(token);
     String username = jwtTools.extractUsernameFromToken(token);
     Girl girl= girlService.getGirlByUsername(username);

     UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(girl, null);
     SecurityContextHolder.getContext().setAuthentication(authentication);

     filterChain.doFilter(request, response);

    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        AntPathMatcher matcher = new AntPathMatcher();
        return matcher.match("/auth/**", request.getServletPath()) ||
                matcher.match("/helps/**", request.getServletPath()) ||
                matcher.match("/girls/**", request.getServletPath());

    }


}
