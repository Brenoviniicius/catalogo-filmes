package com.br.movies.domain.film;

import com.br.movies.domain.film.payloads.MovieRequest;
import com.br.movies.domain.film.payloads.MovieResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/movies")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponse> createMovie(@Valid @RequestBody MovieRequest movieRequest){
        return new ResponseEntity<>(movieService.createMovie(movieRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable Long id) {
        return new ResponseEntity<>(movieService.getMovieById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<MovieResponse>> getAllMovies(Pageable pageable) {
        return new ResponseEntity<>(movieService.getAllMovies(pageable), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> updateCar(@PathVariable Long id, @Valid @RequestBody MovieRequest movieRequest) {
        MovieResponse updatedCar = movieService.updateMovie(id, movieRequest);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovieById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
