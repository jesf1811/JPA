package com.au.jpaassignment.repository;

import com.au.jpaassignment.model.Login;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface LoginRepository extends JpaRepository<Login,Integer> {
    @Query(value = "SELECT (*) from logins",nativeQuery = true)
    List<Login> getLoginQuery();

    @Transactional
    @Modifying
    @Query(value="INSERT INTO logins (id,is_active,password) VALUES (:id,:is_active,:password)",nativeQuery = true)
    Login createLoginQuery(@Param("id") int loginId, @Param("is_active") boolean is_active, @Param("password") String password);

    @Transactional
    @Modifying
    @Query(value="DELETE FROM logins l WHERE l.id=:id")
    void deleteLoginQuery(@Param("id") int loginId);

}
