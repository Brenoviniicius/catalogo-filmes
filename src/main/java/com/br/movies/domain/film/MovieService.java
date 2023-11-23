package com.br.movies.domain.film;

import com.br.movies.domain.film.payloads.MovieRequest;
import com.br.movies.domain.film.payloads.MovieResponse;

import java.util.List;

public interface MovieService {

    MovieResponse createMovie(MovieRequest movieRequest);

    MovieResponse getMovieById(Long id);

    List<MovieResponse> getAllMovies(int page, int size);

    MovieResponse updateMovie(Long id, MovieRequest movieRequest);

    void deleteMovieById(Long id);

}
