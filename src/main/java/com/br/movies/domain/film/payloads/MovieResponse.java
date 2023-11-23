package com.br.movies.domain.film.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {

    private Long id;
    private String title;
    private String description;
    private List<String> categories;
    private String ageRating;
    private Date year;
    private String image;
}
