package umc.spring.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.spring.study.domain.User;
import umc.spring.study.domain.mapping.UserMission;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    @Query(value = "SELECT um FROM UserMission um WHERE um.user = :user AND um.missionStatus = 'CHALLENGING'")
    Page<UserMission> findAllByUser(@Param("user") User user, PageRequest pageRequest);
}
