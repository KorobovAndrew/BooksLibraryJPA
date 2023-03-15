package ru.andrewtest.bookslibrary.services;

import org.springframework.stereotype.Component;
import ru.andrewtest.bookslibrary.factories.PersonDtoFactory;
import ru.andrewtest.bookslibrary.forms.PersonDto1;
import ru.andrewtest.bookslibrary.forms.PersonDto2;
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
    public List<Person> findAllPeople() {
        return personRepository.findAll();
    }

    @Override
    public void addPerson(String fullName, Integer yearOfBirth) {
        Person person = Person.builder()
                .fullName(fullName)
                .yearOfBirth(yearOfBirth)
                .build();
        personRepository.save(person);
    }

    @Override
    public Person findPersonById(int personId) {
//        if (personId == 0)
//            return null;
        return personRepository.findById(personId).orElse(null);
    }

    @Override
    public void updatePerson(int personId, String fullName, Integer yearOfBirth) {
        Person person = Person.builder()
                .id(personId)
                .fullName(fullName)
                .yearOfBirth(yearOfBirth)
                .build();
        personRepository.save(person);
    }

    @Override
    public void deletePerson(int personId) {
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
