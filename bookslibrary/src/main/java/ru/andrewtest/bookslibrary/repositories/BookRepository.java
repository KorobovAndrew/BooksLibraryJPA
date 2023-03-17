package ru.andrewtest.bookslibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andrewtest.bookslibrary.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
