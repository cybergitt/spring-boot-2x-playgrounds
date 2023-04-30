package com.coffeegit.springboot.jpamysql.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffeegit.springboot.jpamysql.basic.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
