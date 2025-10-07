package com.demo.base.domain.application.repository;

import com.demo.base.domain.application.entity.JpaMetrics;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaMetricsRepository extends JpaRepository<JpaMetrics, UUID> {
    String CACHE_NAME = "jpaMetricsGlassnode";

    @Cacheable(value = CACHE_NAME, key = "{'findAllByApiId', #apiId.toString()}")
    List<JpaMetrics> findAllByApiIdOrderByTimeAsc(UUID apiId);

    @Modifying
    @Caching(evict = {@CacheEvict(value = CACHE_NAME, key = "{'findAllByApiId', #apiId.toString()}")})
    @Query("delete from JpaMetrics where apiId = ?1")
    void clearDataByApiId(UUID apiId);

    Optional<JpaMetrics> findJpaMetricsTimeValueByTimeAndApiId(LocalDateTime time, UUID apiId);

    @NotNull
    @Caching(evict = {@CacheEvict(value = CACHE_NAME, key = "{'findAllByApiId', #entity.apiId.toString()}")})
    @Override
    <S extends JpaMetrics> S save(@NonNull S entity);

    @NonNull
    @CacheEvict(cacheNames = CACHE_NAME, allEntries = true)
    @Override
    <S extends JpaMetrics> List<S> saveAll(@NonNull Iterable<S> entities);


}
