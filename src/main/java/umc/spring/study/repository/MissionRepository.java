package umc.spring.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.study.domain.Mission;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
}
