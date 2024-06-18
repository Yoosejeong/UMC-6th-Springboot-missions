package umc.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.StoreConverter;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;
import umc.spring.study.service.StoreCommandService;
import umc.spring.study.validation.annotation.ExistRegion;
import umc.spring.study.validation.annotation.ExistStore;
import umc.spring.study.validation.annotation.ExistUser;
import umc.spring.study.web.dto.StoreRequestDTO;
import umc.spring.study.web.dto.StoreResponseDTO;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

   private final StoreCommandService storeCommandService;
    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.CreateReviewResultDTO> createReview(@RequestBody @Valid StoreRequestDTO.ReviewDTO request,
                                                                            @ExistStore  @PathVariable(name = "storeId") Long storeId,
                                                                            @ExistUser @RequestParam(name = "userId") Long userId){
        Review review = storeCommandService.createReview(userId, storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateReviewResultDTO(review));
    }

    @PostMapping("/{storeId}/mission")
    public ApiResponse<StoreResponseDTO.CreateMissionResultDTO> createMission(@RequestBody @Valid StoreRequestDTO.MissionDTO request,
                                                                             @ExistStore @PathVariable(name= "storeId") Long storeId){
        Mission mission = storeCommandService.createMission(storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreatedMissionResultDTO(mission));
    }

    @PostMapping("/{regionId}")
    public ApiResponse<StoreResponseDTO.CreateStoreResultDTO> createdStore(@RequestBody @Valid StoreRequestDTO.StoreDTO request,
                                                                           @ExistRegion @PathVariable(name = "regionId") Long regionId) {
        Store store = storeCommandService.createStore(regionId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreatedStoreResultDTO(store));
    }

}

