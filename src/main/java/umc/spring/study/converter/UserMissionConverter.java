package umc.spring.study.converter;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.User;
import umc.spring.study.domain.enums.Gender;
import umc.spring.study.domain.enums.MissionStatus;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.web.dto.StoreResponseDTO;
import umc.spring.study.web.dto.UserRequestDTO;
import umc.spring.study.web.dto.UserResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static UserResponseDTO.UserMissionDTO userMissionDTO (UserMission userMission){
        return  UserResponseDTO.UserMissionDTO.builder()
                .store(userMission.getMission().getStore().getName())
                .deadline(userMission.getMission().getDeadline())
                .point(userMission.getMission().getPoint())
                .content(userMission.getMission().getContent())
                .build();
    }

    public static UserResponseDTO.UserMissionListDTO userMissionListDTO(Page<UserMission> missionList){
        List<UserResponseDTO.UserMissionDTO> userMissionDTOList = missionList.stream()
                .map(UserMissionConverter::userMissionDTO).collect(Collectors.toList());


        return UserResponseDTO.UserMissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize( userMissionDTOList.size())
                .missionList(userMissionDTOList)
                .build();

    }
}
