package com.tany.membership.annotation;

import com.auth0.jwt.interfaces.Payload;
import com.tany.membership.validator.IdCardValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Inherited
@Documented
@Constraint(validatedBy = IdCardValidator.class)
public @interface CheckIDCard {
	String message();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
