package umc.spring.study.service;

import umc.spring.study.domain.Region;

import java.util.Optional;

public interface RegionQueryService {
    Optional<Region> findRegion(Long id);
}
