package ru.andrewtest.bookslibrary.forms;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto3 {
    private int id;
    private String title;
    private String author;
    private Integer yearOfWriting;
    private String personFullName;
}
