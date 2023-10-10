package com.brandly360.phonebook.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<PhoneConstraint, String> {

  @Override
  public void initialize(PhoneConstraint phone) {
  }
  @Override
  public boolean isValid(String phoneField, ConstraintValidatorContext cxt) {
    return phoneField != null && phoneField.matches("[0-9]+")
        && (phoneField.length() > 8) && (phoneField.length() < 14);
  }

}
