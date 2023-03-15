package ru.andrewtest.bookslibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andrewtest.bookslibrary.models.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByFullName(String fullName);
//    List<Person> findAll();
//
//    void addPerson(String fullName, Integer yearOfBirth);
//
//    Person findPersonById(int id);
//
//    void updatePerson(int personId, String fullName, Integer yearOfBirth);
//
//    void deletePerson(int personId);
}
