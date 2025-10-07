package com.demo.base.domain.application.repository;

import com.demo.base.domain.application.entity.JpaDashboard;
import com.demo.base.domain.application.entity.JpaRole;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaDashboardRepository extends JpaRepository<JpaDashboard, UUID> {
    static final String CACHE_NAME = "dashboard";

    @Cacheable(value = CACHE_NAME, key = "{'findDashboardByPermission', #roles.toString()}")
    List<JpaDashboard> findAllByRolesInAndStatusIsTrueOrderByName(List<JpaRole> roles);

    Page<JpaDashboard> findByNameContains(String name, Pageable pageable);


    @NonNull
    @CacheEvict(cacheNames = CACHE_NAME, allEntries = true)
    @Override
    <S extends JpaDashboard> List<S> saveAll(@NotNull Iterable<S> entities);

    @CacheEvict(cacheNames = CACHE_NAME, allEntries = true)
    @Override
    void deleteAllInBatch();
}
