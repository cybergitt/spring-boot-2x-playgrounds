package com.coffeegit.springboot.jpamysql.repository;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coffeegit.springboot.jpamysql.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(@NotBlank String email);

    Optional<User> findByUsername(@NotBlank String username);

    Boolean existsByEmail(@NotBlank String email);

    @Query("SELECT 1 FROM Users u WHERE u.email = :userEmail AND u.enabled = 1")
    Boolean existsByEmailAndEnabled(@Param("userEmail")String email);

}