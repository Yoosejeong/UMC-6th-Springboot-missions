package umc.spring.study.converter;

import umc.spring.study.domain.User;
import umc.spring.study.domain.enums.Gender;
import umc.spring.study.domain.enums.MissionStatus;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.web.dto.UserRequestDTO;
import umc.spring.study.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserMissionConverter {
    public static UserResponseDTO.UserMissionResultDTO toUserMissionResultDTO(UserMission userMission){
        return UserResponseDTO.UserMissionResultDTO.builder()
                .UserMissionId(userMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static UserMission toUserMission(UserRequestDTO.UserMissionDTO request){
        MissionStatus missionStatus = null;

        switch (request.getMissionStatus()){
            case 1:
                missionStatus = MissionStatus.CHALLENGING;
                break;
            case 2:
                missionStatus = MissionStatus.COMPLETE;
                break;


        }

        return UserMission.builder()
                .missionStatus(missionStatus)
                .build();
    }
}
