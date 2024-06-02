package umc.spring.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.study.domain.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
