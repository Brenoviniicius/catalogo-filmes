package com.br.movies.domain.film.payloads;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private Date year;
    private String image;
}
