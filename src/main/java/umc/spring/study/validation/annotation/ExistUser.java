package umc.spring.study.validation.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.study.validation.validator.UserExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistUser {

    String message() default "해당하는 회원이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
