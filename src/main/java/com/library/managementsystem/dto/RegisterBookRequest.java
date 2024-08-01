package com.library.managementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterBookRequest {


    @NotBlank(message = "ISBN is mandatory")
    private String isbn;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Author is mandatory")
    private String author;

    private Long borrowerId;
}
