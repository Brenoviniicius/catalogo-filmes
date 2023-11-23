package com.br.filmes.domain.film.payloads;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmResponse {

    private Long id;
    private String title;
    private String description;
    private String category;
    private String ageRating;
    private Date year;
    private String image;
}
