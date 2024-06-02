package umc.spring.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.study.validation.annotation.ExistCategories;

import java.util.List;

public class StoreRequestDTO {
    @Getter
    public static class ReviewDTO{
        @NotBlank
        String title;
        @NotBlank
        String content;
        @NotNull
        Float rating;

    }
}