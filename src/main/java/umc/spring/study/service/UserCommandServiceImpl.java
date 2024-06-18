package umc.spring.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.study.converter.UserConverter;
import umc.spring.study.converter.UserPreferConverter;
import umc.spring.study.domain.FoodCategory;
import umc.spring.study.domain.User;
import umc.spring.study.domain.mapping.UserFood;
import umc.spring.study.repository.FoodCategoryRepository;
import umc.spring.study.repository.UserRepository;
import umc.spring.study.web.dto.UserRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService{

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDTO request){
        User newUser = UserConverter.toUser(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());
        List<UserFood> userFoodList = UserPreferConverter.toUserFoodList(foodCategoryList);
        userFoodList.forEach(userFood -> {userFood.setUser(newUser);});
        return userRepository.save(newUser);
    }
}
