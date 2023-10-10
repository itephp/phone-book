package com.brandly360.phonebook.repository;

import com.brandly360.phonebook.entity.Group;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

  public Optional<Group> findOneByName(String name);
}