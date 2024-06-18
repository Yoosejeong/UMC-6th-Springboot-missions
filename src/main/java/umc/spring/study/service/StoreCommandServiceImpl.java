package umc.spring.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.converter.StoreConverter;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;
import umc.spring.study.repository.*;
import umc.spring.study.web.dto.StoreRequestDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{
    private final ReviewRepository reviewRepository;

    private final UserRepository userRepository;

    private final StoreRepository storeRepository;

    private final MissionRepository missionRepository;

    private final RegionRepository regionRepository;
    @Override
    public Review createReview(Long userId, Long storeId, StoreRequestDTO.ReviewDTO request){
        Review review = StoreConverter.toReview(request);

        review.setUser(userRepository.findById(userId).get());

        review.setStore(storeRepository.findById(storeId).get());

        return reviewRepository.save(review);
    }

    @Override
    public Mission createMission(Long storeId, StoreRequestDTO.MissionDTO request){
        Mission mission = StoreConverter.toMission(request);

        mission.setStore(storeRepository.findById(storeId).get());

        return missionRepository.save(mission);
    }

    @Override
    public Store createStore(Long regionId, StoreRequestDTO.StoreDTO request){
        Store store = StoreConverter.toStore(request);

        store.setRegion(regionRepository.findById(regionId).get());

        return storeRepository.save(store);
    }

}
