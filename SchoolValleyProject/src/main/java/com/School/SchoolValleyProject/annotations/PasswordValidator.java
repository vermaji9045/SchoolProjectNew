package com.School.SchoolValleyProject.annotations;
import com.School.SchoolValleyProject.validations.PasswordStragthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordStragthValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidator {

    String message() default "Please chose Strong Password";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

