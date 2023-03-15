package ru.andrewtest.bookslibrary.services;

import org.springframework.stereotype.Component;
import ru.andrewtest.bookslibrary.factories.BookDtoFactory;
import ru.andrewtest.bookslibrary.forms.BookDto1;
import ru.andrewtest.bookslibrary.forms.BookDto2;
import ru.andrewtest.bookslibrary.models.Book;
import ru.andrewtest.bookslibrary.models.Person;
import ru.andrewtest.bookslibrary.repositories.BookRepository;
import ru.andrewtest.bookslibrary.repositories.PersonRepository;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final PersonRepository personRepository;

    public BookServiceImpl(BookRepository bookRepository, PersonRepository personRepository) {
        this.bookRepository = bookRepository;
        this.personRepository = personRepository;
    }

    @Override
    public List<BookDto1> findAllBookDto1() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(BookDtoFactory::createBookDto1)
                .toList();
    }

    @Override
    public void addBook(String title, String author, Integer yearOfWriting) {
        Book book = Book.builder()
                .title(title)
                .author(author)
                .yearOfWriting(yearOfWriting)
                .build();
        bookRepository.save(book);
    }

    @Override
    public Book findBookById(int bookId) {
        return bookRepository.getReferenceById(bookId);
    }

    @Override
    public BookDto1 findBookDto1ById(int bookId) {
        Book book = bookRepository.getReferenceById(bookId);
        return BookDtoFactory.createBookDto1(book);
    }

    @Override
    public void updateBook(String title, String author, Integer yearOfWriting, int bookId) {
        Book book = Book.builder()
                .title(title)
                .author(author)
                .yearOfWriting(yearOfWriting)
                .id(bookId)
                .build();
        bookRepository.save(book);
    }

    @Override
    public void deleteBookById(int bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public List<BookDto2> findAllBookDto2ByPersonId(int personId) {
        List<Book> books = bookRepository.findBooksByPersonId(personId);
        return books.stream()
                .map(BookDtoFactory::createBookDto2)
                .toList();
    }

    @Override
    public void deleteLinkOnPerson(int bookId) {
        Book book = bookRepository.getReferenceById(bookId);
        book.setPerson(null);
        bookRepository.save(book);
    }

    @Override
    public void updateBorrowerId(String newBorrower, int bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        Person person = personRepository.findByFullName(newBorrower);
        book.setPerson(person);
        bookRepository.save(book);
    }
}
