package com.brandly360.phonebook.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group {

  @Id
  @Column(nullable = false)
  private Long id;

  @Column
  private String name;

  @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "group")
  private Set<Person> persons;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

}