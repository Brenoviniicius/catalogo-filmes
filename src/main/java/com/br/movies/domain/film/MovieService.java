package com.br.movies.domain.film;

import com.br.movies.domain.film.payloads.MovieRequest;
import com.br.movies.domain.film.payloads.MovieResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {

    MovieResponse createMovie(MovieRequest movieRequest);

    MovieResponse getMovieById(Long id);

    Page<MovieResponse> getAllMovies(Pageable pageable);

    MovieResponse updateMovie(Long id, MovieRequest movieRequest);

    void deleteMovieById(Long id);

}
