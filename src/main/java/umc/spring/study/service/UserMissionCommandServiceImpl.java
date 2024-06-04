package umc.spring.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.converter.UserMissionConverter;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.repository.MissionRepository;
import umc.spring.study.repository.UserMissionRepository;
import umc.spring.study.repository.UserRepository;
import umc.spring.study.web.dto.UserRequestDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService{


    private final UserRepository userRepository;


    private final MissionRepository missionRepository;

     private final UserMissionRepository userMissionRepository;

    @Override
    public UserMission createUserMission(UserRequestDTO.UserMissionDTO request, Long userId,Long missionId){
        UserMission userMission = UserMissionConverter.toUserMission(request);

        userMission.setUser(userRepository.findById(userId).get());

        userMission.setMission(missionRepository.findById(missionId).get());

        return userMissionRepository.save(userMission);
    }

}
