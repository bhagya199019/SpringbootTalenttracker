package com.bitlabs.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitlabs.demo.Model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    // Define any custom queries if needed
}