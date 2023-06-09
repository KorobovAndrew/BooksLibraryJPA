package ru.andrewtest.bookslibrary.factories;

import ru.andrewtest.bookslibrary.forms.PersonDto1;
import ru.andrewtest.bookslibrary.models.Person;

public class PersonDtoFactory {
    public static PersonDto1 createPersonDto1(Person person) {
        return PersonDto1.builder()
                .fullName(person.getFullName())
                .yearOfBirth(person.getYearOfBirth())
                .build();
    }
}
