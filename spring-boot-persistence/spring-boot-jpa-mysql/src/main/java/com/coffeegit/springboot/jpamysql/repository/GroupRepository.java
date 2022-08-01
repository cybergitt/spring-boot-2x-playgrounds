package com.coffeegit.springboot.jpamysql.repository;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coffeegit.springboot.jpamysql.model.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {

	Optional<Group> findByName(String groupName);
	
//	@Transactional
//	void deleteByGroupId(UUID id);
}
