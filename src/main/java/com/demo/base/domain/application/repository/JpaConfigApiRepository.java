package com.demo.base.domain.application.repository;

import com.demo.base.domain.application.entity.JpaConfigApi;
import lombok.NonNull;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaConfigApiRepository extends JpaRepository<JpaConfigApi, UUID> {
    String CACHE_NAME = "jpaMetricsGlassnode"; // remove cache metrics glassnode

    List<JpaConfigApi> findAllByIntervalAndStatusIsTrue(JpaConfigApi.IntervalType type);

    List<JpaConfigApi> findAllByStatusIsTrue();

    List<JpaConfigApi> findAllByStatusIsTrueAndAndIntervalIs(@NonNull JpaConfigApi.IntervalType interval);

    Page<JpaConfigApi> findByNameContains(String name, Pageable pageable);

    @NonNull
    @Caching(evict = {@CacheEvict(value = CACHE_NAME, key = "{'findAllByApiId', #entity.id.toString()}")})
    @Override
    <S extends JpaConfigApi> S save(S entity);
}
