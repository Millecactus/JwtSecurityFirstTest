package com.example.testJWT.config;

import com.example.testJWT.dto.UserDto;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor //créer un constrcuteur avec uniquement tout les champs déclarés "finaux"

//OncePerRequestFilter car je veux qu'a chaque fois que j'effectue une requete, le filtre s'actionne
public class JwtAuthentificationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    //ajout de @NonNull car : une requete ne peut pas etre nulle (logique) sinon on lance un exception car
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
    final String AuthHeader= request.getHeader("Authorization"); // lors d'une requete, on veut extraire le header de l'autorisation (en gros le bearer)
    String jwt = AuthHeader;
    final String userEmail;
    if (AuthHeader ==null || !AuthHeader.startsWith("Bearer")){
        filterChain.doFilter(request,response); //si le token ne commence pas par Bearer, le filtre passera a la requete suivante
        return; //ne pas oublier le retour : on ne veut plus continuer  a tout scanner et donc on retour arriere
    }
    jwt= AuthHeader.substring(7);//supprime le préfixe "Bearer"
    userEmail = jwtService.extractUserEmail(jwt);//todo:extract te userEmail from JWT;
    }
}
