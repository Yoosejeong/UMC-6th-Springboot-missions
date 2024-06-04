package umc.spring.study.service;

import umc.spring.study.domain.User;

import java.util.Optional;

public interface UserQueryService {
    Optional<User> findUser(Long id);
}
