package umc.spring.study.converter;

import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;
import umc.spring.study.web.dto.StoreRequestDTO;
import umc.spring.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {
    public static StoreResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review){
        return StoreResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(StoreRequestDTO.ReviewDTO request){
        return Review.builder()
                .title(request.getTitle())
                .rating(request.getRating())
                .content(request.getContent())
                .build();
    }

    public static StoreResponseDTO.CreateMissionResultDTO toCreatedMissionResultDTO(Mission mission){
        return StoreResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(StoreRequestDTO.MissionDTO request){
        return Mission.builder()
                .deadline(request.getDeadline())
                .point(request.getPoint())
                .content(request.getContent())
                .build();
    }

    public static Store toStore(StoreRequestDTO.StoreDTO request){
        return Store.builder()
                .closed(request.getClosed())
                .open(request.getOpen())
                .star(request.getStar())
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }

    public static StoreResponseDTO.CreateStoreResultDTO toCreatedStoreResultDTO(Store store){
        return StoreResponseDTO.CreateStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
