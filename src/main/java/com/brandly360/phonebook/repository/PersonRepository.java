package com.brandly360.phonebook.repository;

import com.brandly360.phonebook.entity.Person;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

  List<Person> findAllBy();

  Optional<Person> findOneByName(String name);

}
