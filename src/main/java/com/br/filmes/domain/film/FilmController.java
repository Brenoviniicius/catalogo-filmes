package com.br.filmes.domain.film;

import com.br.filmes.domain.film.payloads.FilmRequest;
import com.br.filmes.domain.film.payloads.FilmResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/films")
@AllArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @PostMapping
    public ResponseEntity<FilmResponse> createFilm(@Valid @RequestBody FilmRequest filmRequest){
        return new ResponseEntity<>(filmService.createFilm(filmRequest), HttpStatus.CREATED);
    }

}
