package com.testservice.webapp.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LicencePlateValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
public @interface PlateConstraint {
    String message() default "Invalid plate";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
