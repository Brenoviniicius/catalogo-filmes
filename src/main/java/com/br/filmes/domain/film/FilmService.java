package com.br.filmes.domain.film;

import com.br.filmes.domain.film.payloads.FilmRequest;
import com.br.filmes.domain.film.payloads.FilmResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;
    private final ModelMapper mapper;
    public FilmResponse createFilm(FilmRequest filmRequest) {
        Film film = mapper.map(filmRequest, Film.class);
        return  mapper.map(filmRepository.save(film), FilmResponse.class);
    }


}
