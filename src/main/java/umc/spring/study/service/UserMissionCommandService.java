package umc.spring.study.service;

import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.web.dto.UserRequestDTO;

public interface UserMissionCommandService {
    UserMission createUserMission(UserRequestDTO.UserMissionDTO request, Long userId,Long missionId);
}
