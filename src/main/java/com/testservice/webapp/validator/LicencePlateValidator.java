package com.testservice.webapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LicencePlateValidator implements ConstraintValidator<PlateConstraint, String> {

    @Override
    public void initialize(PlateConstraint plateConstraint) {}

    @Override
    public boolean isValid(String plate, ConstraintValidatorContext cxt) {
        return plate.matches("/[A-Z]{2}\\d{3}[A-Z]{2}/gm");
    }
}
