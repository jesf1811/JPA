package com.au.jpaassignment.repository;

import com.au.jpaassignment.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface LoginRepository extends JpaRepository<Login,Integer> {
}
