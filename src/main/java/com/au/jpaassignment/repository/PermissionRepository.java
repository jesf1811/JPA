package com.au.jpaassignment.repository;

import com.au.jpaassignment.model.Permission;
import com.au.jpaassignment.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface PermissionRepository extends JpaRepository<Permission,Integer> {

    @Query(value = "SELECT (*) FROM permissions", nativeQuery = true)
    List<Permission> getPermissionQuery();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO permissions (id,permission_level,user_id) VALUES (:permissionId,:permission_level,:user)", nativeQuery = true)
    Permission createPermissionQuery(@Param("permissionId") int permissionId, @Param("permission_level") int permissionLevel, @Param("user")User user);

    @Transactional
    @Modifying
    @Query("DELECT FROM permissions p WHERE p.id=:id")
    void deletePermissionQuery(@Param("id") int permissionId);
}
