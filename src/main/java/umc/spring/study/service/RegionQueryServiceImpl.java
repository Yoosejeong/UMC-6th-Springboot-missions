package umc.spring.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.domain.Region;
import umc.spring.study.repository.RegionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionQueryServiceImpl implements RegionQueryService {

    private final RegionRepository regionRepository;
    @Override
    public Optional<Region> findRegion(Long id){
        return regionRepository.findById(id);
    }
}
