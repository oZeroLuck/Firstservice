package com.testservice.webapp.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = RegYearValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
public @interface RegistrationYearConstraint {
    String message() default "The registration year must be lower or equal of the current year";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
