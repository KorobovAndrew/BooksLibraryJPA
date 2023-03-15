package ru.andrewtest.bookslibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andrewtest.bookslibrary.models.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBooksByPersonId(int personId);
//    List<Book> findAll();
//
//    List<Book> findBooksByPersonId(int personId);
//
//    void addBook(String title, String author, Integer yearOfWriting);
//
//    Book findBookById(int bookId);
//
//    void updateBook(String title, String author, Integer yearOfWriting, int bookId);
//
//    void deleteBookById(int bookId);
//
//    void deleteLinkOnPerson(int bookId);
//
//    void updateBorrowerId(String newBorrower, int bookId);
}
