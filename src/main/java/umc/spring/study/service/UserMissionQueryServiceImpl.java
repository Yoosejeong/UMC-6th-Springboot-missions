package umc.spring.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.repository.UserMissionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserMissionQueryServiceImpl implements UserMissionQueryService {

    private final UserMissionRepository userMissionRepository;

    @Override
    public Optional<UserMission> findUserMission(Long id) {
        return userMissionRepository.findById(id);
    }
}
