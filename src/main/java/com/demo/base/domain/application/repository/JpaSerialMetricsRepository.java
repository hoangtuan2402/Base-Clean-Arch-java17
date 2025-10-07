package com.demo.base.domain.application.repository;

import com.demo.base.domain.application.entity.JpaSerialMetrics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaSerialMetricsRepository extends JpaRepository<JpaSerialMetrics, UUID> {
    List<JpaSerialMetrics> findAllByIdIn(List<UUID> id);
    Page<JpaSerialMetrics> findByNameContains(String name, Pageable pageable);
}
