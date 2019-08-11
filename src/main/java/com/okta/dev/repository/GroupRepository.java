package com.okta.dev.repository;

import com.okta.dev.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName(String name);
    List<Group> findAllByUserId(String id);
}