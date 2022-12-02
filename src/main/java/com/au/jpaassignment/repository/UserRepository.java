package com.au.jpaassignment.repository;

import com.au.jpaassignment.model.Login;
import com.au.jpaassignment.model.User;
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
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "SELECT (*) FROM users",nativeQuery = true)
    List<User> findAllUsers();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users (id,address,contact_number,name,type,login_id) VALUES (:id,:address,:contactNo,:name,:type,:login)",nativeQuery = true)
    User createUser(@Param("id") int id, @Param("address") String address, @Param("contactNo") String contactNo, @Param("name") String name, @Param("type") String type, @Param("login") Login login);

    @Transactional
    @Modifying
    @Query("DELETE FROM #{#entityName} u WHERE u.id=:id")
    void deleteUser(@Param("id") int userId);
}
