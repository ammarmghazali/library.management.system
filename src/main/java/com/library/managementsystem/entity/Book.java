package com.library.managementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
//@Data
@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;
    private String title;
    private String author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "borrower_id")
    private Borrower borrower;
}
