package com.demo.base.domain.application.repository;

import com.demo.base.domain.application.entity.JpaChart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaChartRepository extends JpaRepository<JpaChart, UUID> {
    List<JpaChart> findAllByIdIn(List<UUID> idCharts);

    Page<JpaChart> findByNameContains(String name, Pageable pageable);
}
