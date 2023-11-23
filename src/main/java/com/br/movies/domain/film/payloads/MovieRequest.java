package com.br.movies.domain.film.payloads;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {

    @NotBlank(message = "title must not be blank")
    @Pattern(regexp = "^(?!\\s)[\\p{L}\\d]+(?:[\\s-][\\p{L}\\d]+)*$", message = "title should only contain letters, numbers, and spaces")
    private String title;

    @NotBlank(message = "description must not be blank")
    private String description;

    @NotBlank(message = "category must not be blank")
    @Pattern(regexp = "^(?!\\s)[\\p{L}\\d]+(?:[\\s-][\\p{L}\\d]+)*$", message = "category should only contain letters, numbers, and spaces")
    private String category;

    @NotBlank(message = "Age Rating must not be blank")
    @Pattern(regexp = "^(?!\\s)[\\p{L}\\d]+(?:[\\s-][\\p{L}\\d]+)*$", message = "Age Rating should only contain letters, numbers, and spaces")
    private String ageRating;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private Date year;

    @URL(message = "Image should be a valid URL")
    private String image;
}
