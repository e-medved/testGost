package com.gostgroup.test.rest;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

/**
 * Created by e.medvedev on 27.01.2017.
 */
public class ValidationErrorBuilder {

  public static ValidationError fromBindingErrors(Errors errors) {
    ValidationError error = new ValidationError();
    for (ObjectError objectError : errors.getAllErrors()) {
      error.addValidationError(objectError.getDefaultMessage());
    }
    return error;
  }
}
