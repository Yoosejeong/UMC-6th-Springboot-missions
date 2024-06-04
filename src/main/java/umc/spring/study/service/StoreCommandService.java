package umc.spring.study.service;

import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;
import umc.spring.study.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Review createReview(Long userId, Long storeId, StoreRequestDTO.ReviewDTO request);

    Mission createMission(Long storeId, StoreRequestDTO.MissionDTO request);

    Store createStore(Long regionId, StoreRequestDTO.StoreDTO request);
}
