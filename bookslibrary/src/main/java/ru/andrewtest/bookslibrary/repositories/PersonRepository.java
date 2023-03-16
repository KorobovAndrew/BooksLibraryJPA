package ru.andrewtest.bookslibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andrewtest.bookslibrary.models.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByFullName(String fullName);
}
