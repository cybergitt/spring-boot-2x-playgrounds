package com.coffeegit.springboot.jpamysql.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coffeegit.springboot.jpamysql.model.entity.Role;
import com.coffeegit.springboot.jpamysql.model.enums.RoleEnum;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(RoleEnum roleName);
}
