package umc.spring.study.service;


import umc.spring.study.domain.mapping.UserMission;

import java.util.Optional;

public interface UserMissionQueryService {
    Optional<UserMission> findUserMission(Long id);
}
