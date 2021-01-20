package com.tany.membership.annotation;

import com.auth0.jwt.interfaces.Payload;
import com.tany.membership.validator.CarNoValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Inherited
@Documented
@Constraint(validatedBy = CarNoValidator.class)
public @interface CheckCarNo {
	String message();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
