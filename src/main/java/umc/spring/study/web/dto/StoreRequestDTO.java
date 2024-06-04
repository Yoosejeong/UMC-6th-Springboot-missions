package umc.spring.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;


public class StoreRequestDTO {

    @Getter
    public static class StoreDTO{
        LocalTime closed;
        LocalTime open;
        Float star;
        @NotBlank
        String name;
        @NotBlank
        String address;
    }
    @Getter
    public static class ReviewDTO{
        @NotBlank
        String title;
        @NotBlank
        String content;
        @NotNull
        Float rating;

    }

    @Getter
    public static class MissionDTO{

        LocalDate deadline;
        @NotNull
        int point;
        @NotBlank
        String content;
    }


}
