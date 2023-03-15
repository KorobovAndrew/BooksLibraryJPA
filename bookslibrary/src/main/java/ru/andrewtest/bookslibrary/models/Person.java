package ru.andrewtest.bookslibrary.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "year_of_birth")
    private Integer yearOfBirth;
    @OneToMany(mappedBy = "person") //указываем поле класса Book? не колонку в таблице?
    List<Book> books;
}
