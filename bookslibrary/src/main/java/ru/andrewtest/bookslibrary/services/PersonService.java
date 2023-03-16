package ru.andrewtest.bookslibrary.services;

import ru.andrewtest.bookslibrary.forms.PersonDto1;
import ru.andrewtest.bookslibrary.models.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();

    void save(String fullName, Integer yearOfBirth);

    Person findById(int personId);

    void update(int personId, String fullName, Integer yearOfBirth);

    void delete(int personId);

    List<PersonDto1> findAllPersonDto1();
}
