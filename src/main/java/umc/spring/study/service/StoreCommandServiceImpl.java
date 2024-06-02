package umc.spring.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.converter.StoreConverter;
import umc.spring.study.domain.Review;
import umc.spring.study.repository.ReviewRepository;
import umc.spring.study.repository.StoreRepository;
import umc.spring.study.repository.UserRepository;
import umc.spring.study.validation.annotation.ExistStore;
import umc.spring.study.web.dto.StoreRequestDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{
    private final ReviewRepository reviewRepository;

    private final UserRepository userRepository;

    private final StoreRepository storeRepository;

    @Override
    public Review createReview(Long userId, Long storeId, StoreRequestDTO.ReviewDTO request){
        Review review = StoreConverter.toReview(request);

        review.setUser(userRepository.findById(userId).get());

        review.setStore(storeRepository.findById(storeId).get());

        return reviewRepository.save(review);
    }

}
