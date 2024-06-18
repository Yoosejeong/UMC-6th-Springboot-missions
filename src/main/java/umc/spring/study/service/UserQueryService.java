package umc.spring.study.service;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.User;

import java.util.Optional;

public interface UserQueryService {
    Optional<User> findUser(Long id);

    Page<Review> getReviewList(Long userId,Integer page);
}
