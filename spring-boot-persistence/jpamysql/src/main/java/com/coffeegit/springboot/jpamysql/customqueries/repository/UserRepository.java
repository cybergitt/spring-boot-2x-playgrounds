package com.coffeegit.springboot.jpamysql.customqueries.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coffeegit.springboot.jpamysql.customqueries.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    /*
     * Query using JPQL
     * SELECT FROM {Model/Table Class}
     */    
    @Query("SELECT u FROM User u WHERE u.status = 1")
    List<User> findAllActiveUers();

    /*
     * Query using Native
     */ 
    @Query(value = "SELECT * FROM users as u WHERE u.status = 1", nativeQuery = true)
    List<User> findAllActiveUsersNative();
}
