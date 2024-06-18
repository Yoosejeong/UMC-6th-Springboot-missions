package umc.spring.study.converter;

import umc.spring.study.domain.FoodCategory;
import umc.spring.study.domain.mapping.UserFood;

import java.util.List;
import java.util.stream.Collectors;

public class UserPreferConverter {
    public static List<UserFood> toUserFoodList(List<FoodCategory> foodCategoryList){
        return foodCategoryList.stream()
                .map(foodCategory ->
                        UserFood.builder()
                                .foodCategory(foodCategory)
                                .build()
                        ).collect(Collectors.toList());
    }
}
