package com.au.jpaassignment.repository;

import com.au.jpaassignment.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface PermissionRepository extends JpaRepository<Permission,Integer> {
}
