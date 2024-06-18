package umc.spring.study.converter;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.User;
import umc.spring.study.domain.enums.Gender;
import umc.spring.study.web.dto.StoreResponseDTO;
import umc.spring.study.web.dto.UserRequestDTO;
import umc.spring.study.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


    public static UserResponseDTO.UserReviewDTO userReviewDTO(Review review){
        return UserResponseDTO.UserReviewDTO.builder()
                .nickname(review.getUser().getName())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt().toLocalDate())
                .content(review.getContent())
                .build();
    }

    public static UserResponseDTO.UserReviewListDTO userReviewListDTO(Page<Review> reviewList){

        List<UserResponseDTO.UserReviewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(UserConverter::userReviewDTO).collect(Collectors.toList());

        return UserResponseDTO.UserReviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
    }



