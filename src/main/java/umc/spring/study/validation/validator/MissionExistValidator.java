package umc.spring.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.repository.UserMissionRepository;
import umc.spring.study.validation.annotation.ExistMission;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistMission, Long> {


    private final UserMissionRepository userMissionRepository;

    @Override
    public void initialize(ExistMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        boolean exists = userMissionRepository.existsById(missionId);

        if (exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_EXISTS.toString()).addConstraintViolation();
            return false;
        }

        return true;
    }
}