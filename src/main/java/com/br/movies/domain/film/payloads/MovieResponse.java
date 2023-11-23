package com.br.movies.domain.film.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {

    private Long id;
    private String title;
    private String description;
    private String category;
    private String ageRating;
    private Date year;
    private String image;
}
