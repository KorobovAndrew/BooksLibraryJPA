package ru.andrewtest.bookslibrary.models;

import jakarta.persistence.*;
import lombok.*;

import javax.print.attribute.standard.MediaSize;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "year_of_writing")
    private Integer yearOfWriting;

    @ManyToOne
    @JoinColumn(name = "borrower_id")
    Person person;
}
