package ru.andrewtest.bookslibrary.services;

import org.springframework.stereotype.Component;
import ru.andrewtest.bookslibrary.factories.PersonDtoFactory;
import ru.andrewtest.bookslibrary.forms.PersonDto1;
import ru.andrewtest.bookslibrary.models.Person;
import ru.andrewtest.bookslibrary.repositories.PersonRepository;

import java.util.List;

@Component
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public void save(String fullName, Integer yearOfBirth) {
        Person person = Person.builder()
                .fullName(fullName)
                .yearOfBirth(yearOfBirth)
                .build();
        personRepository.save(person);
    }

    @Override
    public Person findById(int personId) {
        return personRepository.findById(personId).orElse(null);
    }

    @Override
    public void update(int personId, String fullName, Integer yearOfBirth) {
        Person person = Person.builder()
                .id(personId)
                .fullName(fullName)
                .yearOfBirth(yearOfBirth)
                .build();
        personRepository.save(person);
    }

    @Override
    public void delete(int personId) {
        personRepository.deleteById(personId);
    }

    @Override
    public List<PersonDto1> findAllPersonDto1() {
        List<Person> people = personRepository.findAll();
        return people
                .stream()
                //.map(person -> PersonDtoFactory.createPersonDto1(person)) - стандартная запись
                .map(PersonDtoFactory::createPersonDto1) // - прокачанная запись
                .toList();
    }
}
