package umc.spring.study.validation.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.study.validation.validator.CategoriesExistValidator;
import umc.spring.study.validation.validator.PageCheckValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageCheckValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {

    String message() default "페이지가 너무 작습니다.(0이하)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
