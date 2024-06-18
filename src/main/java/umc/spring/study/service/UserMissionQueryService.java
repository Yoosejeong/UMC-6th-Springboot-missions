package umc.spring.study.service;


import org.springframework.data.domain.Page;
import umc.spring.study.domain.mapping.UserMission;

import java.util.Optional;

public interface UserMissionQueryService {
    Optional<UserMission> findUserMission(Long id);

    Page<UserMission> getMissionList(Long userId, Integer page);
}
