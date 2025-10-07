package com.demo.base.domain.application.repository;

import com.demo.base.domain.application.entity.JpaRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaRoleRepository extends JpaRepository<JpaRole, UUID> {
    List<JpaRole> findAllByNameIn(List<String> roleName);

    List<JpaRole> findAllByIdIn(List<UUID> roleId);

    List<JpaRole> findAllByStatusIs(Boolean status);
}
