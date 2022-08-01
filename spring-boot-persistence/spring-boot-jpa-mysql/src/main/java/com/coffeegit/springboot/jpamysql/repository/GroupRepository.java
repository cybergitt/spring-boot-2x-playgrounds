package com.coffeegit.springboot.jpamysql.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coffeegit.springboot.jpamysql.model.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

	Optional<Group> findByName(String groupName);
}
