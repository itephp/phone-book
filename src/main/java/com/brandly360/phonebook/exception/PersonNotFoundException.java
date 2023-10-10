package com.brandly360.phonebook.exception;

public class PersonNotFoundException extends Exception {

  public PersonNotFoundException(String name) {
    super("Person with name %s not found".formatted(name));
  }
}
