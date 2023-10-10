package com.brandly360.phonebook.service;

import com.brandly360.phonebook.dto.PersonDTO;
import com.brandly360.phonebook.entity.Person;
import com.brandly360.phonebook.exception.PersonNotFoundException;
import com.brandly360.phonebook.repository.GroupRepository;
import com.brandly360.phonebook.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {

  private final PersonRepository personRepository;
  private final GroupRepository groupRepository;

  public PersonService(PersonRepository personRepository, GroupRepository groupRepository) {
    this.personRepository = personRepository;
    this.groupRepository = groupRepository;
  }

  @Override
  public List<Person> findAll() {
    return personRepository.findAllBy();
  }


  @Override
  public Person add(PersonDTO personDTO) {
    var person = new Person();
    person.setName(personDTO.getName());
    person.setPhone(personDTO.getPhones());
    personRepository.save(person);

    return person;
  }

  @Override
  public Person getByName(String name) throws PersonNotFoundException {
    return personRepository.findOneByName(name)
        .orElseThrow(() -> new PersonNotFoundException(name));
  }

  @Override
  public void remove(String name) {
    Optional<Person> person = personRepository.findOneByName(name);
    person.ifPresent(personRepository::delete);
  }
}
