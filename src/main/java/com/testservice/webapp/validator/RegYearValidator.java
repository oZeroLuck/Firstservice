package com.testservice.webapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class RegYearValidator implements ConstraintValidator<RegistrationYearConstraint, Integer> {

    @Override
    public void initialize(RegistrationYearConstraint constraintAnnotation) {}

    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate localDate = LocalDate.now();

        return localDate.getYear() <= year;
    }
}
