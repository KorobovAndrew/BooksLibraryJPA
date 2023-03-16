package ru.andrewtest.bookslibrary.factories;

import ru.andrewtest.bookslibrary.forms.BookDto1;
import ru.andrewtest.bookslibrary.forms.BookDto2;
import ru.andrewtest.bookslibrary.forms.BookDto3;
import ru.andrewtest.bookslibrary.models.Book;
import ru.andrewtest.bookslibrary.models.Person;

import java.util.Optional;

public class BookDtoFactory {
    public static BookDto1 createBookDto1(Book book) {
        return BookDto1.builder()
                .title(book.getTitle())
                .id(book.getId())
                .author(book.getAuthor())
                .yearOfWriting(book.getYearOfWriting())
                .build();
    }

    public static BookDto2 createBookDto2(Book book) {
        return BookDto2.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .yearOfWriting(book.getYearOfWriting())
                .build();
    }

    public static BookDto3 createBookDto3(Book book) {
        String personName;
        if (book.getPerson() == null)
            personName = null;
        else personName = book.getPerson().getFullName();
        return BookDto3.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getTitle())
                .yearOfWriting(book.getYearOfWriting())
                .personFullName(personName)
                .build();
    }
}
