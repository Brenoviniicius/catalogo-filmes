package com.br.movies.domain.film;

import com.br.movies.domain.film.payloads.MovieRequest;
import com.br.movies.domain.film.payloads.MovieResponse;
import com.br.movies.exception.MovieNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;
    private final ModelMapper mapper;

    @Override
    public MovieResponse createMovie(MovieRequest movieRequest) {
        Movie movie = mapper.map(movieRequest, Movie.class);
        return  mapper.map(movieRepository.save(movie), MovieResponse.class);
    }
    @Override
    public MovieResponse getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with id: " + id));
        return mapper.map(movie, MovieResponse.class);
    }

    @Override
    public Page<MovieResponse> getAllMovies(Pageable pageable) {
        Page<Movie> moviesPage = movieRepository.findAllMovies(pageable);
        return moviesPage.map(movie -> mapper.map(movie, MovieResponse.class));
    }

    @Override
    public MovieResponse updateMovie(Long id, MovieRequest movieRequest) {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with id: " + id));

        Movie updatedMovie = mapper.map(movieRequest, Movie.class);
        updatedMovie.setId(existingMovie.getId());

        return mapper.map(movieRepository.save(updatedMovie), MovieResponse.class);
    }

    @Override
    public void deleteMovieById(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new MovieNotFoundException("Movie not found with id: " + id);
        }
        movieRepository.deleteById(id);
    }
}
