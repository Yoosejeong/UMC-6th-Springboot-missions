package umc.spring.study.service;

import umc.spring.study.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
}
