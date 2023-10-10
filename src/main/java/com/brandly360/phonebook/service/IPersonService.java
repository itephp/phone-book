package com.brandly360.phonebook.service;

import com.brandly360.phonebook.dto.PersonDTO;
import com.brandly360.phonebook.entity.Person;
import com.brandly360.phonebook.exception.PersonNotFoundException;
import java.util.List;

public interface IPersonService {

  List<Person> findAll();

  Person add(PersonDTO personDTO);

  Person getByName(String name) throws PersonNotFoundException;

  void remove(String name);
}
