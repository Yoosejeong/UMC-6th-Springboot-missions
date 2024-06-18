package umc.spring.study.converter;

import umc.spring.study.domain.User;
import umc.spring.study.domain.enums.Gender;
import umc.spring.study.web.dto.UserRequestDTO;
import umc.spring.study.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {
    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDTO request){
        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;

        }

        return User.builder()
                .address(request.getAddress())
                .gender(gender)
                .name(request.getName())
                .userFoodList(new ArrayList<>())
                .build();
    }
}
