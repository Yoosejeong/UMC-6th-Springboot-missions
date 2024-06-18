package umc.spring.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.mapping.UserMission;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
}
