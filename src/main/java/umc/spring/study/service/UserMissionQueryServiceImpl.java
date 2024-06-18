package umc.spring.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.domain.User;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.repository.UserMissionRepository;
import umc.spring.study.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserMissionQueryServiceImpl implements UserMissionQueryService {

    private final UserMissionRepository userMissionRepository;

    private final UserRepository userRepository;

    @Override
    public Optional<UserMission> findUserMission(Long id) {
        return userMissionRepository.findById(id);
    }

    @Override
    public Page<UserMission> getMissionList(Long userId, Integer page){
        User user = userRepository.findById(userId).get();

        Page<UserMission> UserPage = userMissionRepository.findAllByUser(user, PageRequest.of(page, 10));
        return UserPage;
    }
}
