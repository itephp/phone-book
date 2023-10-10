package com.brandly360.phonebook.dto;

import com.brandly360.phonebook.validator.PhoneConstraint;
import jakarta.validation.constraints.NotEmpty;

public class PersonDTO {
  @NotEmpty
  private String name;

  @PhoneConstraint()
  private String phone;

  public String getName() {
    return name;
  }

  public String getPhones() {
    return phone;
  }

}
